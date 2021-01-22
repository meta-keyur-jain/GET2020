Ext.define('NewApp.view.employeeForm.EmployeeFormController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.employeeform-employeeform',

    require: ['NewApp.view.employee.EmployeeController'],

    /**
     * This method takes data from form filled by user and store the data,
     * when user is online - store on server and soup,
     * when user is offline -  store on soup
     */
    onRegister: function() {
        var me1 = this;
        let formValidate = false;
        let employeeDetails = me1.getView();
        let name = employeeDetails.down('#name').getValue();
        let email = employeeDetails.down('#email').getValue();
        let project = employeeDetails.down('#project').getValue();
        let photo = employeeDetails.down('#photo').getValue();
        let persantX = employeeDetails.down('#persantX').getValue();
        let persantXII = employeeDetails.down('#persantXII').getValue();
        let aggregate = employeeDetails.down('#aggregate').getValue();
        let companyName = employeeDetails.down('#companyName').getValue();
        let experience = employeeDetails.down('#experience').getValue();
        if (name == null || email == null || project == null || photo == null || persantX == null ||
            persantXII == null || aggregate == null || companyName == null || experience == null) {
            Ext.Msg.alert('Empty value');

        } else {
            formValidate = true;
        }
        if (formValidate == true) {
            let soupName = 'dataEmployee';
            entries = [{
                'AccountId': '0012x000003kcOrAAI',
                'LastName': name,
                'employeeName__c': name,
                'employeeProfilePic__c': photo,
                'employeeEmail__c': email,
                'employeeProject__c': project,
                'classX__c': persantX,
                'classXII__c': persantXII,
                'college__c': aggregate,
                'preCompany__c': companyName,
                'companyExp__c': experience,
                __local__: true,
                __locally_created__: true,
                __locally_deleted__: false,
                __locally_updated__: false,
                attributes: {
                    type: "Contact"
                }
            }]
            if (navigator.onLine) {
                if (Ext.os.is.phone) {
                    smartStore.upsertSoupEntriesWithExternalId({ storeName: 'employeeStore', isGlobalStore: true }, soupName, entries, 'LastName', function(items) {
                        console.log("data upserted  in soup only due to online" + items);
                        Ext.ComponentQuery.query('app-main')[0].getController().doResync('upsync');
                        Ext.ComponentQuery.query('employeeList')[0].getController().setEmployeeData();
                        Ext.Msg.alert('Thanks! form Submitted');
                        me1.closeForm();
                    }, function(error) {
                        Ext.Msg.alert('Error Resubmit');
                    });
                } else {
                    items = {
                        'AccountId': '0012x000003kcOrAAI',
                        'LastName': name,
                        'employeeName__c': name,
                        'employeeProfilePic__c': photo,
                        'employeeEmail__c': email,
                        'employeeProject__c': project,
                        'classX__c': persantX,
                        'classXII__c': persantXII,
                        'college__c': aggregate,
                        'preCompany__c': companyName,
                        'companyExp__c': experience
                    }
                    client.create('Contact', items, function(res) {
                        console.log("form submitted" + res);
                        Ext.ComponentQuery.query('employeeList')[0].getController().setDataOnDesktop();
                        Ext.ComponentQuery.query('rightPanel')[0].getController().setDetailsOnDesktop();
                        Ext.Msg.alert('Thanks! form Submitted');
                        me1.closeForm();
                    }, function(err) {
                        Ext.Msg.alert('Error Resubmit');
                    })
                }
            } else {
                smartStore.upsertSoupEntriesWithExternalId({ storeName: 'employeeStore', isGlobalStore: true }, soupName, entries, 'LastName', function(items) {
                    console.log("data upserted  in soup only due to offline" + items);
                    me1.closeForm();
                }, function(error) {
                    console.log("error occured in soup only due to offline" + error);
                    Ext.Msg.alert('You are Offline');
                });
            }
        }
    },

    /**
     * This method is used to hide.
     */
    closeForm: function() {
        this.getView().hide();
    }
});
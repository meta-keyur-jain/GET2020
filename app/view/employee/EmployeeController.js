Ext.define('NewApp.view.employee.EmployeeController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.employee-employee',

    control: {
        '#search': {
            keyup: 'filter'
        },
        '#sortList': {
            change: 'sortByName'
        }
    },
    /**
     * This method call the rest api to get the data from saleforce.
     * It store the result in response object
     */
    init: function() {

        if (Ext.os.is.phone) {
            window.mobilesync = cordova.require("com.salesforce.plugin.mobilesync");
            this.setEmployeeData();

        } else {
            this.setDataOnDesktop();
        }
    },
    /**
     * This method is used to call rest api and fetch the data from server
     * and render it in store 
     */
    setDataOnDesktop: function() {
        let list = this.getView().down('#employees');
        client.query('SELECT NAME,EMPLOYEENAME__C,EMPLOYEEEMAIL__C,EMPLOYEEPROFILEPIC__C,EMPLOYEEPROJECT__C FROM CONTACT WHERE EMPLOYEEEMAIL__C!=NULL', function(response) {
                console.log("desktop" + response);
                list.getStore().setData(response.records)
            },
            function(error) { console.log("error occured" + error) });
    },

    /**
     * This method is used to fetch data from store and render it in view
     */
    setEmployeeData: function() {
        let querySpec = navigator.smartstore.buildSmartQuerySpec("select * from {dataEmployee}", 1000);
        let list = this.getView().down('#employees');
        navigator.smartstore.runSmartQuery({ storeName: 'employeeStore', isGlobalStore: true }, querySpec, function(response) {
            console.log(response);
            let employeeData = response.currentPageOrderedEntries;
            let result = [];
            for (var i = 0; i < employeeData.length; i++) {
                result.push(employeeData[i][1]);
            }
            list.getStore().setData(result);
        });
    },

    /**
     * This method filter the list on the basis of string passed in searchBar.
     * @param [field=searchBar] it store the string value of searchBar 
     * @param [e=event] this is events
     *@returns it return the filtered list
     */
    filter: function(field, e) {
        let list = this.getView().down('#employees');
        if (field.getValue() == '') {
            return list.getStore().clearFilter();
        } else {
            list.getStore().filter((record) => record.data.employeeName__c.indexOf(field.getValue()) !== -1);
        }
    },

    /**
     * This method sort the list on the basis of name and project.
     * @param [newValue = employee name] this is event. 
     *@returns it return the sorted list
     */
    sortByName: function(field, newValue, oldValue) {
        let list = this.getView().down('#employees');
        if (newValue.get('value') === 'name') {
            list.getStore().sort('employeeName__c', 'AESC');
        } else if (newValue.get('value') === 'project') {
            list.getStore().sort('employeeProject__c', 'AESC');
        }
    },


    /**
     * This method is used when user wants to
     *  route from home page to right panel.
     */
    showRightPanel: function() {
        // if (Ext.os.is.phone) {
        //     this.getView().getParent().getParent().setActiveItem(1);
        //     Ext.ComponentQuery.query('#backButton')[0].setHidden(false);
        //     Ext.Anim.run(this.getView().getParent().getParent().getInnerAt(1), 'fade', {
        //         out: false,
        //         direction: 'right',
        //         duration: 1000
        //     });
        //}
        this.getView().getParent().getParent().setActiveItem(1);
    },

});
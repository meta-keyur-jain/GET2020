/**
 * This class is the controller for the main view for the application. It is specified as
 * the "controller" of the Main view class.
 *
 * TODO - Replace this content of this view to suite the needs of your application.
 */
Ext.define('NewApp.view.main.MainController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.main',

    /**
     * This method is used to initilize salesforce plugin,
     * and create soup.
     */
    init: function() {
        if (Ext.os.is.phone) {
            window.smartStore = cordova.require("com.salesforce.plugin.smartstore");
            window.mobilesync = cordova.require("com.salesforce.plugin.mobilesync");
        } else {
            return null;
        }
        document.addEventListener("deviceready", () => {
            var me = this;
            me.soupCreate();
        }, false);

        /**
         * This method is used to get the data from server using rest call.
         */
        // force.apexrest('/services/apexrest/showContacts',
        //     (res) => { console.log("Remote rest called" + res) },
        //     (err) => { console.log("Remote call failed" + err) });\

        // var restData = {
        //     'AccountId': '0012x000003kcOrAAI',
        //     'LastName': "Mayank",
        //     'employeeName': "Mayank",
        //     'employeeEmail': "mayank.moolchandani@metacube.com",
        //     'employeeProfilePic': 'https://lh3.googleusercontent.com/-dQDCaRATZYw/AAAAAAAAAAI/AAAAAAAAAAc/99xPV4gY70IQPyqXOjMskxh0Dh2lRJnzQCLcDEAE/s32-c-k-no/photo.jpg',
        //     'employeeProject': "Tier1",
        // }
        // var obj = {
        //     'method': 'POST',
        //     'path': '/services/apexrest/showContacts',
        //     'data': restData,
        // };
        /**
         * This method is used to post the data from server using rest call.
         */
        // force.request(obj,
        //     (res) => { console.log("Remote rest called" + res) },
        //     (err) => { console.log("Remote call failed" + err) }, true, false);
    },

    /**
     * This method is used to register soup,
     * and perform syncUp and syncDown first time,
     * and then do resync everytime when user enter into app.
     */
    soupCreate: function() {
        var me = this;
        let soupName = 'dataEmployee';
        let indexSpecs = [
            { path: "Id", type: "string" },
            { path: "AccountId", type: "string" },
            { path: "LastName", type: "string" },
            { path: "Name", type: "string" },
            { path: "employeeName__c", type: "string" },
            { path: "employeeEmail__c", type: "string" },
            { path: "employeeProfilePic__c", type: "string" },
            { path: "employeeProject__c", type: "string" },
            { path: "classX__c", type: "integer" },
            { path: "classXII__c", type: "integer" },
            { path: "college__c", type: "integer" },
            { path: "preCompany__c", type: "string" },
            { path: "companyExp__c", type: "integer" },
            { path: "__local__", type: "string" },
            { path: "__locally_created__", type: "string" }
        ];
        if (Ext.os.is.phone) {
            smartStore.registerSoup({ storeName: 'employeeStore', isGlobalStore: true }, soupName, indexSpecs,
                (soupName) => {
                    let querySpec = navigator.smartstore.buildSmartQuerySpec("select * from {dataEmployee}");
                    navigator.smartstore.runSmartQuery({ storeName: 'employeeStore', isGlobalStore: true }, querySpec,
                        (response) => {
                            if (response.totalEntries <= 0) {
                                me.doSyncDown();
                                me.doSyncUp();
                            } else {
                                me.doResync('downsync');
                                me.doResync('upsync');
                            }
                        });
                },
                (err) => {
                    console.log("registerSoup failed with error: " + err);
                });
        } else {
            return null;
        }
    },

    /**
     * This method perform syncDown
     */
    doSyncDown: () => {
        let target = { type: "soql", query: "SELECT NAME,EMPLOYEENAME__C,EMPLOYEEEMAIL__C,EMPLOYEEPROFILEPIC__C,EMPLOYEEPROJECT__C,classX__c,classXII__c,college__c,preCompany__c, companyExp__c FROM CONTACT WHERE EMPLOYEEEMAIL__C!=NULL" };
        let soupName = 'dataEmployee';
        let syncName = 'downsync';
        let option = { "mergeMode": "OVERWRITE" };
        mobilesync.syncDown({ storeName: 'employeeStore', isGlobalStore: true }, target, soupName, option, syncName, (event) => {
            console.log("sync  soup run" + JSON.stringify(event));
        }, (error) => {
            console.log("error in sync soup" + error);
        });
    },

    /**
     * This method perform resync
     */
    doResync: (syncName) => {
        mobilesync.reSync({ storeName: 'employeeStore', isGlobalStore: true }, syncName, (res) => {
            console.log("resync success" + res);
        }, (err) => {
            console.log("resync error" + err);
        });
    },

    /**
     * This method perform syncUp
     */
    doSyncUp: () => {
        let soupName = 'dataEmployee';
        let option = {
            "mergeMode": "LEAVE_IF_CHANGED",
            fieldlist: [
                'Id',
                'AccountId',
                'LastName',
                'employeeName__c',
                'employeeProfilePic__c',
                'employeeEmail__c',
                'employeeProject__c',
                'classX__c',
                'classXII__c',
                'college__c',
                'preCompany__c',
                'companyExp__c'

            ]
        };
        let target = {
            'createFieldList': ['AccountId',
                'LastName',
                'employeeName__c',
                'employeeProfilePic__c',
                'employeeEmail__c',
                'employeeProject__c',
                'classX__c',
                'classXII__c',
                'college__c',
                'preCompany__c',
                'companyExp__c'
            ],
            'updateFieldList': [
                'AccountId',
                'LastName',
                'employeeName__c',
                'employeeProfilePic__c',
                'employeeEmail__c',
                'employeeProject__c',
                'classX__c',
                'classXII__c',
                'college__c',
                'preCompany__c',
                'companyExp__c'
            ]
        };
        mobilesync.syncUp({ storeName: 'employeeStore', isGlobalStore: true }, target, soupName, option, 'upsync', function(event) {
            console.log("sync soup run" + JSON.stringify(event));
        }, function(error) {
            console.log("error in sync soup" + error);
        });
    }
});
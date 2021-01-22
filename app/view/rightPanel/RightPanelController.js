Ext.define('NewApp.view.rightPanel.RightPanelController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.rightpanel-rightpanel',
    /**
     * This method is used to get the academic,college and work experience details from server 
     * and render it in view
     */
    init: function() {

        if (Ext.os.is.phone) {
            this.setDetailsOnMobile();
        } else {
            this.setDetailsOnDesktop();
        }
    },
    /**
     * This method is used to fetch data from store and render it in mobile view
     */
    setDetailsOnMobile: function() {
        let academic = this.getView().down("#marksDetails");
        let college = this.getView().down("#marksDetailsCollege");
        let experience = this.getView().down("#workExperience");
        force.query('SELECT NAME,EMPLOYEENAME__C,classX__c,classXII__c,college__c,preCompany__c, companyExp__c FROM CONTACT WHERE EMPLOYEEEMAIL__C!=NULL', function(response) {
            academic.setStore().setData(response.records);
            college.setStore().setData(response.records);
            experience.setStore().setData(response.records);
        }, function(err) { console.log(err) });
    },
    /**
     * This method is used to fetch data from store and render it in web view
     */
    setDetailsOnDesktop: function() {
        let academic = this.getView().down("#marksDetails");
        let college = this.getView().down("#marksDetailsCollege");
        let experience = this.getView().down("#workExperience");
        client.query('SELECT NAME,EMPLOYEENAME__C,classX__c,classXII__c,college__c,preCompany__c, companyExp__c FROM CONTACT WHERE EMPLOYEEEMAIL__C!=NULL', function(response) {
            academic.setStore().setData(response.records);
            college.setStore().setData(response.records);
            experience.setStore().setData(response.records);
        }, function(err) { console.log(err) });
    }
});
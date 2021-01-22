/**
 * @className LeftPanel
 * @description
 * This panel display list of employee.
 * It take list from employee class.
 */
Ext.define('NewApp.view.leftPanel.LeftPanel', {
    extend: 'Ext.Panel',
    xtype: 'leftPanel',
    requires: [
        'NewApp.view.leftPanel.LeftPanelController',
        'NewApp.view.leftPanel.LeftPanelModel',
        'NewApp.view.employee.Employee'
    ],

    controller: 'leftpanel-leftpanel',
    viewModel: {
        type: 'leftpanel-leftpanel'
    },

    margin: 5,
    layout: {
        type: 'vbox'
    },
    items: [{
        height: '100%',
        xtype: 'employeeList'
    }]
});
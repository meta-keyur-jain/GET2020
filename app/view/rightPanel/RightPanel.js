/**
 * @className RightPanel
 * @description
 * This display tab panel consist of school detais,college details and employee details.
 * Each tabpanel consist of grid of various details.
 */
Ext.define('NewApp.view.rightPanel.RightPanel', {
    extend: 'Ext.tab.Panel',
    xtype: 'rightPanel',
    requires: [
        'NewApp.view.rightPanel.RightPanelController',
        'NewApp.view.rightPanel.RightPanelModel'
    ],

    controller: 'rightpanel-rightpanel',
    viewModel: {
        type: 'rightpanel-rightpanel'
    },

    margin: 5,
    height: '100%',
    items: [{
        xtype: 'grid',
        itemId: 'marksDetails',
        title: 'School',
        columns: [{ text: 'Employee Name', dataIndex: 'employeeName__c', flex: 1 },
            { text: 'X %', dataIndex: 'classX__c', flex: 1 },
            { text: 'XII %', dataIndex: 'classXII__c', flex: 1 }
        ],
    }, {
        xtype: 'grid',
        title: 'College',
        itemId: 'marksDetailsCollege',
        columns: [{ text: 'Employee Name', dataIndex: 'employeeName__c', flex: 1 },
            { text: 'Aggegrate Marks(in%)', dataIndex: 'college__c', flex: 1 }
        ]
    }, {
        xtype: 'grid',
        title: 'Work Experience',
        itemId: 'workExperience',
        columns: [{ text: 'Employee Name', dataIndex: 'employeeName__c', flex: 1 },
            { text: 'Company Name', dataIndex: 'preCompany__c', flex: 1 },
            { text: 'Years Of Experience', dataIndex: 'companyExp__c', flex: 1 }
        ]
    }]
});
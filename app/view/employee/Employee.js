/**
 * @className Employee
 * @description
 * It display the list of employee.
 * List includes email,profilePic,name of employee.
 * It also include search field to search by name.
 */
Ext.define('NewApp.view.employee.Employee', {
    extend: 'Ext.panel.Panel',
    xtype: 'employeeList',
    requires: [
        'NewApp.view.employee.EmployeeController',
        'NewApp.view.employee.EmployeeModel',
        'NewApp.store.Personnel',
    ],

    controller: 'employee-employee',
    viewModel: {
        type: 'employee-employee'
    },

    cls: 'employee',
    scrollable: 'y',
    items: [{
            layout: {
                type: 'hbox'
            },
            docked: 'top',
            cls: 'selectWork',
            items: [{
                    xtype: 'searchfield',
                    cls: 'searchbar',
                    name: 'query',
                    placeHolder: 'Search',
                    itemId: 'search',
                    clearIcon: false
                },
                {
                    xtype: 'selectfield',
                    cls: 'selectbar',
                    itemId: 'sortList',
                    options: [{
                        text: 'Sort',
                    }, {
                        text: 'Name',
                        value: 'name'
                    }, {
                        text: 'Project',
                        value: 'project'
                    }]
                }
            ]
        },
        {
            xtype: 'panel',
            items: [{
                xtype: 'list',
                itemId: 'employees',
                itemTpl: '<div class="main"><div class="imageDiv"><img src="{employeeProfilePic__c}" class="onImage"/></div><div class="textDiv"><p class="paraEmpName">{employeeName__c}</p><p class="paraEmail">{employeeEmail__c}</p></div></div>',
                store: Ext.create('NewApp.store.Personnel'),
                emptyText: '<h1>No data Available</h1>',
                listeners: {
                    itemtap: 'showRightPanel'
                }
            }]
        }
    ]
});
/**
 * @className Container
 * @description
 * This class is the parent class of left and right panel.
 * It consist of left and right panel.
 */
Ext.define('NewApp.view.container.Container', {
    extend: 'Ext.NavigationView',
    xtype: 'mainContainer',
    requires: [
        'NewApp.view.container.ContainerController',
        'NewApp.view.container.ContainerModel',
        'NewApp.view.leftPanel.LeftPanel',
        'NewApp.view.rightPanel.RightPanel',
        'Ext.Anim'
    ],

    controller: 'container-container',
    viewModel: {
        type: 'container-container'
    },

    height: '100%',
    // platformConfig: {
    //     desktop: {
    //         layout: {
    //             type: 'hbox'
    //         }
    //     },
    //     '!desktop': {
    //         layout: {
    //             type: 'card'
    //         }
    //     }
    // },
    items: [{
            id: 'newIdCmp1',
            title: 'Employee List',
            xtype: 'leftPanel',
            flex: 1
        },
        {
            xtype: 'button',
            iconCls: 'fa-1x fa-plus',
            iconAlign: 'center',
            cls: 'formAddButton',
            scale: 'Large',
            height: '50px',
            width: '50px',
            ui: 'round',
            shadow: true,
            bottom: '40px',
            right: '20px',
            style: 'position: absolute !important;',
            tooltip: {
                html: 'Add Contact'
            },
            listeners: {
                tap: 'openRegistrationForm'
            }
        },
        {
            id: 'newIdCmp2',
            xtype: 'container',
            flex: 2,
            items: [{
                xtype: 'rightPanel'
            }]
        }
    ]
});
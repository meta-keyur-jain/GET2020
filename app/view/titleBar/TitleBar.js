/**
 * @className TitleBar
 * @description
 * Display title of application
 */
Ext.define('NewApp.view.titleBar.TitleBar', {
    extend: 'Ext.TitleBar',
    xtype: 'titlebar',
    requires: [
        'NewApp.view.titleBar.TitleBarController',
        'NewApp.view.titleBar.TitleBarModel'
    ],

    controller: 'titlebar-titlebar',
    viewModel: {
        type: 'titlebar-titlebar'
    },
    xtype: 'appTitlebar',
    docked: 'top',
    cls: 'titleBar',
    title: 'My Application',
    items: [{
        xtype: 'button',
        iconCls: 'fa-2x fa-sign-out',
        align: 'right',
        handler: 'logout',
        cls: 'logoutButton',
        listeners: {
            tap: 'logout'
        }
    }, {

        xtype: 'button',
        docked: 'left',
        itemId: 'backButton',
        iconCls: 'fas fa-arrow-circle-left',
        align: 'left',
        ui: 'round',
        background: 'transparent',
        floating: true,
        cls: 'iconButton',
        hidden: true,
        tooltip: {
            html: 'Back'
        },
        listeners: {
            tap: 'backtoHome'
        }
    }]
});
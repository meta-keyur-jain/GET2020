Ext.define('NewApp.view.container.ContainerController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.container-container',
    init: function() {
        let view = this.getView();
        view.push(this.getView().getItems(0));
    },
    /**
     * This method is rendered when add button in title bar is tapped
     * and used to open form for user regestration 
     */
    openRegistrationForm: function() {
        var regesratonForm = Ext.create('NewApp.view.employeeForm.EmployeeForm', {
            itemId: 'regestrationForm',
            modal: true,
            hideOnMaskTap: true,
            style: 'margin:auto;',
            platformConfig: {
                desktop: {
                    height: '80%',
                    width: '50%'
                },
                '!desktop': {
                    height: '80%',
                    width: '90%'
                }
            },
            showAnimation: {
                type: 'fadeOut',
                duration: 500,
                direction: 'left'
            },
            hideAnimation: {
                type: 'fadeOut',
                duration: 500,
                direction: 'right'
            }
        });
        regesratonForm.showBy(Ext.Viewport, "c-c");
    }
});
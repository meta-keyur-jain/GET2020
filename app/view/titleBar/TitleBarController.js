Ext.define('NewApp.view.titleBar.TitleBarController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.titlebar-titlebar',

    /**
     * This metohd is used to logout user from application
     */
    logout: function() {
        if (Ext.os.is.phone) {
            force.logout();
        } else {
            window.location.href = "https://c.ap17.visual.force.com/secur/logout.jsp";
        }
    },
    /**
     * This method is used for route  from rightpanel to leftpanel
     */
    backtoHome: function() {
        this.getView(Ext.ComponentQuery.query('mainContainer')[0].setActiveItem(0)).setActiveItem(0);
        Ext.ComponentQuery.query('#backButton')[0].setHidden(true);
        Ext.Anim.run(this.getView().getInnerAt(0), 'fade', {
            out: false,
            direction: 'right',
            duration: 1000,
        });
    }
});
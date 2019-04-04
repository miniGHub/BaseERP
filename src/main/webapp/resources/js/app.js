//ExtJs的入口，加载该Js之后，自动调用launch方法内容项
Ext.application({
    name: 'AppIndex',
    extend:'Ext.app.Application',
    appFolder: 'resources/js',
    // autoCreateViewport:'AppHome',

    stores: [
        // TODO: add global / shared stores here
    ],

    views: [
        'AppIndex.view.base.LoginView',
        'AppIndex.view.base.AppHome',
    ],

    listen: {
        /*
        controller: {
            '#': {
                unmatchedroute: 'onUnmatchedRoute'
            }
        }
        */
    },
    onUnmatchedRoute: function(hash) {
        alert('Unmatched:' + hash);
    },
    init:function(){
        console.log("init");
        // this.setDefaultToken('all');
    },
    launch : function() {
        console.log("launch");

        // TODO - Launch the application
        var hasLogin;

        // Check to see the current value of the localStorage key
        hasLogin = localStorage.getItem("HasLogin");
        console.log("hasLogin:" + hasLogin);

        // force login view
        // hasLogin = null;
        hasLogin = true;

        // This ternary operator determines the value of the TutorialLoggedIn key.
        // If TutorialLoggedIn isn't true, we display the login window,
        // otherwise, we display the main view
        if (hasLogin) {
            this.setMainView("AppIndex.view.base.AppHome");
        }
        else {
            //this.setMainView("AppIndex.view.base.LoginView");
            Ext.create({
                xtype: 'app_login_view'
            });
        }
    },
    onAppUpdate: function () {
        Ext.Msg.confirm('Application Update', 'This application has an update, reload?',
            function (choice) {
                if (choice === 'yes') {
                    window.location.reload();
                }
            }
        );
    }
});
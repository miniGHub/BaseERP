Ext.define('AppIndex.controller.LoginController',{
    extend:'Ext.app.ViewController',
    alias:'controller.login_view',
    requires:[],
    control:{},
    routes:{},

    onClockLogin:function () {
        console.log("onLoginClick!");

        // form data
        var form = this.getView().down('form')
        var formData = form.getValues();
        console.log('formData:' + Ext.encode(formData));

        var sendStore = Ext.create('AppIndex.store.SendStore');
        sendStore.proxy.url += 'info/login';
        sendStore.proxy.extraParams = formData;

        sendStore.load({
            scope: this,
            callback: function (records, operation, success) {
                console.log('load callback');

                if (!success) {
                    Ext.MessageBox.show({
                        title: 'Error',
                        msg: '数据传输异常',
                        buttons: Ext.MessageBox.OK,
                        icon: Ext.MessageBox.ERROR
                    });
                } else if (records.length <= 0) {
                    Ext.MessageBox.show({
                        title: 'Error',
                        msg: '数据异常',
                        buttons: Ext.MessageBox.OK,
                        icon: Ext.MessageBox.ERROR
                    });
                } else {
                    // transfer success
                    this.loginCallback(records, operation);
                }
            }
        });
    },
    loginCallback:function(records, operation){
        console.log("loginCallback");

        var code = records[0].data.code;
        switch (code) {
            case -1:
                Ext.MessageBox.show({
                    title: 'Error',
                    msg: '数据异常',
                    buttons: Ext.MessageBox.OK,
                    icon: Ext.MessageBox.ERROR
                });
                break;
            case 0:
                console.log('success');
                this.loginSuccess();
                break;
            case 1:
                Ext.MessageBox.show({
                    title: 'Warning',
                    msg: '用户不存在!',
                    buttons: Ext.MessageBox.OK,
                    icon: Ext.MessageBox.WARNING
                });
                break;
            case 2:
                Ext.MessageBox.show({
                    title: 'Warning',
                    msg: '密码错误!',
                    buttons: Ext.MessageBox.OK,
                    icon: Ext.MessageBox.WARNING
                });
                break;
        }
    },
    loginSuccess:function(){
        console.log("loginSuccess");
        localStorage.setItem("HasLogin", "login");
        this.closeView();
        AppIndex.getApplication().setMainView("AppIndex.view.AppHome");
    }

});
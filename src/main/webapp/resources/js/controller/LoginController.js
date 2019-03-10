Ext.define('AppIndex.controller.LoginController',{
    extend:'Ext.app.ViewController',
    alias:'controller.login_view',
    requires:[],
    control:{},
    routes:{},

    onClockLogin:function () {
        console.log("onLoginClick!");

        // form data
        var form = this.getView().down('form');
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
    onClockRefresh:function(){
        var form = this.getView().down('form');
        form.reset();
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
        this.getUserInfo();
        localStorage.setItem("HasLogin", "login");
        this.closeView();
        AppIndex.getApplication().setMainView("AppIndex.view.AppHome");
    },
    getUserInfo:function(){
        console.log("getUserInfo");

        // form data
        var form = this.getView().down('form');
        var formData = form.getValues();
        console.log("id:" + formData['id']);

        // send parameters
        var sendParam ={
            id: formData['id']
        };
        console.log('sendParam:' + Ext.encode(sendParam));

        var sendStore = Ext.create('AppIndex.store.SendStore');
        sendStore.proxy.url += 'info/getUserInfo';
        sendStore.proxy.extraParams =  sendParam;
        // console.log(sendStore.proxy.url);
        sendStore.load({
            scope:this,
            callback: function (records, operation, success) {
                console.log('records:' + records);
                console.log('operation:' + operation);
                console.log('success:' + success);
                if (!success) {
                    console.log('getUserInfo failed!!!');
                    return;
                }
                console.log("xxx id:" + records[0].data.role_id);
                console.log("xxx name" + records[0].data.role_name);
                localStorage.setItem("UserId", records[0].data.id);
                localStorage.setItem("UserName", records[0].data.name);
                localStorage.setItem("RoleId", records[0].data.role_id);
                localStorage.setItem("RoleName", records[0].data.role_name);
            }
        });
    }

});
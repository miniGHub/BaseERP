Ext.define('AppIndex.controller.base.LoginController',{
    extend:'Ext.app.ViewController',
    alias:'controller.login_view',
    requires:[],
    control:{},
    routes:{},

    onClickLogin:function () {
        console.log("onClickLogin!");

        // form data
        var form = this.getView().down('form');
        var formData = form.getValues();
        console.log('formData:' + Ext.encode(formData));

        var sendStore = Ext.create('AppIndex.store.common.SendStore');
        sendStore.proxy.url += 'info/Login';
        sendStore.proxy.extraParams = formData;

        sendStore.load({
            scope: this,
            callback: function (records, operation, success) {
                console.log('load callback');

                var ret = COMMON_FUNC.StoreCallbackDialog(records, success);
                if (ret) {
                    this.loginCallback(records, operation);
                } else {
                    console.log("StoreCallbackDialog error!");
                }
            }
        });
    },
    onClickRefresh:function(){
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
        AppIndex.getApplication().setMainView("AppIndex.view.base.AppHome");
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

        var sendStore = Ext.create('AppIndex.store.common.SendStore');
        sendStore.proxy.url += 'info/GetUserInfo';
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
                localStorage.setItem("UserId", records[0].data.id);
                localStorage.setItem("UserName", records[0].data.name);
                localStorage.setItem("RoleId", records[0].data.role_id);
                localStorage.setItem("RoleName", records[0].data.role_name);
            }
        });
    }

});
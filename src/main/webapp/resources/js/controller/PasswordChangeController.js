Ext.define('AppIndex.controller.PasswordChangeController',{
    extend:'Ext.app.ViewController',
    alias:'controller.password_change_view',
    requires:[],
    control:{},
    routes:{},

    onClickSave:function () {
        console.log("onClickSave!");

        // form data
        var form = this.getView().down('form');
        var formData = form.getValues();

        console.log('formData:' + Ext.encode(formData));
        var oldPassword = formData['old_password'];
        var newPassword = formData['new_password'];
        var againPassword = formData['again_password'];
        var userId = localStorage.getItem("UserId");

        console.log('new:' + newPassword + ',again:' + againPassword);
        if (parseInt(newPassword) != parseInt(againPassword)) {
            Ext.MessageBox.show({
                title: 'Warning',
                msg: '输入的新密码不一致!',
                buttons: Ext.MessageBox.OK,
                icon: Ext.MessageBox.WARNING
            });
        } else if (parseInt(oldPassword) == parseInt(newPassword)){
            Ext.MessageBox.show({
                title: 'Warning',
                msg: '新密码不能与旧密码一致!',
                buttons: Ext.MessageBox.OK,
                icon: Ext.MessageBox.WARNING
            });
        } else if (parseInt(newPassword) == parseInt(againPassword)){
            var sendParam = {
                id: userId,
                old_password: oldPassword,
                new_password: newPassword
            };

            var sendStore = Ext.create('AppIndex.store.SendStore');
            sendStore.proxy.url += 'info/ChangePassword';
            sendStore.proxy.extraParams = sendParam;

            sendStore.load({
                scope: this,
                callback: function (records, operation, success) {
                    console.log('load callback');
                    // check
                    if (COMMON_FUNC.StoreCallbackDialog(records, success)) {
                        // transfer success
                        this.changePasswordCallback(records, operation);
                    }
                }
            });
        } else {
            console.log("password change onClickSave error!");
        }
    },
    onClickReset:function () {
        this.getView().down('form').reset();
    },
    changePasswordCallback:function(records, operation) {
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
            case 1:
                Ext.MessageBox.show({
                    title: 'Warning',
                    msg: '修改密码失败，用户不存在！',
                    buttons: Ext.MessageBox.OK,
                    icon: Ext.MessageBox.WARNING
                });
                this.refreshGridData(mGridUserManager.getStore().currentPage);
                break;
            case 2:
                Ext.MessageBox.show({
                    title: 'Warning',
                    msg: '修改密码失败,旧密码错误!',
                    buttons: Ext.MessageBox.OK,
                    icon: Ext.MessageBox.WARNING
                });
                break;
            case 9:
                Ext.MessageBox.show({
                    title: 'Warning',
                    msg: '修改密码失败,新密码与旧密码一致!',
                    buttons: Ext.MessageBox.OK,
                    icon: Ext.MessageBox.WARNING
                });
                break;
            case 10:
                Ext.MessageBox.show({
                    title: 'Info',
                    msg: '修改密码成功!',
                    buttons: Ext.MessageBox.OK,
                    icon: Ext.MessageBox.INFO
                });
                break;
            case 11:
                Ext.MessageBox.show({
                    title: 'Warning',
                    msg: '修改密码失败!',
                    buttons: Ext.MessageBox.OK,
                    icon: Ext.MessageBox.WARNING
                });
                break;
        }
    }
});
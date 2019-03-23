Ext.define('AppIndex.controller.PasswordResetController',{
    extend:'Ext.app.ViewController',
    alias:'controller.password_reset_view',
    requires:[],
    control:{},
    routes:{},

    onClickReset:function () {
        console.log("onClickSave!");

        var grid = this.getView().down('app_password_reset_view_grid');
        var record = grid.getSelectionModel().getSelection();

        if (0 == record.length) {
            Ext.MessageBox.show({
                title: 'INFO',
                msg: '请选择需要重置密码的用户',
                buttons: Ext.MessageBox.OK,
                icon: Ext.MessageBox.INFO
            });
            return;
        }

        var listId = [];
        for (var i = 0; i < record.length; i++) {
            var data = {
                id: record[i].data['id']
            };
            listId.push(data);
        }

        var sendParam = {
            grid: listId
        };
        console.log('sendParam:' + Ext.encode(sendParam));

        var sendStore = Ext.create('AppIndex.store.SendStore');
        sendStore.proxy.url += 'info/ResetPassword';
        sendStore.proxy.extraParams = sendParam;

        sendStore.load({
            scope: this,
            callback: function (records, operation, success) {
                console.log('load callback');
                // check
                if (COMMON_FUNC.StoreCallbackDialog(records, false)) {
                    // transfer success
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
                        case 12:
                            Ext.MessageBox.show({
                                title: 'Info',
                                msg: '重置密码成功!',
                                buttons: Ext.MessageBox.OK,
                                icon: Ext.MessageBox.INFO
                            });

                            // refresh grid data
                            var store = grid.getStore();
                            store.proxy.extraParams.isReqDB = true;
                            store.load({
                                scope: this,
                                callback: function (records, operation, success) {
                                    // reset param isReqDB
                                    store.proxy.extraParams.isReqDB = false;
                                }
                            });
                            break;
                        case 13:
                            Ext.MessageBox.show({
                                title: 'Warning',
                                msg: '重置密码失败!',
                                buttons: Ext.MessageBox.OK,
                                icon: Ext.MessageBox.WARNING
                            });
                            break;
                    }
                }
            }
        });
    },
    onClickRefresh:function () {
        console.log("onClickRefresh");

        var grid = this.getView().down('app_password_reset_view_grid');
        // refresh grid data
        var store = grid.getStore();
        store.proxy.extraParams.isReqDB = true;
        store.currentPage = 1;
        store.load({
            scope: this,
            callback: function (records, operation, success) {
                // reset param isReqDB
                store.proxy.extraParams.isReqDB = false;
            }
        });
    }
});
var mWinUserManager = null;
var mGridUserManager = null;
Ext.define('AppIndex.controller.UserManagerController',{
    extend:'Ext.app.ViewController',
    alias:'controller.user_manager_view',
    requires:[
        'AppIndex.view.UserManagerViewWindowAdd',
        'AppIndex.view.UserManagerViewWindowEdit'
    ],
    control:{},
    routes:{},

    // private methods
    loadGrid:function(){
        mGridUserManager = this.getView().down('app_user_manager_view_grid');
    },
    closeWin: function (){
        if (mWinUserManager) {
            mWinUserManager.close();
            mWinUserManager = null;
        }
    },
    refreshGridData: function(page) {
        if (mGridUserManager == null) {
            return;
        }

        // refresh grid data
        var store = mGridUserManager.getStore();
        store.proxy.extraParams.isReqDB = true;
        store.currentPage = page;
        store.load({
            scope: this,
            callback: function (records, operation, success) {
                // reset param isReqDB
                store.proxy.extraParams.isReqDB = false;
            }
        });
    },
    // event methods
    onClickAdd : function () {
        console.log("user manager onClickAdd");

        this.loadGrid();
        Ext.create('AppIndex.store.GetNewIdStore').load({
            scope:this,
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
                    var newId = records[0].data.id;
                    this.closeWin();
                    mWinUserManager = Ext.create({
                        xtype: 'app_user_manager_view_window_add'
                    });
                    var winForm = mWinUserManager.down('form').getForm();
                    winForm.findField('id').setValue(newId);
                    mWinUserManager.show();
                }
            }
        });
    },
    onClickEdit : function () {
        console.log("onClickEdit");

        this.loadGrid();
        var record = mGridUserManager.getSelectionModel().getSelection();

        if (0 == record.length) {
            Ext.MessageBox.show({
                title: 'INFO',
                msg: '请选择一行数据进行编辑',
                buttons: Ext.MessageBox.OK,
                icon: Ext.MessageBox.INFO
            });
            return;
        }

        if (record.length >  1) {
            Ext.MessageBox.show({
                title: 'INFO',
                msg: '只能选择一行数据进行编辑',
                buttons: Ext.MessageBox.OK,
                icon: Ext.MessageBox.INFO
            });
            return;
        }

        this.closeWin();
        mWinUserManager = Ext.create({
            xtype: 'app_user_manager_view_window_edit'
        });

        var winForm = mWinUserManager.down('form').getForm();
        winForm.findField('id').setValue(record[0].data['id']);
        winForm.findField('name').setValue(record[0].data['name']);
        winForm.findField('phone').setValue(record[0].data['phone']);
        winForm.findField('role_name').setValue(parseInt(record[0].data['role_id']));
        winForm.findField('depart_name').setValue(record[0].data['depart_id']);
        mWinUserManager.show();
    },
    onClickDelete : function () {
        console.log("onClickDelete");

        this.loadGrid();
        var record = mGridUserManager.getSelectionModel().getSelection();

        if (0 == record.length) {
            Ext.MessageBox.show({
                title: 'INFO',
                msg: '请选择准备删除的用户',
                buttons: Ext.MessageBox.OK,
                icon: Ext.MessageBox.INFO
            });
            return;
        }

        Ext.Msg.confirm('系统提示','确定要删除？', this.onClickConfirmDelete, this);
    },
    onClickRefresh : function () {
        console.log("onClickRefresh");
        this.loadGrid();
        this.refreshGridData(1);
    },
    onClickAddSave : function () {
        console.log("onClickAddSave");

        var winForm = mWinUserManager.down('form').getForm();
        var winFormData = winForm.getValues();
        // console.log('winFormData:' + Ext.encode(winFormData));

        var sendParam= {
            id: winFormData['id'],
            role_id: winFormData['role_name'],
            depart_id: winFormData['depart_name'],
            name: winFormData['name'],
            phone: winFormData['phone']
        };

        console.log('sendParam:' + Ext.encode(sendParam));

        var sendStore = Ext.create('AppIndex.store.SendStore');
        sendStore.proxy.url += 'info/AddUserInfo';
        sendStore.proxy.extraParams = sendParam;

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
                    this.addSaveCallback(records, operation);
                }
            }
        });

        this.closeWin();
    },
    onClickAddCancel : function () {
        console.log("onClickAddCancel");
        this.closeWin();
    },
    onClickEditSave : function () {
        console.log("onClickEditSave");

        var winForm = mWinUserManager.down('form').getForm();
        var winFormData = winForm.getValues();
        // console.log('winFormData:' + Ext.encode(winFormData));

        var sendParam= {
            id: winFormData['id'],
            role_id: winFormData['role_name'],
            depart_id: winFormData['depart_name'],
            name: winFormData['name'],
            phone: winFormData['phone']
        };

        console.log('sendParam:' + Ext.encode(sendParam));

        var sendStore = Ext.create('AppIndex.store.SendStore');
        sendStore.proxy.url += 'info/UpdateUserInfo';
        sendStore.proxy.extraParams = sendParam;

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
                    this.editSaveCallback(records, operation);
                }
            }
        });
        this.closeWin();
    },
    onClickEditCancel : function () {
        console.log("onClickEditCancel");
        this.closeWin();
    },
    onClickConfirmDelete : function (btn) {
        console.log('onClickConfirmDelete');

        if(btn=='yes'){
            var record = mGridUserManager.getSelectionModel().getSelection();
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
            sendStore.proxy.url += 'info/DeleteUserInfo';
            sendStore.proxy.extraParams = sendParam;

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
                        this.deleteSaveCallback(records, operation);
                    }
                }
            });
        }
    },
    // callback
    addSaveCallback: function (records, operation) {
        console.log('add save callback');

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
                Ext.MessageBox.show({
                    title: 'Warning',
                    msg: '新增用户失败,用户已经存在!',
                    buttons: Ext.MessageBox.OK,
                    icon: Ext.MessageBox.WARNING
                });
                break;
            case 3:
                Ext.MessageBox.show({
                    title: 'Info',
                    msg: '新增用户成功!',
                    buttons: Ext.MessageBox.OK,
                    icon: Ext.MessageBox.INFO
                });
                this.refreshGridData(mGridUserManager.getStore().currentPage);
                break;
            case 4:
                Ext.MessageBox.show({
                    title: 'Warning',
                    msg: '新增用户失败,数据异常!',
                    buttons: Ext.MessageBox.OK,
                    icon: Ext.MessageBox.WARNING
                });
                break;
        }
    },
    editSaveCallback: function (records, operation) {
        console.log('edit save callback');

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
                    msg: '编辑用户失败,用户不存在!',
                    buttons: Ext.MessageBox.OK,
                    icon: Ext.MessageBox.WARNING
                });
                break;
            case 5:
                Ext.MessageBox.show({
                    title: 'Info',
                    msg: '编辑用户成功!',
                    buttons: Ext.MessageBox.OK,
                    icon: Ext.MessageBox.INFO
                });
                this.refreshGridData(mGridUserManager.getStore().currentPage);
                break;
            case 6:
                Ext.MessageBox.show({
                    title: 'Warning',
                    msg: '编辑用户失败,数据异常!',
                    buttons: Ext.MessageBox.OK,
                    icon: Ext.MessageBox.WARNING
                });
                break;
        }
    },
    deleteSaveCallback: function (records, operation) {
        console.log('delete save callback');

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
            case 7:
                Ext.MessageBox.show({
                    title: 'Info',
                    msg: '删除用户成功!',
                    buttons: Ext.MessageBox.OK,
                    icon: Ext.MessageBox.INFO
                });
                this.refreshGridData(mGridUserManager.getStore().currentPage);
                break;
            case 8:
                Ext.MessageBox.show({
                    title: 'Warning',
                    msg: '删除用户失败,数据异常!',
                    buttons: Ext.MessageBox.OK,
                    icon: Ext.MessageBox.WARNING
                });
                break;
        }
    }
});
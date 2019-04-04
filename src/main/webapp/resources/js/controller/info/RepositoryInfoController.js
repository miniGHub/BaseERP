var mWinRepositoryInfo = null;
var mGridRepositoryInfo = null;
Ext.define('AppIndex.controller.info.RepositoryInfoController',{
    extend:'Ext.app.ViewController',
    alias:'controller.repository_info_view',
    requires:[
        'AppIndex.view.info.RepositoryInfoViewWindowAdd',
        'AppIndex.view.info.RepositoryInfoViewWindowEdit'
    ],
    control:{},
    routes:{},

    // private methods
    loadGrid:function(){
        mGridRepositoryInfo = this.getView().down('app_repository_info_view_grid');
    },
    closeWin: function (){
        if (mWinRepositoryInfo) {
            mWinRepositoryInfo.close();
            mWinRepositoryInfo = null;
        }
    },
    refreshGridData: function(page) {
        if (mGridRepositoryInfo == null) {
            return;
        }

        // refresh grid data
        var store = mGridRepositoryInfo.getStore();
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
        console.log("product info manager onClickAdd");

        this.loadGrid();
        var repositoryInfoStore = mGridRepositoryInfo.getStore();
        var max = 0;
        Ext.each(repositoryInfoStore.getRange(0, repositoryInfoStore.getCount()), function(record) {
            if (max < parseInt(record.data['repository_id'])) {
                max = record.data['repository_id'];
            }
        });

        var addId = parseInt(max) + 1;
        // 补'0'
        addId = ('000' + addId).slice(-3);

        this.closeWin();
        mWinRepositoryInfo = Ext.create({
            xtype: 'app_repository_info_view_window_add'
        });
        var winForm = mWinRepositoryInfo.down('form').getForm();
        winForm.findField('repository_id').setValue(addId);
        mWinRepositoryInfo.show();
    },
    onClickEdit : function () {
        console.log("onClickEdit");

        this.loadGrid();
        var record = mGridRepositoryInfo.getSelectionModel().getSelection();

        if (0 === record.length) {
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
        mWinRepositoryInfo = Ext.create({
            xtype: 'app_repository_info_view_window_edit'
        });

        var winForm = mWinRepositoryInfo.down('form').getForm();
        winForm.findField('repository_id').setValue(record[0].data['repository_id']);
        winForm.findField('repository_type_name').setValue(record[0].data['repository_type']);
        winForm.findField('repository_name').setValue(record[0].data['repository_name']);
        winForm.findField('address').setValue(record[0].data['address']);
        winForm.findField('manager').setValue(record[0].data['manager']);
        winForm.findField('phone').setValue(record[0].data['phone']);
        mWinRepositoryInfo.show();
    },
    onClickDelete : function () {
        console.log("onClickDelete");

        this.loadGrid();
        var record = mGridRepositoryInfo.getSelectionModel().getSelection();

        if (0 === record.length) {
            Ext.MessageBox.show({
                title: 'INFO',
                msg: '请选择数据进行删除',
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

        var winForm = mWinRepositoryInfo.down('form').getForm();
        var winFormData = winForm.getValues();
        // console.log('winFormData:' + Ext.encode(winFormData));

        var sendParam= {
            repository_id: winFormData['repository_id'],
            repository_type: winFormData['repository_type_name'],
            repository_name: winFormData['repository_name'],
            address: winFormData['address'],
            manager: winFormData['manager'],
            phone: winFormData['phone']
        };

        console.log('sendParam:' + Ext.encode(sendParam));

        var sendStore = Ext.create('AppIndex.store.common.SendStore');
        sendStore.proxy.url += 'info/AddRepositoryInfo';
        sendStore.proxy.extraParams = sendParam;

        sendStore.load({
            scope: this,
            callback: function (records, operation, success) {
                console.log('load callback');

                var ret = COMMON_FUNC.StoreCallbackDialog(records, success);
                if (ret) {
                    // transfer success
                    this.addSaveCallback(records, operation);
                } else {
                    console.log("StoreCallbackDialog error!");
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

        var winForm = mWinRepositoryInfo.down('form').getForm();
        var winFormData = winForm.getValues();
        // console.log('winFormData:' + Ext.encode(winFormData));

        var sendParam= {
            repository_id: winFormData['repository_id'],
            repository_type: winFormData['repository_type_name'],
            repository_name: winFormData['repository_name'],
            address: winFormData['address'],
            manager: winFormData['manager'],
            phone: winFormData['phone']
        };

        console.log('sendParam:' + Ext.encode(sendParam));

        var sendStore = Ext.create('AppIndex.store.common.SendStore');
        sendStore.proxy.url += 'info/UpdateRepositoryInfo';
        sendStore.proxy.extraParams = sendParam;

        sendStore.load({
            scope: this,
            callback: function (records, operation, success) {
                console.log('load callback');

                var ret = COMMON_FUNC.StoreCallbackDialog(records, success);
                if (ret) {
                    // transfer success
                    this.editSaveCallback(records, operation);
                } else {
                    console.log("StoreCallbackDialog error!");
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

        if(btn === 'yes'){
            var record = mGridRepositoryInfo.getSelectionModel().getSelection();
            var listId = [];

            for (var i = 0; i < record.length; i++) {
                listId.push(record[i].data['repository_id']);
            }

            var sendParam = {
                grid: listId
            };
            console.log('sendParam:' + Ext.encode(sendParam));

            var sendStore = Ext.create('AppIndex.store.common.SendStore');
            sendStore.proxy.url += 'info/DeleteRepositoryInfo';
            sendStore.proxy.extraParams = sendParam;

            sendStore.load({
                scope: this,
                callback: function (records, operation, success) {
                    console.log('load callback');

                    var ret = COMMON_FUNC.StoreCallbackDialog(records, success);
                    if (ret) {
                        // transfer success
                        this.deleteSaveCallback(records, operation);
                    } else {
                        console.log("StoreCallbackDialog error!");
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
                    msg: '新增仓库信息失败,仓库信息已经存在!',
                    buttons: Ext.MessageBox.OK,
                    icon: Ext.MessageBox.WARNING
                });
                break;
            case 3:
                Ext.MessageBox.show({
                    title: 'Info',
                    msg: '新增仓库信息成功!',
                    buttons: Ext.MessageBox.OK,
                    icon: Ext.MessageBox.INFO
                });
                this.refreshGridData(mGridRepositoryInfo.getStore().currentPage);
                break;
            case 4:
                Ext.MessageBox.show({
                    title: 'Warning',
                    msg: '新增仓库信息失败,数据异常!',
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
                    msg: '编辑仓库信息失败,仓库信息不存在!',
                    buttons: Ext.MessageBox.OK,
                    icon: Ext.MessageBox.WARNING
                });
                break;
            case 5:
                Ext.MessageBox.show({
                    title: 'Info',
                    msg: '编辑仓库信息成功!',
                    buttons: Ext.MessageBox.OK,
                    icon: Ext.MessageBox.INFO
                });
                this.refreshGridData(mGridRepositoryInfo.getStore().currentPage);
                break;
            case 6:
                Ext.MessageBox.show({
                    title: 'Warning',
                    msg: '编辑仓库信息失败,数据异常!',
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
                    msg: '删除仓库信息成功!',
                    buttons: Ext.MessageBox.OK,
                    icon: Ext.MessageBox.INFO
                });
                this.refreshGridData(mGridRepositoryInfo.getStore().currentPage);
                break;
            case 8:
                Ext.MessageBox.show({
                    title: 'Warning',
                    msg: '删除仓库信息失败,数据异常!',
                    buttons: Ext.MessageBox.OK,
                    icon: Ext.MessageBox.WARNING
                });
                break;
        }
    }
});
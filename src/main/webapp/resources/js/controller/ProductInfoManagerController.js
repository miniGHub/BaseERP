var mWinProductInfoManager = null;
var mGridProductInfoManager = null;
Ext.define('AppIndex.controller.ProductInfoManagerController',{
    extend:'Ext.app.ViewController',
    alias:'controller.product_info_manager_view',
    requires:[
        'AppIndex.view.ProductInfoManagerViewWindowAdd',
        'AppIndex.view.ProductInfoManagerViewWindowEdit'
    ],
    control:{},
    routes:{},

    // private methods
    loadGrid:function(){
        mGridProductInfoManager = this.getView().down('app_product_info_manager_view_grid');
    },
    closeWin: function (){
        if (mWinProductInfoManager) {
            mWinProductInfoManager.close();
            mWinProductInfoManager = null;
        }
    },
    refreshGridData: function(page) {
        if (mGridProductInfoManager == null) {
            return;
        }

        // refresh grid data
        var store = mGridProductInfoManager.getStore();
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
        var productManagerStore = mGridProductInfoManager.getStore();
        var max = 0;
        Ext.each(productManagerStore.getRange(0, productManagerStore.getCount()), function(record) {
            if (max < parseInt(record.data['product_id'])) {
                max = record.data['product_id'];
            }
        });

        var addId = parseInt(max) + 1;
        // 补'0'
        addId = ('000' + addId).slice(-3);

        this.closeWin();
        mWinProductInfoManager = Ext.create({
            xtype: 'app_product_info_manager_view_window_add'
        });
        var winForm = mWinProductInfoManager.down('form').getForm();
        winForm.findField('product_id').setValue(addId);
        mWinProductInfoManager.show();
    },
    onClickEdit : function () {
        console.log("onClickEdit");

        this.loadGrid();
        var record = mGridProductInfoManager.getSelectionModel().getSelection();

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
        mWinProductInfoManager = Ext.create({
            xtype: 'app_product_info_manager_view_window_edit'
        });

        var winForm = mWinProductInfoManager.down('form').getForm();
        winForm.findField('product_id').setValue(record[0].data['product_id']);
        winForm.findField('product_name').setValue(record[0].data['product_type']);
        winForm.findField('product_specific_name').setValue(record[0].data['product_specific_name']);
        winForm.findField('barcode').setValue(record[0].data['barcode']);
        winForm.findField('state').setValue(record[0].data['state']);
        mWinProductInfoManager.show();
    },
    onClickDelete : function () {
        console.log("onClickDelete");

        this.loadGrid();
        var record = mGridProductInfoManager.getSelectionModel().getSelection();

        if (0 == record.length) {
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

        var winForm = mWinProductInfoManager.down('form').getForm();
        var winFormData = winForm.getValues();
        // console.log('winFormData:' + Ext.encode(winFormData));

        var sendParam= {
            product_id: winFormData['product_id'],
            product_type: winFormData['product_name'],
            product_specific_name: winFormData['product_specific_name'],
            barcode: winFormData['barcode'],
            state: winFormData['state']
        };

        console.log('sendParam:' + Ext.encode(sendParam));

        var sendStore = Ext.create('AppIndex.store.SendStore');
        sendStore.proxy.url += 'info/AddProductInfo';
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

        var winForm = mWinProductInfoManager.down('form').getForm();
        var winFormData = winForm.getValues();
        // console.log('winFormData:' + Ext.encode(winFormData));

        var sendParam= {
            product_id: winFormData['product_id'],
            product_type: winFormData['product_name'],
            product_specific_name: winFormData['product_specific_name'],
            barcode: winFormData['barcode'],
            state: winFormData['state']
        };

        console.log('sendParam:' + Ext.encode(sendParam));

        var sendStore = Ext.create('AppIndex.store.SendStore');
        sendStore.proxy.url += 'info/UpdateProductInfo';
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
            var record = mGridProductInfoManager.getSelectionModel().getSelection();
            var listId = [];

            for (var i = 0; i < record.length; i++) {
                var data = {
                    product_id: record[i].data['product_id']
                };
                listId.push(data);
            }

            var sendParam = {
                grid: listId
            };
            console.log('sendParam:' + Ext.encode(sendParam));

            var sendStore = Ext.create('AppIndex.store.SendStore');
            sendStore.proxy.url += 'info/DeleteProductInfo';
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
                    msg: '新郑商品信息失败,商品信息已经存在!',
                    buttons: Ext.MessageBox.OK,
                    icon: Ext.MessageBox.WARNING
                });
                break;
            case 3:
                Ext.MessageBox.show({
                    title: 'Info',
                    msg: '新增商品信息成功!',
                    buttons: Ext.MessageBox.OK,
                    icon: Ext.MessageBox.INFO
                });
                this.refreshGridData(mGridProductInfoManager.getStore().currentPage);
                break;
            case 4:
                Ext.MessageBox.show({
                    title: 'Warning',
                    msg: '新增商品信息失败,数据异常!',
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
                    msg: '编辑商品信息失败,商品信息不存在!',
                    buttons: Ext.MessageBox.OK,
                    icon: Ext.MessageBox.WARNING
                });
                break;
            case 5:
                Ext.MessageBox.show({
                    title: 'Info',
                    msg: '编辑商品信息成功!',
                    buttons: Ext.MessageBox.OK,
                    icon: Ext.MessageBox.INFO
                });
                this.refreshGridData(mGridProductInfoManager.getStore().currentPage);
                break;
            case 6:
                Ext.MessageBox.show({
                    title: 'Warning',
                    msg: '编辑商品信息失败,数据异常!',
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
                    msg: '删除商品信息成功!',
                    buttons: Ext.MessageBox.OK,
                    icon: Ext.MessageBox.INFO
                });
                this.refreshGridData(mGridProductInfoManager.getStore().currentPage);
                break;
            case 8:
                Ext.MessageBox.show({
                    title: 'Warning',
                    msg: '删除商品信息失败,数据异常!',
                    buttons: Ext.MessageBox.OK,
                    icon: Ext.MessageBox.WARNING
                });
                break;
        }
    }
});
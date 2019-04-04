Ext.define('AppIndex.controller.StorageInController',{
    extend:'Ext.app.ViewController',
    alias:'controller.storage_in_view',
    requires:['AppIndex.store.common.SendStore',
        'AppIndex.store.GetStore'
    ],
    control:{},
    routes:{},

    StorageInSubmit: function() {
        // grid data
        var grid = this.getView().down('app_storage_in_view_grid').getStore();
        var gridData = [];
        Ext.each(grid.getRange(0, grid.getCount()), function(record) {
            // delete value which key is 'id'
            delete record.data['id'];
            gridData.push(record.data);
        });
        // send parameters
        var sendParam ={
            grid: gridData
        };
        console.log("storage amount：" + grid.getCount());
        var sendStore = Ext.create('AppIndex.store.common.SendStore');
        sendStore.proxy.url += 'kc/SubmitStorageIn';
        sendStore.proxy.extraParams = sendParam;
        // sendStore.proxy.extraParams = test;
        // console.log(sendStore.proxy.url);
        sendStore.load({
            scope:this,
            callback: function (records, operation, success) {
                if (success) {
                    console.log(records);
                }
                if (success) {
                    Ext.Msg.alert('入库单', '提交成功');
                    grid.removeAll();
                }
            }
        });
    },

    StorageInPrint: function() {

    },
    StorageInLoad: function(combo, record, index) {
        var id = combo.getValue();
        console.log("purchase note id：" + id);
        var getStore = Ext.create('AppIndex.store.GetStore');
        getStore.proxy.url += "kc/LoadFromPurchaseNote";
        getStore.proxy.extraParams = {'purchase_note_id': id};
        console.log(getStore.proxy.url);
        getStore.load({
            scope:this,
            callback: function (records, operation, success) {
                if (success) {
                    console.log(records);
                    if (records.length > 0) {
                        this.getView().down('app_storage_in_view_grid').getStore().loadRecords(records);
                    }
                }
                else {
                    Ext.Msg.alert('入库单', '没有得到数据');
                }
            }
        });
    }
});
Ext.define('AppIndex.controller.StorageInController',{
    extend:'Ext.app.ViewController',
    alias:'controller.storage_in_view',
    requires:['AppIndex.store.SendStore',
        'AppIndex.store.GetStore'
    ],
    control:{},
    routes:{},

    StorageInSubmit: function() {
        Ext.Msg.alert('入库', 'StorageInSubmit');

        // grid data
        var store = this.getView().down('app_storage_in_view_grid').getStore();
        var gridData = [];
        Ext.each(store.getRange(0, store.getCount()), function(record) {
            // delete value which key is 'id'
            delete record.data['id'];
            gridData.push(record.data);
        });
        // console.log('gridData:'+ Ext.encode(gridData));

        // send parameters
        var sendParam ={
            grid: gridData
        };
        console.log('sendParam:' + Ext.encode(sendParam));

        var sendStore = Ext.create('AppIndex.store.SendStore');
        sendStore.proxy.url += 'kc/SubmitStorageIn';
        sendStore.proxy.extraParams =  sendParam;
        // sendStore.proxy.extraParams = test;
        // console.log(sendStore.proxy.url);
        sendStore.load({
            scope:this,
            callback: function (records, operation, success) {
                console.log('records:' + records);
                console.log('operation:' + operation);
                console.log('success:' + success);
            }
        });
    },

    StorageInPrint: function() {
        Ext.Msg.alert('打印', 'StorageInPrint');
    },
    StorageInLoad: function() {
        Ext.Msg.alert('加载', 'StorageInLoad');
        var getStore = Ext.create('AppIndex.store.GetStore');
        getStore.proxy.uri += "kc/LoadFromPurchaseNote";
        getStore.proxy.extraParams = {'purchase_note_id': "JH-2018-12-23-0001"};
        getStore.load({
            scope:this,
            callback: function (records, operation, success) {
                console.log('records:' + records);
                console.log('operation:' + operation);
                console.log('success:' + success);
            }
        });
    }
});
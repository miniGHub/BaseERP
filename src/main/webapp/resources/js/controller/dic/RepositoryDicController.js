Ext.define('AppIndex.controller.dic.RepositoryDicController',{
    extend:'Ext.app.ViewController',
    alias:'controller.repository_dic_view',
    requires:[],
    control:{},
    routes:{},

    onClickAdd : function () {
        console.log("onClickAdd");
        var grid = this.getView().down('app_repository_dic_view_grid');
        var store = grid.getStore();
        var max = 0;
        Ext.each(store.getRange(0, store.getCount()), function(record) {
            if (max < parseInt(record.data['repository_type'])) {
                max = record.data['repository_type'];
            }
        });
        // new line id
        max += 1;
        var line = {
            'repository_type' : max,
            'repository_type_name' : ''
        };
        store.insert(max, line);
    },
    onClickDelete : function () {
        console.log("onClickDelete");
        var grid = this.getView().down('app_repository_dic_view_grid');
        var store = grid.getStore();

        Ext.Msg.confirm('系统提示','确定要删除？',function(btn){
            if(btn=='yes'){
                var record = grid.getSelectionModel().getSelection()[0];
                store.remove(record);
            }
        });
    },
    onClickSave : function () {
        console.log("onClickSave");

        // grid data
        var store = this.getView().down('app_repository_dic_view_grid').getStore();
        var gridData = [];
        Ext.each(store.getRange(0, store.getCount()), function(record) {
            console.log('gridData:'+ Ext.encode(record.data));
            // delete value which key is 'id'
            delete record.data['id'];
            // continue
            if (0 == record.data['repository_type_name'].length) {
                return true;
            }
            gridData.push(record.data);
        });
        // console.log('gridData:'+ Ext.encode(gridData));

        // send parameters
        var sendParam ={
            grid: gridData
        };

        var sendStore = Ext.create('AppIndex.store.common.SendStore');
        sendStore.proxy.url += 'dic/SubmitRepositoryInfo';
        sendStore.proxy.extraParams =  sendParam;
        // console.log(sendStore.proxy.url);
        sendStore.load({
            scope:this,
            callback: function (records, operation, success) {
                console.log('load callback');

                var ret = COMMON_FUNC.StoreCallbackDialog(records, success);
                if (ret) {
                    // transfer success
                    this.repositoryDicCallback(records, operation);
                } else {
                    console.log("StoreCallbackDialog error!");
                }
            }
        });
    },
    onClickRefresh : function () {
        console.log("onClickRefresh");

        // grid data
        var store = this.getView().down('app_repository_dic_view_grid').getStore();
        store.reload();
    },
    repositoryDicCallback: function (records, operation) {
        console.log('repository dic callback');

    }
});
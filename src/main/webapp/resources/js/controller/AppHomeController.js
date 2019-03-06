var com={
    'app_sales_order_note_view':'app_west_business',
    'app_sales_note_view':'app_west_business',
    'app_purchase_note_view':'app_west_business',
    'app_storage_in_view':'app_west_business',
    'app_role_manager_view':'app_west_system',
    'app_depart_manager_view':'app_west_system',
    'app_product_info_view':'app_west_basic',
    'app_repository_info_view':'app_west_basic',
};
Ext.define('AppIndex.controller.AppHomeController',{
    extend:'Ext.app.ViewController',
    alias:'controller.home',
    requires:[
        'Ext.window.MessageBox'
    ],
    control:{
        'app_west_business':{
            selectionchange:'onTreeNavSelectionChange'
        },
        'app_west_system':{
            selectionchange:'onTreeNavSelectionChange'
        },
        'app_west_basic':{
            selectionchange:'onTreeNavSelectionChange'
        }
    },
    onTreeNavSelectionChange:function(selModel,records)
    {
        var record=records[0];
        console.log("onTreeNavSelectionChange:" + record.getId());
        if(record){
            this.redirectTo(record.getId());
        }
    },
    routes: {
        ':id': 'handleRoute'
    },
    handleRoute: function (id) {
        console.log('Handle:'+id);
        var comName = com[id];
        console.log('comName:' + comName);
        if (comName == undefined) {
            return;
        }
        var me=this,
            homeView = me.getView(),
            navigationTree = homeView.down(comName),
            centerPanel = homeView.down('app_center'),
            store=navigationTree.getStore(),
            node=store.getNodeById(id);
        var className, cmp;

        //响应路由，左侧树定位到相应节点
        navigationTree.getSelectionModel().select(node);
        navigationTree.getView().focusNode(node);

        centerPanel.removeAll(true);

        if (node.isLeaf()) {
            className = Ext.ClassManager.getNameByAlias('widget.' + id);
            console.log('cls:' + className);
            cmp = Ext.create(className);
            centerPanel.add(cmp);
        }
    },
    /*
    beforeHandleRoute: function (id, action) {
        console.log("beforeHandleRoute " + id + "," + action);
    },
    */
});
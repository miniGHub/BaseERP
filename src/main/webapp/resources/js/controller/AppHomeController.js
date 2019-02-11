Ext.define('AppIndex.controller.AppHomeController',{
    extend:'Ext.app.ViewController',
    alias:'controller.home',
    requires:[
        'Ext.window.MessageBox'
    ],
    control:{
        'app_navigation':{
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
        var me=this,
            homeView = me.getView(),
            navigationTree = homeView.down('app_navigation'),
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
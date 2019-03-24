var com={
    'app_sales_order_note_view':'app_west_business',
    'app_sales_note_view':'app_west_business',
    'app_purchase_note_view':'app_west_business',
    'app_storage_in_view':'app_west_business',
    'app_role_manager_view':'app_west_system',
    'app_depart_manager_view':'app_west_system',
    'app_user_manager_view':'app_west_system',
    'app_product_dic_view':'app_west_system',
    'app_repository_dic_view':'app_west_system',
    'app_password_change_view':'app_west_system',
    'app_password_reset_view':'app_west_system',
    'app_product_info_view':'app_west_basic',
    'app_repository_info_view':'app_west_basic',
    'app_supplier_manager_view':'app_west_basic',
    'app_product_info_manager_view':'app_west_basic'
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
        var homeView =  this.getView();
        var menuTree =  homeView.down(comName);
        var node = menuTree.getStore().getNodeById(id);
        var centerPanel = homeView.down('app_center');
        var tab = centerPanel.getComponent(id + '_item_id');            // param: require item id.

        //响应路由，左侧树定位到相应节点
        menuTree.getSelectionModel().select(node);
        menuTree.getView().focusNode(node);

        if (!node.isLeaf()) {
            console.log(id + " is not leaf!");
            return;
        }

        if (tab) {
            centerPanel.setActiveTab(tab);
        } else {
            var className = Ext.ClassManager.getNameByAlias('widget.' + id);
            var comp = Ext.create(className);
            centerPanel.setActiveTab(centerPanel.add(comp));
        }
    },
    onExitClick:function(){
        // Remove the localStorage key/value
        localStorage.removeItem('hasLogin');
        localStorage.removeItem('');

        // Remove Main View
        this.getView().destroy();

        Ext.create({
            xtype: 'app_login_view'
        });
    }
    /*
    beforeHandleRoute: function (id, action) {
        console.log("beforeHandleRoute " + id + "," + action);
    },
    */
});
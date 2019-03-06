Ext.define('AppIndex.view.RoleManagerViewGrid', {
    extend: 'Ext.grid.Panel',
    xtype: 'app_role_manager_view_grid',

    requires: [
        'AppIndex.store.RoleManagerStoreGrid'
    ],

    store:{
        type:'role_manager_store_grid'
    },
    selModel: {
        selType: 'cellmodel'
    },
    stripeRows:true, //斑马线效果
    tbar:[{
        text:'新增',
        iconCls: 'icon_add',
        handler: 'onClickAdd'
    },'-',{
        text:'删除',
        iconCls: 'icon_delete',
        handler: 'onClickDelete'
    },'-',{
        text:'保存',
        iconCls: 'icon_save',
        handler: 'onClickSave'
    },'-',{
        text:'刷新',
        iconCls: 'icon_refresh',
        handler: 'onClickRefresh'
    }
    ],
    plugins:[
        Ext.create('Ext.grid.plugin.CellEditing',{
            id:'role_cell_editing',
            clicksToEdit:1,
            destroy: function() {
                console.log('role destroy');
                this.fireEvent('beforedestroy', this);

                //     this.beforeDestroy();
                //     this.ownerCt.remove(this, false);
                //     this.container.remove();
                //     this.onDestroy();
                //     Ext.ComponentMgr.unregister(this);
                //     this.fireEvent('destroy', this);
                //     this.isDestroyed = true;
            }
        })
    ],
    columns: [
        {
            text: '角色ID',
            dataIndex: 'role_id',
            editor: 'textfield',
            align: 'center',
            menuDisabled: true,
            sortable:false
        },
        {
            text: '角色名称',
            dataIndex: 'role_name',
            editor: 'textfield',
            width: 400,
            align: 'center',
            menuDisabled: true,
            sortable:false
        }
    ],
    /*
    dockedItems: [
        {
            xtype: 'pagingtoolbar',
            store:{
                type:'role_manager_store_grid'
            },
            dock: 'bottom',
            displayInfo: true,
            displayMsg : '显示单位信息 {0} - {1} of {2}',
            emptyMsg : "没有单位信息",
        }
    ],
    */
    onRender: function () {
        console.log("onRender ");
        this.callParent(arguments);

        // hide role_id
        var columns = this.getView().up('app_role_manager_view_grid').getColumns();
        columns[0].hidden = true;
        columns[0].hide();
/***
        // grid data
        var store = this.getView().up('app_role_manager_view_grid').getStore();
        store.loadPage(1);

        // hide refresh button
        var length = this.getView().up('app_role_manager_view_grid').dockedItems.keys.length;
        var refreshStr= "";
        for (var i = 0; i < length; i++) {
            if (this.getView().up('app_role_manager_view_grid').dockedItems.keys[i].indexOf("pagingtoolbar") !== -1) {
                refreshStr= this.getView().up('app_role_manager_view_grid').dockedItems.keys[i];
            }
        }
        this.getView().up('app_role_manager_view_grid').dockedItems.get(refreshStr).child('#refresh').hide(true);
 ***/
    }
});
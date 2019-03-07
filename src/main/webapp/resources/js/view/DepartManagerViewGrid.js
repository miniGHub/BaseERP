Ext.define('AppIndex.view.DepartManagerViewGrid', {
    extend: 'Ext.grid.Panel',
    xtype: 'app_depart_manager_view_grid',

    requires: [
        'AppIndex.store.DepartManagerStoreGrid'
    ],

    store:{
        type:'depart_manager_store_grid'
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
            id:'depart_cell_editing',
            clicksToEdit:1,
            destroy: function() {
                console.log('depart destroy');
                this.fireEvent('beforedestroy', this);
            }
        })
    ],
    columns: [
        {
            text: '部门ID',
            dataIndex: 'depart_id',
            editor: 'textfield',
            align: 'center',
            menuDisabled: true,
            sortable:false
        },
        {
            text: '部门名称',
            dataIndex: 'depart_name',
            editor: 'textfield',
            width: 400,
            align: 'center',
            menuDisabled: true,
            sortable:false
        }
    ],
    onRender: function () {
        console.log("onRender depart");
        this.callParent(arguments);

        // hide role_id
        var columns = this.getView().up('app_depart_manager_view_grid').getColumns();
        columns[0].hidden = true;
        columns[0].hide();
    }
});
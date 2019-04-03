Ext.define('AppIndex.view.info.SupplierInfoViewGrid', {
    extend: 'Ext.grid.Panel',
    xtype: 'app_supplier_info_view_grid',

    requires: [
        'AppIndex.store.info.GetAllSupplierInfoStore'
    ],

    store:{
        type:'get_all_supplier_info_store'
    },
    selModel: {
        selType: 'cellmodel'
    },
    stripeRows:true, //斑马线效果
    tbar:[
        {
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
            id:'supplier_cell_editing',
            clicksToEdit:1,
            destroy: function() {
                console.log('supplier destroy');
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
            text: '供应商ID',
            dataIndex: 'supplier_id',
            editor: 'textfield',
            align: 'center',
            menuDisabled: true,
            sortable:false
        },
        {
            text: '供应商名称',
            dataIndex: 'supplier_name',
            editor: 'textfield',
            width: 400,
            align: 'center',
            menuDisabled: true,
            sortable:false
        },
        {
            text: '负责人',
            dataIndex: 'manager',
            editor: 'textfield',
            width: 400,
            align: 'center',
            menuDisabled: true,
            sortable:false
        },
        {
            text: '联系电话',
            dataIndex: 'phone',
            editor: 'textfield',
            width: 400,
            align: 'center',
            menuDisabled: true,
            sortable:false
        }
    ],
    onRender: function () {
        console.log("onRender ");
        this.callParent(arguments);

        var grid = this.getView().up('app_supplier_info_view_grid');

        // hide role_id
        var columns = grid.getColumns();
        columns[0].hidden = true;
        columns[0].hide();
    }
});
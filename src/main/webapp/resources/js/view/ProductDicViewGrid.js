Ext.define('AppIndex.view.ProductDicViewGrid', {
    extend: 'Ext.grid.Panel',
    xtype: 'app_product_dic_view_grid',

    requires: [
        'AppIndex.store.GetAllProductDicStore'
    ],

    store:{
        type:'get_all_product_dic_store'
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
                console.log('product destroy');
                this.fireEvent('beforedestroy', this);
            }
        })
    ],
    columns: [
        {
            text: '商品类别',
            dataIndex: 'product_type',
            editor: 'textfield',
            align: 'center',
            menuDisabled: true,
            sortable:false
        },
        {
            text: '商品分类名称',
            dataIndex: 'product_dic_name',
            editor: 'textfield',
            width: 400,
            align: 'center',
            menuDisabled: true,
            sortable:false
        }
    ],
    onRender: function () {
        console.log("onRender product info");
        this.callParent(arguments);

        // hide product_type
        var columns = this.getView().up('app_product_dic_view_grid').getColumns();
        columns[0].hidden = true;
        columns[0].hide();
    }
});
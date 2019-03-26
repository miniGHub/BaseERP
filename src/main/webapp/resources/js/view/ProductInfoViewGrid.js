Ext.define('AppIndex.view.ProductInfoViewGrid', {
    extend: 'Ext.grid.Panel',
    xtype: 'app_product_info_view_grid',

    requires: [
        'AppIndex.store.GetAllProductInfoStorePage'
    ],

    store:{
        type:'get_all_product_info_store_page'
    },
    selModel: {
        selType: 'checkboxmodel'
    },
    stripeRows:true, //斑马线效果
    tbar:[
        {
            text:'新增',
            iconCls: 'icon_add',
            handler: 'onClickAdd'
        },'-',{
            text:'编辑',
            iconCls: 'icon_edit',
            handler: 'onClickEdit'
        },'-',{
            text:'删除',
            iconCls: 'icon_delete',
            handler: 'onClickDelete'
        },'-',{
            text:'刷新',
            iconCls: 'icon_refresh',
            handler: 'onClickRefresh'
        }
    ],
    columns: [
        {
            text: '商品编号',
            dataIndex: 'product_id',
            editor: 'textfield',
            align: 'center',
            menuDisabled: true,
            sortable:false
        },
        {
            text: '商品分类',
            dataIndex: 'product_dic_name',
            editor: 'textfield',
            width: 200,
            align: 'center',
            menuDisabled: true,
            sortable:false
        },
        {
            text: '商品名称',
            dataIndex: 'product_name',
            editor: 'textfield',
            width: 200,
            align: 'center',
            menuDisabled: true,
            sortable:false
        },
        {
            text: '条码',
            dataIndex: 'barcode',
            editor: 'textfield',
            width: 200,
            align: 'center',
            menuDisabled: true,
            sortable:false
        },
        {
            text: '状态',
            dataIndex: 'state',
            editor: 'textfield',
            width: 200,
            align: 'center',
            menuDisabled: true,
            sortable:false
        }

    ],
    dockedItems:[
        {
            xtype:'pagingtoolbar',
            dock: 'bottom',
            store: this.store,
            display:true
        }
    ],
    onRender: function () {
        console.log("onRender ");
        this.callParent(arguments);

        var grid = this.getView().up('app_product_info_view_grid');

        // hide refresh button
        var length = grid.dockedItems.keys.length;
        var refreshStr= "";
        for (var i = 0; i < length; i++) {
            if (grid.dockedItems.keys[i].indexOf("pagingtoolbar") !== -1) {
                refreshStr= grid.dockedItems.keys[i];
            }
        }
        grid.dockedItems.get(refreshStr).child('#refresh').hide(true);
    }
});
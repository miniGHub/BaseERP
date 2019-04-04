Ext.define('AppIndex.view.SalesOrderNoteViewGrid', {
    extend: 'Ext.grid.Panel',
    xtype: 'app_sales_order_note_view_grid',

    requires: [
        'AppIndex.store.SalesOrderNoteStoreGrid'
    ],

    store:{
        type:'sales_order_note_store_grid'
    },
    stripeRows:true, //斑马线效果
    selModel: {
        selType: 'checkboxmodel'
    },
    tbar:[
        {
            text:'新增',
            iconCls: 'icon_add',
            handler: 'onClickAddDetail'
        },'-',{
            text:'删除',
            iconCls: 'icon_delete',
            handler: 'onClickDeleteDetail'
        }
    ],
    columns: [
        { text: '批号',  dataIndex: 'batch_id', editor: 'textfield' },
        { text: '商品编号', dataIndex: 'product_id', editor: 'textfield'},
        { text: '商品名称', dataIndex: 'product_name', editor: 'textfield'},
        { text: '单位',  dataIndex: 'client_id', editor: 'textfield'},
        { text: '数量', dataIndex: 'amount', editor: 'textfield'},
        { text: '单价',  dataIndex: 'unit_price', editor: 'textfield'},
        { text: '金额', dataIndex: 'balance', editor: 'textfield'},
        { text: '折扣', dataIndex: 'discount', editor: 'textfield'},
        { text: '折后单价', dataIndex: 'discount_unit_price', editor: 'textfield'},
        { text: '折后金额', dataIndex: 'discount_balance', editor: 'textfield'},
        { text: '税率', dataIndex: 'rate', editor: 'textfield'},
        { text: '含税金额', dataIndex: 'rate_balance', editor: 'textfield'},
        { text: '条码', dataIndex: 'barcode', editor: 'textfield'},
        { text: '状态', dataIndex: 'state', editor: 'textfield'},
        { text: '备注', dataIndex: 'comment', editor: 'textfield'}
    ]
});
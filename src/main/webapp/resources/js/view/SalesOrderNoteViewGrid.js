Ext.define('AppIndex.view.SalesOrderNoteViewGrid', {
    extend: 'Ext.grid.Panel',
    xtype: 'app_sales_order_note_view_grid',

    requires: [
        'AppIndex.store.SalesOrderNoteStoreGrid'
    ],

    store:{
        type:'sales_order_note_store_grid'
    },
    selModel: {
        selType: 'cellmodel',
        //mode: 'MULTI'
    },
    stripeRows:true, //斑马线效果
    tbar:[{
        text:'添加一行',
        handler:function(){
            // console.log('add handler');
            var store = this.up('app_sales_order_note_view_grid').getStore();
            var line = Ext.create('AppIndex.model.SalesOrderNoteModelGrid');
            store.insert(0, line);
        }
    },'-',{
        text:'删除一行',
        handler:function(){
            var grid = this.up('app_sales_order_note_view_grid')
            var store = grid.getStore();
            // console.log('grid:' + grid);
            Ext.Msg.confirm('系统提示','确定要删除？',function(btn){
                if(btn=='yes'){
                    var record = grid.getSelectionModel().getSelection()[0];
                    store.remove(record);
                }
            });
        }
    }],
    plugins:[
        Ext.create('Ext.grid.plugin.CellEditing',{
            clicksToEdit:1 //设置单击单元格编辑
        })
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
        { text: '备注', dataIndex: 'comment', editor: 'textfield', flex:1}
    ],
});
Ext.define('AppIndex.view.PurchaseNoteViewGrid', {
    extend: 'Ext.grid.Panel',
    xtype: 'app_purchase_note_view_grid',

    requires: [
        'AppIndex.store.PurchaseNoteStoreGrid'
    ],

    store:{
        type:'purchase_note_store_grid'
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
            var store = this.up('app_purchase_note_view_grid').getStore();
            var line = Ext.create('AppIndex.model.PurchaseNoteModelGrid');
            store.insert(0, line);
        }
    },'-',{
        text:'删除一行',
        handler:function(){
            var grid = this.up('app_purchase_note_view_grid')
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
            id:'purchase_note_cell_editing',
            clicksToEdit:1,
            destroy: function() {
                console.log('purchase note destroy');
                this.fireEvent('beforedestroy', this);
            }
        })
    ],
    columns: [
        { text: '进货单号', dataIndex: 'purchase_note_id'},
        { text: '商品编号', dataIndex: 'product_id'},
        { text: '仓库编号',  dataIndex: 'repository_id', editor: 'textfield'},
        { text: '数量', dataIndex: 'amount', editor: 'textfield'},
        { text: '单价',  dataIndex: 'unit_price', editor: 'textfield'},
        { text: '金额', dataIndex: 'balance', editor: 'textfield'},
        { text: '开票金额', dataIndex: 'invoice_balance', editor: 'textfield'},
        { text: '条码', dataIndex: 'barcode', editor: 'textfield'},
        { text: '状态', dataIndex: 'state', editor: 'textfield'},
        { text: '备注', dataIndex: 'comment', editor: 'textfield', flex:1}
    ],
});
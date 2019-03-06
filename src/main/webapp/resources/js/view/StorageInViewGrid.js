Ext.define('AppIndex.view.StorageInViewGrid', {
    extend: 'Ext.grid.Panel',
    xtype: 'app_storage_in_view_grid',

    requires: [
        'AppIndex.store.StorageInStoreGrid'
    ],

    store:{
        type:'storage_in_store_grid'
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
            var store = this.up('app_storage_in_view_grid').getStore();
            var line = Ext.create('AppIndex.model.StorageInModelGrid');
            store.insert(0, line);
        }
    },'-',{
        text:'删除一行',
        handler:function(){
            var grid = this.up('app_storage_in_view_grid')
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
            id:'storage_in_cell_editing',
            clicksToEdit:1,
            destroy: function() {
                console.log('storage in destroy');
                this.fireEvent('beforedestroy', this);
            }
        })
    ],
    columns: [
        { text: '商品编号', dataIndex: 'product_id', editor: 'textfield'},
        { text: '仓库编号',  dataIndex: 'repository_id', editor: 'textfield'},
        { text: '入库日期', dataIndex: 'in_date', editor: 'textfield'},
        { text: '数量',  dataIndex: 'amount', editor: 'textfield'},
        { text: '进货单号', dataIndex: 'purchase_note_id', editor: 'textfield'},
        { text: '销售进货', dataIndex: 'sales_return_note_id', editor: 'textfield'},
        { text: '销售换货', dataIndex: 'sales_exchange_note_id', editor: 'textfield'},
        { text: '状态', dataIndex: 'state', editor: 'textfield'},
        { text: '备注', dataIndex: 'comment', editor: 'textfield', flex:1}
    ],
});
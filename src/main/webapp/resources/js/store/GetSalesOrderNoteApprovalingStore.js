Ext.define('AppIndex.store.GetSalesOrderNoteApprovalingStore',{
    extend: 'Ext.data.Store',
    alias: 'store.get_sales_order_note_approvaling_store',

    fields: [
        {name: 'sales_order_note_id', type: 'string'}
    ],
    proxy: {
        type : 'ajax',
        actionMethods: {
            read   : 'POST',
        },
        headers: {
            'Content-Type': 'application/json'
        },
        reader : {
            type : 'json'
        },
        url : 'http://localhost:8080/BasePSS/xs/GetSalesOrderNoteApprovaling',
        noCache:false
    },
    autoLoad: true
});
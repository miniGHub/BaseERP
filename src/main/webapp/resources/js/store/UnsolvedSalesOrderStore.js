Ext.define('AppIndex.store.UnsolvedSalesOrderStore',{
    extend: 'Ext.data.Store',
    alias: 'store.unsolved_sales_order_store',
    fields: ['sales_order_note_id'],
    proxy: {
        type : 'ajax',
        headers: {"Accept": 'application/json', 'Content-Type': 'application/json'},
        reader : {
            type : 'json'
        },
//        paramsAsJson:true,
        url : 'http://localhost:8080/xs/UnsolvedSalesOrder',
        noCache:false
    },
    autoLoad: true,
});
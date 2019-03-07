Ext.define('AppIndex.store.ProductInfoStoreGrid', {
    extend: 'Ext.data.ArrayStore',
    alias: 'store.product_info_store_grid',

    fields:[
        {name: 'product_id', type: 'int'},
        {name: 'product_name', type: 'string'}
    ],

    proxy: {
        type : 'ajax',
        actionMethods: {
            read: 'POST'
        },
        headers: {
            'Content-Type': 'application/json'
        },
        reader : {
            type : 'json'
        },
        url : 'http://localhost:8080/BasePSS/dic/GetAllProduct',
        noCache:false,
        remoteSort: true
    },

    //pageSize: 20,
    autoLoad: true,
});
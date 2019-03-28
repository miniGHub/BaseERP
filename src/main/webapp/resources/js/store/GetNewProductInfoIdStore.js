Ext.define('AppIndex.store.GetNewProductInfoIdStore', {
    extend: 'Ext.data.ArrayStore',
    alias: 'store.get_new_product_info_id_store',

    fields:[
        {name: 'product_id', type: 'string'}
    ],

    proxy: {
        type: 'ajax',
        actionMethods: {
            read: 'POST'
        },
        headers: {
            'Content-Type': 'application/json'
        },
        reader: {
            type: 'json'
        },
        url: 'http://localhost:8080/BasePSS/info/GetNewProductInfoId',
        noCache: false,
        remoteSort: true
    },
    autoLoad: false
});
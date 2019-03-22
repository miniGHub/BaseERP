Ext.define('AppIndex.store.GetAllProductInfoStorePage', {
    extend: 'Ext.data.ArrayStore',
    alias: 'store.get_all_product_info_store_page',

    fields:[
        {name: 'product_id', type: 'string'},
        //Dic
        {name: 'product_type', type: 'int'},
        {name: 'product_name', type: 'string'},
        //Info
        {name: 'product_specific_name', type: 'string'},
        {name: 'barcode', type: 'string'},
        {name: 'state', type: 'string'},

    ],

    proxy: {
        type: 'ajax',
        actionMethods: {
            read: 'GET'
        },
        headers: {
            'Content-Type': 'application/json'
        },
        reader: {
            type: 'json',
            rootProperty: 'items',
            totalProperty: 'total'
        },
        url: 'http://localhost:8080/BasePSS/info/GetAllProductInfoPage',
        extraParams:{
            isReqDB: false
        },
        noCache: false,
        remoteSort: true
    },

    pageSize: 3,
    autoLoad: true
});
Ext.define('AppIndex.store.dic.GetAllProductDicStore', {
    extend: 'Ext.data.ArrayStore',
    alias: 'store.get_all_product_dic_store',

    fields: [
        {name: 'product_type', type: 'int'},
        {name: 'product_type_name', type: 'string'}
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
        url: COMMON_DATA.ServerUrl + 'dic/GetAllProduct',
        noCache: false,
        remoteSort: true
    },
    autoLoad: true
});
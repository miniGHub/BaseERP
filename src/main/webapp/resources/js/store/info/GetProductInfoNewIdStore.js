Ext.define('AppIndex.store.info.GetProductInfoNewIdStore', {
    extend: 'Ext.data.ArrayStore',
    alias: 'store.get_product_info_new_id_store',

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
        url: COMMON_DATA.ServerUrl + 'info/GetProductInfoNewId',
        noCache: false,
        remoteSort: true
    },
    autoLoad: false
});
Ext.define('AppIndex.store.GetNewIdStore', {
    extend: 'Ext.data.ArrayStore',
    alias: 'store.get_new_id_store',

    fields:[
        {name: 'id', type: 'string'}
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
        url: 'http://localhost:8080/BasePSS/info/GetNewId',
        noCache: false,
        remoteSort: true
    },
    autoLoad: false
});
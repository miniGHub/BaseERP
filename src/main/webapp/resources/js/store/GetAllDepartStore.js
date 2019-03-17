Ext.define('AppIndex.store.GetAllDepartStore', {
    extend: 'Ext.data.ArrayStore',
    alias: 'store.get_all_depart_store',

    fields: [
        {name: 'depart_id', type: 'int'},
        {name: 'depart_name', type: 'string'}
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
        url : 'http://localhost:8080/BasePSS/dic/GetAllDepart',
        noCache:false,
        remoteSort: true
    },
    autoLoad: true,
});
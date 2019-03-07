Ext.define('AppIndex.store.DepartManagerStoreGrid', {
    extend: 'Ext.data.ArrayStore',
    alias: 'store.depart_manager_store_grid',

    fields:[
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

    //pageSize: 20,
    autoLoad: true,
});
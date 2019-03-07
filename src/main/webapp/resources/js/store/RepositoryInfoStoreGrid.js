Ext.define('AppIndex.store.RepositoryInfoStoreGrid', {
    extend: 'Ext.data.ArrayStore',
    alias: 'store.repository_info_store_grid',

    fields:[
        {name: 'repository_id', type: 'int'},
        {name: 'repository_name', type: 'string'}
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
        url : 'http://localhost:8080/BasePSS/dic/GetAllRepository',
        noCache:false,
        remoteSort: true
    },

    //pageSize: 20,
    autoLoad: true,
});
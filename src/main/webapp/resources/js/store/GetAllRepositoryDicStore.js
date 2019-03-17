Ext.define('AppIndex.store.GetAllRepositoryDicStore', {
    extend: 'Ext.data.ArrayStore',
    alias: 'store.get_all_repository_dic_store',

    fields: [
        {name: 'repository_type', type: 'int'},
        {name: 'repository_name', type: 'string'}
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
        url: 'http://localhost:8080/BasePSS/dic/GetAllRepository',
        noCache: false,
        remoteSort: true
    },
    autoLoad: true
});
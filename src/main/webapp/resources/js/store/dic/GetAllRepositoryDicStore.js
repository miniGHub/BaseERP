Ext.define('AppIndex.store.dic.GetAllRepositoryDicStore', {
    extend: 'Ext.data.ArrayStore',
    alias: 'store.get_all_repository_dic_store',

    fields: [
        {name: 'repository_type', type: 'int'},
        {name: 'repository_type_name', type: 'string'}
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
        url: COMMON_DATA.ServerUrl + 'dic/GetAllRepository',
        noCache: false,
        remoteSort: true
    },
    autoLoad: true
});
Ext.define('AppIndex.store.GetAllRepositoryInfoPageStore', {
    extend: 'Ext.data.ArrayStore',
    alias: 'store.get_all_repository_info_page_store',

    fields:[
        {name: 'repository_id', type: 'string'},
        {name: 'repository_type', type: 'int'},
        {name: 'repository_type_name', type: 'string'},
        {name: 'repository_name', type: 'string'},
        {name: 'address', type: 'string'},
        {name: 'manager', type: 'string'},
        {name: 'phone', type: 'string'}
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
        url: 'http://localhost:8080/BasePSS/info/GetAllRepositoryPage',
        extraParams:{
            isReqDB: false
        },
        noCache: false,
        remoteSort: true
    },

    pageSize: 3,
    autoLoad: true
});
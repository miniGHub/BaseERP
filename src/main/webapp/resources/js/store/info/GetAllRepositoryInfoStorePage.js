Ext.define('AppIndex.store.info.GetAllRepositoryInfoStorePage', {
    extend: 'Ext.data.ArrayStore',
    alias: 'store.get_all_repository_info_store_page',

    fields: [
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
        url: COMMON_DATA.ServerUrl + 'info/GetAllRepositoryPage',
        extraParams:{
            isReqDB: false
        },
        noCache: false,
        remoteSort: true
    },

    pageSize: COMMON_DATA.PageSize,
    autoLoad: true
});
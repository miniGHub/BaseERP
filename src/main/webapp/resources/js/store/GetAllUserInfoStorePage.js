Ext.define('AppIndex.store.GetAllUserInfoStorePage', {
    extend: 'Ext.data.ArrayStore',
    alias: 'store.get_all_user_info_store_page',

    fields:[
        {name: 'id', type: 'string'},
        {name: 'name', type: 'string'},
        {name: 'phone', type: 'string'},
        {name: 'role_id', type: 'int'},
        {name: 'role_name', type: 'string'},
        {name: 'depart_id', type: 'int'},
        {name: 'depart_name', type: 'string'}
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
        url: 'http://localhost:8080/BasePSS/info/GetAllUserInfoPage',
        noCache: false,
        remoteSort: true
    },

    pageSize: 3,
    autoLoad: true
});
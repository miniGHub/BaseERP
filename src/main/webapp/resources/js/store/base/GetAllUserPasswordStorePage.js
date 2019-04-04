Ext.define('AppIndex.store.base.GetAllUserPasswordStorePage', {
    extend: 'Ext.data.ArrayStore',
    alias: 'store.get_all_user_password_store_page',

    fields:[
        {name: 'id', type: 'string'},
        {name: 'name', type: 'string'},
        {name: 'role_id', type: 'int'},
        {name: 'role_name', type: 'string'},
        {name: 'depart_id', type: 'int'},
        {name: 'depart_name', type: 'string'},
        {name: 'password_state', type: 'string'}
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
        url: COMMON_DATA.ServerUrl + 'info/GetAllUserPasswordPage',
        extraParams:{
            isReqDB: false
        },
        noCache: false,
        remoteSort: true
    },

    pageSize: COMMON_DATA.PageSize,
    autoLoad: true
});
Ext.define('AppIndex.store.RoleManagerStoreGrid', {
    extend: 'Ext.data.ArrayStore',
    alias: 'store.role_manager_store_grid',

    fields:[
        {name: 'role_id', type: 'int'},
        {name: 'role_name', type: 'string'}
    ],

    proxy: {
        type : 'ajax',
        actionMethods: {
            read   : 'POST',
        },
        headers: {
            'Content-Type': 'application/json'
        },
        reader : {
            type : 'json'
        },
        url : 'http://localhost:8080/BasePSS/dic/GetAllRole',
        noCache:false,
        remoteSort: true
    },

    //pageSize: 20,
    autoLoad: true,
});
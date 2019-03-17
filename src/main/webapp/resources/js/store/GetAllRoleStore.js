Ext.define('AppIndex.store.GetAllRoleStore', {
    extend: 'Ext.data.ArrayStore',
    alias: 'store.get_all_role_store',

    fields: [
        { name: 'role_id', type: 'int' },
        { name: 'role_name', type: 'string' }
    ],

    proxy: {
        type: 'ajax',
        actionMethods: {
            read: 'POST'
        },
        headers: {
            'Content-Type': 'application/json'
        },
        reader : {
            type : 'json'
        },
        url: 'http://localhost:8080/BasePSS/dic/GetAllRole',
        noCache: false,
        remoteSort: true
    },

    autoLoad: true
});
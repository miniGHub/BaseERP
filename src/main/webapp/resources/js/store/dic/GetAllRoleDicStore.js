Ext.define('AppIndex.store.dic.GetAllRoleDicStore', {
    extend: 'Ext.data.ArrayStore',
    alias: 'store.get_all_role_dic_store',

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
        url: COMMON_DATA.ServerUrl + 'dic/GetAllRole',
        noCache: false,
        remoteSort: true
    },

    autoLoad: true
});
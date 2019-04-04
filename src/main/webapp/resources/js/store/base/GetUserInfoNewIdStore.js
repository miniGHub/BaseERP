Ext.define('AppIndex.store.base.GetUserInfoNewIdStore', {
    extend: 'Ext.data.ArrayStore',
    alias: 'store.get_user_info_new_id_store',

    fields:[
        {name: 'id', type: 'string'}
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
        url: COMMON_DATA.ServerUrl + 'info/GetUserInfoNewId',
        noCache: false,
        remoteSort: true
    },
    autoLoad: false
});
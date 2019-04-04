Ext.define('AppIndex.store.common.SendStore', {
    extend: 'Ext.data.Store',
    alias: 'store.send_store',

    proxy : {
        type : 'ajax',
        actionMethods: {
            create : 'POST', // by default GET
            read   : 'POST',
            update : 'POST',
            destroy: 'POST'
        },
        headers: {
            'Content-Type': 'application/json'
        },
        paramsAsJson:true,
        url : COMMON_DATA.ServerUrl,
        extraParams:{},
    },
    autoLoad: false
});
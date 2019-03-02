Ext.define('AppIndex.store.SendStore', {
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
        url : 'http://localhost:8080/BasePSS/',
        extraParams:{},
    },
    autoLoad: false
});
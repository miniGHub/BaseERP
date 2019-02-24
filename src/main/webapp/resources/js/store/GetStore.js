Ext.define('AppIndex.store.GetStore', {
    extend: 'Ext.data.Store',
    alias: 'store.get_store',

    proxy : {
        type : 'ajax',
        headers: {"Accept": 'application/json', 'Content-Type': 'application/json'},
        reader : {
            type : 'json'
        },
//        paramsAsJson:true,
        url : 'http://localhost:8080/',
        extraParams:{},
        noCache:false
    },
    autoLoad: false
});
Ext.define('AppIndex.store.dic.GetAllDepartDicStore', {
    extend: 'Ext.data.ArrayStore',
    alias: 'store.get_all_depart_dic_store',

    fields: [
        {name: 'depart_id', type: 'int'},
        {name: 'depart_name', type: 'string'}
    ],

    proxy: {
        type : 'ajax',
        actionMethods: {
            read: 'POST'
        },
        headers: {
            'Content-Type': 'application/json'
        },
        reader : {
            type : 'json'
        },
        url : COMMON_DATA.ServerUrl + 'dic/GetAllDepart',
        noCache:false,
        remoteSort: true
    },
    autoLoad: true,
});
Ext.define('AppIndex.store.info.GetAllSupplierInfoStore', {
    extend: 'Ext.data.ArrayStore',
    alias: 'store.get_all_supplier_info_store',

    fields: [
        {name: 'supplier_id', type: 'string'},
        {name: 'supplier_name', type: 'string'},
        {name: 'manager', type: 'string'},
        {name: 'phone', type: 'string'}
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
        url : COMMON_DATA.ServerUrl + 'info/GetAllSupplier',
        noCache:false,
        remoteSort: true
    },
    autoLoad: true,
});
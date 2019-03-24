Ext.define('AppIndex.store.GetAllSupplierStore', {
    extend: 'Ext.data.ArrayStore',
    alias: 'store.get_all_supplier_store',


    fields: [
        {name: 'supplier_id', type: 'int'},
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
        url : 'http://localhost:8080/BasePSS/info/GetAllSupplier',
        noCache:false,
        remoteSort: true
    },
    autoLoad: true,
});
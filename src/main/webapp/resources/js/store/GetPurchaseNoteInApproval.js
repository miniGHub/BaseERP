Ext.define('AppIndex.store.GetPurchaseNoteInApproval',{
    extend: 'Ext.data.Store',
    alias: 'store.get_purchase_note_in_approval',

    fields: ['purchase_note_id'],
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
        url : 'http://localhost:8080/BasePSS/cg/GetPurchaseNoteInApproval',
        noCache:false
    },
    autoLoad: true
});
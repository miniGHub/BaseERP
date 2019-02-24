Ext.define('AppIndex.store.PurchaseNoteStoreGrid', {
    extend: 'Ext.data.ArrayStore',
    alias: 'store.purchase_note_store_grid',
    model: 'AppIndex.model.PurchaseNoteModelGrid',

    autoLoad: false,
    data:[
        ['', '', '', '', 0, 0.0, 0.0, 0.0, '', '', '']
    ]
});
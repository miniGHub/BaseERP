Ext.define('AppIndex.store.SalesNoteStoreGrid', {
    extend: 'Ext.data.ArrayStore',
    alias: 'store.sales_note_store_grid',
    model: 'AppIndex.model.SalesNoteModelGrid',

    autoLoad: false,
    data:[
        ['', '', 0, 0.0, 0.0, 0.0, 0.0, 0.0, '', 0, '']
    ]
});
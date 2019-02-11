Ext.define('AppIndex.store.SalesOrderNoteStoreGrid', {
    extend: 'Ext.data.ArrayStore',
    alias: 'store.sales_order_note_store_grid',
    model: 'AppIndex.model.SalesOrderNoteModelGrid',

    autoLoad: false,
    data:[
        ['', '', '', '', 0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, '', '', '']
    ]
});
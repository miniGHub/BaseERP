Ext.define('AppIndex.store.StorageInStoreGrid', {
    extend: 'Ext.data.ArrayStore',
    alias: 'store.storage_in_store_grid',
    model: 'AppIndex.model.StorageInModelGrid',

    autoLoad: false,
    data:[
        ['', '', '', 0, '', '', '', 0, '']
    ]
});
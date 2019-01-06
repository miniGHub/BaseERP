Ext.define('et.store.Menus',{
    extend: 'Ext.data.TreeStore',
    requires: 'et.model.Menu',
 	model: 'et.model.Menu',
 	autoLoad: true,
 	proxy: {
        type: 'ajax',
        url: 'data/manager.json',
        reader: {
            type: 'json',
            successProperty: 'success'
        }
    } 
});

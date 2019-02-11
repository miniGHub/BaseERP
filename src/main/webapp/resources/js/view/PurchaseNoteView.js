Ext.define('AppIndex.view.PurchaseNoteView',{
    extend:'Ext.panel.Panel',
    xtype:'app_purchase_note_view',
    controller:'purchase_note_view',
    requires:['AppIndex.controller.PurchaseNoteController'],

    title: '进货单',
});
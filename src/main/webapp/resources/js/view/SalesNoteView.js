Ext.define('AppIndex.view.SalesNoteView',{
    extend:'Ext.panel.Panel',
    xtype:'app_sales_note_view',
    controller:'sales_note_view',
    requires:['AppIndex.controller.SalesNoteController'],

    title: '销售单',
});
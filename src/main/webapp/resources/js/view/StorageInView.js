Ext.define('AppIndex.view.StorageInView',{
    extend:'Ext.panel.Panel',
    xtype:'app_storage_in_view',
    controller:'storage_in_view',
    requires:['AppIndex.controller.StorageInController',
        'AppIndex.view.StorageInViewToolbar',
        'AppIndex.view.StorageInViewGrid'
    ],

    title: '入库单',
    width: window.innerWidth - 300,
    height: window.innerHeight,
    layout: {
        type:'border'
    },

    items:[
        {
            region:'north',
            xtype:'app_storage_in_view_toolbar'
        },
        {
            region:'center',
            xtype:'app_storage_in_view_grid'
        }
    ]
});
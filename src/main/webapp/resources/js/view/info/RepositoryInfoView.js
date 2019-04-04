Ext.define('AppIndex.view.info.RepositoryInfoView',{
    extend:'Ext.panel.Panel',
    xtype:'app_repository_info_view',
    itemId: 'app_repository_info_view_item_id',
    controller:'repository_info_view',

    requires:[
        'AppIndex.controller.info.RepositoryInfoController',
        'AppIndex.view.info.RepositoryInfoViewGrid'
    ],

    title: '仓库信息',
    width: window.innerWidth - 300,
    height: window.innerHeight,
    closable:true,

    layout: {
        type:'border'
    },

    items:[
        {
            region:'center',
            xtype:'app_repository_info_view_grid'
        }
    ]
});
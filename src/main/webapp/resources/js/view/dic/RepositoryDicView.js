Ext.define('AppIndex.view.dic.RepositoryDicView',{
    extend:'Ext.panel.Panel',
    xtype:'app_repository_dic_view',
    itemId:'app_repository_dic_view_item_id',
    controller:'repository_dic_view',

    requires:[
        'AppIndex.controller.dic.RepositoryDicController',
        'AppIndex.view.dic.RepositoryDicViewGrid'
    ],

    title: '仓库字典',
    width: window.innerWidth - 300,
    height: window.innerHeight,
    closable:true,

    layout: {
        type:'border'
    },

    items:[
        {
            region:'center',
            xtype:'app_repository_dic_view_grid'
        }
    ]
});
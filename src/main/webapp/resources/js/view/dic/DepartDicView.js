Ext.define('AppIndex.view.dic.DepartDicView',{
    extend:'Ext.panel.Panel',
    xtype:'app_depart_dic_view',
    itemId: 'app_depart_dic_view_item_id',
    controller:'depart_dic_view',

    requires:[
        'AppIndex.controller.dic.DepartDicController',
        'AppIndex.view.dic.DepartDicViewGrid'
    ],

    title: '部门管理',
    width: window.innerWidth - 300,
    height: window.innerHeight,
    closable:true,

    layout: {
        type:'border'
    },

    items:[
        {
            region:'center',
            xtype:'app_depart_dic_view_grid'
        }
    ]
});
Ext.define('AppIndex.view.DepartManagerView',{
    extend:'Ext.panel.Panel',
    xtype:'app_depart_manager_view',
    itemId: 'app_depart_manager_view_item_id',
    controller:'depart_manager_view',

    requires:[
        'AppIndex.controller.DepartManagerController',
        'AppIndex.view.DepartManagerViewGrid'
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
            xtype:'app_depart_manager_view_grid'
        }
    ]
});
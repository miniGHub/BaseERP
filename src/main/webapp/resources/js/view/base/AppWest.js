Ext.define("AppIndex.view.base.AppWest",{
    extend:'Ext.panel.Panel',
    xtype:'app_west',

    requires:[
        'AppIndex.view.base.AppWestBusiness',
        'AppIndex.view.base.AppWestBasic',
        'AppIndex.view.base.AppWestSystem'
    ],

    title:'导航菜单',
    width:250,
    minWidth:100,
    collapsible:true,
    layout: {
        type:'accordion'
    },
    items:[
        {
            xtype:'app_west_business'
        },
        {
            xtype:'app_west_basic'
        },
        {
            xtype:'app_west_system'
        }
    ]

});
Ext.define("AppIndex.view.AppWest",{
    extend:'Ext.panel.Panel',
    xtype:'app_west',

    requires:[
        'AppIndex.view.AppWestBusiness',
        'AppIndex.view.AppWestBasic',
        'AppIndex.view.AppWestSystem'
    ],

    title:'导航栏',
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
Ext.define("AppIndex.view.AppNavigation",{
    extend:'Ext.tree.Panel',
    xtype:'app_navigation',

    rootVisible:false,
    userArrows:true,
    // hideHeaders:true,
    width:250,
    minWidth:100,
    split:true,
    collapsible:true,
    autoScroll: true,
    animate: true,

    store:Ext.create('Ext.data.TreeStore', {
        id:'NavigationStore',
        root: {
            expanded: true,
            id:'all',
            text:'All',
            children: [
                {
                    text: "销售",
                    children: [
                        {text:"销售订单", id: "app_sales_order_note_view", leaf: true},
                        {text:"销售单", id: "app_sales_note_view", leaf: true}
                    ]
                },
                {
                    text: "采购",
                    children: [
                        {text:"进货单", id: "app_purchase_note_view", leaf: true}
                    ]
                }
            ]
            /*
            children: [
                {text: "消息管理", id: "message-view", leaf: true},
                {text: "用户列表", id: "UserGrid", leaf: true}
            ]
            */
        }
    })
});
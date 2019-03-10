Ext.define("AppIndex.view.AppWestBusiness",{
    extend:'Ext.tree.Panel',
    xtype:'app_west_business',

    requires:[
        'AppIndex.view.SalesOrderNoteView',
        'AppIndex.view.SalesNoteView',
        'AppIndex.view.PurchaseNoteView',
        'AppIndex.view.StorageInView'
    ],

    title:'业务菜单',
    rootVisible:false,
    userArrows:true,
    // hideHeaders:true,
    width:250,
    minWidth:100,
    split:true,
    collapsible:true,
    autoScroll: true,
    animate: true,
    frame: true,

    store:
        Ext.create('Ext.data.TreeStore', {
        id:'AppWestBusinessStore',
        animate:true,
        root: {
            expanded: true,
            id:'app_west_business_root',
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
                },
                {
                    text: "库存",
                    children: [
                        {text:"入库单", id: "app_storage_in_view", leaf: true}
                    ]
                }
            ]
        }
        })
});
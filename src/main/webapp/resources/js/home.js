Ext.onReady(function(){
    Ext.create('Ext.container.Viewport',{
        layout:'border',//表格布局
        items:[{
            title:'North Panel',
            html:'上边',
            region:'north',//指定子面板所在区域为north
            height:100
        },{
            title:'West Panel',
            html:'左边',
            region:'west',//指定子面板所在区域为west
            width:150
        },{
            title:'Main Panel',
            html:'中间',
            region:'center'//指定子面板所在区域为center
        }]
    });
});
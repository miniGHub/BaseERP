Ext.define('et.view.South',{ 
    extend: 'Ext.Toolbar', 
    initComponent : function(){ 
        Ext.apply(this,{ 
            id:"bottom", 
            //frame:true, 
            region:"south", 
            height:23, 
            items:['->',"版权所有     Copyright © 2013 计算机学院",'->'] 
        }); 
        this.callParent(arguments); 
    } 
}); 

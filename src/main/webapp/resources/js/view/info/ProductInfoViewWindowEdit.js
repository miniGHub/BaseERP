Ext.define('AppIndex.view.info.ProductInfoViewWindowEdit',{
    extend:'Ext.window.Window',
    xtype:'app_product_info_view_window_edit',
    controller: 'product_info_view',

    title: '编辑商品信息',
    width:380,
    height:260,
    layout:'fit',
    closable:true,
    modal: true,        // 遮罩效果
    draggable: false,   // 拖拽效果
    frame:true,

    items:{
        xtype: 'form',
        align:'center',
        border:false,
        bodyStyle:'background-color: #DFE8F6;',
        padding:'10 0 0 50',       // 上内 右内 下内 左内
        defaults:{
            margin:'10 0 0 0'       // 元素间隔
        },
        fieldDefaults: {
            labelWidth: 60,
            labelAlign: "right",
            flex: 1
        },
        items:[
            {
                xtype:'textfield',
                name: 'product_id',
                fieldLabel: '商品编号',
                readOnly:true
            },
            {
                xtype: 'combo',
                name: 'product_type_name',
                fieldLabel: '商品分类',
                displayField: 'product_type_name',
                valueField : 'product_type',
                forceSelection : true,
                triggerAction : 'all',
                selectOnFocus : true,
                queryMode : 'local',
                allowBlank: true,
                store: {
                    type:'get_all_product_dic_store'
                }
            },
            {
                xtype:'textfield',
                name: 'product_name',
                fieldLabel: '商品名称',
                allowBlank: true,
                maxLength:50,
                minLength:1
            },
            {
                xtype:'textfield',
                name: 'barcode',
                fieldLabel: '条码',
                allowBlank: true,
                maxLength:50,
                minLength:1
            },
            {
                xtype:'textfield',
                name: 'state',
                fieldLabel: '状态',
                allowBlank: true,
                maxLength:50,
                minLength:1
            }
        ],
        buttons: [
            {
                xtype:'button',
                iconCls:'icon_accept',
                text: '确定',
                formBind: true,     // 按钮是否可用取决于form
                listeners: {
                    click: 'onClickEditSave'
                }
            },
            {
                xtype:'button',
                iconCls:'icon_cancel',
                text: '取消',
                listeners: {
                    click: 'onClickEditCancel'
                }
            }
        ]
    }
});
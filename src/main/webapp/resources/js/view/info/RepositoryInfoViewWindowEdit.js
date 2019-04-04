Ext.define('AppIndex.view.info.RepositoryInfoViewWindowEdit',{
    extend:'Ext.window.Window',
    xtype:'app_repository_info_view_window_edit',
    controller: 'repository_info_view',

    title: '编辑仓库信息',
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
                name: 'repository_id',
                fieldLabel: '仓库编号',
                readOnly:true
            },
            {
                xtype: 'combo',
                name: 'repository_type_name',
                fieldLabel: '仓库分类',
                displayField: 'repository_type_name',
                valueField : 'repository_type',
                forceSelection : true,
                triggerAction : 'all',
                selectOnFocus : true,
                queryMode : 'local',
                allowBlank: true,
                store: {
                    type:'get_all_repository_dic_store'
                }
            },
            {
                xtype:'textfield',
                name: 'repository_name',
                fieldLabel: '仓库名称',
                allowBlank: true,
                maxLength:50,
                minLength:1
            },
            {
                xtype:'textfield',
                name: 'address',
                fieldLabel: '地址',
                allowBlank: true,
                maxLength:50,
                minLength:1
            },
            {
                xtype:'textfield',
                name: 'manager',
                fieldLabel: '负责人',
                allowBlank: true,
                maxLength:50,
                minLength:1
            },
            {
                xtype:'textfield',
                name: 'phone',
                fieldLabel: '联系电话',
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
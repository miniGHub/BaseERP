Ext.define('AppIndex.view.base.UserManagerViewWindowEdit',{
    extend:'Ext.window.Window',
    xtype:'app_user_manager_view_window_edit',
    controller: 'user_manager_view',

    title: '编辑用户',
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
                name: 'id',
                fieldLabel: '用户名',
                readOnly:true
            },
            {
                xtype:'textfield',
                name: 'name',
                fieldLabel: '姓名',
                allowBlank: false,
                maxLength:100,
                minLength:1
            },
            {
                xtype: 'combo',
                name: 'role_name',
                fieldLabel: '角色',
                displayField: 'role_name',
                valueField : 'role_id',
                forceSelection : true,
                triggerAction : 'all',
                selectOnFocus : true,
                queryMode : 'local',
                allowBlank: true,
                store: {
                    type:'get_all_role_dic_store'
                }
            },
            {
                xtype: 'combo',
                name: 'depart_name',
                fieldLabel: '部门',
                displayField: 'depart_name',
                valueField : 'depart_id',
                forceSelection : true,
                triggerAction : 'all',
                selectOnFocus : true,
                queryMode : 'local',
                allowBlank: true,
                store: {
                    type:'get_all_depart_dic_store'
                }
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
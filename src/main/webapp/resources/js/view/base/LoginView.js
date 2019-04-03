Ext.define('AppIndex.view.base.LoginView', {
    extend: 'Ext.window.Window',
    xtype: 'app_login_view',
    controller: 'login_view',
    requires: [
        'AppIndex.controller.base.LoginController',
        'Ext.form.Panel'
    ],

    // language=HTML
    title: '<span style="font-size:14px;">XXX进销存管理系统</span>',
    titleAlign:'center',

    closable: false,    // 窗口是否可关闭
    autoShow: true,     // windows默认是隐藏，要设置为显示
    modal: true,        // 遮罩效果
    shadow: false,      // 阴影特效
    draggable: false,   // 拖拽效果
    frame:true,

    y:200,
    width:380,
    height:210,
    layout:'fit',

    items: {
        xtype: 'form',
        align:'center',
        border:false,
        bodyStyle:'background-color: #DFE8F6;',
        // bodyPadding:20,
        padding:'40 40 0 40',       // 上内 右内 下内 左内
        defaults: {
            anchor: '100%'
        },
        fieldDefaults: {
            labelWidth: 60,
            labelAlign: "left",
            flex: 1     // 自动调整宽度
        },
        items: [
        {
            xtype:'textfield',
            name: 'id',
            fieldLabel: '用户名',
            // labelPad: -5,
            blankText: '账号不能为空',
            emptyText: '请输入4位数字用户名',
            allowBlank: false,
            maxLength:4,
            minLength:4,
            regex:/^[0-9]+$/
        }, {
            xtype:'textfield',
            name: 'password',
            margin:'20 0 0 0',
            inputType: 'password',
            fieldLabel: '密码',
            emptyText: '请输入4位数字密码',
            blankText: '密码不能为空',
            allowBlank: false,
            maxLength:4,
            minLength:4,
            regex:/^[0-9]+$/
        }],
        buttonAlign:'center',
        buttons: [
            {
                xtype:'button',
                iconCls:'icon_login',
                text: '登录',
                formBind: true,     // 按钮是否可用取决于form
                listeners: {
                    click: 'onClickLogin'
                }
            },
            {
                xtype:'button',
                iconCls:'icon_refresh',
                text: '重置',
                listeners: {
                    click: 'onClickRefresh'
                }

            }
        ]
    }
});
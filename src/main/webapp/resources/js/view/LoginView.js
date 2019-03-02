Ext.define('AppIndex.view.LoginView', {
    extend: 'Ext.window.Window',
    xtype: 'app_login_view',
    controller: 'login_view',
    requires: ['AppIndex.controller.LoginController',
        'Ext.form.Panel'
    ],

    title: 'XXX进销存系统',
    titleAlign:'center',

    closable: false,//窗口是否可关闭
    autoShow: true,//windows默认是隐藏，要设置为显示

    layout:'fit',

    items: {
        xtype: 'form',
        defaults: {
            anchor: '100%',
        },
        fieldDefaults: {
            labelWidth: 50,
            labelAlign: "left",
            flex: 1,
            margin: 5
        },
        buttonAlign:'center',
        items: [
        {
            xtype:'textfield',
            name: 'id',
            fieldLabel: '用户名',
            blankText: '账号不能为空',
            emptyText: '请输入4位数字账号',
            allowBlank: false,
            maxLength:4,
            minLength:4,
            regex:/^[0-9]+$/
        }, {
            xtype:'textfield',
            name: 'password',
            inputType: 'password',
            fieldLabel: '密码',
            emptyText: '请输入4位数字密码',
            blankText: '密码不能为空',
            allowBlank: false,
            maxLength:4,
            minLength:4,
            regex:/^[0-9]+$/
        }],
        buttons: [{
            xtype:'button',
            text: '登录',
            formBind: true,//按钮是否可用取决于form
            listeners: {
                click: 'onClockLogin'
            }
        }]
    }
});
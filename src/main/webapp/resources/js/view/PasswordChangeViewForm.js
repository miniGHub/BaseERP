Ext.define('AppIndex.view.PasswordChangeViewForm',{
    extend: 'Ext.form.Panel',
    xtype:'app_password_change_view_form',

    border:false,
    align:'center',
    layout:'anchor',
    width: '25%',

    tbar:[
        {
            text:'修改密码',
            iconCls: 'icon_accept',
            handler: 'onClickSave',
            formBind:true
        },'-',
        {
            text:'重置',
            iconCls: 'icon_refresh',
            handler: 'onClickReset'
        }
    ],
    defaults: {
        xtype:'textfield',
        inputType: 'password',
        margin:'10 0 0 0'
    },
    fieldDefaults: {
        labelAlign:'right',
        labelWidth:70
    },
    items: [
        {
            name: 'old_password',
            anchor:'25%',
            fieldLabel: '输入旧密码',
            emptyText: '请输入旧密码',
            blankText: '密码不能为空',
            allowBlank: false,
            maxLength: 4,
            minLength: 4,
            regex: /^[0-9]+$/
        },
        {
            name: 'new_password',
            anchor:'25%',
            fieldLabel: '输入新密码',
            emptyText: '请输入4位数字密码',
            blankText: '密码不能为空',
            allowBlank: false,
            maxLength: 4,
            minLength: 4,
            regex: /^[0-9]+$/
        },
        {
            name: 'again_password',
            anchor:'25%',
            fieldLabel: '确认新密码',
            emptyText: '确认新密码',
            blankText: '密码不能为空',
            allowBlank: false,
            maxLength: 4,
            minLength: 4,
            regex: /^[0-9]+$/
        }
    ]
});
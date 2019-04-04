var mAppHeaderTimer = null;
Ext.define('AppIndex.view.base.AppHeader',{
    extend:'Ext.toolbar.Toolbar',
    xtype:'app_header',

    height:50,

    items:[
        {
            xtype: 'component', //或者xtype: 'box',
            width: 24, //图片宽度
            height: 24, //图片高度
            autoEl: {
                tag: 'img',    //指定为img标签
                src: 'resources/css/images/icons/application_home.png'    //指定url路径
            }
        },
        {
            xtype:'label',
            text:'XXX进销存管理系统',
            style:'font-size:20px;'
        },'->',
        {
            id:'app_header_time',
            xtype:'label'
        },'  ',
        {
            xtype:'tbseparator'
        },'  ',
        {
            id:'app_header_user_name',
            xtype:'label',
            text:'操作员：'+'XXX'
        },'  ',
        {
            xtype:'tbseparator'
        },'  ',
        {
            id:'app_header_role_name',
            xtype:'label',
            text:'角色：'+'XXX'
        },'  ',
        {
            xtype:'tbseparator'
        },'  ',
        {
            text:'注销',
            xtype:'button',
            iconCls:'icon_exit',
            handler: 'onExitClick'
        }
    ],
    onRender:function(){
        console.log("header onRender");
        this.callParent(arguments);
    },
    afterRender:function(){
        console.log("header afterRender");
        this.callParent(arguments);

        var userName = localStorage.getItem("UserName");
        var roleName = localStorage.getItem("RoleName");

        Ext.getCmp("app_header_user_name").setText("操作员：" + userName);
        Ext.getCmp("app_header_role_name").setText("角色：" + roleName);

        mAppHeaderTimer = {
            run: function () {
                var date = Ext.Date.format(new Date, 'Y-m-d H:i:s');
                Ext.getCmp("app_header_time").setText("系统时间：" + date);
            },
            interval: 1000      // 1秒
        };

        // start timer
        Ext.TaskManager.start(mAppHeaderTimer);
    },
    destroy:function(){
        console.log("header destroy");
        this.callParent(arguments);

        // stop timer
        if (mAppHeaderTimer != null) {
            Ext.TaskManager.stop(mAppHeaderTimer);
        }
    }
});
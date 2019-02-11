//ExtJs的入口，加载该Js之后，自动调用launch方法内容项
Ext.application({
    name: 'AppIndex',
    extend:'Ext.app.Application',
    appFolder: 'resources/js',
    autoCreateViewport:'AppHome',
    listen: {
        controller: {
            '#': {
                unmatchedroute: 'onUnmatchedRoute'
            }
        }
    },
    onUnmatchedRoute: function(hash) {
        alert('Unmatched:' + hash);
    },
    init:function(){
        var me=this;
        me.setDefaultToken('all');
    },
    launch : function() {
        console.log("launch");
    }
});
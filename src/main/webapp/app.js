Ext.Loader.setConfig({enabled: true});		//开启动态加载
Ext.application({
	name:'et',			//呵呵，就是ExtTest
	autoCreateViewport: true,
	appFolder:'app',	//指定根目录
	controllers:[		
		'Menu'
	]
});

Ext.define('AppIndex.controller.PurchaseNoteController',{
    extend:'Ext.app.ViewController',
    alias:'controller.purchase_note_view',
    requires:['AppIndex.store.SendStore',
        'AppIndex.store.GetStore'
    ],
    control:{},
    routes:{},

    PurchaseNoteSubmit: function() {
        // form data
        var form = this.getView().down('app_purchase_note_view_form').getForm();
        var formData = form.getValues();
        // console.log('formData:' + Ext.encode(formData));

        // grid data
        var store = this.getView().down('app_purchase_note_view_grid').getStore();
        var gridData = [];
        Ext.each(store.getRange(0, store.getCount()), function(record) {
            // delete value which key is 'id'
            delete record.data['id'];
            gridData.push(record.data);
        });
        // console.log('gridData:'+ Ext.encode(gridData));

        // send parameters
        var sendParam ={
            form: formData,
            grid: gridData
        };
        console.log('sendParam:' + Ext.encode(sendParam));

        var sendStore = Ext.create('AppIndex.store.SendStore');
        sendStore.proxy.url += 'cg/SubmitPurchaseNote';
        sendStore.proxy.extraParams =  sendParam;
        // sendStore.proxy.extraParams = test;
        // console.log(sendStore.proxy.url);
        sendStore.load({
            scope:this,
            callback: function (records, operation, success) {
                console.log(records);
                console.log(operation);
                console.log(success);
                if (success) {
                    Ext.Msg.alert('进货单', '提交成功');
                }
            }
        });
    },
    PurchaseNoteModify: function() {
        Ext.Msg.alert('修改', 'PurchaseNoteModify');
    },
    PurchaseNotePrint: function() {
        Ext.Msg.alert('打印', 'PurchaseNotePrint');
    },
    PurchaseNoteLoad: function() {
        var form = this.getView().down('app_purchase_note_view_form').getForm().getValues();
        console.log(form);
        var id = form['sales_order_note_id'];
        console.log("sale order id：" + id);
        var getStore = Ext.create('AppIndex.store.GetStore');
        getStore.proxy.url += "cg/LoadBaseFromSalesOrder";
        getStore.proxy.extraParams = {'Sales_order_note_id': id}; // "JH-2018-12-23-0001"
        console.log(getStore.proxy.url);
        getStore.load({
            scope:this,
            callback: function (records, operation, success) {
                if (success) {
                    console.log("get base：");
                    console.log(records);
                    if (records.length > 0) {
                        this.getView().down('app_purchase_note_view_form').loadRecord(records[0]);
                    }
                }
                else {
                    Ext.Msg.alert('进货单', '没有得到数据');
                }
            }
        });

        var getStore2 = Ext.create('AppIndex.store.GetStore');
        getStore2.proxy.url += "cg/LoadDetailFromSalesOrder";
        getStore2.proxy.extraParams = {'Sales_order_note_id': id};
        console.log(getStore2.proxy.url);
        getStore2.load({
            scope:this,
            callback: function (records, operation, success) {
                if (success) {
                    console.log("get detail：");
                    console.log(records);
                    if (records.length > 0) {
                        this.getView().down('app_purchase_note_view_grid').getStore().loadRecords(records);
                    }
                }
                else {
                    Ext.Msg.alert('进货单', '没有详情数据');
                }
            }
        });
    }
});
Ext.define('AppIndex.controller.SalesOrderNoteController',{
    extend:'Ext.app.ViewController',
    alias:'controller.sales_order_note_view',
    requires:['AppIndex.store.SendStore'],
    control:{},
    routes:{},

    SalesOrderNoteSubmit: function() {
        Ext.Msg.alert('提交', 'SalesOrderNoteSubmit');

        // form data
        var form = this.getView().down('app_sales_order_note_view_form').getForm();
        var formData = form.getValues();
        // console.log('formData:' + Ext.encode(formData));

        // grid data
        var store = this.getView().down('app_sales_order_note_view_grid').getStore();
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
        sendStore.proxy.url += 'xs/SubmitSalesOrderNote';
        sendStore.proxy.extraParams =  sendParam;
        // console.log(sendStore.proxy.url);
        sendStore.load({
            scope:this,
            callback: function (records, operation, success) {
                console.log('records:' + records);
                console.log('operation:' + operation);
                console.log('success:' + success);
            }
        });
    },
    SalesOrderNoteModify: function() {
        Ext.Msg.alert('修改', 'SalesOrderNoteModify');
    },
    SalesOrderNotePrint: function() {
        var getStore = Ext.create('AppIndex.store.GetStore');
        getStore.proxy.url += "xs/SalesOrderNote";
        getStore.proxy.extraParams = {'Sales_order_note_id': "XSD-2018-12-23-0001"};
        getStore.load({
            scope:this,
            callback: function (records, operation, success) {
                if (success) {
                    this.getView().down('app_sales_order_note_view_form').loadRecord(records[0]);
                }
                else {
                    console.log(getStore.proxy.url + ": failed")
                }
            }
        });
    }
});
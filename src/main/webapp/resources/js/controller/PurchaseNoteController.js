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
        var grid = this.getView().down('app_purchase_note_view_grid').getStore();
        var gridData = [];
        Ext.each(grid.getRange(0, grid.getCount()), function(record) {
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
                    form.reset();
                    grid.removeAll();
                }
            }
        });
    },
    PurchaseNotePrint: function() {
        var form = this.getView().down('app_purchase_note_view_form').getForm().getValues();
        var grid = this.getView().down('app_purchase_note_view_grid').getStore();
        var rows = 4;
        var page = "";
        var amount = grid.getCount()/rows;
        for (var i=0; i<amount; i++) {
            var form_tab = "<div id='tab_form'>" +
                "<DIV align=center><font size='20'>XXX公司进货单</font></DIV>" +
                "<table border=0 cellspacing=0 cellpadding=0 width='100%'>" +
                "<tbody>" +
                "<tr>" +
                "<td width='33.3%'>录单日期:" + form['entry_date'] + "</td>" +
                "<td width='33.3%'>进货单号:" + form['purchase_note_id'] + "</td>" +
                "<td width='33.3%'>销售订单:" + form['sales_order_note_id'] + "</td>" +
                "</tr>" +
                "<tr>" +
                "<td width='33.3%'>供应商:" + form['supplier_id'] + "</td>" +
                "<td width='33.3%'>仓库:" + form['repository_id'] + "</td>" +
                "<td width='33.3%'>经办人:" + form['operator_id'] + "</td>" +
                "</tr>" +
                "</tbody>" +
                "</table>" +
                "</div>";

            var detail_tab = "<div id='tab_detail'>" +
                "<table border=1 cellSpacing=0 cellPadding=1 width='100%' style='border-collapse:collapse'>" +
                "<thead><tr>" +
                "<th align=center>商品编号</th>" +
                "<th align=center>仓库编号</th>" +
                "<td align=center>数量</td>" +
                "<td align=center>单价</td>" +
                "<td align=center>金额</td>" +
                "</tr></thead>" +
                "<tbody>";
            var st= i*rows;
            Ext.each(grid.getRange(st, st+rows-1), function (record) {
                detail_tab += "<tr>" +
                    "<td>" + record.data['product_id'] + "</td>" +
                    "<td>" + record.data['repository_id'] + "</td>" +
                    "<td>" + record.data['amount'] + "</td>" +
                    "<td>" + record.data['unit_price'] + "</td>" +
                    "<td format='#,##0.00'>" + record.data['balance'] + "</td>" +
                    "</tr>"
            });
            detail_tab += "</tbody>" +
                "<tfoot>" +
                "<tr>" +
                "<td tdata='pageNO' format='#' align='left'><p align='center'><b>第<font color='#0000FF'>#</font>页</b></p></td>" +
                "<td tdata='pageCount' format='#' align='left'><p align='center'><b>总<font color='#0000FF'>##</font>页</b></td>" +
                "<td width='19%' tdata='subSum' format='0' align='right'><font color='#0000FF'>###个</font></td>" +
                "<td width='14%' align='right'></td>" +
                "<td width='19%' tdata='subSum' format='#,##0.00' align='right'><font color='#0000FF'>###元</font></td>" +
                "</tr>" +
                "</tfoot>" +
                "</table></div>";

            var foot_info = "<div id='div3'>" +
                "<DIV style='LINE-HEIGHT: 30px'" +
                "align=center><font color='#0000FF'>This is a demo from FirstBlood Group</font></DIV>" +
                "</div><div style='page-break-before: auto;page-break-after:always;'/>";
// 强制分页： <div style='page-break-before: auto;page-break-after:always;'/>
            page +=  form_tab + detail_tab + foot_info;
        }

        $("#printframe").html(page).print();
        $("#printframe").html('');
    },
    PurchaseNoteLoad: function(combo, record, index) {
        var id = combo.getValue();
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
                        var userId = localStorage.getItem("UserId");
                        records[0].set("operator_id", userId);
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
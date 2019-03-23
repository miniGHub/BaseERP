var COMMON_FUNC = {
    StoreCallbackDialog : function(records, success) {
        console.log("StoreCallbackDialog success=" + success + ",records==" + records);
        var ret = true;

        if (!success) {
            Ext.MessageBox.show({
                title: 'Error',
                msg: '数据传输异常',
                buttons: Ext.MessageBox.OK,
                icon: Ext.MessageBox.ERROR
            });
            ret = false;
        } else if (records.length <= 0) {
            Ext.MessageBox.show({
                title: 'Error',
                msg: '数据异常',
                buttons: Ext.MessageBox.OK,
                icon: Ext.MessageBox.ERROR
            });
            ret = false;
        }

        return ret;
    }
};
package com.mini.dao.xs;

import com.mini.model.xs.XS003;

public interface IXs003 {
    void InsertSalesNoteDetail(XS003 xs003);
    int countSalesNoteIdLike(String id_prefix);
}

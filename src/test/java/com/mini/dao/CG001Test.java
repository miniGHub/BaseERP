package com.mini.dao;

import com.mini.model.CG001;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class CG001Test {

    @Autowired
    private ICG001Dao dao;

    @Test
    public void testSelectCG001() throws Exception{
        String id = "JH-2018-12-23-0001";
        CG001 cg001 = dao.selectCG001(id);
        System.out.println("testSelectCG001(): " + cg001.getSales_order_note_id());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alchemytec.rest.test;

import com.alchemytec.rest.dao.IExpenseDAO;
import com.alchemytec.rest.entity.Expense;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author amalkan
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = Application.class)
@ContextConfiguration(locations={"classpath:WEB-INF/spring-config.xml"})
@WebAppConfiguration
public class ExpensesDAOImplTest {

    @Autowired
    IExpenseDAO expensesDAO;
    
    @Before
    public void setUp() {
    }

    @Test
    @Transactional
    @Rollback(true)
    public void addExpense() throws Exception {
        Expense test1 = new Expense(new Timestamp(856648800000L), new BigDecimal(100),
                new BigDecimal(20), "reason");
        Expense result = expensesDAO.addExpense(test1);
        assertEquals(test1.getAmount(), result.getAmount());
        assertEquals(test1.getVat(), result.getVat());
        assertEquals(test1.getReason(), result.getReason());
    }

    @Test
    @Transactional
    public void getExpensesList() throws Exception {
        List<Expense> result = expensesDAO.getExpensesList();
        assertNotNull(result); 
    }
}
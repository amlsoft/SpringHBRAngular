/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alchemytec.rest.dao;

import com.alchemytec.rest.entity.Expense;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author amalkan
 */
@Repository("expensesDAO")
public class ExpenseDAOImpl implements IExpenseDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Expense addExpense(Expense expense) throws Exception {
        sessionFactory.getCurrentSession().persist(expense);
        return expense;
    }

    @Override
    public List<Expense> getExpensesList() throws Exception {
        return sessionFactory.getCurrentSession().createCriteria(Expense.class).list();
    }
}
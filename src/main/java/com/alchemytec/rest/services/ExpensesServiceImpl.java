/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alchemytec.rest.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.alchemytec.rest.dao.IExpenseDAO;
import com.alchemytec.rest.entity.Expense;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author amalkan
 */
@Service("expensesService")
public class ExpensesServiceImpl implements IExpensesService {

    @Autowired
    IExpenseDAO expensesDAO;

    @Override
    @Transactional
    public Expense addExpense(Expense expense) throws Exception {
        expensesDAO.addExpense(expense);
        return expense;
    }

    @Override
    @Transactional
    public List<Expense> getExpensesList() throws Exception {
        return expensesDAO.getExpensesList();
    }
}
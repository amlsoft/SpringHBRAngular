/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alchemytec.rest.services;

import java.util.List;
import com.alchemytec.rest.entity.Expense;

/**
 *
 * @author amalkan
 */
public interface IExpensesService {

    public Expense addExpense(Expense expence) throws Exception;

    public List<Expense> getExpensesList() throws Exception;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alchemytec.rest.controller;

import com.alchemytec.rest.entity.Expense;
import com.alchemytec.rest.services.IExpensesService;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author amalkan
 */
@Controller
//@RequestMapping("/expenses")
public class ExpensesController {

    @Autowired
    IExpensesService expensesService;
    static final Logger logger = Logger.getLogger(ExpensesController.class);

    @RequestMapping(value = "/expenses", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    void addExpence(@RequestBody Expense expense) {
        try {
            expensesService.addExpense(expense);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/expenses", method = RequestMethod.GET)
    public @ResponseBody
    List<Expense> getExpencesList() {

        List<Expense> expensesList = null;
        try {
            expensesList = expensesService.getExpensesList();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return expensesList;
    }
}
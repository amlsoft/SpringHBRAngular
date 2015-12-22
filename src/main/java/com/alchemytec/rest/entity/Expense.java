/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alchemytec.rest.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 *
 * @author amalkan
 */
@Entity
@Table(name = "expenses")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Expense implements Serializable {

    public Expense() {
    }
    public Expense(Timestamp date, BigDecimal amount, BigDecimal vat, String reason) {
        this.date = date;
        this.amount = amount;
        this.vat = vat;
        this.reason = reason;
    }
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "e_id")
    private long id;

    @Column(name = "e_date")
    private Timestamp date;

    @Column(name = "e_amount")
    private BigDecimal amount;

    @Column(name = "e_vat")
    private BigDecimal vat;

    @Column(name = "e_reason")
    private String reason;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the date
     */
    public Timestamp getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Timestamp date) {
        this.date = date;
    }

    /**
     * @return the amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * @return the vat
     */
    public BigDecimal getVat() {
        return vat;
    }

    /**
     * @param vat the vat to set
     */
    public void setVat(BigDecimal vat) {
        this.vat = vat;
    }

    /**
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param reason the reason to set
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Expense expense = (Expense) obj;
        return (this.amount == expense.getAmount()
                && (this.date == expense.getDate())
                && (this.vat == expense.getVat())
                && (this.reason == expense.getReason() 
                     || (this.reason != null && this.reason.equals(expense.getReason()))
                ));
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((reason == null) ? 0 : reason.hashCode());
        return result;
    }
}
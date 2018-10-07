/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utfpr.cp.sa.business;

import edu.utfpr.cp.sa.dao.CountryDAO;
import edu.utfpr.cp.sa.dao.CustomerDAO;
import edu.utfpr.cp.sa.entity.Country;
import edu.utfpr.cp.sa.entity.Customer;
//import edu.utfpr.cp.sa.gui.CustomerTableModel;
import edu.utfpr.cp.sa.gui.CustomerWindow;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vinicius
 */
public class VerificarCustomer {

    private CustomerDAO customerDAO;
    private CountryDAO countryDAO;
    private CustomerWindow customerwindow;

    public VerificarCustomer(CustomerDAO customerDAO, CountryDAO countryDAO, CustomerWindow customerwindow) {
        this.customerDAO = customerDAO;
        this.countryDAO = countryDAO;
        this.customerwindow = customerwindow;
    }
    
    public VerificarCustomer(){
        
    }
    
    public void UpdateCustomer(Customer c) throws Exception {
        try {
            customerDAO.update(c);
            JOptionPane.showMessageDialog(null, "Update successfully added!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void DeleteCustomer(Long id) throws Exception {
        try {
            customerDAO.delete(new Long(id));
            JOptionPane.showMessageDialog(null, "Update successfully added!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public void CriarCustomer(Customer c) throws Exception {
        try {
            customerDAO.create(c);
            JOptionPane.showMessageDialog(null, "Customer successfully added!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public String VerificarPhone(String phone, int CgetPhoneDigits) throws Exception {
        System.out.println(phone.length());
        System.out.println(CgetPhoneDigits);
        if (phone.length() != CgetPhoneDigits) {
            throw new Exception("Phone does not conform to country!");
        } else {
            return phone;
        }
    }

    public double VerificarAge(int age, double Credit) {

        if (age <= 18) {
            return (Credit + 100.0);
        } else if (age <= 35) {
            return (Credit + 300.0);
        } else {
            return (Credit + 500.0);
        }

    }

    public double VerificaCountry(String countryName, double CreditLimit) throws Exception {

        if (countryName.equalsIgnoreCase("Brazil")) {
            return (CreditLimit + 100.0);
        }

        return CreditLimit;
    }

    public Set<Customer> LerCustomer() {
        HashSet<Customer> customers = new HashSet<>();
        customers = (HashSet<Customer>) customerDAO.read();
        return customers;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utfpr.cp.sa.business;

import edu.utfpr.cp.sa.dao.CountryDAO;
import edu.utfpr.cp.sa.entity.Country;
import edu.utfpr.cp.sa.entity.Customer;
import edu.utfpr.cp.sa.gui.CustomerWindow;
import javax.swing.JOptionPane;

/**
 *
 * @author vinicius
 */
public class VerificarCountry {
    private CountryDAO countryDAO;
    private CustomerWindow customerwindow;
    
    public void UpdateCountry(Country c) throws Exception {
        try {
            countryDAO.update(c);
            JOptionPane.showMessageDialog(null, "Update successfully added!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void DeleteCountry(Long id) throws Exception {
        try {
            countryDAO.delete(new Long(id));
            JOptionPane.showMessageDialog(null, "Update successfully added!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public void CriarCountry(Country c) throws Exception {
        try {
            countryDAO.create(c);
            JOptionPane.showMessageDialog(null, "Customer successfully added!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public VerificarCountry(CountryDAO countryDAO, CustomerWindow customerwindow) {
        this.countryDAO = countryDAO;
        this.customerwindow = customerwindow;
    }
    
    
}

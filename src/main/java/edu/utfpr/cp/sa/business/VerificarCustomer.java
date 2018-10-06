/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utfpr.cp.sa.business;

import edu.utfpr.cp.sa.entity.Country;


/**
 *
 * @author vinicius
 */
public class VerificarCustomer {
    
   
    
    public String VerificarPhone(String phone, int CgetPhoneDigits) throws Exception{
    
	
        if (phone.length() != CgetPhoneDigits){
		throw new Exception("Phone does not conform to country!");
        }else 
            return phone;    
    }    
    
    public double VerificarAge(int age,double Credit){   
    
        if (age <= 18)
		return (Credit + 100.0);
        else if (age <= 35)
		return(Credit + 300.0);
        else
		return(Credit + 500.0);
    
    }
    
    public double VerificaCountry(String countryName,double CreditLimit) throws Exception{
       
    if (countryName.equalsIgnoreCase("Brazil"))
	return (CreditLimit + 100.0);
    
    return CreditLimit;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prjbanca;

/**
 *
 * @author luca.facchini
 */
public class ContoCorente {
    private int cc;
    private String intestatario;
    private String iban;
    
    public ContoCorente(int cc, String intestatario, String iban){
        this.cc=cc;
        this.iban=iban;
        this.intestatario=intestatario;
    }

    public int getCc() {
        return cc;
    }

    public String getIntestatario() {
        return intestatario;
    }

    public String getIban() {
        return iban;
    }
    
    public String modIban(String newIban){
        iban = newIban;
        return iban;
    }
    
    public String stapa(){
        String txt="";
        txt+="cc "+cc;
        txt+="\nintestatario "+intestatario;
        txt+="\niban "+iban;
        return txt;
    }
}

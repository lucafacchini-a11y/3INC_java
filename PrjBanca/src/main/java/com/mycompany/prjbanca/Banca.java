/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prjbanca;

/**
 *
 * @author luca.facchini
 */
public class Banca {
    private ContoCorente[] nConto;

    private int dimL;
    
    public Banca(int dimF){
        nConto = new ContoCorente[dimF];
        dimL=0;
    }

    public ContoCorente[] getnConto() {
        return nConto;
    }

    public int getDimL() {
        return dimL;
    }
    
    public void addConto(int cc, String intestatario, String iban){
        nConto[dimL] = new ContoCorente(cc,intestatario,iban);
        dimL++;
    }
    
     public String stapa(){
        String txt="";
        for(int i=0; i<dimL; i++){
            txt += "ContoCorente " + nConto[i].stapa();
        }
        txt += "dimL" + dimL;
        
        return txt;
    }
}

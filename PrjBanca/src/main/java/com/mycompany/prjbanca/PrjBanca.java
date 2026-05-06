/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.prjbanca;

/**
 *
 * @author luca.facchini
 */
public class PrjBanca {

    public static void main(String[] args) {
        //ContoCorente c = new ContoCorente(38070, "luca","it4890349308");
        //c.modIban("IT57M1503971346528934888309");
        //System.out.println(c.stapa());
        
        
        Banca b = new Banca(10);
        b.addConto(38078, "luca facchini", "it340398409840");
        System.out.println(b.stapa());
        
    }
}

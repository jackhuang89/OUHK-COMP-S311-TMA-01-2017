/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tma1_q1;

/**
 *
 * @author jackhuang
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ElectronicClock ec = new ElectronicClock();
        ec.setPowerSource("AC power");
        String test = ec.description();
        System.out.println(test);
    }
    
}

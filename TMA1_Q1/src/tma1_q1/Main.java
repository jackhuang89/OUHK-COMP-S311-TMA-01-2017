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
        String html_output = "";
        
        //ElectronicClock
        
        ElectronicClock ec = new ElectronicClock();
        ec.setPowerSource("AC power");
//        ec.setPowerSource("batteries");
        ec.setName("The Ching Dynasty Clock");
        ec.setYear("1782");
        ec.setCountry("England");
        html_output = ec.HTML();
        System.out.println(html_output);
        
        //MechanicalClock
        
        MechanicalClock mc = new MechanicalClock();
        mc.setPowerSource("spring");
//        mc.setPowerSource("weight");
        mc.setName("The Ching Dynasty Clock");
        mc.setYear("1782");
        mc.setCountry("England");
        html_output = mc.HTML();
        System.out.println(html_output);
        
    }
    
}

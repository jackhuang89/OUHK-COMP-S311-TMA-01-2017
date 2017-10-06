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
public abstract class ElectronicClock extends Clock{

    public String description(String powerSource) {
        //depends on power source
        if(powerSource == "battery"){
            return "The clock uses batteries";
        }
        
        return "The clock uses AC";
    }
    
}

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
public class ElectronicClock extends Clock{

    private String powerSource;
    
    @Override
    public String description() {
        //depends on power source AC or batteries
        if("AC power".equals(this.powerSource)){
            return "The clock uses AC";
        }else if("batteries".equals(this.powerSource)){
            return "The clock uses batteries";
        }
        return "Input error";
    }

    public String getPowerSource() {
        return powerSource;
    }

    public void setPowerSource(String powerSource) {
        this.powerSource = powerSource;
    }
    
}

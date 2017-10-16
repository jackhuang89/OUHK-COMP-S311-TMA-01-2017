/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tma1_q3;

/**
 *
 * @author Jack
 */
public class TMA1_Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Simple Java Word Count Program");

        String str1 = "Today is Holdiay Day";

        String[] wordArray = str1.trim().split("\\s+");
        int wordCount = wordArray.length;

        System.out.println("Word count is = " + wordCount);
    }
    
}

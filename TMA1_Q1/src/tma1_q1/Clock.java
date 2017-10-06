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
public abstract class Clock {
    abstract public String description();
    public String name;
    public String year;
    public String country;
    
    public String HTML(){
        return "<HTML>\n" +
"	<h2>The Ching Dynasty Clock</h2>\n" +
"	<h3>Year made: 1782</h3>\n" +
"	<h3>Made in England</h3>\n" +
"	<p>The clock is powered by clockwork spring</p> \n" +
"</HTML><HTML>\n" +
"	<h2>The Ching Dynasty Clock</h2>\n" +
"	<h3>Year made: 1782</h3>\n" +
"	<h3>Made in England</h3>\n" +
"	<p>The clock is powered by clockwork spring</p> \n" +
"</HTML>";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.helper;

/**
 *
 * @author PC
 */
public class RandomCode {

    private final static String NUMBERS = "0123456789";
    private final static String ALPHABE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private String input = " ";
    
    public RandomCode() {
        input=NUMBERS+ALPHABE+ALPHABE.toLowerCase();
    }

    public String createRandomString() {
        String code = new String();
        int max = input.length();
        for(int i=0; i<30; i++) {
            code += input.charAt(((int)(Math.random()*1000)) % max);
        }
        return code;
    }
}

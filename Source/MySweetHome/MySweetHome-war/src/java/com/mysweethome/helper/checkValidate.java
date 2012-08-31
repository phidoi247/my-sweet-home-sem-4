/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.helper;

import java.util.regex.Pattern;

/**
 *
 * @author Anh
 */
public class checkValidate {

    public static boolean checkSpace(String s) {
        if (s.substring(0).toString().equals(" ")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkSpaceCenter(String s) {
        char ch;
        String str1;
        for (int i = 0; i
                < s.length(); i++) {
            ch = s.charAt(i);
            str1 = String.valueOf(ch);
            if (str1.equals(" ")) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkEmpty(String s) {
        if (s == null) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkCharSpecial(String s) {
        String charspec = "<>:;,./?\'[}{]@#!$%^&*()|-_=+";
        char ch, ch1;
        for (int i = 0; i
                < s.length(); i++) {
            ch1 = s.charAt(i);
            String strkytu = String.valueOf(ch1);
            for (int j = 0; j
                    < charspec.length(); j++) {
                ch = charspec.charAt(j);
                String chuoi = String.valueOf(ch);
                if (chuoi.equals(strkytu)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkEmail(String s) {
        String Port = ".+@.+\\.[a-z]+";
        if (s != null && !Pattern.matches(Port, s)) {
            return true;
        }
        return false;
    }

    
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pc2_calidaddesoftware;


public class PasswordValidator 
{
  private static final int MIN_LENGTH = 8;
    private static final int MAX_LENGTH = 64;
    private static final String SPECIAL_CHARS = "!@#$%^&*()_-+=\\{}\\[\\]|:;\"'<>,.?/";

    public static boolean isValid(String password) {
        
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("La contraseña no puede ser nula o vacía");
        }

        if (password.length() < MIN_LENGTH || password.length() > MAX_LENGTH) {
            return false;
        }

        if (password.startsWith(" ") || password.endsWith(" ")) {
            return false;
        }

        boolean mayuscula = false;
        boolean minuscula = false;
        boolean numero = false;
        boolean especial = false;
        boolean espacioValido = true;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (Character.isUpperCase(c)) mayuscula = true;
            else if (Character.isLowerCase(c)) minuscula = true;
            else if (Character.isDigit(c)) numero = true;
            else if (SPECIAL_CHARS.contains(String.valueOf(c))) especial = true;
            else if (c == ' ') espacioValido = espacioValido && true;
            else return false;
        }

        return mayuscula && minuscula && numero && especial && espacioValido;
    }
}

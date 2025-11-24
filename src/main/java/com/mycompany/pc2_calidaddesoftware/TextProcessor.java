/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pc2_calidaddesoftware;


public class TextProcessor 
{
    public static String reverseAndCapitalize(String input) {

        if (input == null) {
            throw new IllegalArgumentException("El texto no puede ser nulo");
        }

        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("El texto no puede estar vacío");
        }

        if (input.length() > 1000) {
            throw new IllegalArgumentException("El texto excede el límite de 1000 caracteres");
        }

        input = input.trim();

        String reversed = new StringBuilder(input).reverse().toString();

        return reversed.toUpperCase();
    }
}

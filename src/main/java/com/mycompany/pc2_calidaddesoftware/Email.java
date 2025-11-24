/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pc2_calidaddesoftware;


public class Email 
{
    public boolean isValidEmail(String email) {

        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("El correo no puede ser nulo o vacío");
        }

        email = email.trim();

        if (email.length() < 6 || email.length() > 254) {
            return false;
        }

        if (!email.contains("@") || email.indexOf("@") != email.lastIndexOf("@")) {
            return false;
        }

        String[] parts = email.split("@");
        if (parts.length != 2) return false;

        String local = parts[0];
        String domain = parts[1];

        if (local.startsWith(".") || local.endsWith(".")) {
            return false;
        }

        if (local.contains("..")) {
            return false;
        }

        if (!domain.contains(".")) {
            return false;
        }

        int indexDot = domain.indexOf(".");
        if (indexDot < 2) {
            return false;
        }

        String extension = domain.substring(domain.lastIndexOf(".") + 1);
        if (extension.length() < 2) {
            return false;
        }

        if (email.contains(" ")) {
            return false;
        }
        return true;
    }
}

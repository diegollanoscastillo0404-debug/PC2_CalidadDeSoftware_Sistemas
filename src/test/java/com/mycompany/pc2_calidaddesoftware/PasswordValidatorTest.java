/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.pc2_calidaddesoftware;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class PasswordValidatorTest 
{
    @Test
    void testNullPassword() {
        assertThrows(IllegalArgumentException.class, () -> {
            PasswordValidator.isValid(null);
        });
    }

    @Test
    void testEmptyPassword() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            PasswordValidator.isValid("");
        });
        assertEquals("La contraseña no puede ser nula o vacía", e.getMessage());
    }

    @Test
    void testValidPassword() {
        assertTrue(PasswordValidator.isValid("Secure123!"));
    }

    @Test
    void testMissingRequirements() {
        assertFalse(PasswordValidator.isValid("nosecura"));
    }

    @Test
    void testLongPassword() {
        String longPassword = "A1!" + "a".repeat(62);
        assertFalse(PasswordValidator.isValid(longPassword));
    }

    @Test
    void testPasswordWithSpacesAtEdges() {
        assertFalse(PasswordValidator.isValid(" Hola123! "));
    }
}
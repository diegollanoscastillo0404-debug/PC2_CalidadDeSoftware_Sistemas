/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pc2_calidaddesoftware;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class EmailTest 
{
    @Test
    public void testCorreoNulo() {
        Email e = new Email();
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> e.isValidEmail(null)
        );
        assertEquals("El correo no puede ser nulo o vacío", ex.getMessage());
    }

    @Test
    public void testCorreoVacio() {
        Email e = new Email();
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> e.isValidEmail("")
        );
        assertEquals("El correo no puede ser nulo o vacío", ex.getMessage());
    }

    @Test
    public void testCorreoSinArrobaODominioInvalido() {
        Email e = new Email();

        assertAll(
                () -> assertFalse(e.isValidEmail("usuario.gmail.com")),
                () -> assertFalse(e.isValidEmail("usuario@com"))
        );
    }

    @Test
    public void testCorreoValido() {
        Email e = new Email();
        assertTrue(e.isValidEmail("cliente123@tienda.com"));
    }

    @Test
    public void testCorreoConPuntosInvalidos() {
        Email e = new Email();

        assertAll(
                () -> assertFalse(e.isValidEmail(".abc@dominio.com")),   // empieza con punto
                () -> assertFalse(e.isValidEmail("abc.@dominio.com")),   // termina con punto
                () -> assertFalse(e.isValidEmail("ab..cd@dominio.com"))  // doble punto
        );
    }

    @Test
    public void testExtensionInvalida() {
        Email e = new Email();
        assertFalse(e.isValidEmail("user@mail.c"));
    }
}

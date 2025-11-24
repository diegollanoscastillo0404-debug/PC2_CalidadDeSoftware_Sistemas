/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pc2_calidaddesoftware;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TextProcessorTest 
{
    @Test
    public void testTextoValido() 
    {
        String result = TextProcessor.reverseAndCapitalize(" hola ");
        assertEquals("ALOH", result);
    }

    @Test
    public void testTextoNulo() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> TextProcessor.reverseAndCapitalize(null)
        );
        assertEquals("El texto no puede ser nulo", ex.getMessage());
    }

    @Test
    public void testTextoSoloEspacios() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> TextProcessor.reverseAndCapitalize("    ")
        );
        assertEquals("El texto no puede estar vacío", ex.getMessage());
    }

    @Test
    public void testTextoLargoExcedeLimite() {
        String largo = "a".repeat(1001);

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> TextProcessor.reverseAndCapitalize(largo)
        );
        assertEquals("El texto excede el límite de 1000 caracteres", ex.getMessage());
    }

    @Test
    public void testInversionCorrecta() {
        String result = TextProcessor.reverseAndCapitalize("abcd");
        assertEquals("DCBA", result);
    }

    @Test
    public void testTrimEInversion() {
        String result = TextProcessor.reverseAndCapitalize("  mundo  ");
        assertEquals("ODNUM", result);
    }
}

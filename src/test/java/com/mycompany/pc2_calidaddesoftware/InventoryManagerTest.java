/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pc2_calidaddesoftware;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class InventoryManagerTest 
{
       @Test
    public void testAgregarItemNuevo() {
        InventoryManager inv = new InventoryManager();
        inv.addItem("Laptop", 5);
        assertEquals(5, inv.getStock("Laptop"));
    }

    @Test
    public void testCantidadNegativa() {
        InventoryManager inv = new InventoryManager();
        assertThrows(IllegalArgumentException.class,
                () -> inv.addItem("Mouse", -1));
    }

    @Test
    public void testNombreVacio() {
        InventoryManager inv = new InventoryManager();
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> inv.addItem("", 5)
        );
        assertEquals("El nombre del producto no puede estar vacío", ex.getMessage());
    }

    @Test
    public void testCantidadMayorA1000() {
        InventoryManager inv = new InventoryManager();
        assertThrows(IllegalArgumentException.class,
                () -> inv.addItem("Televisor", 1500));
    }

    @Test
    public void testSumarCantidadProductoExistente() {
        InventoryManager inv = new InventoryManager();
        inv.addItem("Teclado", 3);
        inv.addItem("Teclado", 2);
        assertEquals(5, inv.getStock("Teclado"));
    }

    @Test
    public void testNombreConSoloEspacios() {
        InventoryManager inv = new InventoryManager();
        assertThrows(IllegalArgumentException.class,
                () -> inv.addItem("   ", 5));
    }
}

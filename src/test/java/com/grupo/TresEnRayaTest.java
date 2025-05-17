package com.grupo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class TresEnRayaTest {

    @Test
    public void primerTurnoDebeSerX() {
        TresEnRaya juego = new TresEnRaya();
        assertEquals('X', juego.obtenerJugadorActual());
    }

    @Test
    public void turnoDebeAlternarEntreXyMas() {
        TresEnRaya juego = new TresEnRaya();
        juego.colocarFicha(0, 0); // X
        assertEquals('+', juego.obtenerJugadorActual());

        juego.colocarFicha(1, 1); // +
        assertEquals('X', juego.obtenerJugadorActual());
    }
    
    @Test
    public void fueraDelEjeXDebeLanzarExcepcion() {
        TresEnRaya juego = new TresEnRaya();
        assertThrows(IllegalArgumentException.class, () -> juego.colocarFicha(5, 1));
    }

    @Test
    public void fueraDelEjeYDebeLanzarExcepcion() {
        TresEnRaya juego = new TresEnRaya();
}

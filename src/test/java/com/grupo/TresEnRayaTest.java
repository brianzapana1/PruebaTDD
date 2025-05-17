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

    }


}

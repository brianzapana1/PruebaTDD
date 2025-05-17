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

}

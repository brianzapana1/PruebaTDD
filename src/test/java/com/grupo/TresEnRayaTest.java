package com.grupo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class TresEnRayaTest {
//test primera funcion
    @Test
    public void primerTurnoDebeSerX() {
        TresEnRaya juego = new TresEnRaya(); // Se crea una nueva instancia del juego
        assertEquals('X', juego.obtenerJugadorActual()); // Se espera que el primer jugador sea 'X'
    }
//test tsegunda funcion
    @Test
    public void turnoDebeAlternarEntreXyMas() {
        TresEnRaya juego = new TresEnRaya();
        juego.colocarFicha(0, 0); // X
        assertEquals('+', juego.obtenerJugadorActual());

        juego.colocarFicha(1, 1); // +
        assertEquals('X', juego.obtenerJugadorActual());
    }

//test tercera funcion
    @Test
    public void fueraDelEjeXDebeLanzarExcepcion() {
        TresEnRaya juego = new TresEnRaya();
        assertThrows(IllegalArgumentException.class, () -> juego.colocarFicha(5, 1));
    }

//test cuarta funcion
    @Test
    public void fueraDelEjeYDebeLanzarExcepcion() {
        TresEnRaya juego = new TresEnRaya();
        assertThrows(IllegalArgumentException.class, () -> juego.colocarFicha(1, -1));
    }

//test quinta función
    @Test
    public void lugarOcupadoDebeLanzarExcepcion() {
        TresEnRaya juego = new TresEnRaya();
        juego.colocarFicha(0, 0);
        assertThrows(IllegalStateException.class, () -> juego.colocarFicha(0, 0));
    }
}

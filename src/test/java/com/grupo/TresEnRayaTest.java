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
//test segunda funcion
    // Verifica que el turno se alterne entre 'X' y '+'
    @Test
    public void turnoDebeAlternarEntreXyMas() {
        TresEnRaya juego = new TresEnRaya(); // Se crea una nueva instancia del juego
        juego.colocarFicha(0, 0); // Jugador 'X' coloca su ficha en la posición (0,0)
        assertEquals('+', juego.obtenerJugadorActual()); // Se espera que el siguiente turno sea del jugador '+'

        juego.colocarFicha(1, 1); // Jugador '+' coloca su ficha en la posición (1,1)
        assertEquals('X', juego.obtenerJugadorActual()); // Se espera que el turno vuelva al jugador 'X'
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

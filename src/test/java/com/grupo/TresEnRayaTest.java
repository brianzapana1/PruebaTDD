package com.grupo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

//clase que representa el juego tres en raya
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

    @Test
    public void reiniciarDejaTableroVacio() {
        TresEnRaya juego = new TresEnRaya();
        juego.colocarFicha(0, 0);
        juego.reiniciarJuego();
        char[][] tablero = juego.obtenerTablero();
        assertEquals(' ', tablero[0][0]);
    }

    @Test
    public void tableroEmpatadoNoTieneGanador() {
        TresEnRaya juego = new TresEnRaya();
        // X + X
        juego.colocarFicha(0, 0);
        juego.colocarFicha(0, 1);
        juego.colocarFicha(0, 2);
        juego.colocarFicha(1, 0);
        juego.colocarFicha(1, 2);
        juego.colocarFicha(1, 1);
        juego.colocarFicha(2, 1);
        juego.colocarFicha(2, 0);
        juego.colocarFicha(2, 2);

        assertFalse(juego.hayGanador());
    }
    

    @Test
    public boolean tableroLleno() {
    for (int i = 0; i < 3; i++)
        for (int j = 0; j < 3; j++)
            if (tablero[i][j] == ' ') return false;
    return true;
    }

}

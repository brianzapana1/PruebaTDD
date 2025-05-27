package com.grupo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class TresEnRayaTest {

    // Test 1: Verifica que el primer turno siempre sea del jugador 'X'
    @Test
    public void primerTurnoDebeSerX() {
        TresEnRaya juego = new TresEnRaya(); 
        assertEquals('X', juego.obtenerJugadorActual()); 
    }

    // Test 2: Verifica que los turnos se alternen entre 'X' y '+'
    @Test
    public void turnoDebeAlternarEntreXyMas() {
        TresEnRaya juego = new TresEnRaya();
        juego.colocarFicha(0, 0);
        assertEquals('+', juego.obtenerJugadorActual()); 
        juego.colocarFicha(1, 1);
        assertEquals('X', juego.obtenerJugadorActual()); 
    }

    // Test 3: Verifica que colocar ficha fuera del eje X (filas) lanza excepción
    @Test
    public void fueraDelEjeXDebeLanzarExcepcion() {
        TresEnRaya juego = new TresEnRaya();
        assertThrows(IllegalArgumentException.class, () -> juego.colocarFicha(5, 1));
    }

    // Test 4: Verifica que colocar ficha fuera del eje Y (columnas) lanza excepción
    @Test
    public void fueraDelEjeYDebeLanzarExcepcion() {
        TresEnRaya juego = new TresEnRaya();
        assertThrows(IllegalArgumentException.class, () -> juego.colocarFicha(1, -1));
    }

    // Test 5: Verifica que no se pueda colocar una ficha en una celda ocupada
    @Test
    public void lugarOcupadoDebeLanzarExcepcion() {
        TresEnRaya juego = new TresEnRaya();
        juego.colocarFicha(0, 0);
        assertThrows(IllegalStateException.class, () -> juego.colocarFicha(0, 0));
    }

    // Test 6: Verifica que el método reiniciarJuego limpia el tablero
    @Test
    public void reiniciarDejaTableroVacio() {
        TresEnRaya juego = new TresEnRaya();
        juego.colocarFicha(0, 0);
        juego.reiniciarJuego();
        char[][] tablero = juego.obtenerTablero();
        assertEquals(' ', tablero[0][0]);
    }

    // Test 7: Verifica que en un empate (tablero lleno sin ganador), no hay ganador
    @Test
    public void tableroEmpatadoNoTieneGanador() {
        TresEnRaya juego = new TresEnRaya();
        juego.colocarFicha(0, 0); // X
        juego.colocarFicha(0, 1); // +
        juego.colocarFicha(0, 2); // X
        juego.colocarFicha(1, 1); // +
        juego.colocarFicha(1, 0); // X
        juego.colocarFicha(1, 2); // +
        juego.colocarFicha(2, 1); // X
        juego.colocarFicha(2, 0); // +
        juego.colocarFicha(2, 2); // X

        assertFalse(juego.hayGanador());
    }

    // Test 8: Verifica que el método tableroLleno detecte correctamente un tablero sin espacios
    @Test
    public void verificarTableroLleno() {
        TresEnRaya juego = new TresEnRaya();
        juego.colocarFicha(0, 0); // X
        juego.colocarFicha(0, 1); // +
        juego.colocarFicha(0, 2); // X
        juego.colocarFicha(1, 1); // +
        juego.colocarFicha(1, 0); // X
        juego.colocarFicha(1, 2); // +
        juego.colocarFicha(2, 1); // X
        juego.colocarFicha(2, 0); // +
        juego.colocarFicha(2, 2); // X

        assertTrue(juego.tableroLleno());
    }

    // Test 9: Verifica victoria por fila completa
    @Test
    public void jugadorGanaPorFila() {
        TresEnRaya juego = new TresEnRaya();
        juego.colocarFicha(0, 0); // X
        juego.colocarFicha(1, 0); // +
        juego.colocarFicha(0, 1); // X
        juego.colocarFicha(1, 1); // +
        juego.colocarFicha(0, 2); // X
        assertTrue(juego.hayGanador());
    }

    // Test 10: Verifica victoria por columna completa
    @Test
    public void jugadorGanaPorColumna() {
        TresEnRaya juego = new TresEnRaya();
        juego.colocarFicha(0, 0); // X
        juego.colocarFicha(0, 1); // +
        juego.colocarFicha(1, 0); // X
        juego.colocarFicha(1, 1); // +
        juego.colocarFicha(4, 0); // X
        assertTrue(juego.hayGanador());
    }

    // Test 11: Verifica victoria por diagonal principal (↘)
    @Test
    public void jugadorGanaPorDiagonalPrincipal() {
        TresEnRaya juego = new TresEnRaya();
        juego.colocarFicha(0, 0); // X
        juego.colocarFicha(0, 1); // +
        juego.colocarFicha(1, 1); // X
        juego.colocarFicha(1, 2); // +
        juego.colocarFicha(2, 2); // X
        assertTrue(juego.hayGanador());
    }

    // Test 12: Verifica victoria por diagonal inversa (↙)
    @Test
    public void jugadorGanaPorDiagonalInversa() {
        TresEnRaya juego = new TresEnRaya();
        juego.colocarFicha(0, 2); // X
        juego.colocarFicha(0, 1); // +
        juego.colocarFicha(1, 1); // X
        juego.colocarFicha(1, 2); // +
        juego.colocarFicha(2, 0); // X
        assertTrue(juego.hayGanador());
    }

}

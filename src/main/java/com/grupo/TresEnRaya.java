package com.grupo;

public class TresEnRaya {
    private char[][] tablero = new char[3][3];
    private char jugadorActual = 'X';

    public TresEnRaya() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                tablero[i][j] = ' ';
    }
    
    public char obtenerJugadorActual() {
        return jugadorActual;
    }

}

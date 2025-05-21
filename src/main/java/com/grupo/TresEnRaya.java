package com.grupo;

public class TresEnRaya {
    private char[][] tablero = new char[3][3];
    private char jugadorActual = 'X';
    public TresEnRaya() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                tablero[i][j] = ' ';
    }
    //funcion para deterctare a jugador actual
    public char obtenerJugadorActual() {
        return jugadorActual;
    }
    //funcion para colocar la ficha
    public void colocarFicha(int fila, int columna) {
        if (fila < 0 || fila > 2)
            throw new IllegalArgumentException("Fila fuera de rango");
        if (columna < 0 || columna > 2)
            throw new IllegalArgumentException("Columna fuera de rango");
        if (tablero[fila][columna] != ' ')
            throw new IllegalStateException("La casilla [" + fila + "," + columna + "] ya está ocupada");


        tablero[fila][columna] = jugadorActual;
        jugadorActual = (jugadorActual == 'X') ? '+' : 'X';
    }
    //retorno de datos
    public char[][] obtenerTablero() {
        return tablero;
    }

    public void reiniciarJuego() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                tablero[i][j] = ' ';
        jugadorActual = 'X';
    }

}

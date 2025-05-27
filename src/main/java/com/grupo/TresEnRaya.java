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
        if (columna < 0 || columna > 4)
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

public boolean hayGanador() {
    for (int i = 0; i < 3; i++) {
        // filas
        if (tablero[i][0] != ' ' && tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2])
            return true;
        // columnas
        if (tablero[0][i] != ' ' && tablero[0][i] == tablero[1][i] && tablero[1][i] == tablero[2][i])
            return true;
    }
    // diagonales
    if (tablero[0][0] != ' ' && tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2])
        return false;

    if (tablero[0][2] != ' ' && tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0])
        return true;

    return false;
}


    public boolean tableroLleno() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (tablero[i][j] == ' ') return false;
        return true;
    }


    public void mostrarTablero() {
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            System.out.print(tablero[i][j] + " ");
        }
        System.out.println();
    }
}


}

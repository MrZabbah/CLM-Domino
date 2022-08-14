/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edpracdomino;

import java.util.Scanner;

/**
 *
 * @author mulas
 */
public class Game {

    //DATA
    Table table;
    Player one;
    Player two;
    TokenPack tokens;

    //CONSTRUCTOR
    public Game() {
        tokens = new TokenPack();
        one = new Player();
        two = new Player();
        table = new Table();
        for (int i = 0; i < 7; i++) {
            one.stealToken(tokens);
            two.stealToken(tokens);

        }
    }

    //METHODS
    public boolean endgame() {
        return (one.sizeHand() == 0 || two.sizeHand() == 0 || closeGame());
    }

    public void finishGame(int pl) {
        if (closeGame()) {
            int ones = one.score();
            int twos = two.score();
            if (ones - twos < 0) {
                System.out.println("GANADOR: PLAYER 1\n"
                        + "PUNTUACIÓN: " + one.score() + " PUNTOS.");
            } else if (ones - twos > 0) {
                System.out.println("GANADOR: PLAYER 2\n"
                        + "PUNTUACIÓN: " + two.score() + " PUNTOS.");
            } else {
                if (pl == 1) {
                    System.out.println("GANADOR: PLAYER 1\n"
                            + "PUNTUACIÓN: " + two.score() + " PUNTOS.");
                } else {
                    System.out.println("GANADOR: PLAYER 2\n"
                            + "PUNTUACIÓN: " + two.score() + " PUNTOS.");
                }
            }
        } else {
            if (one.sizeHand() == 0) {
                System.out.println("GANADOR: PLAYER 1\n"
                        + "PUNTUACIÓN: " + two.score() + " PUNTOS.");
            } else {
                System.out.println("GANADOR: PLAYER 2\n"
                        + "PUNTUACIÓN: " + one.score() + " PUNTOS.");
            }
        }
    }

    public boolean putToken(char op, int pl, Scanner entry) {
        int aux;

        boolean con = false;
        aux = Integer.parseInt(Character.toString(op));

        if (pl == 1) {
            con = table.addTable(pl, entry, one.putToken(aux));
        } else if (pl == 0) {
            con = table.addTable(pl, entry, two.putToken(aux));
        }
        if (con) {
            if (pl == 1) {
                one.removeToken(aux);
            } else {
                two.removeToken(aux);
            }
            System.out.println("Has añadido una ficha.");
        }
        return con;
    }

    public void steal(int pl) {
        if (pl == 1) {
            one.stealToken(tokens);
        } else {
            two.stealToken(tokens);
        }
        System.out.println("Has robado una ficha.");
    }

    public char menu(int pl, Scanner entry) {

        char op;
        int aux = -1;
        System.out.println("Table:----\n"
                + table.showTable() + "\n"
                + "----------");
        if (pl == 1) {
            System.out.println("Fichas Jugador 1: " + one.showHand());
            System.out.println("Token Number: " + one.showSize());
        } else {
            System.out.println("Fichas Jugador 2: " + two.showHand());
            System.out.println("Token Number: " + two.showSize());
        }
        do {
            System.out.print("Escriba numero de ficha, o 'R' para Robar, o 'P' para Pasar: ");
            op = entry.next().charAt(0);
            op = Character.toUpperCase(op);
            if (Character.isDigit(op)) {
                aux = Integer.parseInt(Character.toString(op));
            }
        } while (op != 'P' && op != 'R' && ((pl == 1 && (aux < 0 || aux >= one.sizeHand())) || (pl == 0 && (aux < 0 || aux >= two.sizeHand()))));

        return op;
    }

    private boolean closeGame() {
        boolean closed = false;
        if (!table.isEmpty()) {
            if (table.firstToken().show1() == table.lastToken().show2()) {
                closed = tokens.notContainsNum(table.firstToken().show1());
            }
        }
        return closed;
    }
}

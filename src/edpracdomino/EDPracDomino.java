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
public class EDPracDomino {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //DATA
        Scanner entry = new Scanner(System.in);
        int round = 1;
        int pl = 0;
        int rob;
        Game match = new Game();
        boolean opp;
        char op;

        //MAIN
        System.out.println("-------------------------------------------------\n"
                + "CLM Domino: Realizado por MULAS AZABAL, SERGIO\n"
                + "-------------------------------------------------\n");

        do {
            opp=false;
            pl = (pl + 1) % 2;
            if (pl == 0) {
                rob = 2;
            } else {
                rob = 1;
            }
            System.out.println("                        ROUND " + round + "/Player " + (rob) + "\n");

            rob = 0;
            do {
                op = match.menu(pl, entry);
                switch (op) {
                    case ('P'):
                        if (rob == 1) {
                            opp = true;
                        } else {
                            System.out.println("No puedes Pasar. Coloca ficha o roba");
                        }
                        break;
                    case ('R'):
                        if (rob == 0) {
                            rob++;
                            match.steal(pl);
                        } else {
                            System.out.println("No puedes robar más.");
                        }
                        break;
                    default:
                        opp = match.putToken(op, pl, entry);
                }
                System.out.println("");
            } while (op == 'R' || opp == false);
            if (pl == 0) {
                round++;
            }

            System.out.println("");
        } while (match.endgame() == false);
        match.finishGame(pl);
    }

}

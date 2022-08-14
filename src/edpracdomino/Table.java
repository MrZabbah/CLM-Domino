/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edpracdomino;


import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mulas
 */
public class Table {

    //DATA
    private ArrayList<DominoToken> state;

    //CONSTRUCTOR
    public Table() {
        state = new ArrayList<>();
    }

    //METHODS
    public boolean addTable(int elem, Scanner entry, DominoToken add) {
        boolean added;
        char a;
        do {
            System.out.print("Escriba si la ficha se escribe por el inicio 'I' o por el final 'F' : ");
            a = entry.next().charAt(0);
            a = Character.toUpperCase(a);
        } while (a != 'I' && a != 'F');

        if (elem == 1) {
            if (a == 'I') {
                added = addTableBegin(add);
            } else {
                added = addTableEnd(add);
            }
        } else {
            if (a == 'I') {
                added = addTableBegin(add);
            } else {
                added = addTableEnd(add);
            }
        }
        return added;
    }

    public boolean isEmpty() {
        return state.isEmpty();
    }

    public String showTable() {
        return state.toString();
    }

    public DominoToken firstToken() {
        return state.get(0);
    }

    public DominoToken lastToken() {
        return state.get(state.size() - 1);
    }

    private boolean validE(DominoToken token) {
        return state.get(state.size() - 1).unionE(token);
    }

    private boolean validB(DominoToken token) {
        return state.get(0).unionB(token);
    }

    private boolean addTableEnd(DominoToken add) {
        if (state.size() == 0) {
            state.add(add);
            return true;
        } else if (validE(add)) {
            state.add(add);
            return true;
        } else if (validE(add.swap())) {
            state.add(add.swap());
            return true;
        } else {
            System.out.println("You cannot put that token on the table.");
            return false;
        }
    }

    private boolean addTableBegin(DominoToken add) {
        if (state.size() == 0) {
            state.add(add);
            return true;
        } else if (validB(add)) {
            state.add(0, add);
            return true;
        } else if (validB(add.swap())) {
            state.add(0, add.swap());
            return true;
        } else {
            System.out.println("You cannot put that token on the table.");
            return false;
        }
    }

}

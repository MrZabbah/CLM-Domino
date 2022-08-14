/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edpracdomino;

import java.io.Serializable;

/**
 * SE CORRESPONDE CON LA CLASE FICHA PEDIDA EN LA PRACTICA
 *
 * @author mulas
 */
public class DominoToken implements Serializable {

    //DATA
    private int num1, num2;

    //CONSTRUCTOR
    public DominoToken(int a, int b) {
        num1 = a;
        num2 = b;
    }

    //METHODS
    public DominoToken swap() {
        DominoToken a = new DominoToken(num2, num1);
        return a;
    }

    @Override
    public boolean equals(Object o) {

        return this.num1 == ((DominoToken) o).num1 && this.num2 == ((DominoToken) o).num2;
    }

    public boolean same() {
        return (num1 == num2);
    }

    @Override
    public String toString() {
        String ab = "[" + num1 + "/" + num2 + "]";
        return ab;
    }

    public boolean unionE(DominoToken elem) {
        return this.num2 == elem.num1;
    }

    public boolean unionB(DominoToken elem) {
        return this.num1 == elem.num2;
    }

    public int show1() {
        return num1;
    }

    public int show2() {
        return num2;
    }
}

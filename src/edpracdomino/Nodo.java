/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edpracdomino;

/**
 *
 * @author mulas
 * @param <E>
 */
public class Nodo<E> {
    
    //DATA
    E info;
    Nodo<E> next;
    Nodo<E> before;
    
    //CONSTRUCTOR
    public Nodo(E elem){
        info = elem;
        next = null;
        before = null;
    }
}

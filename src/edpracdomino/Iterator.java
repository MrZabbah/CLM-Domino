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
public class Iterator<E> {

    //DATA
    Nodo<E> list;

    //CONSTRUCTOR
    public Iterator(Nodo<E> list) {
        this.list = list;
    }

    //METHODS
    public boolean hasNext() {
        return list != null;
    }

    /**
     *
     * @return @throws NullPointerException
     */
    public E next() throws NullPointerException {
        if (hasNext()) {
            E aux = list.info;
            list = list.next;
            return aux;
        } else {
            throw new NullPointerException();
        }
    }
}

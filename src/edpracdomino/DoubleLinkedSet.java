/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edpracdomino;

import java.util.Random;

/**
 *
 * @author mulas
 * @param <E>
 */
public class DoubleLinkedSet<E> implements Set<E> {

    //DATA
    Nodo<E> Set;
    int cardinal;

    //CONSTRUCTOR
    public DoubleLinkedSet() {
        Set = null;
        cardinal = 0;
    }

    @Override
    public boolean add(E elem) {
        Nodo<E> add = new Nodo<>(elem);
        Nodo<E> aux = Set;

        if (!contains(elem)) {
            if (!isEmpty()) {
                while (aux.next != null) {
                    aux = aux.next;
                }
                aux.next = add;
                add.before = aux;
            } else {
                Set = add;
            }
            cardinal++;
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean remove(E elem) {
        Nodo<E> aux = Set;

        if (contains(elem)) {

            while (!aux.info.equals(elem)) {
                aux = aux.next;
            }
            if (aux.info.equals(Set.info)) {
                Set = Set.next;

            } else if (aux.next != null && aux.before != null) {
                aux.before.next = aux.next;
                aux.next.before = aux.before;
            } else if (aux.next == null) {
                aux.before.next = null;
            }

            cardinal--;
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        String ab = "{ ";
        Iterator it = this.iterator();
        while (it.hasNext()) {
            ab += it.next().toString() + " ";
        }
        ab += "}";
        return ab;

    }

    @Override
    public boolean contains(E elem) {
        boolean found = false;
        
        Iterator<E> it = this.iterator();
        
        while (it.hasNext() && found == false) {
            found = it.next().equals(elem);
            
        }
        return found;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<>(Set);
        return it;
    }

    @Override
    public void addAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        return cardinal;
    }

    @Override
    public boolean isEmpty() {
        return cardinal == 0;
    }

    @Override
    public void clear() {
        Set = null;
        cardinal = 0;
    }

    @Override
    public E choose() {
        Random a = new Random();
        int value = (a.nextInt(cardinal))+1;
        Iterator it = this.iterator();
        E aux=null;
        for (int i = 0; i < value; i++) {
            aux = (E)it.next();
        }
        this.remove(aux);
        return aux;
    }
    
    
}

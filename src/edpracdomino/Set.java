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
public interface Set<E> {
    public boolean add(E elem);
    
    public boolean remove(E elem);
    
    public boolean contains(E elem);
    
    public Iterator<E> iterator();
    
    public void addAll();
    
    public void removeAll();
    
    public boolean containsAll();
    
    public int size();
    
    public boolean isEmpty();
    
    public void clear();
    
    public E choose();
}

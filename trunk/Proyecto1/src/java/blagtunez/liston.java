package blagtunez;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Es la implementación de la lista enlazada acorde a java.util.List, no sirve
 * @param <E> la clase de la lista
 * @author tian
 */
public class liston<E> implements java.util.List  {

    class Contenedor{
    Contenedor sig;
    Contenedor ant;

    E payload;

        public Contenedor getAnt() {
            return ant;
        }

        public void setAnt(Contenedor ant) {
            this.ant = ant;
        }

        public E getPayload() {
            return payload;
        }

        public void setPayload(E payload) {
            this.payload = payload;
        }

        public Contenedor getSig() {
            return sig;
        }

        public void setSig(Contenedor sig) {
            this.sig = sig;
        }

    }

    static boolean FuncioListon = false; //TODO: cambiar esto cuando funcione
    
    private Contenedor ini, fin;

    public int size() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean contains(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Iterator iterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object[] toArray(Object[] a) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean add(Object e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean containsAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean addAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean addAll(int index, Collection c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean removeAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean retainAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void clear() {
        ini = null;
        fin = null;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object get(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object set(int index, Object element) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void add(int index, Object element) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object remove(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ListIterator listIterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ListIterator listIterator(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}

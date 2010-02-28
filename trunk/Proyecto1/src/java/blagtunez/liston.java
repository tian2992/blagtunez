package blagtunez;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Es la implementación de la lista enlazada acorde a java.util.List, no sirve aún
 * @param <E> la clase de la lista
 * @author tian
 */
public class liston<E> implements java.util.List<E>  {

    class Yterbio implements java.util.ListIterator<E> {

        liston<E> l;

        Contenedor inicio = l.ini;
        Contenedor finito = l.fin;
        Contenedor tempi;

        public Yterbio(liston<E> listolon){
            l = listolon;
        }

        public boolean hasNext() {
            return tempi.isSig();
        }

        public E next() {
            if (tempi == null){
                tempi = ini;
                return tempi.getPayload();
            }
            else {
                tempi = tempi.getSig();
                return tempi.getPayload();
            }
        }

        public void remove() {
            Contenedor prev = tempi.getAnt();
            Contenedor sigur = tempi.getSig();

            if (prev!=null)
                prev.setSig(sigur);

            if (sigur!=null)
                sigur.setAnt(prev);

            if (prev==null) //si el que eliminamos era el inicial
                tempi=ini;
        }

        public boolean hasPrevious() {
            return tempi.isAnt();
        }

        public E previous() {
            if (tempi == null){
                tempi = fin;
                return tempi.getPayload();
            }
            else {
                tempi = tempi.getAnt();
                return tempi.getPayload();
            }
        }

        public int nextIndex() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public int previousIndex() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void set(E e) { //Deberian funcionar
            tempi.setPayload(e);
        }

        public void add(E e) { //supuestamente deberia funcionar
            l.add(e);
        }

    }

    class Contenedor{
    Contenedor sig; //Debieron Haber sido ZIG para gran justicia
    Contenedor ant;

    E payload;

        public Contenedor(){}

        public Contenedor(E pay){
            payload = pay;
        }

        public boolean isAnt(){
            if (getAnt()==null)
                return false;
            return true;
        }

        public boolean isSig(){
            if (getSig()==null)
                return false;
            return true;
        }

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

    private Yterbio iterino = new Yterbio(this);
    
    private Contenedor ini, fin;

    public boolean add(E e) {
        if (ini==null){
            ini=new Contenedor(e);
            fin=ini;
            return true;
        }
        else { //solo lo añade al final...
            Contenedor conti = new Contenedor(e);
            conti.setAnt(fin);
            fin.setSig(conti);
            fin = conti;
            return true;
        }
    }

    public int size() {
        int contador = 0;
        Contenedor temp  = ini;
        while (temp!=null){
            contador++;
            temp = temp.getSig();
        }
        return contador;
    }

    public boolean isEmpty() {
        if (ini == null)
            return true;
        else
            return false;
    }

    public boolean contains(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void clear() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public E get(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void add(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public E remove(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ListIterator<E> listIterator() {
        return iterino;
    }

    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

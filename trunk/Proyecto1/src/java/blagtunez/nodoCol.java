package blagtunez;
/**
 * Nodo especializado para las columnas
 * @author tian
 */
public class nodoCol extends nodoHead implements java.io.Serializable {
    nodoCol(){}
    nodoCol(String g){
        setGenero(g);
    }
    /**
    * Funcion getDerecha especial para nodoCol
    * @return el nodo a la derecha "casteado" como nodoCol
    */
    @Override
    public nodoCol getDerecha(){
        return (nodoCol)super.getDerecha();
    }
    /**
    * Funcion getIzquierda especial para nodoCol
    * @return el nodo a la izquierda "casteado" como nodoCol
    */
    @Override
    public nodoCol getIzquierda(){
        return (nodoCol)super.getIzquierda();
    }
}
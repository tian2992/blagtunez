package blagtunez;
/**
 * Nodo especial para las Filas
 * @author tian
 */
public class nodoFila extends nodoHead implements java.io.Serializable{
    nodoFila(){}
    nodoFila(char c){
        setLetra(c);
    }

    /**
    * Funcion getAbajo especial para nodoFila
    * @return el nodo abajo "casteado" como nodoFila
    */
    @Override
    public nodoFila getAbajo(){
        return (nodoFila)super.getAbajo();
    }
    /**
    * Funcion getArriba especial para nodoFila
    * @return el nodo arriba "casteado" como nodoFila
    */
    @Override
    public nodoFila getArriba(){
        return (nodoFila)super.getArriba();
    }
}

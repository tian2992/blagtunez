package blagtunez;

/**
 *
 * @author tian
 */
public class nodo implements java.io.Serializable{

    private nodo arriba     = null;
    private nodo abajo      = null;
    private nodo izquierda  = null;
    private nodo derecha    = null;

    private String genero   = "";
    private char letrina;

    public String toString(){
        return "Letra: "+getLetrina()+" - Genero: "+getGenero();
    }

    public char getLetrina() {
        return letrina;
    }

    public void setLetrina(char letrina) {
        this.letrina = letrina;
    }

    public char getLetra() {
        return letrina;
    }

    public void setLetra(char letra) {
        this.letrina = letra;
    }


    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isAbajo(){
        if (abajo==null)
            return false;
        return true;
    }
    public boolean isArriba(){
        if (arriba==null)
            return false;
        return true;
    }
    public boolean isIzquierda(){
        if (izquierda==null)
            return false;
        return true;
    }
    public boolean isDerecha(){
        if (derecha==null)
            return false;
        return true;
    }

    public nodo getAbajo() {
        return abajo;
    }

    public void setAbajo(nodo abajo) {
        this.abajo = abajo;
    }

    public nodo getArriba() {
        return arriba;
    }

    public void setArriba(nodo arriba) {
        this.arriba = arriba;
    }

    public nodo getDerecha() {
        return derecha;
    }

    public void setDerecha(nodo derecha) {
        this.derecha = derecha;
    }

    public nodo getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(nodo izquierda) {
        this.izquierda = izquierda;
    }

}

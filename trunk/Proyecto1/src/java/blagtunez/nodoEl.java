package blagtunez;


/**
 * Nodo diseñado para los elementos de la matriz, solo tiene la letra inicial y el genero
 * @author tian
 */
public class nodoEl extends nodo implements java.io.Serializable{
    private nodoFila let;
    private nodoHead gen;

    private java.util.List<artista> payload;

    public nodoEl(){
        payload = new liston<artista>();
    }

    nodoEl(char l, String ge){
        payload = new liston<artista>();
        setLetrina(l);
        setGenero(ge);
    }

    nodoEl(nodoFila l, nodoHead g){
        payload = new liston<artista>();
        let = l;
        gen = g;
    }

    public nodoHead getGen() {
        return gen;
    }

    public void setGen(nodoHead gen) {
        this.gen = gen;
    }

    public nodoFila getLet() {
        return let;
    }

    public void setLet(nodoFila let) {
        this.let = let;
    }

    public String printi(){
        String estringente = this.toString();
        System.out.println(estringente);
        return estringente;
    }

    public java.util.List<artista> getPayload() {
        return payload;
    }

    public void setPayload(java.util.List<artista> payload) {
        this.payload = payload;
    }

}

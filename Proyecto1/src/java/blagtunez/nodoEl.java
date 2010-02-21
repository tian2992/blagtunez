package blagtunez;


/**
 *
 * @author tian
 */
public class nodoEl extends nodo {
    nodoFila let;
    nodoHead gen;

    java.util.List<artista> payload;

    nodoEl(){
        if (liston.noFuncioListon)
            payload = new java.util.ArrayList<artista>();
        else
            payload = new liston<artista>();
    }

    nodoEl(char l, String ge){
        setLetrina(l);
        setGenero(ge);
    }

    nodoEl(nodoFila l, nodoHead g){
        super();
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

    public java.util.List getPayload() {
        return payload;
    }

    public void setPayload(java.util.List payload) {
        this.payload = payload;
    }

}

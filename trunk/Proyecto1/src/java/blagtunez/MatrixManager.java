package blagtunez;

/**
 * La clase que abstrae la matriz
 * @author tian
 */
public class MatrixManager implements java.io.Serializable {
    matriz Matrix = new matriz();

    MatrixManager(){
        
    }

    public boolean agregarArtista(String art, String gen){
        nodoEl let = new nodoEl(art.trim().charAt(0),gen);
        artista arti = new artista(art);
        try {
            let = (nodoEl)Matrix.agregarNodo(let);
            return let.getPayload().add(arti);
        }
        catch (Exception e){
            return false;
        }
    }

    public String estadoDeMatriz(){
        if (Matrix.esVacia())
            return "No hay artistas registrados, Porque no <a href='agregaArtista.jsp'>Añades uno</a>";
        else{
            
            return "Hay "+Matrix.contarArtistas()+" artistas en "+Matrix.contarColumnas()+ " generos";
        }
    }



}

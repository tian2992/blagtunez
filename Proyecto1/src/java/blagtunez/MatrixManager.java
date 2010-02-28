package blagtunez;

/**
 * La clase que abstrae la matriz
 * @author tian
 */
public class MatrixManager implements java.io.Serializable {
    static matriz matrix;

    public MatrixManager(){
        
    }
    void setup(){
        if (matrix == null)
            matrix = new matriz();
        else
            return;
    }

    public boolean agregarArtista(artista arti){
        setup();
        nodoEl let = new nodoEl(arti.getNombre().trim().charAt(0),arti.getGenero());

        try{
            let = (nodoEl)matrix.agregarNodo(let);
            return let.getPayload().add(arti);
        }
        catch (Exception e){
            return false;
        }
        //return agregarArtista(a.getNombre(), a.getNacionalidad(),a.getImagen());
    }



    public boolean agregarArtista(String art, String gen){ 
        return agregarArtista(new artista(art,gen));
    }

    public String estadoDeMatriz(){
        setup();
        if (matrix.esVacia())
            return "No hay artistas registrados, Porque no <a href='agregaArtista.jsp'>Añades uno</a>";
        else{
            return "Hay "+matrix.contarArtistas()+" artistas en "+matrix.contarColumnas()+ " generos";
        }
    }



}

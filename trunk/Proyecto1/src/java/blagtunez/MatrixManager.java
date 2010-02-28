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

    public boolean borrarArtista(artista arti){ //TODO: Hacer algo con el nodo que nos retorna la matrix
        nodo nodel= matrix.borrarNodo(arti.getNombre().charAt(0), arti.getGenero());
        if (nodel==null){
            return false;
        }
        return true;
    }

    public java.util.List<String> listarGeneros(){
        return matrix.getGeneros();
    }

    public artista buscarArtista(artista arti){
        if (arti==null)
            return null;
        if (arti.getNombre()==null || arti.getGenero()==null)
            return null;

        nodoEl nodista = matrix.buscarNodo(arti.getNombre().charAt(0),arti.getGenero());

        if (nodista == null)
            return null;

        java.util.List<artista> listin = nodista.getPayload();

        if (listin==null)
            return null;

        if (!listin.isEmpty()){
            for (artista R2D2: listin){
                if (R2D2.getNombre().equalsIgnoreCase(arti.getNombre()) && R2D2.getGenero().equalsIgnoreCase(arti.getGenero())){
                    return R2D2; //esto deberia de funcionar...
                }
            }
        }
        else {
            return null;
        }
        

        return null;
    }



    public boolean agregarArtista(String art, String gen){ 
        return agregarArtista(new artista(art,gen));
    }

    public boolean esVacia(){
        return matrix.esVacia();
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

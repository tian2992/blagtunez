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
        return agregarArtista(arti, false);
    }

    public boolean agregarArtista(artista arti, boolean sano){
        setup();

        if (!sano){
            arti.setNombre(stringFixer.toUTF8(arti.getNombre()));
            arti.setGenero(stringFixer.toUTF8(arti.getGenero()));
        }
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
        arti.setNombre(stringFixer.toUTF8(arti.getNombre()));
        arti.setGenero(stringFixer.toUTF8(arti.getGenero()));
        nodo nodel= matrix.borrarNodo(arti.getNombre().charAt(0), arti.getGenero());
        if (nodel==null){
            return false;
        }
        return true;
    }

    public java.util.List<String> listarGeneros(){
        return matrix.getGeneros();
    }

    public java.util.List<artista> listarArtistas(){
        setup();
        return matrix.getArtistas();
    }

    public java.util.List<artista> listarArtistas(String gen){
        setup();
        return matrix.getArtistasPorGenero(gen);
    }


     /**
     * agrega cancion a lo Ranger, a.k.a no sano
     * @param songi
     * @return el true si funcio, false si no
     */
    public boolean agregarCancion(cancion songi){
        return agregarCancion(songi, false);
    }
    
    public boolean agregarCancion(cancion songi, boolean sano){
        if (songi==null)
            return false;
        if (songi.getNombre()==null || songi.getInterprete()==null)
            return false;
        
        artista artuditu;
        if (sano)
            artuditu = buscarArtista(songi.getInterprete(), true);
        else
            artuditu = buscarArtista(songi.getInterprete());
        
        /* boolean artexis = false;
        if (artuditu == null)
            artexis = agregarArtista(artuditu);
        
        if (!artexis){
            if (sano)
                artuditu = buscarArtista(songi.getInterprete(), true);
            else
                artuditu = buscarArtista(songi.getInterprete());
        }
        */
        if (artuditu==null) //lo intente...
            return false;
        
        if (!sano){
            songi.setNombre(stringFixer.toUTF8(songi.getNombre()));
            songi.getInterprete().setGenero(stringFixer.toUTF8(songi.getInterprete().getGenero()));
            songi.getInterprete().setNombre(stringFixer.toUTF8(songi.getInterprete().getNombre()));
        }
        
        return artuditu.getLisCan().add(songi); //lo metemos ya sanitizado
        
        
        
        //return true;
    }

    /**
     * retorna las canciones del artista, ya sanitizada
     * @param arti
     * @return el artista o null si no ta
     */
    public java.util.List<cancion> getCancionesArtista(String art, String gen){
        //envio las strings ya sanitizadas, :D UTF8 FTW

        artista artuditu = buscarArtista(new artista(art,gen), true);
        if (artuditu==null)
            return null;

        //java.util.List<cancion> listolon = new liston<cancion>();

        return artuditu.getLisCan();

        //return null;
    }
    /**
     * busca los artistas a lo Ranger, a.k.a no sano
     * @param arti
     * @return el artista o null si no ta
     */
    public artista buscarArtista(artista arti){ // si lo envio a lo ranger, no estan sanitizadas
        return buscarArtista(arti, false);
    }

     /**
     * busca los artistas civilizadamente, sano decide si ya estan en UTF-8
      * @param arti el artista a buscar
      * @param sano true si estan sanitizadas
      * @return el artista, o null si no ta
     */
    public artista buscarArtista(artista arti, Boolean sano){
        if (arti==null)
            return null;
        if (arti.getNombre()==null || arti.getGenero()==null)
            return null;

        if (!sano){ //sano decide si estan sanas o no
            arti.setNombre(stringFixer.toUTF8(arti.getNombre()));
            arti.setGenero(stringFixer.toUTF8(arti.getGenero()));
        }

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

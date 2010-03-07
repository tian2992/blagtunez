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

    public void vaciarMatriz(){
        matrix = new matriz();
    }

    public boolean reemplazarArtista(artista art1, artista art2, Boolean sano){
        UserManager.log("Se reemplaza "+art1+" por "+art2);
        art2.setLisCan(art1.getLisCan());
        borrarArtista(art1,sano);
        return agregarArtista(art2,sano);
    }

    public boolean reemplazarArtista(artista art1, artista art2){
        return reemplazarArtista(art1,art2,false);
    }

    public boolean agregarArtista(artista arti){
        return agregarArtista(arti, false);
    }

    public boolean agregarArtista(artista arti, boolean sano){
        setup();
        UserManager.log("Se agrega "+arti);
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

    public boolean borrarArtista(artista arti){
        return borrarArtista(arti, false);
    }

    public boolean borrarArtista(artista arti, boolean sano){ //TODO: Hacer algo con el nodo que nos retorna la matrix
        UserManager.log("Se Borra "+arti);
        if (!sano){
            arti.setNombre(stringFixer.toUTF8(arti.getNombre()));
            arti.setGenero(stringFixer.toUTF8(arti.getGenero()));
        }
        try {
            nodoEl nodel = (nodoEl)matrix.buscarNodo(arti.getNombre().charAt(0), arti.getGenero());
            if (nodel==null){
                return false;
            }
            liston<artista> listu = (liston<artista>)nodel.getPayload();

            artista temp = null;
            for (artista ar:listu){ //forma no eficiente de hacer las cosas
                if (ar.getNombre().equalsIgnoreCase(arti.getNombre())&&(ar.getGenero().equalsIgnoreCase(arti.getGenero()))){
                    temp = ar;
                    break;
                }
            }
            if (temp == null)
                return false;

            listu.remove(temp);

            if (listu.isEmpty()){
                matrix.borrarNodo(nodel);
            }

            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean borrarGenero(String s){
        UserManager.log("Se borra el genero "+s);
        //no funcio...
        nodoCol coli = matrix.buscarColumna(s);
        
        if (coli==null)
            return false;

        matrix.borrarColumna(coli);
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

    public boolean agregarCancion(String nomSon, String anio, String art, String gen){
        return agregarCancion(nomSon,anio,art,gen,false);
    }

    public boolean agregarCancion(String nomSon, String anio, String art, String gen, boolean sano){
        try {
        int año = Integer.parseInt(anio);
        if (!sano){
            nomSon = stringFixer.toUTF8(nomSon);
            art  = stringFixer.toUTF8(art);
            gen = stringFixer.toUTF8(gen);
        }

        artista arti = buscarArtista(new artista(art,gen),true);

        if (arti == null)
            return false;
        
        cancion songi = new cancion(nomSon,año,arti);

        if (songi==null)
            return false;

        return agregarCancion(songi,arti,true);

        //return true;
        } catch (Exception e){
            return false;
        }
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

        UserManager.log("Se agregó "+songi);

        return artuditu.getLisCan().add(songi); //lo metemos ya sanitizado
        
        
        
        //return true;
    }

    public boolean agregarCancion(cancion songi, artista arti, boolean sano){ //solo si ya estan ambos
        if (!sano)
            songi.setNombre(songi.getNombre());
        songi.setInterprete(arti);
        arti.getLisCan().add(songi);
        UserManager.log("Se agregó "+songi);
        return true;
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

        nodoEl nodista = (nodoEl)matrix.buscarNodo(arti.getNombre().charAt(0),arti.getGenero());

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

    public artista buscarArtista(String s){
        return matrix.getArtista(s);
    }

    public boolean borrarCancion(String artiString, String genString, String rola, boolean sano){
        if (!sano){
            rola = stringFixer.toUTF8(rola);
        }

        artista artuditu = this.buscarArtista(new artista(artiString,genString),false); //Si sano es verdad, si si no no
        if (artuditu==null)
            return false;
        
        cancion tempRola = null; //Terriblemente ineficiente, pero que se le hace...
        for (cancion s: artuditu.getLisCan()){
            if (s.getNombre().equalsIgnoreCase(rola)){
                tempRola = s;
                break;
            }
        }
        if (tempRola == null)
            return false;
        
        UserManager.log("Se borro "+tempRola);

        return artuditu.getLisCan().remove(tempRola); // se que lo recorre dos veces, es ineficiente...
        
    }

    public boolean borrarCancion(String a, String g, String r){
        return borrarCancion(a,g,r,false);
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

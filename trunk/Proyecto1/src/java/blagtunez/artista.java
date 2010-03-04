package blagtunez;

import java.util.List;

/**
 * Clase de Artistas
 */

public class artista implements java.io.Serializable {

    String nombre;
    String nacionalidad;
    String imagen;
    String genero;

    static String imagenPrefix = "";

    java.util.List<cancion> lisCan;

    public artista(){
        if (liston.FuncioListon)
            lisCan = new liston<cancion>();
        else
            lisCan = new java.util.ArrayList<cancion>();
    }

    public artista(String nom){
        super();
        setNombre(nom);
    }
    public artista(String nom, String gen){
        super();
        setNombre(nom);
        setGenero(gen);
    }

    public artista(String nom, String gen, String nacion){
        super();
        setNombre(nom);
        setNacionalidad(nacion);
    }

    public artista(String nom, String gen, String nacion, String pic){
        super();
        setNombre(nom);
        setGenero(gen);
        setNacionalidad(nacion);
        setImagen(pic);
    }

    public String toString(){
        return getNombre()+" - "+getGenero();
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getImagen() {
        return imagenPrefix+imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Boolean isImagen(){
        if (imagen==null)
            return false;
        if (imagen.equals(""))
            return false;

        return true;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

        public List<cancion> getLisCan() {
        return lisCan;
    }

    public void setLisCan(List<cancion> lisCan) {
        this.lisCan = lisCan;
    }

    public static String getImagenPrefix() {
        return imagenPrefix;
    }

    public static void setImagenPrefix(String imagenPrefix) {
        artista.imagenPrefix = imagenPrefix;
    }
}

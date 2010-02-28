package blagtunez;

/**
 * Clase de Artistas
 */

public class artista implements java.io.Serializable {

    String nombre;
    String nacionalidad;
    String imagen;
    String genero;

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

   public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
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

    

}

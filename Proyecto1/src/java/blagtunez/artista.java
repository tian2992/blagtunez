package blagtunez;

/**
 * Clase de Artistas
 */

public class artista implements java.io.Serializable {

    String nombre;
    String nacionalidad;
    String imagen;

    java.util.List<cancion> lisCan;

    artista(){
        if (liston.FuncioListon)
            lisCan = new liston<cancion>();
        else
            lisCan = new java.util.ArrayList<cancion>();
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

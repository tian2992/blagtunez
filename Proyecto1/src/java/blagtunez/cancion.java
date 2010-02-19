package blagtunez;

/**
 * Clase <code>Canción</code>
 * @author tian
 */
public class cancion implements java.io.Serializable {
    String nombre;
    int año;
    artista interprete;

    public cancion() {

    }

    public cancion(String nombre, int año, artista interprete) {
        this.nombre = nombre;
        this.año = año;
        this.interprete = interprete;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public artista getInterprete() {
        return interprete;
    }

    public void setInterprete(artista interprete) {
        this.interprete = interprete;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

}

package blagtunez;

/**
 *
 * @author tian
 */
public class Usuario implements java.io.Serializable {
    private String nombre;
    private String username;
    private String pass;
    private String email;
    private boolean admin;



    public Usuario(){
    }

    @Override
    public String toString(){
        return getUsername() + " - " + getPass();
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the email
     */
    public String getEMail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEMail(String eMail) {
        this.email = eMail;
    }
    public void setEmail(String eMail) {
        this.email = eMail;
    }

    /**
     * @return the admin
     */
    public boolean isAdmin() {
        return admin;
    }

    /**
     * @param admin the admin to set
     */
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    


}

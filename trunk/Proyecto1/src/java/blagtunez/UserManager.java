package blagtunez;

/**
 *
 * @author tian
 */
public class UserManager implements java.io.Serializable {
    static java.util.List<Usuario> lisUser;
    
    static void setup(){
        if (lisUser == null){
            if (liston.FuncioListon)
                lisUser = new liston<Usuario>();
            else
                lisUser = new java.util.ArrayList<Usuario>();

            Usuario ad = new Usuario();
            ad.setAdmin(true);
            ad.setUsername("admin");
            ad.setPass("admin");
            ad.setNombre("Administrador");
            ad.setEMail("tian@localhost");
            lisUser.add(ad);
        }
    }

    public UserManager(){
        setup();
    }

    static public boolean autenticar(String user, String pass){
        setup();
        for (Usuario us: lisUser){
            if ((us.getUsername().equalsIgnoreCase(user))&&(us.getPass().equals(pass))){
                return true;
            }
        }
        return false;
    }
    static public boolean anadirUser(Usuario u){
        setup();
        return lisUser.add(u);
    }

    static public boolean isValido(Usuario u){
        if ((u.getUsername() != null) && (u.getPass()!=null) && (u.getNombre()!=null) && (u.getEMail()!=null)){
            return true;
        }
        else{
            return false;
        }
    }

}
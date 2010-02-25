package blagtunez;

/**
 *
 * @author tian
 */
public class UserManager implements java.io.Serializable {
    private static java.util.List<Usuario> lisUser;

    static void setup(){
        if (lisUser == null){
            if (liston.FuncioListon)
                lisUser = new liston<Usuario>();
            else
                lisUser = new java.util.ArrayList<Usuario>();

            Usuario ad = new Usuario();
            ad.setAdmin(true);
            ad.setNombre("Administrador");
            ad.setUsername("admin");
            ad.setPass("admin");
            lisUser.add(ad);
        }
    }

    public UserManager(){
        setup();
    }

    //TODO: crear usuarios

    static public boolean autenticar(String user, String pass){
        setup();
        for (Usuario us: lisUser){
            if ((us.getUsername().equalsIgnoreCase(user))&&(us.getPass().equals(pass))){
                return true;
            }
        }
        return false;
    }
    static public boolean añadirUser(Usuario u){
        setup();
        return lisUser.add(u);
    }

}

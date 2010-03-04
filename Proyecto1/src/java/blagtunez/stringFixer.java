package blagtunez;
import java.net.URLEncoder;
/**
 * Arreglando las idioteces de Tomcat
 * @author tian
 */
public class stringFixer {
    /**
    * Arreglando las idioteces de Tomcat
    * @author tian
    */
    public static String toUTF8(String isoString) {
        String utf8String = null;
        if (null != isoString && !isoString.equals("")) {
            try {
                byte[] stringBytesISO = isoString.getBytes("ISO-8859-1");
                utf8String = new String(stringBytesISO, "UTF-8");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            utf8String = isoString;
        }
        return utf8String;
    }
    public static String urlEncode(String s){
        try {
            return URLEncoder.encode(s,"UTF-8");
        }
        catch (Exception e){
            return s;
        }
    }
}

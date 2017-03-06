package id.co.aribanilia.gdserver.util;

/**
 * Created by ivan_j4u on 2/23/2017.
 */
public class GDConstants {

    public interface CLIENT {
        String ADMIN = "admin";
        String USER = "user";
    }

    public interface AUTHORITIES {
        String APPLICATION_WEB = "APPLICATION_WEB";
        String APPLICATION_MOBILE = "APPLICATION_MOBILE";
        String HAS_AUTHORITY_WEB = "hasAuthority('APPLICATION_WEB')";
        String HAS_AUTHORITY_MOBILE = "hasAuthority('APPLICATION_MOBILE')";
    }

    public interface PERMISSION {
        String USER_EDIT = "USER_EDIT";
        String USER_VIEW = "USER_VIEW";
    }

    public interface SCOPE {
        String MODULE_GADAI = "modul-gadai";
        String MODULE_HARGA = "modul-harga";
    }
}

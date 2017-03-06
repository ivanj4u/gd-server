package id.co.aribanilia.gdserver.util;

/**
 * Created by ivan_j4u on 2/23/2017.
 */
public class GDConstants {

    public enum CLIENT {
        ADMIN("admin", "Admin","admin123"),
        USER("user", "User","user123");

        private String username;
        private String role;
        private String password;

        CLIENT(String clientId, String role, String password) {
            this.username = clientId;
            this.role = role;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getRole() {
            return role;
        }

        public String getPassword() {
            return password;
        }
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

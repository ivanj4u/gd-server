package id.co.aribanilia.gdserver.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;

/**
 * Created by ivan_j4u on 2/23/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    private String fullname;
    private String email;
    private String noHandphone;

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNoHandphone() {
        return noHandphone;
    }

    public void setNoHandphone(String noHandphone) {
        this.noHandphone = noHandphone;
    }
}

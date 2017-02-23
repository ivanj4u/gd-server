package id.co.aribanilia.gdserver.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;

/**
 * Created by ivan_j4u on 2/23/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRole {
    @Id
    private String id;
    private String username;
    private String roleId;

    public UserRole() {
    }

    public UserRole(String username, String roleId) {
        this.username = username;
        this.roleId = roleId;
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

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}

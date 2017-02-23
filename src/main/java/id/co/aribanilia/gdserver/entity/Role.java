package id.co.aribanilia.gdserver.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;

/**
 * Created by ivan_j4u on 2/23/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Role {
    @Id
    private String id;
    private String roleId;
    private String roleName;
    private String description;

    public Role() {
    }

    public Role(String roleId, String roleName, String description) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

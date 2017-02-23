package id.co.aribanilia.gdserver.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;

/**
 * Created by ivan_j4u on 2/23/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Permission {
    @Id
    private String id;
    private String permissionId;
    private String permissionType;
    private String description;

    public Permission(String permissionId, String permissionType, String description) {
        this.permissionId = permissionId;
        this.permissionType = permissionType;
        this.description = description;
    }

    public Permission() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(String permissionType) {
        this.permissionType = permissionType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

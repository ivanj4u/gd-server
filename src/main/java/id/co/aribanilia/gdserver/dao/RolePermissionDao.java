package id.co.aribanilia.gdserver.dao;

import id.co.aribanilia.gdserver.entity.RolePermission;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by ivan_j4u on 2/23/2017.
 */
public interface RolePermissionDao extends MongoRepository<RolePermission, String> {
    List<RolePermission> findByRoleId(String roleId);
}

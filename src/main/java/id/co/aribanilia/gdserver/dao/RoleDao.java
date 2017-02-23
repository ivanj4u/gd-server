package id.co.aribanilia.gdserver.dao;

import id.co.aribanilia.gdserver.entity.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by ivan_j4u on 2/23/2017.
 */
public interface RoleDao extends MongoRepository<Role, String> {
    Role findByRoleId(String roleId);
}

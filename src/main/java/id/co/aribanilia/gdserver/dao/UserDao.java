package id.co.aribanilia.gdserver.dao;

import id.co.aribanilia.gdserver.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by ivan_j4u on 2/23/2017.
 */

public interface UserDao extends MongoRepository<User, String> {
    User findByUsername(String username);
}

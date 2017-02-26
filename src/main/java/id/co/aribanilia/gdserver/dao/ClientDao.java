package id.co.aribanilia.gdserver.dao;

import id.co.aribanilia.gdserver.entity.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by ivan_j4u on 2/24/2017.
 */
public interface ClientDao extends MongoRepository<Client, String> {
    Client findByClientId(String clientId);
}

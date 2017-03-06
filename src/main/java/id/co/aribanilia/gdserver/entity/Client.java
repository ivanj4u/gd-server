package id.co.aribanilia.gdserver.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;

/**
 * Created by ivan_j4u on 2/24/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Client {

    @Id
    private String id;
    private String clientId;
    private String clientName;
    private String password;
    private int tokenValidity;

    public Client() {
    }

    public Client(String clientId, String clientName, String password, int tokenValidity) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.password = password;
        this.tokenValidity = tokenValidity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTokenValidity() {
        return tokenValidity;
    }

    public void setTokenValidity(int tokenValidity) {
        this.tokenValidity = tokenValidity;
    }
}

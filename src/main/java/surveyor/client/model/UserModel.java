
package surveyor.client.model;

import java.io.Serializable;
import javax.validation.constraints.Size;

/**
 *
 * @author Temujin Penlington
 */
public class UserModel implements Serializable {

    private static final long serialVersionUID = 1L;    

    private String id;
    
    @Size(min = 1, max = 50)
    private String userName;

    @Size(min = 1, max = 20)
    private String password;
    
    private String role = "AUDITOR";
    
    private String srvrSessionId;
    
    private String clientSessionId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    public String getSrvrSessionId() {
        return srvrSessionId;
    }

    public void setSrvrSessionId(String srvrSessionId) {
        this.srvrSessionId = srvrSessionId;
    }

    public String getClientSessionId() {
        return clientSessionId;
    }

    public void setClientSessionId(String clientSessionId) {
        this.clientSessionId = clientSessionId;
    }
        
}
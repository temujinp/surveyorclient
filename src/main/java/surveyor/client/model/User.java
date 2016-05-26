
package surveyor.client.model;

import java.io.Serializable;
import javax.validation.constraints.Size;

/**
 *
 * @author Temujin Penlington
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;    
    
    private String id = "";
    private @Size(min = 1, max = 50) String userName = "";
    private @Size(min = 1, max = 20) String password = "";
    private String passwordconfirm = "";
    private String role = "";
    private String email = "";
    private String phone = "";
    private String name = "";    
    private String surname = "";
    private String gender = "";    
    
    public User(){}
            
    public User(String id, String userName, String password, String role, String email, String phone, String name, String surname, String gender){
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.email = email;
        this.phone = phone;
        this.name = name;    
        this.surname = surname;
        this.gender = gender;     
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordconfirm() {
        return passwordconfirm;
    }

    public void setPasswordconfirm(String passwordconfirm) {
        this.passwordconfirm = passwordconfirm;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
        
}
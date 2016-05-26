
package surveyor.client.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import surveyor.client.collection.HashMap2D;
import surveyor.client.model.Person;
import surveyor.client.model.Role;
import surveyor.client.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author Temujin Penlington
 * This will make calls to the REST webservice
 */
@Component
@Scope(WebApplicationContext.SCOPE_APPLICATION)
public class RestServiceClient implements ServletContextAware {
    
    private final Logger logger = LoggerFactory.getLogger(getClass());    
    
    private ServletContext servletContext;
    private HashMap2D roles = new HashMap2D();
    private String contextPath = "/surveyorclient/";
    
    /* 
       Each Role has certain Pemissions elated to that Role.
       The links governed by those Roles are geneated accordingly
       This has a performance impact, so is strictly for experimentation purposes
    */
    public void getPermissions(){
        roles.clear();
        
        // Admin(s) roles permissions
        roles.addElement("ADMIN", "userHome", true);
        roles.addElement("ADMIN", "userView", true);
        roles.addElement("ADMIN", "userListView", true);        
        roles.addElement("ADMIN", "userListEdit", true);
        roles.addElement("ADMIN", "userEdit", true);
        roles.addElement("ADMIN", "userCreate", true);
        roles.addElement("ADMIN", "userDelete", true);

        // Supervisor(s) role permissions
        roles.addElement("SUPER", "userHome", true);
        roles.addElement("SUPER", "userListView", true);           
        roles.addElement("SUPER", "userView", true);
        roles.addElement("SUPER", "userListEdit", true);
        roles.addElement("SUPER", "userEdit", true);

        roles.addElement("SUPER", "personHome", true);        
        roles.addElement("SUPER", "personCreate", true);     
        roles.addElement("SUPER", "personListEdit", true);          
        roles.addElement("SUPER", "personEdit", true);
        
        // Workers(s) role permissions
        roles.addElement("WORKER", "userHome", true);
        roles.addElement("WORKER", "userEdit", true);
 
        roles.addElement("WORKER", "personHome", true);
        roles.addElement("WORKER", "personListEdit", true);            
        roles.addElement("WORKER", "personEdit", true);
               
        // Auditor(s) role permissions
        roles.addElement("AUDITOR", "userHome", true);
        roles.addElement("AUDITOR", "userView", true);
        roles.addElement("AUDITOR", "userListView", true);        
        
        roles.addElement("AUDITOR", "personHome", true);
        roles.addElement("AUDITOR", "personListView", true);         
        roles.addElement("AUDITOR", "personView", true);
        
        System.out.println("RestServiceClient.getPermissions()");
    }

    public List<Role> getAllRoles() {
        // This will make the call to the Rest Webservice Endpoint
        // A sessionToken should also be sent for authentication        
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<List<Role>> rateResponse = restTemplate.exchange("url rest end point", HttpMethod.GET, null, new ParameterizedTypeReference<List<Role>>() {});
//        List<Role> roles = rateResponse.getBody();
        
        ArrayList<Role> allRoles = new ArrayList<>();
        allRoles.add(new Role("ADMIN", "ADMIN"));
        allRoles.add(new Role("SUPER", "SUPER"));
        allRoles.add(new Role("WORKER", "WORKER"));
        allRoles.add(new Role("AUDITOR", "AUDITOR"));
        return allRoles;
    }

    public List<User> getAllUsers() {
        // This will make the call to the Rest Webservice Endpoint
        // A sessionToken should also be sent for authentication        
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<List<User>> rateResponse = restTemplate.exchange("url rest end point", HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {});
//        List<User> users = rateResponse.getBody();        
        
        ArrayList<User> allUsers = new ArrayList<>();
        allUsers.add(new User("1", "joe", "pwd1", "ADMIN", "joe@gmail.com", "1111", "Joe", "Blog", "m"));
        allUsers.add(new User("2", "ed", "pwd2", "SUPER", "ed@gmail.com", "2222", "Ed", "Harris", "m"));
        allUsers.add(new User("3", "mary", "pwd3", "WORKER", "mary@gmail.com", "4444", "Mary", "Smith", "f"));
        allUsers.add(new User("4", "jane", "pwd4", "AUDITOR", "jane@gmail.com", "5555", "Jane", "Doe", "f"));
        return allUsers;
    }

    public User getUserById(String id) {
        // This will make the call to the Rest Webservice Endpoint
        // A sessionToken should also be sent for authentication        
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<List<User>> rateResponse = restTemplate.exchange("url rest end point", HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {});
//        List<User> users = rateResponse.getBody();        
        
        ArrayList<User> allUsers = new ArrayList<>();
        allUsers.add(new User("1", "joe", "pwd1", "ADMIN", "joe@gmail.com", "1111", "Joe", "Blog", "m"));
        allUsers.add(new User("2", "ed", "pwd2", "SUPER", "ed@gmail.com", "2222", "Ed", "Harris", "m"));
        allUsers.add(new User("3", "mary", "pwd3", "WORKER", "mary@gmail.com", "4444", "Mary", "Smith", "f"));
        allUsers.add(new User("4", "jane", "pwd4", "AUDITOR", "jane@gmail.com", "5555", "Jane", "Doe", "f"));
        for (User user : allUsers) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return new User("", "", "", "", "", "", "", "", "");
    }    
        
    public User userAuthenticate(String userName, String password) {
        // This will make the call to the Rest Webservice Endpoint
        // A sessionToken should also be sent for authentication        
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<List<User>> rateResponse = restTemplate.exchange("url rest end point", HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {});
//        List<User> users = rateResponse.getBody();        
        
        ArrayList<User> allUsers = new ArrayList<>();
        allUsers.add(new User("1", "joe", "pwd1", "ADMIN", "joe@gmail.com", "1111", "Joe", "Blog", "m"));
        allUsers.add(new User("2", "ed", "pwd2", "SUPER", "ed@gmail.com", "2222", "Ed", "Harris", "m"));
        allUsers.add(new User("3", "mary", "pwd3", "WORKER", "mary@gmail.com", "4444", "Mary", "Smith", "f"));
        allUsers.add(new User("4", "jane", "pwd4", "AUDITOR", "jane@gmail.com", "5555", "Jane", "Doe", "f"));
        for (User user : allUsers) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }    
    
    public List<Person> getAllPersons() {
        // This will make the call to the Rest Webservice Endpoint
        // A sessionToken should also be sent for authentication
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<List<Person>> rateResponse = restTemplate.exchange("url rest end point", HttpMethod.GET, null, new ParameterizedTypeReference<List<Person>>() {});
//        List<Person> persons = rateResponse.getBody();      
        
        ArrayList<Person> allPersons = new ArrayList<>();
        allPersons.add(new Person("1", "pete", "osmond", "Male", "01-01-1987"));
        allPersons.add(new Person("2", "ted", "nugent", "Male", "10-09-1975"));
        allPersons.add(new Person("3", "may", "frill", "Female", "03-05-1986"));
        allPersons.add(new Person("4", "jen", "grant", "Female", "06-02-1968"));
        return allPersons;
    }

    public Person getPersonById(String id) {
        // This will make the call to the Rest Webservice Endpoint
        // A sessionToken should also be sent for authentication
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<List<Person>> rateResponse = restTemplate.exchange("url rest end point", HttpMethod.GET, null, new ParameterizedTypeReference<List<Person>>() {});
//        List<Person> persons = rateResponse.getBody();                
        
        ArrayList<Person> allPersons = new ArrayList<>();
        allPersons.add(new Person("1", "pete", "osmond", "Male", "01-01-1987"));
        allPersons.add(new Person("2", "ted", "nugent", "Male", "10-09-1975"));
        allPersons.add(new Person("3", "may", "frill", "Female", "03-05-1986"));
        allPersons.add(new Person("4", "jen", "grant", "Female", "06-02-1968"));
        for (Person Person : allPersons) {
            if (Person.getId().equals(id)) {
                return Person;
            }
        }
        return new Person("", "", "", "", "");
    }    
    
    public String getContextPath() {
        return contextPath;
    }
        
    public void addPermissions(){
        //roles.addElement("ADMIN", "userListView", true);
    }    
    
    public HashMap2D getRole() {
        return roles;
    }

    public void setRole(HashMap2D roles) {
        this.roles = roles;
    }

    public void addRolePermission(String role, String permission){
        roles.addElement(role, permission, true);
    }
    
    public Object hasRolePermission(String role, String permission){
        return roles.getElement(role, permission);
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
            this.servletContext = servletContext;
    }

    public ServletContext getServletContext() {
            return servletContext;
    }        
}

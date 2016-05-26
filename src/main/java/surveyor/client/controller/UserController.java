package surveyor.client.controller;

import surveyor.client.annotation.Authorize;
import surveyor.client.annotation.Home;
import surveyor.client.model.Role;
import surveyor.client.model.User;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Temujin Penlington
 */
@Controller
@RequestMapping(value = "/")
public class UserController extends BaseController { 
    
    private final Logger logger = LoggerFactory.getLogger(getClass());        

    // Controller requestMapping
    //String controllerMapping = this.getClass().getAnnotation(RequestMapping.class).value()[0];
    //Method requestMapping
    //String methodMapping = new Object(){}.getClass().getEnclosingMethod().getAnnotation(RequestMapping.class).value()[0];
    
    @RequestMapping(value = "userHome", method = RequestMethod.GET)
    @Authorize(permission = "userHome", action = "home", description = "View Users Home page", linkGenerate = "true", linkTitle = "User(s)", pageTitle="User Home")
    @Home
    public String userHome(Model model, HttpServletRequest request) {
        logger.debug("UserController.userHome");
        //System.out.println("getContextPath : " + request.getContextPath());
        return "userHome";
    }

    @RequestMapping(value = "userListView", method = RequestMethod.GET)
    @Authorize(permission = "userListView", action = "search", description = "View Users Listing page", linkGenerate = "true", linkTitle = "User(s) Viewing", pageTitle="User(s) Viewing")
    public String userListView(Model model) {
        logger.debug("UserController.userListView");
        model.addAttribute("message", "");
        return "userListView";
    }
    
    @RequestMapping(value = "userView/{id}", method = RequestMethod.GET)
    @Authorize(permission = "userView", action = "read", description = "View User page", linkGenerate = "false", pageTitle="User Viewing")
    public String userView(@PathVariable(value = "id") String id, Model model) {
        logger.debug("UserController.userView");
        model.addAttribute("message", "");
        model.addAttribute("userModel", user(id));
        return "userView";
    }
    
    @RequestMapping(value = "userCreate", method = RequestMethod.GET)
    @Authorize(permission = "userCreate", action = "create", description = "Create User page", linkGenerate = "true", linkTitle = "User Creation", pageTitle="User Creation")
    public String userCreate(Model model) {
        logger.debug("UserController.userView");
        model.addAttribute("message", "");
        model.addAttribute("userModel", new User());
        return "userCreate";
    }

    @RequestMapping(value = "userCreate", method = RequestMethod.POST)
    @Authorize(permission = "userCreate", action = "create", description = "Create User page", linkGenerate = "false", pageTitle="User Creation")
    public String userCreatePost(@ModelAttribute("userModel") User user, Model model) {
        logger.debug("UserController.userCreatePost");
        model.addAttribute("message", "User Created Successfuly");
        //System.out.println("getUserById.getName : " + getUserById.getName());
        return "userCreate";
    }

    @RequestMapping(value = "userListEdit", method = RequestMethod.GET)
    @Authorize(permission = "userListEdit", action = "search", description = "View Users Editing page", linkGenerate = "true", linkTitle = "User(s) Editing", pageTitle="User(s) Editing")
    public String userListEdit(Model model) {
        logger.debug("UserController.userListEdit");
        model.addAttribute("message", "");
        return "userListEdit";
    }    
    
    @RequestMapping(value = "userEdit/{id}", method = RequestMethod.GET)
    @Authorize(permission = "userEdit", action = "edit", description = "Edit User page", linkGenerate = "false", pageTitle="User Editing")
    public String userEdit(@PathVariable(value = "id") String id, Model model) {
        logger.debug("UserController.userEdit");
        model.addAttribute("message", "");
        model.addAttribute("userModel", user(id));
        return "userEdit";
    }

    @RequestMapping(value = "userEdit/{id}", method = RequestMethod.POST)
    @Authorize(permission = "userEdit", action = "edit", description = "Edit User update page", linkGenerate = "false", pageTitle="Edit User")
    public String userEditPost(@PathVariable(value = "id") String id, @ModelAttribute("userModel") User user, Model model) {
        logger.debug("UserController.userEditPost");
        model.addAttribute("message", "User Updated Successfuly");
        return "userEdit";
    }
    
    @ModelAttribute("allRoles")
    public List<Role> allRoles() {
        return super.getRestServiceClient().getAllRoles();
    }

    @ModelAttribute("allUsers")
    public List<User> allUsers() {
        return super.getRestServiceClient().getAllUsers();
    }

    @ModelAttribute("user")
    public User user(String id) {
        List<User> allUsers = super.getRestServiceClient().getAllUsers();
        for (User user : allUsers) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return new User("", "", "", "", "", "", "", "", "");
    }

}

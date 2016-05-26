
package surveyor.client.controller;

import surveyor.client.annotation.Authorize;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Temujin Penlington
 */
@Controller
@RequestMapping(value = "/")
public class AdminController extends BaseController {
    
    private final Logger logger = LoggerFactory.getLogger(getClass());    
    
    public String getContextPath(String contextPath){
        return "";
    }    
    
    @RequestMapping(value = "rolePermissions", method = RequestMethod.GET)
    @Authorize(permission = "rolePermissions", action = "")
    public String rolePermissions(Model model) {
        System.out.println("AdminController.rolePermissions");
        model.addAttribute("message", "List of Role permissions");
        return "rolePermissions";
    }     
}

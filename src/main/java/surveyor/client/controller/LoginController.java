package surveyor.client.controller;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import surveyor.client.model.User;
import surveyor.client.model.UserModel;
import surveyor.client.service.RestServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Temujin Penlington
 */
@Controller
@RequestMapping(value = "/")
public class LoginController {
    
    private final Logger logger = LoggerFactory.getLogger(getClass());        
    
    @Autowired
    private RestServiceClient restServiceClient;        

    public RestServiceClient getRestServiceClient() {
        return restServiceClient;
    }

    public void setRestServiceClient(RestServiceClient restServiceClient) {
        this.restServiceClient = restServiceClient;
    }
    
    @RequestMapping(value = {"userLogin", "/"}, method = RequestMethod.GET)
    public String userLogin(ModelMap map, Model model, HttpServletRequest request) {
        logger.debug("LoginController.userLogin");
        request.getSession().invalidate();
        User userModel = new User();
        model.addAttribute("userModel", userModel);
        return "userLogin";
    }

    @RequestMapping(value = "userLogin", method = RequestMethod.POST)
    public String userLoginPost(@Valid UserModel userModel,
            BindingResult result,
            Map model,
            HttpServletRequest request,
            HttpServletResponse reponse) {
        logger.debug("LoginController.loginProcess");
        request.getSession().invalidate();
        userModel = (UserModel) model.get("userModel");
        User user = restServiceClient.userAuthenticate(userModel.getUserName(), userModel.getPassword());
        try {
            if(user != null){
                SecureRandom prng = SecureRandom.getInstance("SHA1PRNG");
                userModel.setSrvrSessionId(prng.toString());
                HttpSession session = request.getSession(true);
                userModel.setId(user.getId());
                userModel.setClientSessionId(session.getId());
                userModel.setRole(user.getRole());
                session.setAttribute("userModel", userModel);            
            }else{
                model.put("message", "User does not exist");
                return "userLogin";
            }
        } catch (NoSuchAlgorithmException ex) {
            System.err.println(ex);
        }
        return "redirect:userHome";
    }
    
    @RequestMapping(value = "notLoggedIn", method = RequestMethod.GET)
    public String notLoggedIn(Model model) {
        logger.debug("LoginController.notLoggedIn");
        User userModel = new User();
        model.addAttribute("userModel", userModel);
        model.addAttribute("message", "Login to have access");
        return "userLogin";
    }
        
    @RequestMapping(value = "/notPermission", method = RequestMethod.GET)
    public String notPermission(Model model) {
        logger.debug("LoginController.notPermission");
        model.addAttribute("message", "You have no permission");
        return "notPermission";
    }    
    
}

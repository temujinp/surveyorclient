
package surveyor.client.controller;

import surveyor.client.annotation.Authorize;
import surveyor.client.annotation.Home;
import surveyor.client.model.Person;
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
public class PersonController extends BaseController {
    
    private final Logger logger = LoggerFactory.getLogger(getClass());        
    
    @RequestMapping(value = "personHome", method = RequestMethod.GET)
    @Authorize(permission = "personHome", action = "home", description = "View person(s) Home page", linkGenerate = "true", linkTitle = "Person(s)", pageTitle="Person Home")
    @Home
    public String personHome(Model model, HttpServletRequest request) {
        logger.debug("personController.personHome");
        //System.out.println("getContextPath : " + request.getContextPath());
        return "personHome";
    }

    @RequestMapping(value = "personListView", method = RequestMethod.GET)
    @Authorize(permission = "personListView", action = "search", description = "View persons Listing page", linkGenerate = "true", linkTitle = "Person(s) Viewing", pageTitle="Person(s) Viewing")
    public String personListView(Model model) {
        logger.debug("personController.personListView");
        model.addAttribute("message", "");
        return "personListView";
    }
    
    @RequestMapping(value = "personView/{id}", method = RequestMethod.GET)
    @Authorize(permission = "personView", action = "read", description = "View person page", linkGenerate = "false", pageTitle="Person Viewing")
    public String personView(@PathVariable(value = "id") String id, Model model) {
        logger.debug("personController.personView");
        model.addAttribute("message", "");
        model.addAttribute("personModel", super.getRestServiceClient().getPersonById(id));
        return "personView";
    }
    
    @RequestMapping(value = "personCreate", method = RequestMethod.GET)
    @Authorize(permission = "personCreate", action = "create", description = "Create person page", linkGenerate = "true", linkTitle = "Person Creation", pageTitle="Person Creation")
    public String personCreate(Model model) {
        logger.debug("personController.personView");
        model.addAttribute("message", "");
        model.addAttribute("personModel", new Person());
        return "personCreate";
    }

    @RequestMapping(value = "personCreate", method = RequestMethod.POST)
    @Authorize(permission = "personCreate", action = "create", description = "Create person page", linkGenerate = "false", pageTitle="Person Creation")
    public String personCreatePost(@ModelAttribute("personModel") Person person, Model model) {
        logger.debug("personController.personCreatePost");
        model.addAttribute("message", "Person Created Successfuly");
        //System.out.println("getPersonById.getName : " + getPersonById.getName());
        return "personCreate";
    }

    @RequestMapping(value = "personListEdit", method = RequestMethod.GET)
    @Authorize(permission = "personListEdit", action = "search", description = "View persons Editing page", linkGenerate = "true", linkTitle = "Person(s) Editing", pageTitle="Person(s) Editing")
    public String personListEdit(Model model) {
        logger.debug("personController.personListEdit");
        model.addAttribute("message", "");
        return "personListEdit";
    }    
    
    @RequestMapping(value = "personEdit/{id}", method = RequestMethod.GET)
    @Authorize(permission = "personEdit", action = "edit", description = "Edit person page", linkGenerate = "false", pageTitle="Person Editing")
    public String personEdit(@PathVariable(value = "id") String id, Model model) {
        logger.debug("personController.personEdit");
        model.addAttribute("message", "");
        model.addAttribute("personModel", super.getRestServiceClient().getPersonById(id));
        return "personEdit";
    }

    @RequestMapping(value = "personEdit/{id}", method = RequestMethod.POST)
    @Authorize(permission = "personEdit", action = "edit", description = "Edit person update page", linkGenerate = "false", pageTitle="Person Editing")
    public String personEditPost(@PathVariable(value = "id") String id, @ModelAttribute("personModel") Person person, Model model) {
        logger.debug("personController.personEditPost");
        model.addAttribute("message", "Person Updated Successfuly");
        //System.out.println("getPersonById.getName : " + getPersonById.getName());
        return "personEdit";
    }    

    @ModelAttribute("allPersons")
    public List<Person> allPersons() {
        return super.getRestServiceClient().getAllPersons();
    }

    @ModelAttribute("person")
    public Person person(String id) {
        List<Person> allPersons = super.getRestServiceClient().getAllPersons();
        for (Person person : allPersons) {
            if (person.getId().equals(id)) {
                return person;
            }
        }
        return new Person("", "", "", "", "");
    }    
}

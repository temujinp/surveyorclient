
package surveyor.client.controller;

import surveyor.client.annotation.Authorize;
import surveyor.client.annotation.Home;
import surveyor.client.model.UserModel;
import surveyor.client.service.RestServiceClient;
import j2html.tags.ContainerTag;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Temujin Penlington
 */
@Controller
public abstract class BaseController implements Serializable {
    
    private final Logger logger = LoggerFactory.getLogger(getClass());        
    
    @Autowired
    private RestServiceClient restServiceClient;      
    
    @ModelAttribute("homeLinks")
    public String homeLinks(HttpServletRequest request){
        HttpSession session = request.getSession(false);        
        UserModel userModel = (UserModel) session.getAttribute("userModel");
        restServiceClient.getPermissions();
        
        ContainerTag parent = j2html.TagCreator.div().withClass("ver-nav");
        Reflections reflections = new Reflections(new ConfigurationBuilder()
        .setUrls(ClasspathHelper.forPackage("surveyor.client.controller"))
        .setScanners(new MethodAnnotationsScanner()));
        Set<Method> methods = reflections.getMethodsAnnotatedWith(Home.class);
        for(Method method: methods){
            RequestMapping reqMapping = method.getAnnotation(RequestMapping.class);
            Authorize authorize = method.getAnnotation(Authorize.class);
            if(authorize != null){ 
                System.out.println("PERMISSION : " + userModel.getRole() + " - " + authorize.permission());
                if("true".equals(authorize.linkGenerate()) 
                    && "home".equals(authorize.action())
                    && (restServiceClient.hasRolePermission(userModel.getRole(), authorize.permission()) != null)){
                String[] value = reqMapping.value();
                parent.with(j2html.TagCreator.a().withHref(restServiceClient.getContextPath() + value[0]).withAlt(authorize.linkTitle()).withClass("ver-link").withText(authorize.linkTitle()));
                parent.with(j2html.TagCreator.br());  
                }
            }            
        }
        return parent.render();
    }     
    
    @ModelAttribute("crudLinks")
    public String crudLinks(HttpServletRequest request) {
        HttpSession session = request.getSession(false);        
        UserModel userModel = (UserModel) session.getAttribute("userModel");
        restServiceClient.getPermissions();

        ContainerTag parent = j2html.TagCreator.div().withClass("hor-nav");
        Method[] methods = this.getClass().getMethods();
        for(Method method: methods){
            // get the annotation
            RequestMapping reqMapping = method.getAnnotation(RequestMapping.class);
            Authorize authorize = method.getAnnotation(Authorize.class);
            if(authorize != null 
                    && "true".equals(authorize.linkGenerate())
                    && (restServiceClient.hasRolePermission(userModel.getRole(), authorize.permission()) != null)){
                String[] value = reqMapping.value();
                parent.with(j2html.TagCreator.a().withHref(restServiceClient.getContextPath() + value[0]).withAlt(authorize.linkTitle()).withClass("hor-link").withText(authorize.linkTitle()));
            }
        }
        return parent.render();
    }

    public RestServiceClient getRestServiceClient() {
        return restServiceClient;
    }

    public void setRestServiceClient(RestServiceClient restServiceClient) {
        this.restServiceClient = restServiceClient;
    }
        
}

package surveyor.client.interceptor;

import surveyor.client.annotation.Authorize;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import surveyor.client.model.UserModel;
import surveyor.client.service.RestServiceClient;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Temujin Penlington
 */
public class AuthorizationInterceptor implements HandlerInterceptor {
    
    private final Logger logger = LoggerFactory.getLogger(getClass());        

    @Autowired
    private RestServiceClient restServiceClient;     

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.debug("AuthorizationInterceptor.preHandle");

//        WebApplicationContext ctx = RequestContextUtils.getWebApplicationContext(request); 
//        RestServiceClient clientService = (ApplicationScope) ctx.getBean("clientServiceBean");
//        clientService.populate();
        
        restServiceClient.getPermissions();
        
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Authorize authorize = handlerMethod.getMethod().getAnnotation(Authorize.class);
        HttpSession session = request.getSession(false);
        
        logger.debug("method Name : " + handlerMethod.getMethod().getName());
        logger.debug("class Name : " + handlerMethod.getMethod().getClass().getName());
        
        if (authorize == null) {
            logger.debug("No Authentication needed");
            return true;
        } else {
            logger.debug("Authentication needed");
            request.setAttribute("pageTitle", authorize.pageTitle());
            ModelAndView mav = new ModelAndView("userLogin");
            UserModel userModel;
            if (session != null && session.getAttribute("userModel") != null) {
                logger.debug("Active Session");
                userModel = (UserModel) session.getAttribute("userModel");
                if (restServiceClient.hasRolePermission(userModel.getRole(), authorize.permission()) == null) {
                    logger.debug("No Permission Granted");
                    mav = new ModelAndView("userNoPermission");
                    mav.addObject("userModel", userModel);
                    mav.addObject("message", "You have no permission to access '" + authorize.description() + "'");
                    throw new ModelAndViewDefiningException(mav);
                } else {
                    logger.debug("Permission Granted");
                    return true;
                }
            } else {
                logger.debug("No Session");
                userModel = new UserModel();
                mav.addObject("userModel", userModel);
                mav.addObject("message", "Login to have access to '" + authorize.description() + "'");
                throw new ModelAndViewDefiningException(mav);
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }

    public RestServiceClient getRestServiceClient() {
        return restServiceClient;
    }

    public void setRestServiceClient(RestServiceClient restServiceClient) {
        this.restServiceClient = restServiceClient;
    }
        
}

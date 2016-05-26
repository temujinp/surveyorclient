
package surveyor.client.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SessionAttributeListen implements HttpSessionAttributeListener {
            
    private final Logger logger = LoggerFactory.getLogger(getClass());   
    
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        logger.debug("SessionAttributeListen.attributeAdded : " + event.getValue().getClass().getName());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        logger.debug("SessionAttributeListen.attributeRemoved : " + event.getValue().getClass().getName());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        logger.debug("SessionAttributeListen.attributeReplaced : " + event.getValue().getClass().getName());
    }

}
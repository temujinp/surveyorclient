package surveyor.client.listener;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// The purpose of this was just to understand the framework
public class SessionListen implements HttpSessionListener {
            
    private final Logger logger = LoggerFactory.getLogger(getClass());   
    
    private int sessionCount;

    public SessionListen() {
        this.sessionCount = 0;
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        session.setMaxInactiveInterval(60);
        System.out.println("\n\n");
        for(String str: session.getValueNames()){
            System.out.println("name : " + str);
        }
        synchronized (this) {
            sessionCount++;
        }
        String id = session.getId();
        Date now = new Date();
        String message = new StringBuffer("\n\nDate : ")
                .append(now.toString())
                .append("\nCreate ID : ")
                .append(id)
                .append("\n")
                .append("\nCount : ")
                .append(sessionCount)
                .append(" live sessions in the application.").toString();
        logger.debug(message);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        String id = session.getId();
        synchronized (this) {
            --sessionCount;
        }
        Date now = new Date();
        String message = new StringBuffer("\n\nDate : ")
                .append(now.toString())
                .append("\n\nDestroy ID : ")
                .append(id)
                .append("\n")
                .append("\nCount : ")
                .append(sessionCount)
                .append(" live sessions in the application.").toString();
        logger.debug(message);
    }
}


package surveyor.client.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author Temujin Penlington
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Authorize {
    String permission() default "";// actual permissin name in permission table
    String action() default "";// crudsh (create, read, update, delete, search, home)    
    String description() default "";
    String linkTitle() default "";
    String linkGenerate() default "";
    String pageTitle() default "";
}

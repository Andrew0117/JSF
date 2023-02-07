package jsf2spring.beans;

import jsf2spring.components.Main;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import java.util.Locale;

/**
 * @author Andrey
 */
@ManagedBean(name = "loginBean", eager = true)
@SessionScoped
public class Login {

    private String name;
    private String pass;
    private String l;

    private Main main;

    @PostConstruct
    public void init() {
        WebApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
        main = ctx.getBean(Main.class);
        if (main != null) {
            FacesContext fc = FacesContext.getCurrentInstance();
            l = main.getLocale();
            UIViewRoot viewRoot = fc.getViewRoot();
            if (viewRoot != null) viewRoot.setLocale(new Locale(main.getLocale()));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getLocale() {
        return l;
    }

    public Main getMain() {
        return main;
    }

}

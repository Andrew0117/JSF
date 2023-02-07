package jsf2spring.components;

import jsf2spring.entity.Login;

/**
 * @author Andrey
 */
public class MainImpl implements Main {

    private String locale;
    private Login login;

    @Override
    public String getLocale() {
        return locale;
    }

    @Override
    public void setLocale(String locale) {
        this.locale = locale;
    }

    @Override
    public Login getLogin() {
        return login;
    }

    @Override
    public void setLogin(Login login) {
        this.login = login;
    }

}

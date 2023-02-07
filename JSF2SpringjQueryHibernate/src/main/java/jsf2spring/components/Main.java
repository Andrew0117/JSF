package jsf2spring.components;

import jsf2spring.entity.Login;

/**
 * @author Andrey
 */
public interface Main {

    String getLocale();

    void setLocale(String locale);

    Login getLogin();

    void setLogin(Login login);

}

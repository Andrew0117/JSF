package jsf2spring.dao;

import jsf2spring.components.Main;
import jsf2spring.entity.Login;
import jsf2spring.pojos.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.Serializable;

/**
 * @author Andrey
 */
@Transactional
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class DaoLoad implements Serializable {

    @Autowired
    private Main main;

    @Autowired
    private SessionFactory sessionFactory;

    public boolean load(User user) {

        Session session = sessionFactory.getCurrentSession();
        String sql =
                " SELECT i {u.id}, l {u.login}, p {u.password} " +
                        " FROM vwU where l = '" + user.getU() + "' and SHA1('" + user.getP() + "') = p ";
        Object o = session.createSQLQuery(sql)
                .addEntity("u", Login.class)
                .uniqueResult();
        if (o != null) {
            Login login = (Login) o;
            main.setLogin(login);
            return true;
        } else {
            return false;
        }
    }

}

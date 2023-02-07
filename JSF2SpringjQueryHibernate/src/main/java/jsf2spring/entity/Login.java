package jsf2spring.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Andrey
 */
@Entity
@Table(name = "u",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})}
)

public class Login implements Serializable {
    private static final long serialVersionUID = -4727727495060874309L;

    @Id
    @Column(name = "id", nullable = false, unique = true, length = 11)
    private Long id;

    @Column(name = "login", length = 100, nullable = false, unique = true)
    private String login;

    @Column(name = "password", length = 255, nullable = false)
    private String password;

    public Login() {
    }

    public Login(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Login login1 = (Login) o;

        if (!id.equals(login1.id)) return false;
        if (!login.equals(login1.login)) return false;
        return password.equals(login1.password);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Login{" + "id=" + id + ", login=" + login + ", password=" + password + '}';
    }

}

package jsf2spring.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @author Andrey
 */
@JsonRootName(value = "user")
public class User {

    @JsonProperty(value = "u")
    private String u;

    @JsonProperty(value = "p")
    private String p;

    public String getU() {
        return u;
    }

    public void setU(String u) {
        this.u = u;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

}

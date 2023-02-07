package jsf2spring.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @author Andrey
 */
@JsonRootName(value = "error")
public class Error {

    @JsonProperty(value = "er")
    private String er;

    public String getEr() {
        return er;
    }

    public void setEr(String er) {
        this.er = er;
    }

}

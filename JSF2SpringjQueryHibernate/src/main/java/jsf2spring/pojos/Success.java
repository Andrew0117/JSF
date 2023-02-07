package jsf2spring.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @author Andrey
 */
@JsonRootName(value = "success")
public class Success {

    @JsonProperty(value = "s")
    private String s;

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

}

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jsf2spring.pojos.User;
import org.junit.Test;

import java.sql.SQLException;

/**
 * @author Andrey
 */
public class Json {

    @Test
    public void Json() throws SQLException {
        ObjectMapper mapper = new ObjectMapper();
        String str = null;

        User user = new User();
        user.setU("1");
        user.setP("2");
        try {
            str = mapper.writeValueAsString(user);
            System.out.println(str);
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }

    }

}

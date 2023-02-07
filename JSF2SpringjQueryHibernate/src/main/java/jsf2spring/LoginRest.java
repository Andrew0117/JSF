package jsf2spring;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jsf2spring.components.Main;
import jsf2spring.dao.DaoLoad;
import jsf2spring.pojos.Error;
import jsf2spring.pojos.Success;
import jsf2spring.pojos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;
import java.util.Map;

/**
 * @author Andrey
 */
@RestController
@RequestMapping(value = "/r")
public class LoginRest {

    @Autowired
    private ReloadableResourceBundleMessageSource messageSource;
    @Autowired
    private Main main;
    @Autowired
    private DaoLoad daoLoad;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> setDataUser(
            @RequestHeader Map<String, String> header,
            @RequestBody User user
    ) throws JsonProcessingException {

        header.forEach((key, value) -> {
            System.out.println("entry: " + key + ", " + value);
        });

        ObjectMapper mapper = new ObjectMapper();

        if (!header.get("content-type").contains("application/json")) {
            Error er = new Error();
            er.setEr(messageSource.getMessage("labelUNSUPPORTED_MEDIA_TYPE", null, new Locale(main.getLocale())));
            return new ResponseEntity<>(mapper.writeValueAsString(er), HttpStatus.UNSUPPORTED_MEDIA_TYPE);
        }

        if (!validate(user)) {
            Error er = new Error();
            er.setEr(messageSource.getMessage("labelError", null, new Locale(main.getLocale())));
            return new ResponseEntity<>(mapper.writeValueAsString(er), HttpStatus.FORBIDDEN);
        }

        if (daoLoad.load(user) == true) {
            Success s = new Success();
            s.setS("success");
            return new ResponseEntity<>(mapper.writeValueAsString(s), HttpStatus.OK);
        } else {
            Error er = new Error();
            er.setEr(messageSource.getMessage("labelError", null, new Locale(main.getLocale())));
            return new ResponseEntity<>(mapper.writeValueAsString(er), HttpStatus.FORBIDDEN);
        }
    }

    private boolean validate(User user) {
        if (user == null) {
            return false;
        }
        if (user.getU() == null || user.getU().equals("")) {
            return false;
        }
        if (user.getP() == null || user.getP().equals("")) {
            return false;
        }
        return true;
    }
}

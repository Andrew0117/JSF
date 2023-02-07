package jsf2spring;

import jsf2spring.components.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @author Andrey
 */
@Controller
public class DefaultUrl {

    @Autowired
    private Main main;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String defaultUrl(
            @RequestHeader Map<String, String> header
    ) {

        if (header.get("accept-language") == null || !header.get("accept-language").contains("ru")) {
            main.setLocale("en");
        } else {
            main.setLocale("ru");
        }

        return "redirect:/index.xhtml";
    }
}

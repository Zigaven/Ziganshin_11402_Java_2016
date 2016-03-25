package Task014;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ruslanzigansin on 25.03.16.
 */
@Controller
@RequestMapping("/date")
public class Data {
    @RequestMapping(method = RequestMethod.GET)
    public String datePage(ModelMap model) {
        model.put("time", new java.util.Date());
        return "date";
    }
}

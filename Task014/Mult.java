package Task014;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ruslanzigansin on 25.03.16.
 */
@Controller
@RequestMapping("/mult/{val1}/{val2}")
public class Mult {
    @RequestMapping(method = RequestMethod.GET)
    public String addPage(@PathVariable(value = "val1") int val1, @PathVariable(value = "val2")int val2, ModelMap model) {
        int val3 = val1 * val2;
        model.put("val3", val3);
        return "mult";
    }
}

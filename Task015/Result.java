package Task015;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by ruslanzigansin on 25.03.16.
 */
@Controller
@RequestMapping("/result")
public class Result {
    @RequestMapping(method = RequestMethod.GET)
    public String datePage(ModelMap model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Integer k = (Integer)session.getAttribute("choice");
        model.put("k", k);
        return "result";
    }
}

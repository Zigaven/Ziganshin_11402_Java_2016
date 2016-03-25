package Task015;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by ruslanzigansin on 25.03.16.
 */
@Controller
@RequestMapping("/process")
public class Process {
    @RequestMapping(method = RequestMethod.GET)
    public String processPage(ModelMap model){
        return "process";

    }
    @RequestMapping(method = RequestMethod.POST)
    public String process2Page(ModelMap model, HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession();
        String s = request.getParameter("Choice");
        String text = request.getParameter("text");
        int k = 0;
        if (s.equals("Amount of Characters")) {
            k = text.length();
        }
        else if (s.equals("Amount of Words")) {
            String[] str = text.split(" ");
            k = str.length;
        } else if (s.equals("Amount of Sentences")) {
            String[] st = text.split("[!\\.\\?]");
            k = st.length;
        } else if (s.equals("Amount of Paragraphs")) {
            String[] p = text.split("\\n");
            k = p.length;
        }
        session.setAttribute("choice", k);
        return "redirect:/result";
    }

}

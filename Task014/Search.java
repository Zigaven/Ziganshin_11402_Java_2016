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
@RequestMapping("/{site}/search")
public class Search {
    @RequestMapping(method = RequestMethod.GET)
    public String datePage(@PathVariable(value = "site") String site, ModelMap model) {
        String sth = "";
        if (site.equals("baidu")) {
            sth = "<form action='http://www.baidu.com/s'>\n<input type= 'text' name= 'wd'>\n<input type= 'submit' value= 'Baidu Search'>\n</form>";
        } else if (site.equals("bing")) {
            sth = "<form action= 'https://www.bing.com/search'>\n<input type='text' name='q'>\n<input type=\"submit\" value=\"Bing Search\">\n</form>";
        } else if (site.equals("yahoo")) {
            sth = "<form action='https://search.yahoo.com/search'>\n<input type='text' name='p'>\n<input type=\"submit\" value=\"Yahoo Search\">\n</form>";
        } else if (site.equals("aol")) {
            sth = "<form action='http://search.aol.com/aol/search'>\n<input type='text' name='q'>\n<input type='submit' value='Aol Search'>\n</form>";
        } else
            sth = "OOPS, Page isn't found, error 404";
        model.put("sth", sth);
        return "search";
    }

}

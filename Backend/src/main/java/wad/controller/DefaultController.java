package wad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 *
 * @author Kim Martesuo
 */
@Controller
@RequestMapping("*")
public class DefaultController {
    
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String view() {
        return "lelelele";
    }
}

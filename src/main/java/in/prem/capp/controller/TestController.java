package in.prem.capp.controller;

import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// Below class acts as a Controller
@Controller
public class TestController {
    @RequestMapping("/test/hello")      // Method will be called when url matches with this path. 
    public String helloWorld(){
        return "hello" ; // -> /WEB-INF/view/hello.jsp
    } 
    @RequestMapping("/test/ajax_test")
    public String testPage(){
        return "test" ; 
    }
    
    @RequestMapping("/test/get_time")
    @ResponseBody
    public String getServerTime(){
        System.out.println("-----getServerTime()-------");
        Date d=new Date();
        return d.toString(); 
    }
}

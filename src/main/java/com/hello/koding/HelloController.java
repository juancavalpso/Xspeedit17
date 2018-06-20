package com.hello.koding;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "hello";
    }

    @RequestMapping("/test")
    public String test(){
        return  separa(52364, "") ;
    }

    private static String separa(int n, String r){
        if( n < 10 )
            return r;
        else if ( n/10 >= 1000 && r.equals(""))
            return separa(n, " "+n%10);
        else
            return separa(n/10, " "+(((n/10))%10) + r );
    }
}
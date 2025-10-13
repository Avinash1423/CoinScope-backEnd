package com.crypto.backend;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontendController {

      @RequestMapping(value="/{path:[^\\.]*}")
       public String redirect(){

          return "forward:/index.html";


       }

    @RequestMapping(value="/{path1:[^\\.]*}/{path2:[^\\.]*}")
    public String redirect2(){

        return "forward:/index.html";


    }

}

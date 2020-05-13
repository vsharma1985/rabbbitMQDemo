package com.example.rabbitMQDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/rabbitmq")
public class HelloworldController {
   
   @Autowired
   Publisher publisher;
   @RequestMapping(value="/send/{msg}",method=RequestMethod.GET)
   public String sendMessage(@PathVariable("msg") String msg){
      System.out.println("*****"+msg);
      for(int i =0; i<25;i++){
      publisher.produceMsg(msg);
      }
      return "Successfully Msg Sent";
   }
}


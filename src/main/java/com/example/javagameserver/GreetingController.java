package com.example.javagameserver;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {


    //public function greeting which returns Greeting type and takes HelloMessage as input
    @MessageMapping("/hello") // if a message is sent to the hello endpoint greeting() is called
    // The payload is bound to a Hello Message object passed in to greeting
    @SendTo("/topic/greetings") //We then send it to all subscribers of /topic/greetings
    public Greeting greetings(HelloMessage message) throws Exception {
        Thread.sleep(1000); //Simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
}

package com.Predictify.www.Controller;

import com.Predictify.www.Model.UserBetDTO;
import com.Predictify.www.Service.UserBetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bets")
public class UserBetController {
    UserBetService userBetService;
//    public UserBetController(){}
    public UserBetController(UserBetService userBetService){
        this.userBetService = userBetService;
    }

    @PostMapping("/place")
    public ResponseEntity<?> placeUserBet(@RequestBody UserBetDTO userBetDTO){
        System.out.println("@Controller UserBetDTO = " + userBetDTO);
        return userBetService.placeUserBet(userBetDTO);
    }


}

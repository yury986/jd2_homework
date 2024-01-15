package by.yury.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;


@Controller
public class RegistrationController {


        @PostMapping("/register")


        public ModelAndView getRegResult(
                @RequestParam("first_name") String firstNameReq,
                @RequestParam("last_name") String lastNameReq,
                @RequestParam("username") String usernameReq,
                @RequestParam("password") String passwordReq,
                @RequestParam("address") String addressReq,
                @RequestParam("passport") String passportReq,
                @RequestParam("contact") String contactReq) throws SQLException, ClassNotFoundException {


            if (firstNameReq.isEmpty() || lastNameReq.isEmpty() || usernameReq.isEmpty() ||
                    passwordReq.isEmpty() || addressReq.isEmpty() || passportReq.isEmpty() || contactReq.isEmpty()) {

                ModelAndView modelAndView = new ModelAndView("register");
                return modelAndView;
            }
            return  null;
        }


        @GetMapping("/register")

        public String getSearchPage(){

            return "register";
        }
    }



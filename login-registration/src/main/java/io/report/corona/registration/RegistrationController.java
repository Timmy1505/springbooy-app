package io.report.corona.registration;

import io.report.corona.appuser.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @GetMapping(value = "/form")
    public String registrationForm (Model model){
      model.addAttribute("user", new AppUser());
      return ("registration");
    }

    @PostMapping (value = "/register")
    public String register(RegistrationRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", request);
        return registrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

}

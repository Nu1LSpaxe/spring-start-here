package springboot.controllers;

import springboot.services.LoginCountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springboot.services.LoggedUserManagementService;

@Controller
public class MainController {

    private  final LoggedUserManagementService loggedUserManagementService;
    private  final LoginCountService loginCountService;

    public MainController(
            LoggedUserManagementService loggedUserManagementService,
            LoginCountService loginCountService
    ) {
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
    }

    @RequestMapping("/springboot")
    public String home(
            @RequestParam(required = false) String logout,
            Model model
    ) {
        if (logout != null) {
            loggedUserManagementService.setUsername(null);
        }

        String username = loggedUserManagementService.getUsername();
        int count = loginCountService.getCount();

        if (username == null) {
            return "redirect:/";
        }

        model.addAttribute("username", username);
        model.addAttribute("loginCount", count);

        return "main.html";
    }
}

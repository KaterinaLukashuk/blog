package by.javatrenning.blog.Controller;
import by.javatrenning.blog.data.User;
import by.javatrenning.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userServ;

    @GetMapping("/registration")
    public String registration()
    {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String,Object> model)
    {
       if (!userServ.addUser(user))
        {
            model.put("msg", "user exists");
            return "registration";
        }

        return "redirect:/login";
    }
    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code) {
        boolean isActivated = userServ.activateUser(code);

        if (isActivated) {
            model.addAttribute("msg", "User successfully activated");
        } else {
            model.addAttribute("msg", "Activation code is not found!");
        }

        return "login";
    }

}

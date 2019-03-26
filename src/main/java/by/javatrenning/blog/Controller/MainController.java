package by.javatrenning.blog.Controller;


import by.javatrenning.blog.data.Article;
import by.javatrenning.blog.repos.ArticleRepository;
import by.javatrenning.blog.data.User;
import by.javatrenning.blog.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
    public class MainController {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private ArticleRepository articleRepo;

        @GetMapping("/")
        public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name,
                               Map<String, Object> model) {
            model.put("name", name);
            return "greeting";
        }

        @GetMapping ("/main")
         public String main(Map<String, Object> model)
        {
            Iterable<User> users = userRepo.findAll();
            model.put("users", users);
            return "main";
        }




    @PostMapping("/main")
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
        User user = new User(text, tag);
        userRepo.save(user);
        Iterable<User> users = userRepo.findAll();
        model.put("users", users);
        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<User> users;

//        if (filter != null && !filter.isEmpty()) {
//            //users = userRepo.findByName(filter);
//        } else {
            users = userRepo.findAll();
      //  }
        model.put("messages", users);
        return "main";
    }

    @GetMapping("/userpage")
    public String add(@AuthenticationPrincipal User user,
                      Map<String, Object> model) {
            model.put("user", user);
            Iterable<Article> articles = articleRepo.findByUser(user);
            model.put("usersartcl", articles);
        return "userpage";
    }

    }


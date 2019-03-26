package by.javatrenning.blog.Controller;

import by.javatrenning.blog.data.Article;
import by.javatrenning.blog.data.Comment;
import by.javatrenning.blog.repos.CommentRepository;
import by.javatrenning.blog.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Map;

@Controller
public class CommentController {
    @Autowired
    CommentRepository commentRepo;
    @Autowired
    UserRepository userRepo;


    @PostMapping("newcomment")
    public String addComment(
                      @RequestParam("articleId") Article article,
                      @RequestParam String message,
                      Principal principal,
                      Map<String, Object> model)
    {
        Comment comment = new Comment(message, article, userRepo.findByUsername(principal.getName()));
        commentRepo.save(comment);
        Iterable<Comment> comments = commentRepo.findAll();
        model.put("comments", comments);
        return "/article/" + article.getId();
    }
}

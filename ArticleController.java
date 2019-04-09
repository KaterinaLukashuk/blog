package by.javatrenning.blog.Controller;

import by.javatrenning.blog.data.*;
import by.javatrenning.blog.repos.ArticleRepository;

import by.javatrenning.blog.repos.CommentRepository;
import by.javatrenning.blog.repos.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.Map;

@Controller
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepo;
    @Autowired
    private CommentRepository commentRepo;
    @Autowired
    private TagRepository tagRepo;

    @GetMapping("/page")
    public String articles(Map<String, Object> model) {
        model.put("page", "i hate myself");
        Iterable<Article> articles = articleRepo.findAll();


        model.put("articles", articles);
        return "page";
    }



    @GetMapping("/addarticle")
    public String artcl(Map<String, Object> model) {
        return "addarticle";
    }


    @PostMapping("/addarticle")
    public String add(@AuthenticationPrincipal User user,
                      @RequestParam String title,
                      @RequestParam String text,
                      @RequestParam Status status,
                      Map<String, Object> model) {
        Article article = new Article(title, text, status, user);
        articleRepo.save(article);
        Iterable<Article> articles = articleRepo.findAll();
        model.put("articles", articles);
        return "redirect:/page";
    }

    @RequestMapping(value = "/article/{id}")
    public String showArticle(
            @PathVariable(value = "id") int id,
            Map<String, Object> model) {
        Article article = articleRepo.findById(id);
        model.put("article", article);

        Iterable<Comment> comments = commentRepo.findByArticle(article);
        model.put("articlecomments", comments);
       // Iterable<Tag> tags = tagRepo.findAll();
        Iterable<Tag> tags = tagRepo.findByArticles(article);
        //Iterable<Tag> tags = tagRepo.findByTagId(1);
        model.put("tags", tags);

        return "article";

    }


    @GetMapping("/articleedit/{article}")
    public String articleEditForm(@PathVariable Article article,
                                  //  @PathVariable User user,
                                  Map<String, Object> model) {
        model.put("article", article);
        //  model.put("user", user);
        return "articleedit";
    }

    @PostMapping("savearticle")
    public String saveArticle(
            @RequestParam("articleId") Article article,
            @RequestParam String title,
            @RequestParam String text,
            @RequestParam Status status,
            Map<String, Object> model) {
        article.setTitle(title);
        article.setText(text);
        article.setStatus(status);
        article.setUpdatedAt(new Date());
        articleRepo.save(article);
        return "redirect:/article/" + article.getId();
    }

    @GetMapping("/articledelete/{article}/{user}")
    public String articleDelete(@PathVariable Article article,
                                @PathVariable User user,
                                Map<String, Object> model) {
        articleRepo.delete(article);
        model.put("deletemsg", "Article '" + article.getTitle() + "' deleted");

        model.put("user", user);
        Iterable<Article> articles = articleRepo.findByUser(user);
        model.put("usersartcl", articles);

        return "userpage";
    }

    @RequestMapping("/find")
    public  String find(
            @RequestParam("tag") Tag tag,
            Map<String, Object> model)
    {
        //use for search article by tag
          Iterable<Article> articles = articleRepo.findByTags(tagRepo.findByTagId(1).get(0));
        return "page";
    }
}


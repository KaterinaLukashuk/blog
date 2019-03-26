package by.javatrenning.blog.repos;

import by.javatrenning.blog.data.Article;
import by.javatrenning.blog.data.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticleRepository extends CrudRepository<Article, Integer> {
    Article findById(int id);
    List<Article> findByUser(User user);
}

package by.javatrenning.blog.data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String message;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "article_id")
    Article article;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    User author;
    Date createdAt;

    public Comment() {
    }

    public Comment(String message, Article article, User author) {
        this.message = message;
        this.article = article;
        this.author = author;
        this.createdAt = new Date();
    }

    public Integer getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Article getArticle() {
        return article;
    }

    public User getAuthor() {
        return author;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}

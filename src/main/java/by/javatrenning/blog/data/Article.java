package by.javatrenning.blog.data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "artcl")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String text;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    private Date createdAt;
    private Date updatedAt;
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "article_tag",
            joinColumns = { @JoinColumn(name = "id") },
            inverseJoinColumns = { @JoinColumn(name = "tagId") }
    )
    Set<Tag> tags;

    public Article() {
    }

    public Article(String title, String text, Status status, User user) {
        this.title = title;
        this.text = text;
        this.status = status;
        this.createdAt = new Date();
        this.updatedAt = new Date();
        this.user = user;
    }

    public Status getStatus() {
        return status;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }



    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }


    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }
}

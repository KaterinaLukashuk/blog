package by.javatrenning.blog.data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer tagId;

    String name;

    public Tag(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "tags")
    private Set<Article> articles;

    public Tag() {
    }

    public Integer getTagId() {
        return tagId;
    }

    public String getName() {
        return name;
    }

    public Set<Article> getEmployees() {
        return articles;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployees(Set<Article> employees) {
        this.articles = employees;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tagId=" + tagId +
                ", name='" + name + '\'' +
                ", articles=" + articles +
                '}';
    }
}

package Books;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "Book_List")
public class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;
    private String author;
    private Date publishDate;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
}

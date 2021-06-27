package Books;

import java.util.*;

public class Book {

    private String m_name;
    private String m_description;
    private String m_author;
    private Date m_publishDate;

    public Book(String name, String description, String author, Date publishDate){
        this.m_name = name;
        this.m_description = description;
        this.m_author = author;
        this.m_publishDate = publishDate;
    }

    public String getName() {
        return m_name;
    }

    public String getDescription() {
        return m_description;
    }

    public String getAuthor() {
        return m_author;
    }

    public Date getPublishDate() {
        return m_publishDate;
    }

    public void setName(String name) {
        this.m_name = name;
    }

    public void setDescription(String description) {
        this.m_description = description;
    }

    public void setAuthor(String author) {
        this.m_author = author;
    }

    public void setPublishDate(Date publishDate) {
        this.m_publishDate = publishDate;
    }
}

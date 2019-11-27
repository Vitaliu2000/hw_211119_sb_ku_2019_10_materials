package ru.itvitality.sbrf.cu.library.entities;

import javax.persistence.*;

@Entity
public class BookEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE)
    private Long id;

    //Все кроме id
    public BookEntity(String isbn, String name, String author, Integer deleted) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.deleted = deleted;
    }

    //И пустой
    public BookEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    private String isbn;

    private String name;

    private String author;

    private Integer deleted;

}

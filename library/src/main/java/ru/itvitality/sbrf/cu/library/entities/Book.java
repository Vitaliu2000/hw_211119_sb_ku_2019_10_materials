package ru.itvitality.sbrf.cu.library.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "isbn", nullable = false)
    private String isbn;

    @Column
    private String name;

    @Column
    private String author;

    @Column
    private Integer deleted;

    @OneToMany(targetEntity = Movement.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private List<Movement> movements;

    public Book(Long id, String isbn, String name, String author, Integer deleted) {
        this.id = id;
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.deleted = deleted;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book: " + this.id + ", " + this.isbn + ", " + this.author;
    }

    public Long getId() {
        return id;
    }

    public Book setId( Long id ) {
        this.id = id;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public Book setIsbn( String isbn ) {
        this.isbn = isbn;
        return this;
    }

    public String getName() {
        return name;
    }

    public Book setName( String name ) {
        this.name = name;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Book setAuthor( String author ) {
        this.author = author;
        return this;
    }

    public List<Movement> getMovements() {
        return movements;
    }

    public Book setMovements( List<Movement> movements ) {
        this.movements = movements;
        return this;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public Book setDeleted( Integer deleted ) {
        this.deleted = deleted;
        return this;
    }
}

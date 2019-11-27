package ru.itvitality.sbrf.cu.library.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "librarian")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn()
public class Librarian {

    @OneToMany(targetEntity = Movement.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "name")
    private List<Movement> movements;

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String name;

    public Long getId() {
        return id;
    }

    public Librarian setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Librarian setName(String name) {
        this.name = name;
        return this;
    }
}

package ru.itvitality.sbrf.cu.library.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "movement")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn()
public class Movement {

    @OneToMany(targetEntity = Holder.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@JoinColumn(name = "id")
    private List<Holder> holders;

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String name;

    public Long getId() {
        return id;
    }

    public Movement setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Movement setName(String name) {
        this.name = name;
        return this;
    }
}

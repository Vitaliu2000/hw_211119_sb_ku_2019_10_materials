package ru.itvitality.sbrf.cu.library.entities;

import javax.persistence.*;

@Entity
@DiscriminatorValue("placement")
public class Placement extends Holder {
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String name;

    @Column
    private String descroption;

    public Long getId() {
        return id;
    }

    public Placement setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Placement setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescroption() {
        return descroption;
    }

    public Placement setDescroption( String descroption ) {
        this.descroption = descroption;
        return this;
    }

    /*@OneToOne(targetEntity = Holder.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private List<Holder> holders;*/
}

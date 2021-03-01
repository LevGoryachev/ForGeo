package ru.goryachev.forgeo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "constructions")
public class Construction extends BaseEntity {

    @Column (name = "code_number")
    private String codeNumber;

    @Column (name = "name")
    private String name;

    @Column (name = "description")
    private String description;
}

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

    public Construction() {
    }

    public Construction (String codeNumber, String name, String description) {
        this.codeNumber = codeNumber;
        this.name = name;
        this.description = description;
    }


    public String getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

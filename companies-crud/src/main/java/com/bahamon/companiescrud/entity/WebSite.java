package com.bahamon.companiescrud.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name="web_site")
@Data
public class WebSite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column( columnDefinition = "category" )
    @Enumerated( value=EnumType.STRING )
    private Category category;

    private String description;
}

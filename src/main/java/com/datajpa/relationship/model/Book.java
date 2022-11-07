package com.datajpa.relationship.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(
            name = "book_author",
            joinColumns =@JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name="author_id")
    )
    private List<Author> author=new ArrayList<>();
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    private Category category;
}

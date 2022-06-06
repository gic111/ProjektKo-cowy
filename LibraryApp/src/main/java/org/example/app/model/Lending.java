package org.example.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name = "lending")
public class Lending {

    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    @JoinColumn(name = "user_id")
    private List<User> users = new ArrayList<>();
    @ManyToMany
    @JoinColumn(name = "book_id")
    private List<Book> books = new ArrayList<>();
    private LocalDateTime rent;

    private LocalDateTime returning;

    public Lending() {
    }

    @PrePersist
    public void prePersist() {
        rent = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        returning = LocalDateTime.now();
    }
    public LocalDateTime getRent() {
        return rent;
    }

    public void setRent(LocalDateTime rent) {
        this.rent = rent;
    }

    public LocalDateTime getReturn() {
        return returning;
    }

    public void setReturn(LocalDateTime returning) {
        this.returning = returning;
    }

    private int extensionOfTheDeadline;




}

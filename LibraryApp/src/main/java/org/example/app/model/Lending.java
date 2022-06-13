package org.example.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
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
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    private LocalDate rent;

    private LocalDate returning;

    public Lending() {
    }

    @PrePersist
    public void prePersist() {
        rent = LocalDate.now();
    }

    @PreUpdate
    public void preUpdate() {
        returning = LocalDate.now();
    }
    public LocalDate getRent() {
        return rent;
    }

    public void setRent(LocalDate rent) {
        this.rent = rent;
    }

    public LocalDate getReturn() {
        return returning;
    }

    public void setReturn(LocalDate returning) {
        this.returning = returning;
    }

    private int extensionOfTheDeadline;




}

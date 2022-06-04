package org.example.app.model;

import javax.persistence.*;

@Entity
@Table(name = "penalty")
public class Penalty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;
    private int value;




}

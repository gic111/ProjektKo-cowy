package org.example.app.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    @OneToOne
    @JoinColumn(name = "lending_id")
    private Lending lending;
    private int paymentValue;
    private int penaltyValue;




}

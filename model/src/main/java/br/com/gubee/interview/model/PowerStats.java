package br.com.gubee.interview.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "powerStats")
public class PowerStats {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID id;

    @Column(nullable = false)
    private Short strength;

    @Column(nullable = false)
    private Short agility;

    @Column(nullable = false)
    private Short dexterity;

    @Column(nullable = false)
    private Short intelligence;




}

package com.pushkjn.bored.model;

import java.util.UUID;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "bored")
@NamedQueries({
    @NamedQuery(name = "Activity.getActivitiesIds",
            query = """
                SELECT id FROM Activity 
                WHERE (:category IS NULL OR category = :category) 
                AND (:maxChallenge IS NULL OR challenge <= :maxChallenge) 
                AND (:minChallenge IS NULL OR challenge >= :minChallenge)"""
    )
})
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "activity")
    private String activity;

    @Column(name = "challenge")
    private Integer challenge;

    @Column(name="external_id")
    @Generated(GenerationTime.ALWAYS)
    private UUID external_id;

    @Column(name="category")
    private String category;
}

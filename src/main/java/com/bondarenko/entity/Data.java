package com.bondarenko.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "data")
public class Data {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "data_id_sequence")
    @SequenceGenerator(name = "data_id_sequence", sequenceName = "data_id_sequence")
    private int id;

    @Column(name = "data")
    private String data;

    @Column(name = "updated_time")
    private LocalDateTime updatedTime;
}

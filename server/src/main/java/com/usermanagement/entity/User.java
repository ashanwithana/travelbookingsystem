package com.usermanagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER")
@SequenceGenerator(name = "USER_SEQ_GENERATOR", sequenceName = "ID_SEQ_USER", allocationSize = 1)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ_GENERATOR")
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "DOB")
    private String dob;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "IS_ACTIVE")
    private Boolean active;

    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;

    @Column(name = "UPDATED_DATE")
    private LocalDateTime updatedDate;

}

package com.example.api.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "bugs")
@Data
public class Bug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 65535)
    private String body;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BugStatus status;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User assignedUser;

    @OneToMany(mappedBy = "bug", cascade = CascadeType.ALL)
    private List<Comment> comments;

}

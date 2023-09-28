package com.example.api.model;

import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
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

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Priority priority;

  @Embedded
  private TimeAudit timeAudit = new TimeAudit();

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "assigned_user_id")
  private User assignedUser;

  @OneToMany(mappedBy = "bug", cascade = CascadeType.ALL)
  private List<Comment> comments;
}

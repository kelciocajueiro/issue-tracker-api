package com.example.api.model;

import javax.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "comments")
@Data
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false, length = 65535)
  private String body;

  @Embedded
  private TimeAudit timeAudit = new TimeAudit();

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "bug_id", nullable = false)
  private Bug bug;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;
}

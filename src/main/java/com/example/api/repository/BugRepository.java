package com.example.api.repository;

import com.example.api.model.Bug;
import com.example.api.model.BugStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BugRepository extends JpaRepository<Bug, Long> {

  Page<Bug> findByStatus(BugStatus status, Pageable pageable);
}

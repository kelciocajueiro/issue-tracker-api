package com.example.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class UserAudit {

//    @CreatedBy
//    @Column(name = "created_by", nullable = false, updatable = false)
//    private String createdBy;

//    @LastModifiedBy
//    @Column(name = "last_modified_by")
//    private String modifiedBy;

}

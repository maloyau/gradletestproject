package com.serhii.entity;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

//@MappedSuperclass
//@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditableEntity<U> {
    /*@CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate;
    @CreatedBy
    @Column(name = "created_by_user")
    private U createdBy;
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_date")
    private Date modifiedDate;
    @LastModifiedBy
    @Column(name = "modified_by_user")
    private U modifiedBy;
    @Version
    @Column(name = "version")
    private int version;*/
}

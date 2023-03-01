package com.tanzicai.caimusic.core.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Data
public abstract class BaseEntity {

    @Column(unique = true)
    @Id
    @GeneratedValue(generator = "ksuid")
    @GenericGenerator(name = "ksuid",strategy = "com.tanzicai.caimusic.core.untils.KsuidIdentificationGennerater")
    private String id;


    @CreationTimestamp
    private Date createdTime;


    @UpdateTimestamp
    private Date updatedTime;
}

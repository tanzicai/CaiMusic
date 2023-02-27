package com.tanzicai.caimusic.core.entity;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Role {
    @Id
    @Column(unique = true)
    private String id;

    @Column(unique = true)
    private String name;

    private String title;


    @CreationTimestamp
    private Date created_time;


    @UpdateTimestamp
    private Date updated_time;






}

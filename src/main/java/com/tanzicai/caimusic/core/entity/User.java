package com.tanzicai.caimusic.core.entity;


import com.tanzicai.caimusic.core.enums.Gender;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class User extends BaseEntity{

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles;

    private String username;

    private String ncikname;

    private String password;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Boolean locked;

    private Boolean enable;

    private String last_login_ip;

    private Date lastLoginTime;




}

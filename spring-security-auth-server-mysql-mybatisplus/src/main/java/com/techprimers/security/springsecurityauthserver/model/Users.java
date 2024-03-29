package com.techprimers.security.springsecurityauthserver.model;

import org.hibernate.annotations.GeneratorType;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class Users {
    public Users() {
    }

    Users(Users users) {
        this.active = users.active;
        this.email = users.email;
        this.id = users.id;
        this.realName = users.realName;
        this.name = users.name;
        this.password = users.password;
        this.roles = users.roles;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="user_id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="real_name")
    private String realName;
    @Column(name="active")
    private int active;

    @OneToMany(cascade = CascadeType.ALL,fetch= FetchType.EAGER)
    @JoinTable(name="user_role",joinColumns=
    @JoinColumn(name="user_id"),inverseJoinColumns=
    @JoinColumn(name="role_id"))
    private Set<Role> roles;
    //user_role 表中 user_id,role_id 字段 组成 set 集合

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}

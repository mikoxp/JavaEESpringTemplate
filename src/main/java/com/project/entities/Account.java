/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author moles
 */
@Entity
@Table(name = "account")
@SequenceGenerator(name = "account_seq", sequenceName = "account_id_seq")
public class Account implements Serializable, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "account_seq")
    private int id;

    /**
     *
     */
    public Account() {
    }

    public Account(String login, String password, String name, Group group, Boolean restartedPassword, Boolean enabled) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.group = group;
        this.restartedPassword = restartedPassword;
        this.enabled = enabled;
    }

    @Column(name = "login", length = 64, nullable = false, unique = true)
    private String login;
    @Column(name = "password", length = 64, nullable = false)
    private String password;
    @Column(name = "user_name", length = 64, nullable = false)
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_group")
    private Group group;
    @Column(name = "password_restarted")
    private Boolean restartedPassword;
    @Column(name = "enabled")
    private Boolean enabled;
    @Column(name = "last_log")
    private Date lastLog;

    public Date getLastLog() {
        return lastLog;
    }

    public void setLastLog(Date lastLog) {
        this.lastLog = lastLog;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getRestartedPassword() {
        return restartedPassword;
    }

    public void setRestartedPassword(Boolean restartedPassword) {
        this.restartedPassword = restartedPassword;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;

        Account account = (Account) o;

        if (getId() != account.getId()) return false;
        if (!getLogin().equals(account.getLogin())) return false;
        if (!getPassword().equals(account.getPassword())) return false;
        if (!getName().equals(account.getName())) return false;
        if (!getGroup().equals(account.getGroup())) return false;
        return getRestartedPassword() != null ? getRestartedPassword().equals(account.getRestartedPassword()) : account.getRestartedPassword() == null;

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getLogin().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getGroup().hashCode();
        result = 31 * result + (getRestartedPassword() != null ? getRestartedPassword().hashCode() : 0);
        return result;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        if (getGroup() != null) {
            authorities.addAll(getGroup().getRoles());
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }


}
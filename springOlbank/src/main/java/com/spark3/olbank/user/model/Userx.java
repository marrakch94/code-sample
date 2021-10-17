package com.spark3.olbank.user.model;

import com.spark3.olbank.user.model.Role;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
public class Userx implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "surname", nullable = false)
    private String surname;
    @Column(name = "Email", nullable = false)
    private String email;
    private String adresse;
    private float salary;
    @Column(name = "UserName", unique = true)
    private String userName;
    private String password;
    private Date joinDate;
    private String profileImageUrl;
    private String phoneNumber;
    private String country;
    private String city;
    private String codepost;
    private Boolean enabled;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastPasswordResetDate;

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH})
    @JoinTable(
            name = "USER_ROLE",
            joinColumns = {@JoinColumn(name = "USER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID")})
    private List<Role> roles;

    public Userx() {
    }

    public Userx(Long id, String name, String surname, String email, String adresse, float salary, String userName, String password, String phoneNumber, String country, String city, String codepost, Boolean enabled, Date lastPasswordResetDate, List<Role> roles) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.adresse = adresse;
        this.salary = salary;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.country = country;
        this.city = city;
        this.codepost = codepost;
        this.enabled = true;//enabled;
        this.lastPasswordResetDate = lastPasswordResetDate;
        this.roles = roles;
    }

    public Userx(Long id, String name, String surname, String email, String adresse, float salary, String userName, String password, Date joinDate, String profileImageUrl, String phoneNumber, String country, String city, String codepost, Boolean enabled, Date lastPasswordResetDate, List<Role> roles) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.adresse = adresse;
        this.salary = salary;
        this.userName = userName;
        this.password = password;
        this.joinDate = joinDate;
        this.profileImageUrl = profileImageUrl;
        this.phoneNumber = phoneNumber;
        this.country = country;
        this.city = city;
        this.codepost = codepost;
        this.enabled = enabled;
        this.lastPasswordResetDate = lastPasswordResetDate;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getCodepost() {
        return codepost;
    }

    public void setCodepost(String codepost) {
        this.codepost = codepost;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public void setLastPasswordResetDate(Date lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }
}

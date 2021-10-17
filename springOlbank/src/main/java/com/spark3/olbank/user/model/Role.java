package com.spark3.olbank.user.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME", length = 50, unique = true)
    @NotNull
    @Enumerated(EnumType.STRING)
    private RoleName name;

    @JsonBackReference
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Userx> users;

    public Role() {
    }

    public Role(final RoleName name) {
        this.name = name;
    }

    public Role(RoleName name, List<Userx> users) {
        this.name = name;
        this.users = users;
    }

    public Role(Long id, RoleName name) {
        this.id = id;
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }

    public List<Userx> getUsers() {
        return users;
    }

    public void setUsers(List<Userx> users) {
        this.users = users;
    }

}


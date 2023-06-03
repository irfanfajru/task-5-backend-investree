package com.investree.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name="users")
public class User implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="username", unique=true)
    private String username;

    @JsonIgnore
    @Column(name="password",nullable = false)
    private String password;

    @Column(name="is_active", nullable = false)
    private Boolean isActive;

    //    one to one user detail
    @JsonIgnore
    @OneToOne(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private UserDetail userDetail;

    //    one to many transaksi peminjam
    @JsonIgnore
    @OneToMany(mappedBy = "peminjam",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Transaksi> transaksiPeminjam;

    //    one to many transaksi meminjam
    @JsonIgnore
    @OneToMany(mappedBy = "meminjam", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Transaksi> transaksiMeminjam;

}
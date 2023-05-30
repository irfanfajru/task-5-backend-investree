package com.investree.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name="user")
public class User implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="username", unique=true)
    private String username;

    @Column(name="password",nullable = false)
    private String password;

    @Column(name="is_active", nullable = false)
    private Boolean isActive;

//    one to one user detail
    @OneToOne(mappedBy = "user")
    private UserDetail userDetail;

//    one to many transaksi peminjam
    @OneToMany(mappedBy = "userPeminjam")
    private List<Transaksi> transaksiPeminjam;

//    one to many transaksi meminjam
    @OneToMany(mappedBy = "userMeminjam")
    private List<Transaksi> transaksiMeminjam;

}
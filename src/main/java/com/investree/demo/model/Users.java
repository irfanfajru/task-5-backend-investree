package com.investree.demo.model;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name="users")
public class Users implements Serializable {

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
    @OneToMany(mappedBy = "peminjam")
    private List<Transaksi> transaksiPeminjam;

//    one to many transaksi meminjam
    @OneToMany(mappedBy = "meminjam")
    private List<Transaksi> transaksiMeminjam;

}
package com.investree.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="payment_history")
public class PaymentHistory implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="pembayaran_ke",nullable = false)
    private int pembayaranKe;

    @Column(name="jumlah",nullable = false)
    private Double jumlah;

    @Column(name="bukti_pembayaran",nullable = false)
    private String buktiPembayaran;

//    Many to one Transaksi
    @ManyToOne(targetEntity = Transaksi.class, cascade = CascadeType.ALL)
    private Transaksi transaksi;
}

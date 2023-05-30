package com.investree.demo.repository;

import com.investree.demo.model.Transaksi;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransaksiRepo extends PagingAndSortingRepository<Transaksi,Long> {
    @Query("select c from Transaksi c")
    public List<Transaksi> getList();

    @Query("select c from Transaksi c where c.id = :id")
    public Transaksi getById(@Param("id") Long id);

    @Query("select c from Transaksi c where c.id_peminjam = :id_peminjam")
    public List<Transaksi> getByIdPeminjam(@Param("id_peminjam") Long idPeminjam);

    @Query("select c from Transaksi c where c.id_meminjam = :id_meminjam")
    public List<Transaksi> getByIdMeminjam(@Param("id_meminjam") Long idMeminjam);
}

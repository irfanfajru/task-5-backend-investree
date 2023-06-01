package com.investree.demo.repository;

import com.investree.demo.model.Transaksi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TransaksiRepo extends PagingAndSortingRepository<Transaksi,Long> {
    @Query("select c from Transaksi c")
    public List<Transaksi> getList();

    @Query("select c from Transaksi c where c.id = :id")
    public Transaksi getById(@Param("id") Long id);

    @Query("select c from Transaksi c where c.status like :status")
    public Page<Transaksi> getByStatusLike(String status, Pageable pageable);

    @Query("select c from Transaksi c")
    public Page<Transaksi> getAllData(Pageable pageable);
}

package com.investree.demo.repository;

import com.investree.demo.model.PaymentHistory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaymentHistoryRepo extends PagingAndSortingRepository<PaymentHistory, Long> {
    @Query("select c from PaymentHistory c")
    public List<PaymentHistory> getList();

    @Query("select c from PaymentHistory c where c.id = :id")
    public PaymentHistory getById(@Param("id") Long id);

    @Query("select c from PaymentHistory c where c.id_transaksi = :id_transaksi")
    public List<PaymentHistory> getByIdTransaksi(@Param("id_transaksi") Long idTransaksi);
}

package com.investree.demo.repository;

import com.investree.demo.model.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends PagingAndSortingRepository<Users,Long>{
    @Query("select c from Users c where c.id = :id")
    public Users getById(@Param("id") Long id);

    @Query("select c from Users c where c.username = :username")
    public Users getByUsername(@Param("username") String username);
}

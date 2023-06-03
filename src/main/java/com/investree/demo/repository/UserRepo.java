package com.investree.demo.repository;

import com.investree.demo.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends PagingAndSortingRepository<User,Long>{
    @Query("select c from User c where c.id = :id")
    public User getById(@Param("id") Long id);

    @Query("select c from User c where c.username = :username")
    public User getByUsername(@Param("username") String username);
}
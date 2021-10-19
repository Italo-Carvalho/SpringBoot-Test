package com.backend.api.repository;

import com.backend.api.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {


    @Query("SELECT u FROM User u WHERE u.id > :id") // (:id) vem do parâmetro
    public List<User> findAllMoreThan(@Param("id") Long id);


    //<Parâmetro><Campo><Parâmetro>
    //<findBy><Id><GreaterThan>
    public List<User> findByIdGreaterThan(Long id);

    //<Parâmetro><Campo>
    //<findBy><Name>
    public List<User> findByNameIgnoreCase(String name);
}

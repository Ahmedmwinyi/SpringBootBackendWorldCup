package com.football.footballbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.football.footballbackend.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

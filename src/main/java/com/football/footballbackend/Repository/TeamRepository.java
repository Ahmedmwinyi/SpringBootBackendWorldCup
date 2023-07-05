package com.football.footballbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.football.footballbackend.Model.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

}

package com.football.footballbackend.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.football.footballbackend.Exception.ResourceNotFoundException;
import com.football.footballbackend.Model.Team;
import com.football.footballbackend.Repository.TeamRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/")
public class TeamController {

    @Autowired
    public TeamRepository teamRepository;

    // Get All Teams
    @GetMapping("/teams")
    public List<Team> getallTeams() {
        return teamRepository.findAll();
    }

    // Post Team
    @PostMapping("/teams")
    public Team addTeam(@RequestBody Team team) {
        return teamRepository.save(team);
    }

    // Update Team
    @PutMapping("/teams/{id}")
    public ResponseEntity<Team> updateTeam(@PathVariable Long id, Team teamDetails) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Team with ID " + id + " are not found"));

        team.setName(team.getName());
        team.setTitle(team.getTitle());
        team.setCont(team.getCont());
        team.setCoach(team.getCoach());
        team.setKeyplayer(team.getKeyplayer());

        Team team2 = teamRepository.save(team);
        return ResponseEntity.ok(team2);
    }

    // Get Teams by ID
    @GetMapping("/teams/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable Long id) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Team with ID " + id + " are not found"));

        return ResponseEntity.ok(team);
    }

    // Delete Team by ID
    @DeleteMapping("/teams/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteTeam(@PathVariable Long id) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Team with ID " + id + " are not found"));

        teamRepository.delete(team);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}

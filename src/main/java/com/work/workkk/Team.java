package com.work.workkk;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Entity
public class Team {

    @Id
    @GeneratedValue
    public Integer id;
    public String name;

    @OneToMany(mappedBy = "team")
    public Set<Player> player;

    public Team() {
    }

}

@RestController
class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping("/team")
    public List<Team> getAllTeam() {
        return teamRepository.findAll();
    }
}

interface TeamRepository extends JpaRepository<Team, Integer> {
}
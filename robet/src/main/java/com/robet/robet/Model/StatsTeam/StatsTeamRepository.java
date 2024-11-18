package com.robet.robet.Model.StatsTeam;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StatsTeamRepository extends JpaRepository<StatsTeam, Integer> {
    List<StatsTeam> findBynumeroRodada(int numeroRodada);
}

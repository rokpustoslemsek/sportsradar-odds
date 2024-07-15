package org.rokp.service.impl;

import org.rokp.domain.Match;
import org.rokp.repository.MatchesRepository;
import org.rokp.service.ScoreBoardService;

import java.util.UUID;

public class ScoreBoardServiceImpl implements ScoreBoardService {

    private MatchesRepository repository;

    public ScoreBoardServiceImpl(MatchesRepository repository) {
        this.repository = repository;
    }

    public Match createNewMatch(String homeTeam, String awayTeam) {
        UUID matchId = UUID.randomUUID();
        Match match = new Match(matchId, homeTeam, awayTeam, 0, 0);
        return repository.addOrUpdateMatch(match);
    }

    @Override
    public Match updateMatchScore(UUID matchId, int homeScore, int awayScore) {
        Match matchToUpdate = repository.getMatch(matchId);
        Match match = new Match(matchId, matchToUpdate.homeTeam(), matchToUpdate.awayTeam(), homeScore, awayScore);
        return repository.addOrUpdateMatch(match);
    }
}

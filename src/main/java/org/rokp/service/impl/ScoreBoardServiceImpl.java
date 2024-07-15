package org.rokp.service.impl;

import org.rokp.domain.Match;
import org.rokp.repository.MatchesRepository;
import org.rokp.service.ScoreBoardService;

import java.util.List;
import java.util.UUID;

public class ScoreBoardServiceImpl implements ScoreBoardService {

    private MatchesRepository repository;

    public ScoreBoardServiceImpl(MatchesRepository repository) {
        this.repository = repository;
    }

    public Match createNewMatch(String homeTeam, String awayTeam) {
        UUID matchId = UUID.randomUUID();
        Match match = new Match(matchId, homeTeam, awayTeam, 0, 0);
        // TODO maybe we should check here that a team doesnt have a match in progress.
        return repository.addOrUpdateMatch(match);
    }

    @Override
    public Match updateMatchScore(UUID matchId, int homeScore, int awayScore) {
        Match matchToUpdate = repository.getMatch(matchId);
        //TODO add an edgecase check that match exists.
        Match match = new Match(matchId, matchToUpdate.homeTeam(), matchToUpdate.awayTeam(), homeScore, awayScore, matchToUpdate.startTime());
        return repository.addOrUpdateMatch(match);
    }

    @Override
    public Match finishMatch(UUID matchId) {
        return repository.deleteMatch(matchId);
    }

    @Override
    public List<Match> getMatches() {
        return repository.getMatchesOrderByScoreDescAndStartTimeDesc();
    }
}

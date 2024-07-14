package org.rokp.service.impl;

import org.rokp.domain.Match;
import org.rokp.service.ScoreBoardService;

import java.util.UUID;

public class ScoreBoardServiceImpl implements ScoreBoardService {

    public Match createNewMatch(String homeTeam, String awayTeam) {
        Match match = new Match(UUID.randomUUID(), homeTeam, awayTeam, 0,0);
        return match;
    }

    @Override
    public Match updateMatchScore(UUID matchId, int homeScore, int awayScore) {
        return null;
    }
}

package org.rokp.domain;

import java.util.UUID;

public record Match(UUID matchId, String homeTeam, String awayTeam, int homeScore, int awayScore, long startTime) {

    public Match(UUID matchId, String homeTeam, String awayTeam, int homeScore, int awayScore) {
        this(matchId, homeTeam, awayTeam, homeScore, awayScore, System.currentTimeMillis());
    }

}

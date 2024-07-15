package org.rokp.repository;

import org.rokp.domain.Match;

import java.util.List;
import java.util.UUID;

public interface MatchesRepository {

    Match addOrUpdateMatch(Match match);

    Match getMatch(UUID matchId);

    Match deleteMatch(UUID matchId);

    List<Match> getMatchesOrderByScoreDescAndStartTime();

}

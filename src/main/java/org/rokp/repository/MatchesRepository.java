package org.rokp.repository;

import org.rokp.domain.Match;

import java.util.UUID;

public interface MatchesRepository {

    Match addOrUpdateMatch(Match match);

    Match getMatch(UUID matchId);

}

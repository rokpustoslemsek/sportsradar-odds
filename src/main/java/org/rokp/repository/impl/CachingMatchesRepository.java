package org.rokp.repository.impl;

import org.rokp.domain.Match;
import org.rokp.repository.MatchesRepository;

import java.util.HashMap;
import java.util.UUID;

public class CachingMatchesRepository implements MatchesRepository {

    private static final HashMap<UUID, Match> matches = new HashMap<>();

    @Override
    public Match addOrUpdateMatch(Match match) {
        matches.put(match.matchId(), match);
        return match;
    }

    @Override
    public Match getMatch(UUID matchId) {
        return matches.get(matchId);
    }
}

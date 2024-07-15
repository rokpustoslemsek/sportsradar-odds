package org.rokp.repository.impl;

import org.rokp.domain.Match;
import org.rokp.repository.MatchesRepository;

import java.util.*;
import java.util.stream.Collectors;

public class CachingMatchesRepository implements MatchesRepository {

    private static final Map<UUID, Match> matches = Collections.synchronizedMap(new HashMap<>());

    @Override
    public Match addOrUpdateMatch(Match match) {
        matches.put(match.matchId(), match);
        return match;
    }

    @Override
    public Match getMatch(UUID matchId) {
        return matches.get(matchId);
    }

    @Override
    public Match deleteMatch(UUID matchId) {
        return matches.remove(matchId);
    }

    @Override
    public List<Match> getMatchesOrderByScoreDescAndStartTimeDesc() {
        return matches.values().stream()
                .sorted(
                        Comparator.comparing(Match::totalScore)
                        .thenComparing(Match::startTime).reversed())
                .collect(Collectors.toList());
    }
}

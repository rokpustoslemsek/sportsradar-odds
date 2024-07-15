package org.rokp.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.rokp.domain.Match;
import org.rokp.repository.impl.CachingMatchesRepository;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class MatchesRepositoryTest {

    MatchesRepository matchesRepository = new CachingMatchesRepository();

    @Test
    public void givenMatch_whenAddOrInsertMatch_returnMatch() {
        Match match = new Match(UUID.randomUUID(), "home", "awayTeam", 0,0);

        Match insertedMatch = matchesRepository.addOrUpdateMatch(match);

        assertEquals(match, insertedMatch);
    }

    @Test
    public void givenMatch_whenGetMatch_returnMatch() {
        Match match = new Match(UUID.randomUUID(), "home", "awayTeam", 0,0);
        matchesRepository.addOrUpdateMatch(match);

        Match getMatch = matchesRepository.getMatch(match.matchId());

        assertEquals(match, getMatch);
    }

    @Test
    public void givenNewMatch_whenGetMatch_returnNull() {
        Match match = new Match(UUID.randomUUID(), "home", "awayTeam", 0,0);

        Match getMatch = matchesRepository.getMatch(match.matchId());

        assertNull(getMatch);
    }

    @Test
    public void givenMatch_whenDeleteMatchIsCalled_returnDeletedMatchAndValidateDeletion() {
        Match match = new Match(UUID.randomUUID(), "home", "awayTeam", 0,2);
        matchesRepository.addOrUpdateMatch(match);

        Match matchToDelete = matchesRepository.deleteMatch(match.matchId());

        assertEquals(match, matchToDelete);
        assertNull(matchesRepository.getMatch(match.matchId()));
    }

    @Test
    public void givenMatches_whenGetMatchesInOrder_returnOrderedMatches() {
        Match match1 = new Match(UUID.randomUUID(), "home1", "away1", 0,2);
        Match match2 = new Match(UUID.randomUUID(), "home2", "away2", 0, 3);
        Match match3 = new Match(UUID.randomUUID(), "home3", "away3", 0,2);
        matchesRepository.addOrUpdateMatch(match3);
        matchesRepository.addOrUpdateMatch(match2);
        matchesRepository.addOrUpdateMatch(match1);
        //we really shouldnt be adding matches to storage via public methods since there could be side effects.... todo for later

        List<Match> matches = matchesRepository.getMatchesOrderByScoreDescAndStartTime();

        assertEquals(match1, matches.get(1));
        assertEquals(match2, matches.get(0));
        assertEquals(match3, matches.get(2));
    }
}

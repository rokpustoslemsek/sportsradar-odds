package org.rokp.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.rokp.domain.Match;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MatchesRepositoryTest {

    @Mock
    MatchesRepository matchesRepository;

    @Test
    void givenMatch_whenAddOrInsertMatch_returnMatch() {
        Match match = new Match(UUID.randomUUID(), "home", "awayTeam", 0,0);

        Match insertedMatch = matchesRepository.addOrUpdateMatch(match);

        assertEquals(match, insertedMatch);
    }

    @Test
    void givenMatch_whenGetMatch_returnMatch() {
        Match match = new Match(UUID.randomUUID(), "home", "awayTeam", 0,0);
        matchesRepository.addOrUpdateMatch(match);

        Match getMatch = matchesRepository.getMatch(match.matchId());

        assertEquals(match, getMatch);
    }

    @Test
    void givenNewMatch_whenGetMatch_returnNull() {
        Match match = new Match(UUID.randomUUID(), "home", "awayTeam", 0,0);

        Match getMatch = matchesRepository.getMatch(match.matchId());

        assertNull(getMatch);
    }

}

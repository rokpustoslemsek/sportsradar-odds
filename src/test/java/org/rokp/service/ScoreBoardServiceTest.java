package org.rokp.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.rokp.domain.Match;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class ScoreBoardServiceTest {
    @Mock
    ScoreBoardService scoreBoardService;

    @Test
    public void givenTeams_whenInitializeMatch_returnInitialMatch() {
        //GIVEN

        //WHEN
        Match match = scoreBoardService.createNewMatch("home", "away");

        //THEN
        assertNotNull(match.matchId());
        assertEquals("home", match.homeTeam());
        assertEquals("away", match.awayTeam());
        assertEquals(0, match.homeScore());
        assertEquals(0, match.awayScore());
    }

}
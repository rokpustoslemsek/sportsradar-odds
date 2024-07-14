package org.rokp.service;

import org.junit.jupiter.api.Test;
import org.rokp.domain.Match;
import org.rokp.service.impl.ScoreBoardServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ScoreBoardServiceTest {
    ScoreBoardService scoreBoardService = new ScoreBoardServiceImpl();

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
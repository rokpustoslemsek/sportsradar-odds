package org.rokp.service;

import org.junit.jupiter.api.Test;
import org.rokp.domain.Match;
import org.rokp.service.impl.ScoreBoardServiceImpl;

import java.util.UUID;

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

    @Test
    public void givenNewScore_whenUpdateMatchScore_updatedMatchIsReturned() {
        //GIVEN
        UUID uuid = UUID.randomUUID();
        int homeScore = 0;
        int awayScore = 1;
        //WHEN
        Match match = scoreBoardService.updateMatchScore(uuid, homeScore, awayScore);
        //THEN
        assertEquals(uuid, match.matchId());
        assertEquals(homeScore, match.homeScore());
        assertEquals(awayScore, match.awayScore());
    }

}

package org.rokp.service;

import org.junit.jupiter.api.Test;
import org.rokp.domain.Match;
import org.rokp.repository.impl.CachingMatchesRepository;
import org.rokp.service.impl.ScoreBoardServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreBoardComponentTest {

    ScoreBoardService scoreBoardService = new ScoreBoardServiceImpl(new CachingMatchesRepository());

    @Test
    public void givenMatches_whenGetMatches_returnMatches() throws InterruptedException {
        //GIVEN
        Match match1 = scoreBoardService.createNewMatch("Mexico", "Canada");
        Match match2 = scoreBoardService.createNewMatch("Spain", "Brazil");
        Match match3 = scoreBoardService.createNewMatch("Germany", "France");
        Thread.sleep(2); // make sure the creation time is not the same due to the same totalScore
        Match match4 = scoreBoardService.createNewMatch("Uruguay", "Italy");
        Match match5 = scoreBoardService.createNewMatch("Argentina", "Australia");
        match1 = scoreBoardService.updateMatchScore(match1.matchId(), 0,5);
        match2 = scoreBoardService.updateMatchScore(match2.matchId(), 10, 2);
        match3 = scoreBoardService.updateMatchScore(match3.matchId(), 2,2);
        match4 = scoreBoardService.updateMatchScore(match4.matchId(), 6, 6);
        match5 = scoreBoardService.updateMatchScore(match5.matchId(), 3,1);
        //WHEN
        List<Match> matches = scoreBoardService.getMatches();
        //THEN
        assertEquals(match4, matches.get(0));
        assertEquals(match2, matches.get(1));
        assertEquals(match1, matches.get(2));
        assertEquals(match5, matches.get(3));
        assertEquals(match3, matches.get(4));
    }

}

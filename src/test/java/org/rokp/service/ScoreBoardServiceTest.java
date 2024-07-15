package org.rokp.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.rokp.domain.Match;
import org.rokp.repository.MatchesRepository;
import org.rokp.service.impl.ScoreBoardServiceImpl;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ScoreBoardServiceTest {

    @Mock
    MatchesRepository repository;

    @InjectMocks
    ScoreBoardServiceImpl scoreBoardService;

    @Test
    public void givenTeams_whenInitializeMatch_returnInitialMatch() {
        //GIVEN
        when(repository.addOrUpdateMatch(any(Match.class))).thenAnswer(AdditionalAnswers.returnsFirstArg());
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
        Match matchToUpdate = new Match(uuid, "home", "away", 0,0);
        when(repository.getMatch(uuid)).thenReturn(matchToUpdate);
        when(repository.addOrUpdateMatch(any(Match.class))).thenAnswer(AdditionalAnswers.returnsFirstArg());
        //WHEN
        Match match = scoreBoardService.updateMatchScore(uuid, homeScore, awayScore);
        //THEN
        assertEquals(uuid, match.matchId());
        assertEquals(homeScore, match.homeScore());
        assertEquals(awayScore, match.awayScore());
    }

    @Test
    public void givenMatch_whenFinishMatch_returnFinishedMatch(){
        //GIVEN
        UUID uuid = UUID.randomUUID();
        Match matchToFinish = new Match(uuid, "home", "away", 1,1);
        when(repository.deleteMatch(uuid)).thenReturn(matchToFinish);
        //WHEN
        Match match = scoreBoardService.finishMatch(uuid);
        //THEN
        verify(repository).deleteMatch(uuid);
        assertEquals(matchToFinish, match);
    };

}

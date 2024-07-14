package org.rokp.service;

import org.rokp.domain.Match;

/**
 * Main service interface for scoreboard management. On the scoreboard we can start new and end a match,
 * we can update the score of a match and we can fetch all the matches currently in progress.
 */
public interface ScoreBoardService {

    Match createNewMatch(String homeTeam, String awayTeam);
}

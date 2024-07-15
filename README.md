# sportsradar-odds

## version 1.0.0
### changes
- added jar infra
- added scoreBoard service interface and a match record
- added (failing) test with Mockito + Junit5 to validate setup
### notes
* we assume that the scoreboard as a structure is and will be 1 in size, so we can simplify it to a list of matches.
* therefore we dont even create a structure since we dont have any metadata to keep about the scoreboard.
* java records are used for match structure to promote immutable nature.

## version 1.0.1
- added implemenation for simple creation of new match

## version 1.0.2
- added match score update contract.

## version 1.0.3
- added match score update with persistence for matches.
- supported mocking of the matches repository in the test, since we don't care/know about all potential mocking needs the first time we write a test.

## version 1.0.4
- added implementation for persisting matches into a hashmap

## version 1.0.5
- added contract to finish match and added tests

## version 1.0.6
- implemented finishing of the match, i.e. removal from the scoreboard

## version 1.0.7
- added contract and tests for getting all matches

## version 1.0.8
- added implementation for getting all matches
- added component test for getting all matches
- marked in the code, where the edge cases should be further addressed

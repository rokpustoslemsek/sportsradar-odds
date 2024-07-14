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

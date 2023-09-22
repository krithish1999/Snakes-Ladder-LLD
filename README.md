# Snakes-Ladder-LLD
low-level design for Snakes and Ladders Game

We divide this project into two halves:
   a. One of them being the models: Players, Snakes, Ladders, BoardGame.
   b. Other being services: It is responsible for the actual logic of the game. 

Points that I've taken into consideration:
1. The board size could change depending on the - user input size.
2. Only one dice has been put into play. (*Can change the logic within the code to incorporate more dice.)
3. As soon as a player wins, the game ends. (*Can change the logic until only one player is left)
4. Also, make sure that the ladder & snake do not end in an infinite loop - the coordinates for them must be considered when building the game.
5. Can modify the number of users, the snakes - start and end positions, and the ladders - start and end position in Main.java

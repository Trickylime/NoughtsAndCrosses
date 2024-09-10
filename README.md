# Noughts and Crosses Game (Tic-Tac-Toe)

Description

This is a command-line version of the classic Noughts and Crosses (Tic-Tac-Toe) game, developed in Java. Two players take turns placing their symbols (X or O) on a 3x3 grid. The first player to align three of their symbols either horizontally, vertically, or diagonally wins the game. The game can be played multiple times, with a score tally tracked for both players.

Features

    Two-player mode (enter names for players).
    Automatic random selection of the player who goes first.
    Players can choose between "X" or "O".
    Win detection (horizontal, vertical, and diagonal checks).
    Draw detection if the grid is fully filled without any winner.
    Option to play multiple rounds with a running score displayed after each game.
    Clear and user-friendly command-line interface.

How to Play

    Enter player names: At the start of the game, both players will be prompted to enter their names.
    Choose symbol: A player will be randomly selected to choose between "X" or "O".
    Take turns: Players will alternate turns, placing their symbol (X or O) by selecting a grid position (1-9) corresponding to the available spaces.
    Win or Draw: The game ends when a player aligns three symbols in a row, column, or diagonal. If all spaces are filled and no player wins, the game                                   ends in a draw.
    Play again or quit: After each game, players can choose to play again or quit. The score is displayed after every round.

Installation

Prerequisites

    Java Development Kit (JDK) version 8 or higher.

Setup

Clone the repository:

    git clone https://github.com/Trickylime/NoughtsAndCrosses

Navigate to the project directory:

    cd noughts-and-crosses-java

Compile the game:

    javac NoughtsAndCrossesApplication.java

Run the game:

    java NoughtsAndCrossesApplication

Gameplay Example

------------------------------
Please Enter Player One's name
John
Please Enter Player Two's name
Jane
------------------------------
Jane please select if you want X's or O's
X
------------------------------
       Player 1        Player 2
      John - O's      Jane - X's
         _1_|_2_|_3_
         _4_|_5_|_6_
          7 | 8 | 9 
------------------------------
It's Jane's turn! Please enter a number of where you'd like to make your move:
2
Jane has chosen 2
------------------------------
       Player 1        Player 2
      John - O's      Jane - X's
         _1_|_X_|_3_
         _4_|_5_|_6_
          7 | 8 | 9 
------------------------------
It's John's turn! Please enter a number of where you'd like to make your move:
5
John has chosen 5
------------------------------
       Player 1        Player 2
      John - O's      Jane - X's
         _1_|_X_|_3_
         _4_|_O_|_6_
          7 | 8 | 9 
------------------------------

Game Flow

    Start: Players are prompted for their names.
    Random Player Selection: A random player is selected to choose whether they want to play with "X" or "O".
    Grid: The game displays a 3x3 grid with numbers representing available positions.
    Player Input: Players take turns entering numbers to make their moves.
    Winner Check: Each turn after 5 turns, the game checks for a winner. If no winner is found and all spaces are filled, the game ends in a draw.
    End Game: The game displays the result and the current score tally. Players can then choose to play again or quit.

Score System

    After each game, the winner's score is incremented by 1.
    A draw does not increment any score.
    The current score for each player is displayed at the end of each game.

Example End-Game Scoreboard

    Congratulations! Jane is the winner!

    The Score is
    John - 0
    Jane - 1
    Would you like to play again? (y/n)

License

    This project is licensed under the MIT License.

Author

    Developed by Trickylime (Jack).

Acknowledgments

    Inspired by the classic Noughts and Crosses (Tic-Tac-Toe) game.
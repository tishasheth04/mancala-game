Project Title - Mancala Game
The main purpose of this code is to play the game mancala game.
Simple overview of use/purpose.

Description
This function has 6 classes that hold different methods that help play the game for the user. They use encapsulation that help achieve a final product that is playable and runnable for the user. THe first class, the Player class, holds all methods in relation to the player itself. The pit class holds all methods related to the pits and stones in the pits. The third class, the Store class, holds all methods in relation to the Store. For instnace, the number of stones in a player's store, or setting the owner of the store etc. The board class is now non existent. It has been broken into two different rule classes, Kalah and Ayo. Both thee classes use functions to implement two different game rules. Finally, the MancalaGame class holds all the methods that call other methods from the previous classes. This basically allows us to call all methods from the MancalaGame class in our TextUI as the MancalaGame class calls vairous different methods from different classes. The TextUI is the runner in which there are multiple methods and where the game is played. Methods from all different classes are called to ensure that the game runs smoothly. Finally, there are also some exception classes whose main job is to handle various different expcetions created. These exceptions include InvalidMove, PitNotFound, GameNotOver etc. This ensures that if the user enters invalid input or does something that is not correct, then exceptions are thrown to let the user know. This game also has a GUI that can let poeple use play testing. 

Getting Started

Dependencies

You will need the GP4 cloned to run the code, along with a code editor that can easily run java code. I believe no specific versions are needed. You will also need gradle to effectively compile and run the code.
Describe any prerequisites, libraries, OS version, etc., needed before installing and running your program.


Executing program

First type in "gradle build"
Next you will need your terminal to run the GUI.
Paste the line and press enter. This should easily run the code.


use code blocks for commands



Expected Output:

The expected output is different for each case as this is a game. It is a GUI so the expected output is a GUI that changes with each button pressed.

Limitations
What isn't done? What things cause errors?
As of right now, my code does everything that is asked from the assignment guidelines. However, my GUI is partially done. 

Author Information
Name: Tisha Sheth
Email: tsheth@ugoeulph.ca
Student Number: 1214407
Your name and contact information including your email address

Development History

19th October, 2023 - Finished Pit class,started board class,completed other methods, finished all functions in Pit,Store,Player.
19th November, 2023 - Finished refactoring, finished Kalah
21st November, 2023 - Finished Ayo
24th November, 2023 - Started GUi, implemented some things
24th November, 2023 - Fixed my code so it runs with the test cases
26th November, 2023 - Finished everything to the best of my abilities
October 30th, 2023 - Finished TextUI

Keep a log of what things you accomplish when.  You can use git's tagging feature to tag the versions or you can reference commits.

0.2

Various bug fixes and optimizations
See commit change or See release history



0.1

Initial Release




Acknowledgments
Inspiration, code snippets, etc.

awesome-readme
[simple-readme] (https://gist.githubusercontent.com/DomPizzie/7a5ff55ffa9081f2de27c315f5018afc/raw/d59043abbb123089ad6602aba571121b71d91d7f/README-Template.md)
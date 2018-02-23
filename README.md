# cs310-tic-tac-toe
CS310 Software Engineering I
Java Code
This project was meant to give additional experience in Gradle build system and the software testing tools along with more coding 
experience. There are two parts to this project part 1A and 1B. Part one of the project we were tasked with forking the project to our
GitHub account and then cloning the GitHub repository from the main build ttps://github.com/jsnellen/cs310-tic-tac-toe to our own work 
stations. Once these steps are complete you will have a working repository in your GitHub account. This allowed us the ability to work
in different areas and push the work to the GitHub repository. In part one of the project you are given 4 files TicTacToe.java, 
TicTacToeModel.java, TicTacToeView.java, and TicTacToeController.java. If searching in the GitHub account the path to these files 
are src/main/java/edu/jsu/mcis.  The first version of this program will use the console for the input and output. The design pattern 
used where the board is the Model, the terminal window is the View, and the Controller receives and processes keyboard input.
When the game is finished, the output is expected to match the following example.

  012

0 ---
1 ---
2 ---

Player 1 (X) Move:
Enter the row and column numbers, separated by a space: 1 1


  012

0 ---
1 -X-
2 ---

Player 2 (O) Move:
Enter the row and column numbers, separated by a space: 0 1


  012

0 -O-
1 -X-
2 ---

Player 1 (X) Move:
Enter the row and column numbers, separated by a space: 0 0


  012

0 XO-
1 -X-
2 ---

Player 2 (O) Move:
Enter the row and column numbers, separated by a space: 1 2


  012

0 XO-
1 -XO
2 ---

Player 1 (X) Move:
Enter the row and column numbers, separated by a space: 2 2


  012

0 XO-
1 -XO
2 --X

X!

This requires going into the skeleton code in TicTacToeModel.java to implement the layout of the design. Here you are required 
initialize the grid by filling every square with empty marks and placing the current players mark in the specified location, but 
only if that location is valid. Once these are completed you will move on to checking if the game is over and who the winner is.
From here you will need to go to the TicTacToeController.java file. This is where you will be required to write a code that is able 
to receive and validate inputs by making a mark if the input is valid or throwing an error if it is not. Once this is done you are 
only left with completing the TicTacToeView.java file. You must now create a for loop that prints the board to the console along with 
displaying and Prompting the Players next move. Now that it is finished and you have run a successful build, the assignment must be 
pushed back to the GitHub repository.
Project 1B (Part Two)
After completing Part One the first part will expand the implementation of Tic-tac-toe into a GUI version using the Java Swing element. 
Here you will be required to delete the TicTacToeViewTest.java and implement a new file in its place called TicTacToeGuiTest.robot. 
File content supplied.

*** Settings ***
Library          SwingLibrary

*** Keywords ***
Start New Game
    Start Application   edu.jsu.mcis.TicTacToe
    Select Window       Tic-Tac-Toe

Mark Location   [Arguments]     ${row}      ${col}
    ${component}=   Catenate    SEPARATOR=  Square    ${row}  ${col}
    Click On Component  ${component}

Check Location  [Arguments]     ${row}  ${col}  ${mark}
    ${component}=   Catenate    SEPARATOR=  Square    ${row}  ${col}
	${text}=    Get Button Text   ${component}
    Should Be Equal    ${text}    ${mark}
    
Winner Should Be    [Arguments]     ${winner}
	${text}=    Get Label Content    ResultLabel
    Should Be Equal    ${text}    ${winner}
    Close Window    Tic-Tac-Toe
    
*** Test Cases ***
Win Diagonally as X
    Start New Game
    Mark Location       1   1
    Check Location      1   1   X
    Mark Location       0   1
    Check Location      0   1   O
    Mark Location       0   0
    Check Location      0   0   X
    Mark Location       0   2
    Check Location      0   2   O
    Mark Location       2   2
    Check Location      2   2   X
    Winner Should Be    X

Win Horizontally as O
    Start New Game
    Mark Location       1   1
    Check Location      1   1   X
    Mark Location       2   0
    Check Location      2   0   O
    Mark Location       0   0
    Check Location      0   0   X
    Mark Location       2   2
    Check Location      2   2   O
    Mark Location       0   2
    Check Location      0   2   X
    Mark Location       2   1
    Check Location      2   1   O
    Winner Should Be    O

Force a Tie
    Start New Game
    Mark Location       1   1
    Check Location      1   1   X
    Mark Location       0   0
    Check Location      0   0   O
    Mark Location       2   0
    Check Location      2   0   X
    Mark Location       0   2
    Check Location      0   2   O
    Mark Location       0   1
    Check Location      0   1   X
    Mark Location       2   1
    Check Location      2   1   O
    Mark Location       1   2
    Check Location      1   2   X
    Mark Location       1   0
    Check Location      1   0   O
    Mark Location       2   2
    Check Location      2   2   X
    Winner Should Be    TIE

    This new file will change the testing parameters from the previous project. You will be able to keep the model-view-contoller
    pattern the same and not make any changes to the Model file. However, to implement the GUI, your new View should extend the JPanel 
    class and implement the ActionListner interface. To keep it simple you will combine the functions of the View and Controller into a 
    combines View class. This will take actionPerformed() method of View that handles the button clicks and makes it act as the new 
    controller. In the JPanel, the squares of the board should be implemented as two-dimensional array of JButton objects with a 
    preferred size of 64 X 64 (see line 34 in View). It is also necessary to create a JLabel called “ResultLabel” to display the
    winner of the game. The reason for creating these names is so that the GUI tester can call them by name when checking the build. 
    Once the build is tested and passes, it is required to push the final code back to GitHub.
    

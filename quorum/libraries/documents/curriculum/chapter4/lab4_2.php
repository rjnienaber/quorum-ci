<?php include("../../include/header.php"); ?>
<script type="text/javascript">
    document.title = 'Lab 4_2';
</script>

<h1>Lab 4.2: Rock Paper Scissors</h1>
<h2>Objectives</h2>
<p>
The goal of this lab is to understand the following concepts:
</p>
<ul>
<li>Actions without parameters and return types</li>
<li>Ability to read and understand requirements to write basic actions</li>
</ul>
<h2>Overview</h2>
<p>
In this lab, we will be writing a Rock Paper Scissors game. In this game a human player will be competing with the computer.  The human player will choose rock, paper, or scissors and then the computer will randomly select one of the options. Then our program will tell the player who won the round. The use of actions will allow us to organize the game and make the program look organized.
</p>
<h2>Task 1: Getting Started</h2>
<p>
Start Sodbeans.  Create a new &quot;Quorum Application&quot; project, and name it <b>RockPaperScissors</b>. As in the previous labs, this will leave us with a skeleton <tt>Main.quorum</tt> file, containing a <tt>Main</tt> class and <tt>Main</tt> action. After our project is created, we can use the following code skeleton(replace the code in your project with the following code):
</p>
<p><pre class="code""><code>
use Libraries.Compute.Random
class Main
    /* Action Main has no parameters or return value.
       This is where the program begins executing. Within this method we should
       give the instructions to the user and then play the game.
    */
    action Main
    end
    
    /* Action GiveInstructions has no parameters or return value.
        It handles giving all game rules and instructions to the user before
        the game begins.
    */
    action GiveInstructions
    end
    
    /* Action PlayGame has no parameters or return value.
       It handles anything involving playing the game. This includes asking the player
       for their choice, generating the computers choice, determining the winner,
       and determining if the player wishes to quit the game or continue playing.
    */
    action PlayGame
    end
    
    /* Action PlayersTurn has no parameters and returns an integer value.
       This action handles asking the user for their choice of rock, paper, or
       scissors. It also checks the input for errors. Then it returns the valid
       user choice.
    */
    action PlayersTurn returns integer
       integer choice = 1
       //your code goes here
       return choice
    end
    
    /* Action ComputersTurn has no parameters and returns an integer value.
       This action handles randomly generating the computers choice. Then it
       returns that value.
    */
    action ComputersTurn returns integer
       integer choice = 1
       //your code goes here
       return choice
    end
    
    /* Action DetermineWinner has two parameters and no return value. The first
       parameter is the players choice and the second is the computers choice.
       This action handles determining the winner of a round in the game. It
       also says who won the round
    */
    action DetermineWinner(integer playerChoice, integer computerChoice)
    end
end
</code></pre></p>
<p>
We will start by writing the <tt>GiveInstructions</tt> action. In this action we should say or print the rules and instructions for the rock, paper, scissors game. That message might be something like the following:
</p>
<p><pre class="code"><code>
Welcome to the Rock Paper Scissors game!
Here are the rules:
The player and the computer will pick rock, paper, or scissors.
Paper beats rock.
Rock beats scissors.
Scissors beat paper.
Enter a 1 for rock, a 2 for paper, or a 3 for scissors.
</code></pre></p>
<p>
Once the <tt>GiveInstructions</tt> action is written, call the action in the <tt>Main</tt> action. Remember <tt>Main</tt> is where our program begins executing or running and the <tt>end</tt> following the <tt>Main</tt> action is where it ends. Run the program and it should give the instructions you wrote in the <tt>GiveInstructions</tt> action.
</p>
<h2>Task 2: Create A Game with Actions</h2>
<p>
We are going to create a game with actions.  We will separate each action so that they serve their own purpose. The first of these actions will be the <tt>PlayersTurn</tt> action. This action should ask the user to choose rock, paper, or scissors and it should continue to ask the user this until a valid input is given.
</p>
<p>
Go to the <tt>PlayersTurn</tt> action. Within that action start writing code at the comment that says "your code goes here". We will need our code to do the following:
</p>
<ul><li>Declare a boolean and initialize it to false to track valid input.
</li><li>Create a loop that loops until the input is valid.
</li><li>Within that loop, ask the user to choose rock, paper, or scissors.
</li><li>Cast the input from the user to an integer and store it in the <strong>choice</strong> variable(has already been declared in this action).
</li><li>Check if the input is valid; if it is valid the loop should stop.
</li></ul><p>
The existing code then returns the user's choice from the action, <tt>return choice</tt>, is already written into the action. Don't worry about calling and testing this action right now. We will come back to this when we write the <tt>PlayGame</tt> action. Instead move onto writing the <tt>ComputersTurn</tt> action.
</p>
<p>
Go to the <tt>ComputersTurn</tt> action. Within that action start writing code at the comment that says "your code goes here". We will need our code to do the following:
</p>
<ul><li>Declare a Random object. e.g. <tt>Random random</tt>.
</li><li>Generate a random integer between 1 and 3, including 1 and 3.
</li><li>Assign the random integer to the <tt>choice</tt> variable.
</li></ul><p>
The computers choice is then returned(the code for this is already included). 
</p>
<p>
The next action we are going to write is the <tt>DetermineWinner</tt> action. This action has two parameters playerChoice and computerChoice. For this to be a general solution we won't worry about the value of each parameter; those are determined when we call the <tt>DetermineWinner</tt> action. In this action we want to use conditional statements to determine if there is a tie, if the computer won, or if the player won. 
</p>
<p>
To start writing this action we can use the following code:
</p>
<p><pre class="code"><code>
if playerChoice = computerChoice then
   say &quot;It's a tie!&quot;
end
</code></pre></p>
<p>
Add onto this conditional so that, if:
</p>
<ul><li>Player chooses rock and computer chooses paper the output is, "Paper beats rock - the computer wins!"
</li><li>Player chooses rock and computer chooses scissors the output is, "Rock beats scissors - you win!"
</li><li>Player chooses paper and computer chooses rock the output is, "Paper beats rock - you win!"
</li><li>Player chooses paper and computer chooses scissors the output is, "Scissors beats paper - the computer wins!"
</li><li>Player chooses scissors and computer chooses paper the output is, "Scissors beats paper - you win!"
</li><li>Player chooses scissors and computer chooses rock the output is, "Rock beat scissors - the computer wins!"
</li></ul><p>
The next action we will write is the <tt>PlayGame</tt> action. This action handles all of the game play, including, getting the players choice, randomly generating the computers choice, determining a winner of the round, and asking the player if they want to continue playing or stop the game.
</p>
<p>
In this action, start by defining a text variable called <strong>playAgain</strong> and initialize it to "Y". Create a loop that will continue to loop when <strong>playAgain</strong> is equal to "Y" or "y". Inside this loop we need to call the <tt>PlayersTurn</tt> action and store the returned value in a variable named <strong>player</strong> with a type of integer. Then do the same with the <tt>ComputersTurn</tt> action. Store the returned value in a variable named <strong>computer</strong> with a type of integer. Call <tt>DetermineWinner</tt> passing the arguments <strong>player</strong> and <strong>computer</strong>. Finally, ask the user, "Would you like to play again (Y/N)?", and assign the result to the <strong>playAgain</strong> variable.
</p>
<p>
When we are done the <tt>PlayGame</tt> action should look like the following code:
</p>
<p><pre class="code"><code>
    action PlayGame
        text playAgain = &quot;Y&quot;
        repeat while playAgain = &quot;Y&quot; or playAgain = &quot;y&quot;
            integer player = PlayersTurn()
            integer computer = ComputersTurn()
            DetermineWinner(player, computer)
            playAgain = input(&quot;Would you like to play again (Y/N)?&quot;)
        end
    end
</code></pre></p>
<p>
The final step is to finish writing the <tt>Main</tt> action. The <tt>Main</tt> action should give the instructions, play the game, and say "Game over" when the game is done. 
</p>
<p>
The following is sample output from the game (The input dialogs are indicated as [Input Dialog]):
</p>
<p><pre class="code"><code>
Welcome to the Rock Paper Scissors game!
Here are the rules:
The player and the computer will pick rock, paper, or scissors.
Paper beats rock.
Rock beats scissors.
Scissors beat paper.
Enter a 1 for rock, a 2 for paper, or a 3 for scissors.
[Input Dialog] Rock (1), Paper (2), or Scissors (3)? 4
Error: The value needs to be between 1 and 3. Please try again. You entered 4
[Input Dialog] Rock (1), Paper (2), or Scissors (3)? 1
Rock beats scissors - you win!
[Input Dialog] Would you like to play again (Y/N)? Y
[Input Dialog] Rock (1), Paper (2), or Scissors (3)? 1
Paper beats rock - the computer wins!
[Input Dialog] Would you like to play again (Y/N)? y
[Input Dialog] Rock (1), Paper (2), or Scissors (3)? 3
It's a tie!
[Input Dialog] Would you like to play again (Y/N)? N
Game over
</code></pre></p>
<p>
Debug your program and fix any compiler errors there might be. Now would be a great time to use the debugger to test our program. When an action is called use step into to see what happens when a particular action is called. Did your program run correctly? If not, fix any problems. Show the work to the instructor.
</p>
<?php include("../../include/footer.php"); ?>
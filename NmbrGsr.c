#include<stdio.h>
#include<stdlib.h>
#include<ncurses.h>


// consts for array
const int SIZE = 7;
const int ELEMENTS = 3;

// data for the menu
int cursorPos = 0;


// data for the actual guess
int CLow = 0;
int CHigh = 999;
int guess = 0;
int intial = 0;
int isFound = 0;
int attempts = 0;

// the array elements
char option1[SIZE] = " Higher";
char option2[SIZE] = " Lower ";
char option3[SIZE] = " Found ";

// string array pointer
char* options[ELEMENTS] = {option1, option2, option3};

// Leftover from style change but used to determine user choice
char response = ' ';

/*
*  Function that prints the options put into the
*  options string array
*
*  Parameters: None
*  Return: None
*/
void printOptions(){
    // loop for as many elements
    for (int i = 0; i < ELEMENTS; i++){
        // get the string pointer from the array
        char *optionCore = options[i];
        
        // loop for every chacter in the string
        for (int j = 0; j < SIZE; j++){
            char let = optionCore[j];
            printw("%c", let);
        }
        // separator
        printw("\t");
    }
    printw("\n");
}

/*
*  Function that puts a '#' literal in front of the currently selected
*  option
*
*  Parameters: indx: an index of the position of the current option
*  Return: None
*/
void highlight(int indx){
    // do nothing if the index is out of range
    if (indx >= ELEMENTS || indx < 0){}
    
    else{
        // get the first character from the string in the array and:
        // clear all of the first characters
        for (int i = 0; i < ELEMENTS; i++){
            char *item = options[i];
            
            item[0] = ' ';
        }
        // put the '#' literal in the right option
        char *selected = options[indx];
        selected[0] = '#';
    }
    
}

/*
*  Function that generates a random guess based on the highest and 
*  Lowest known bounderies
*
*  Parameters: None
*  Return: None
*/
int generateRandom(){
    // generate initial random number
    int num = rand() % CHigh;
    
    // make sure that it's bigger than the our current lowest guess
    while (num < CLow){
        num = rand() % CHigh;
    }
    
    // return the number
    return num;
}


/*
*  Function that makes appropriate the changes to the appropriate variables
*  Containing the highest and lowest possible numbers.
*
*  Parameters: None
*  Return: None
*/
void react(int state){
    // where the cursor is
    if (state == 0){
        // update the lowest bounderies
        CLow = guess;
        // generate a new guess
        guess = generateRandom();
        // increase attempt count
        attempts++;
    }
    else if (state == 1){
        // update the highest bounderies
        CHigh = guess;
        // generate a new guess
        guess = generateRandom();
        // increase attempt count
        attempts++;
    }
    else if (state == 2){
        // break out of the loop
        isFound = 1;
    }
    
}

int main(){
    // start the screen
    initscr();
    // make an absolutely random guess
    guess = generateRandom();
    
    // clear the screen to begin showing the information and controlls
        printw("--------------------------------------\n\t   Number Guesser\n--------------------------------------\n");
        printw("\n    CONTROLS:\n    - A and D: Move left and right\n    - Return: Confirm\n\n    Press Any Button to Continue");
        getch();
    
    // begin the guessing process
    while (isFound == 0){
        
        // VISUAL STUFF FROM HERE
        clear();
        printw("--------------------------------------\n\t   Number Guesser\n--------------------------------------\n");
        printw("      Is this your number? %d\n\n\t", guess);
        // TO HERE
        
        // put the cursor at the position
        highlight(cursorPos);
        // print the options with the cursor at the right place
        printOptions();
        // get user input
        response = getch();
        
        // check for controls
        if (response == 'd'){
            cursorPos++;
        }
        
        if (response == 'a'){
            cursorPos--;
        }
        
        if (response == '\n'){
            react(cursorPos);
        }
        
        // checks to make sure that user doesn't go out of bounds
        if (cursorPos > 2){cursorPos = 2;}
        else if (cursorPos < 0){cursorPos = 0;}
    }
    
    // print the number of attempts 
    printw("\n   Number was found in %d attempts!\n", attempts);
    getch();
    
    // exit
    endwin();
    return 0;
}


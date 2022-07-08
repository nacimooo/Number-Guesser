# Number-Guesser
A program that guesses at number between 0 and 999

# Why Make This:
I was inspired to make this during a lab in class, and I kinda wanted to practice making a user interface in java, but then it ballooned into two independent versions.

# Two Versions:
There are two versions of this program, a version with a window based GUI and one with a Terminal based "GUI".

![Number Guesser Java Screenshot](https://user-images.githubusercontent.com/105907112/178074221-4c79b812-79ca-413f-818f-82d7ae2c4cf7.png)


![Number Guesser C Screenshot Controls](https://user-images.githubusercontent.com/105907112/178074241-02d70aab-0249-47fa-9e04-f93b5ae2e7af.png)
![Number Guesser C Screenshot Prog](https://user-images.githubusercontent.com/105907112/178074252-3f03544b-0812-4fe1-b826-22abf11dc36f.png)


# The Java Version
This is the reason I decided to make this program, I wanted a way to practice designing a GUI with proper arrangements in JAVA, and this was the result

# The C Version
I got frustrated by how boilerplate JAVA was and decided to make the same thing in C, but GTK doesn't work on Mac, and I cannot use the Windows libraries to do it, so I decided to turn to my good old friend, terminal and ncurses to make it. At the end of the day this probably took me twice as long to make but it was time well spent.

# How to Compile and Run the C Version
First make sure you have the ncurses lib downloaded, then:
Go to the directory where you downloaded the file, then run this command in your terminal of choice: 

"gcc NmbrGsr.c -o NmbrGsr.out -lncurses"

Then, to run it, simply paste this:

"./NmbrGsr.out"

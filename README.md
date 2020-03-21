# SENG-300-Group-18-Project
A Journal submission program

## Getting Started
This project is developed using Java. To get it up and running on your local machine, the installation guide is given below. Two forms of installation can be used. One with a dedicated IDE of your choice (Eclipse or IntelliJ), or by running the executable JAR file given.

## Prerequisites/Requirements

In order for this application to work on your local machine, make sure you have installed the latest version of Java (that is, if you are running the JAR file.) If you are running it through an IDE, make sure you have a JDK installed. The corresponding JDK's can be found on Oracle's website [here](https://www.oracle.com/java/technologies/javase-downloads.html)

Corresponding IDE's that correlate to testing and running Java programs can be found below
- [IntelliJ](https://www.jetbrains.com/idea/)
- [Eclipse](https://www.eclipse.org/downloads/)

## Installation

### For running the .jar file
Download the project.jar (temporary placeholder) file onto your local machine, and then run it.

### For running it through a dedicated IDE (Eclipse)
Assuming git is not installed on your machine, open up Eclipse. </br>
First, add the git repository into eclipse. This is visible in the drop down menu *Window -> Show views -> Other -> Git -> Git repositories*. You will see a menu labled *Git Repositories*. From there, select *Clone a git repository*. Be mindful to select GitHub as the standard repository source. Enter the name of the git project, which in this case, is *SENG-300-Group-18-Project*. Save it to a directory and select *Import all existing Eclipse projects after clone finishes*. Now that it is in your directory, you are able to import it from your directory when you start up Eclipse.

## Built with
- [Java](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Eclipse](https://www.eclipse.org/downloads/)

## Authors
- Sijia Yin
- Zhen Gui
- Jason Jiang
- Sebastian Collard
- Boxiao Li
_________________________________________________________________________________________________________________________________________
Iteration 1 (As of March 2)

The user must have java installed in their system to run the program that we upload on this project.
The user may run the program by simply running the executable jar file or by importing the project into an IDE and running it using the IDE, or compiling and running the program with the commandline/terminal.

- The user can login in by register the user name and password first, the user name should less than 16 bits, and password should not less than 8 bits.

- If the user does not use proper username and login combination, they will be prompted with a message.

- Once logged in, the user can open submission pages and perform operations in these pages via buttons.

- The user can open one of each window simultaneously (up to 5 windows at once: main menu, journal submission window...etc.) but the user may not open more than one submission page. The system prevents them from doing so by greying out the corresponding button that is used to open a window.

- Inside the submission pages and main menu, the user can interact with a dropdown list containing dummy objects which are placeholders for both the submission pages and the main menu. Which will be added later on.

- At the bottom of these windows, there is a search selection which currently does not do anything and will be implemented later on.

We will enchance the system to meet the needs later on.

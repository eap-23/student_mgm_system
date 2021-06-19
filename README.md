# Welcome to EduAssist!
Simple console-based school management system project demonstrating some object-oriented programming concepts
## What It Does
Login to EduAssist to do the following:
- Add New Students
	- Enter the number of students you would like to add
		- A unique student ID number is automatically generated for each student
	- Enter student(s) name
	- Select their grade year
	- Enroll them in classes from the list of available options
	- Enter the amount of tuition that the student has paid (each class costs $700)
- Add New Teachers
	- Enter the number of teachers you would like to add
		- A unique teacher ID number is automatically generated for each teacher
	- Enter teacher(s) name
	- Select the subject that they will teach
	- Enter their starting salary
- Pay Teachers
	- Select which teachers to give biweekly paycheck. There is an option to pay all
- Adjust Salaries
	- Select a teacher to give a salary increase or decrease
- Check School Funds
	- Print out school funds based on tuition received from students and salary paid to teachers

## Login Information
Login information is stored in users.txt file in root directory. Each line is an acceptable username and password separated by a comma.

User #1 is Username: bob65, Password: 828282

More users can be added by simply adding a new line to users.txt.

## How it Works
User will be prompted to enter username and password on program start. Username and password entered is checked against username/password in users.txt. The user has 3 attempts to successfully login. 

Once logged in, the user will be presented with 6 options from the Main Menu and prompted to choose what they would like to do.

The user can operate in the Main Menu for as much as they would like before logging out. A while(true) loop is utilized to keep the program running until the user opts to logout.

An unknown number of student/teacher objects will need to be created at every program start. If the user chooses to (1) add new students or (2) add new teachers then they will be prompted to enter the number to add. The program will then loop the object creation process for as many times as the user has entered. User-entered info for students and teachers are stored in Student and Teacher classes respectively.

Users can choose to (3) pay or (4) adjust salaries of teachers. Selecting either of these options will generate a list of all teachers that were entered previously by the user. User then has option to choose a teacher and update appropriate info.

Only one school object will be created each time the program is run. Selecting to (5) check school funds will print out school funds info stored in School class.

After entering all appropriate info for a given option (options 1-5 on Main Menu), the user will be returned to the Main Menu. Some options loop until the user chooses to return to Main Menu (like on the Paying Teachers Menu). 

A Util class is used for error catching methods. These Util class methods are used when a user is prompted for input and an integer is expected. Method overloading is used to alter the method depending on the need. For example, sometimes any integer entered is valid ("Please enter number of new students to enroll") whereas other times only an integer within a range is valid (only integers 1-6 valid on Main Menu).

## How to Use
Make a clone of repo and run Main in your preferred IDE. Java needs to be installed on you local system.

## Future Updates
My future goal for this project is to connect it to an SQLite database where student, teacher, and school info can be stored. This way the program can be persistent and not be reset at the start of every program run. This project was mainly educational but adding database connectivity would get it closer to a real-world application.

## Credits
Credit where credit is due! I used the below youtube tutorials to help get started. Would highly recommend if your are looking to build something similar.

https://www.youtube.com/watch?v=GOGt7PACl10

https://www.youtube.com/watch?v=e0X00EoFQbE

https://www.youtube.com/watch?v=XrktMbcoeis










 






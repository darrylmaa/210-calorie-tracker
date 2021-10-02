# My Personal Project

## Fitness Calorie Tracker



<p>My plan for the calorie tracker is that the user would enter the desired caloric intake for the day and throughout the
day as the user consumes food they could input the data into the application and it would slowly subtract from the
desired intake. If the user is at a deficit then the text might display in red and some kind of text (eg: you're at
a deficit!) would display or if the person is at a surplus then the colour would be green with a message of (eg: you're
at a surplus!) would display. As for the food there could be preset common foods already entered into the app as well
as a feature to be able to <i>add other foods that aren't already entered into the system</i>. </p>

<p>This application wouldn't be for anyone specifically! However, the target audience would be for <b>people interested
in monitoring their calorie intake (ie: weight gain/loss)</b>. This project interests me because I'm fairly into fitness being a high performance athlete in my own sport, calorie
intake is a big thing that I need to monitor throughout the year and this could be of future use to me as I continue
to pursue sport. </p>

##User Stories

<ul>As a user, I want to be able to add a new food to my list of food consumed</ul>
<ul>As a user, I want to be able to accurately track my caloric intake</ul>
<ul>As a user, I want to be able to retrieve a list of all the foods with their calories that
 I consumed</ul>
<ul>As a user, I want to be able to know if I'm at a caloric deficit or surplus</ul>
<ul>As a user, I want to be able to save my calorie tracker numbers</ul>
<ul>As a user, I want to be able to load my calorie tracker numbers where I left off</ul>

##Instructions for Grader

<ul>You can generate the first required event by clicking any of the buttons</ul>
<ul>You can generate the second required event by clicking the "add consumed food" button and from there you can interact with the text box</ul>
<ul>You can locate my visual component by clicking on the "wholesome" button</ul>
<ul>You can save the state of my application by clicking the "save" button</ul>
<ul>There is no reload state in the application because there were contradictory comments on piazza. I will try to implement it for phase 4</ul>

##Phase 4: Task 2

<ul>I fulfilled task 2 by throwing a checked exception (NegativeNumberException)</ul>
<ul>The classes that participate in this are Tracker and CalorieTrackerPanel and the test is in Calorie Tracker Test</ul>
<ul>The methods that participate are addFood, openNewFoodDialogue, and submit</ul>

##Phase 4: Task 3

<ul>Removed getConsFood and making consFood to return string so 2 method calls aren't needed in every method that requires consFood</ul>
<ul>Removed back() and making any parts of that GUI that used back() to use menu() instead</ul>
<ul>Removed printCal() and printConsFood and inserted their implementation directly into methods that called for them</ul>
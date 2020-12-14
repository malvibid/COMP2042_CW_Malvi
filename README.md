# Task List
* [x] Setup a Maven-JavaFX project
* [ ] Tests with Junit
* [ ] Refactor
* [ ] MVC Design Pattern
* [x] Scene manager framework
* [ ] Levels (Factory Design Pattern)
* [ ] Main menu
* [ ] High score engine and file saving
* [ ] Improve graphics
* [ ] Final refactor/clean-up
* [ ] Comments and Javadocs
* [ ] README file (change log)
* [ ] Version control with Git and Github.  
* [ ] Class diagram
* [ ] Video presentation


# Change Log
All notable changes to this project will be documented in this file using the semantic versioning scheme.
Types of changes => Added, Changed, Removed, Fixed.

### [0.1.0]
* Created maven project using javafx-maven-archetypes. Added JavaFX dependencies in pom.xml.
* Reorganised project files. Moved game assets to separate resources' directory.
* Removed non-essential images and edited and added useful images.
* Renamed 'Animal.java' to 'Player.java'.
* Renamed 'Obstacle.java' to 'Vehicle.java'.
* Enabled Up, Down, Left, Right arrow keys along with A, W, S, D keys to control sprite.

### [1.0.0]
* As this is a single player game, only one instance of the player represented by 'frog' is required. Hence, changed 'Player' class to follow the Singleton design pattern.
* Implemented Model, View, Controller (MVC) pattern. 'GamePlayController' is responsible for level object creation and instance of 'MyStage' (which is a custom scene) is created in 'GamePlayView.fxml'.
* 'Main.java' is now only responsible for changing between different scenes in the application.
* Changed project file structure and 'module-info.java' such that all .fxml files can be found from the resources' directory in the 'Views' folder and all controllers can be found in the 'Controllers' package. 
* Added Main Menu. 
* Added an exit confirmation box.

# Screenshot of Game

![Game Screenshot](src/main/resources/p4_group_8_repo/Assets/arcade.png)
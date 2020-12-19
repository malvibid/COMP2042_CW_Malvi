package p4_group_8_repo;


import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * World class is a custom JavaFX control.
 * It holds the game loop which runs continuously during gameplay.
 * Each turn of the loop, it processes user input without blocking, updates the game state, and renders the game.
 * It tracks the passage of time to control the rate of gameplay.
 *
 * */
public abstract class World extends Pane {
    private AnimationTimer timer;

    /**
     * This constructor listens for changes in scene and updates the values according to new changes values.
     */
    public World() {
    	
    	sceneProperty().addListener(new ChangeListener<Scene>() {

			@Override
			public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
				if (newValue != null) {
					newValue.setOnKeyReleased(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyReleased() != null) 
								getOnKeyReleased().handle(event);
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor: myActors) {
								if (anActor.getOnKeyReleased() != null) {
									anActor.getOnKeyReleased().handle(event);
								}
							}
						}
						
					});
					
					newValue.setOnKeyPressed(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyPressed() != null) 
								getOnKeyPressed().handle(event);
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor: myActors) {
								if (anActor.getOnKeyPressed() != null) {
									anActor.getOnKeyPressed().handle(event);
								}
							}
						}
						
					});
				}
				
			}
    		
		});
    }

    /**
     * This method creates the main game loop.
     * This timer is responsible for updating the actors in real-time, i.e. responsible for making it move.
     *
     */
    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                act(now);
                List<Actor> actors = getObjects(Actor.class);
                
                for (Actor anActor: actors) {
                	anActor.act(now);
                }
      
            }
        };
    }

    /**
     * Starts main animation timer.
     */
    public void start() {
    	createTimer();
        timer.start();
    }

    /**
     * Stops main animation timer.
     */
    public void stop() {
        timer.stop();
    }

    /**
     * Helper method to add actors to the game World scene.
     * @param actor can only add actors to the game World.
     */
    public void add(Actor actor) {
        getChildren().add(actor);
    }

    /**
     * Helper method to remove actors to the game World scene.
     * @param actor remove actor object from game World.
     */
    public void remove(Actor actor) {
        getChildren().remove(actor);
    }


    /**
     * Helper method to get objects of type Actor.
     * @param cls get objects of this class. Bounded by <A>, meaning cls has to be an Actor.
     * @return an array of type Actor.
     */
    public <A extends Actor> List<A> getObjects(Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (Node n: getChildren()) {
            if (cls.isInstance(n)) {
                someArray.add((A)n);
            }
        }
        return someArray;
    }

    /**
     * Update method for the main game loop.
     * @param now current time
     */
    public abstract void act(long now);
}

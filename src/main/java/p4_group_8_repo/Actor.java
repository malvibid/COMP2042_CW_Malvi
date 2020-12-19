package p4_group_8_repo;

import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;

import java.util.ArrayList;

/**
 * Actor is an ImageView. It represents all the game objects.
 * This class contains logic for detecting collisions between objects and moving objects.
 */
public abstract class Actor extends ImageView{

    /**
     * This method allows the actor to move left, right, top, and bottom.
     * @param dx change in X direction.
     * @param dy change in Y direction.
     */
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    /**
     * gets the parent node of this ImageView.
     * @return the game World.
     */
    public World getWorld() {
        return (World) getParent();
    }

    /**
     * Checks for collisions.
     * @param cls class the object belongs to. Bounded by <A> which means cls has to be an Actor.
     * @return An array of objects of that are intersecting with player. Values of the array returned are upper bounded by <A extends Actor>, meaning it will return object of any class that inherits Actor class, i.e., any object that is an actor.
     */
    public <A extends Actor> java.util.List<A> getIntersectingObjects(Class<A> cls){
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }

    /**
     * Update function responsible for continuously changing the state of the moving functions.
     * @param now current time.
     */
    public abstract void act(long now);

}

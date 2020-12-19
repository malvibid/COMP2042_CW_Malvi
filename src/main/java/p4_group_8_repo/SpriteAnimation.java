package p4_group_8_repo;

import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * This class is used to set animations for the turtles.
 */
public class SpriteAnimation extends Transition {

    private final ImageView imageView;
    private final int count;
    private final int columns;
    private final int offsetX;
    private final int offsetY;
    private final int width;
    private final int height;

    private int lastIndex;
    private int x;
    private int y;

    /**
     * Instantiates the animation.
     * @param imageView - class of image.
     * @param duration - duration of one animation cycle.
     * @param count - number of frames.
     * @param columns - number of frames in one row in the image.
     * @param offsetX - offset of the first frame.
     * @param offsetY - offset of the first frame.
     * @param width - width of each frames.
     * @param height - height of each frames.
     */
    public SpriteAnimation(
            ImageView imageView,
            Duration duration,
            int count,   int columns,
            int offsetX, int offsetY,
            int width,   int height) {
        this.imageView = imageView;
        this.count     = count;
        this.columns   = columns;
        this.offsetX   = offsetX;
        this.offsetY   = offsetY;
        this.width     = width;
        this.height    = height;
        setCycleDuration(duration); //duration of a single cycle - time taken to go through all frames.
        setInterpolator(Interpolator.LINEAR);
    }

    /**
     * gets interpolated values, which are used to parse through the image frame by frame, creating the animation.
     * @param k - different values of k will be passed to interpolate as animation runs. In the beginning it will be 0.0 and end 1.0.
     */
    public void interpolate(double k) {
        final int index = Math.min((int) Math.floor(k * count), count - 1);
        if (index != lastIndex) {
            x = (index % columns) * width  + offsetX;
            y = (index / columns) * height + offsetY;
            imageView.setViewport(new Rectangle2D(x, y, width, height));
            lastIndex = index;

            imageView.setFitHeight(50);

        }
    }

    public int getX() {
        return x;
    }
}



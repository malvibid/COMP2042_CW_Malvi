package p4_group_8_repo;

import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class SpriteAnimation extends Transition {

    private final ImageView imageView;
    private final int count; //number of frames.
    private final int columns; //number of frames in one row in the image.
    private final int offsetX; //offset of the first frame.
    private final int offsetY; //offset of the first frame.
    private final int width; //width of each frames.
    private final int height; //height of each frames.

    private int lastIndex;
    private int x;
    private int y;

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
        setCycleDuration(duration); //duration of a single cycle - time take to go through all frames.
        setInterpolator(Interpolator.LINEAR);
    }

    public void interpolate(double k) {
        final int index = Math.min((int) Math.floor(k * count), count - 1);
        if (index != lastIndex) {
            x = (index % columns) * width  + offsetX;
            y = (index / columns) * height + offsetY;
            imageView.setViewport(new Rectangle2D(getX(), y, width, height));
            lastIndex = index;

            imageView.setFitHeight(50);

        }
    }

    public int getX() {
        return x;
    }
}



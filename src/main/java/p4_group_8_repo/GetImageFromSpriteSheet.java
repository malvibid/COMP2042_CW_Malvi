package p4_group_8_repo;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
/**
 * This class reads pixels of a spritesheet and uses the colours of these pixels to extract single frames of images.
 * */
public class GetImageFromSpriteSheet {

    /**
     * This method uses JavaFxs pixel reader and writer methods to strip and sprite sheet into an array of images.
     * @param frames - number of frames in the sprite sheet.
     * @param w - width of each frame.
     * @param h - height of each frame.
     * @param imageToStrip - sprite sheet.
     * @return an array of images according to the dimensions specified.
     */
    public static Image[] getImage(int frames, int w, int h, Image imageToStrip) {

        Image[] imgs = new Image[frames];

        //img that contains all frames
        Image spriteSheet = imageToStrip;
        PixelReader pr = spriteSheet.getPixelReader();
        PixelWriter pw = null;

        for (int i = 0; i < frames; i++) {

            WritableImage wImg = new WritableImage(w, h);
            pw = wImg.getPixelWriter();

            for (int readY = 0; readY < h; readY++) {

                int ww = (w * i);
                for (int readX = ww; readX < ww + w; readX++) {
                    //get pixel at X  & Y position
                    Color color = pr.getColor(readX, readY);

                    //set pixel to writableimage through pixel writer
                    pw.setColor(readX - ww, readY, color);

                }

            }

            //finally new image is stored
            imgs[i] = wImg;
        }

        spriteSheet = null;
        pr = null;
        pw = null;

        return imgs;
    }
}

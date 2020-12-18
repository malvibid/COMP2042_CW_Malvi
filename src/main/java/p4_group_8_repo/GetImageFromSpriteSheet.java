package p4_group_8_repo;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class GetImageFromSpriteSheet {

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

                }//X

            }//Y

            //finally new image is stored
            imgs[i] = wImg;
        }//

        spriteSheet = null;
        pr = null;
        pw = null;

        return imgs;
    }//
}

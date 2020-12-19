package p4_group_8_repo;

import javafx.scene.image.Image;
import p4_group_8_repo.Controllers.MainMenuController;

/***
 * This class loads all the images into the game prior to starting game play. This prevents lags. Also provides easy access to all images.
 */

public class ImageLoader{

    public static Image ALLIGATOR_SPRITES;
    public static Image BOTTOM_GROUND;
    public static Image CAR_DEATH_SPRITES;
    public static Image CARS_SPRITES;
    public static Image FROG_SPRITES;
    public static Image GAME_BACKGROUND;
    public static Image HOMEBASE_SPRITES;
    public static Image LIVES;
    public static Image SHORE_GROUND;
    public static Image TOP_GROUND;
    public static Image LOG_1;
    public static Image LOG_2;
    public static Image LOG_3;
    public static Image MENU_BACKGROUND;
    public static Image TRUCK;
    public static Image TURTLE_2RED_SPRITES;
    public static Image TURTLE_3RED_SPRITES;
    public static Image TURTLE_2GREEN_SPRITES;
    public static Image TURTLE_3GREEN_SPRITES;
    public static Image WATER_DEATH_SPRITES;
    public static Image SINGLE_CAR;


    /**
     * Helper method to get the resources from file directory..
     * @param imageName name of image
     * @return image
     */
    public static Image getLink(String imageName){
        return new Image(ImageLoader.class.getResource("/p4_group_8_repo/Assets/"+ imageName).toString());
    }

    /**
     * The ImageLoader constructor will load the images specified in it. The image loader is triggered from the main menu.
     * @see MainMenuController
     */
    public ImageLoader(){
        ALLIGATOR_SPRITES = getLink("alligator_sprites.png");
        BOTTOM_GROUND = getLink("bottom_ground.png");
        CAR_DEATH_SPRITES = getLink("car_death_sprites.png");
        CARS_SPRITES = getLink("car_sprites.png");
        FROG_SPRITES = getLink("frog_sprites.png");
        GAME_BACKGROUND = getLink("game_background.png");
        HOMEBASE_SPRITES = getLink("homebase_sprites.png");
        LIVES = getLink("lives.png");
        SHORE_GROUND = getLink("shore_ground.png");
        TOP_GROUND = getLink("top_ground.png");
        LOG_1 = getLink("log_1.png");
        LOG_2 = getLink("log_2.png");
        LOG_3 = getLink("log_3.png");
        MENU_BACKGROUND = getLink("menu_background.png");
        TRUCK = getLink("truck.png");
        TURTLE_2RED_SPRITES = getLink("turtle_2red_sprites.png");
        TURTLE_3RED_SPRITES = getLink("turtle_3red_sprites.png");
        TURTLE_2GREEN_SPRITES = getLink("turtle_2green_sprites.png");
        TURTLE_3GREEN_SPRITES = getLink("turtle_3green_sprites.png");
        WATER_DEATH_SPRITES = getLink("water_death_sprites.png");


    }
}

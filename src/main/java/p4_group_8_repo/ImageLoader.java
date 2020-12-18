package p4_group_8_repo;

import javafx.scene.image.Image;

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


    public static Image getLink(String imageName){
        return new Image(ImageLoader.class.getResource("/p4_group_8_repo/NewAssets/"+ imageName).toString());
    }

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
        SINGLE_CAR = getLink("car1right.png");


    }
}

//package com.ae2dms.Controller;
//
//import com.ae2dms.IO.ResourceFactory;
//import com.ae2dms.IO.ResourceType;
//import javafx.fxml.FXML;
//import javafx.scene.control.Label;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//
//import java.util.Random;
//
///**
// * The score item to be added into High Score List
// * This is the controller for that
// */
//public class RecordController {
//
//    /**
//     * The background Image of this score record
//     * has different types for Steps, Durations, Best Steps and Best Duration
//     */
//    @FXML
//    private ImageView HighScoreItemImage;
//
//    /**
//     * The Avatar image of this score record
//     * will be shuffle chosen when creat this ScoreView
//     */
//    @FXML
//    private ImageView AvatarImage;
//
//    /**
//     * NameField to display the typed name of player
//     */
//    @FXML
//    private Label NameField;
//
//    /**
//     * DataField to display the data (duration seconds or steps)
//     */
//    @FXML
//    private Label DataField;
//
//    /**
//     * randomly select the Avatar image of this record
//     */
//    public void setRandomImage() {
//        Random random = new Random();
//        Image randomImage = (Image)ResourceFactory.getResource("AVATARS_" + (random.nextInt(10) + 1), ResourceType.Image);
//        AvatarImage.setImage(randomImage);
//    }
//
//    /**
//     * set the type of this record, will update the background image if according to the type
//     *
//     * @param type the type of this record: "Score" or "Time"
//     */
//    public void setType(String type) {
//        switch (type) {
//            case "Score" -> {
//                this.HighScoreItemImage.setImage((Image)ResourceFactory.getResource("SCORE_ITEM_BACKGROUND", ResourceType.Image));
//            }
//            case "Time" -> {
//                this.HighScoreItemImage.setImage((Image)ResourceFactory.getResource("TIME_ITEM_BACKGROUND", ResourceType.Image));
//            }
//        }
//    }
//
//    /**
//     * Sets name.
//     *
//     * @param name the name
//     */
//    public void setName(String name) {
//        this.NameField.setText(name);
//    }
//
//    /**
//     * Sets data.
//     *
//     * @param data the data
//     */
//    public void setData(int data) {
//        this.DataField.setText(String.valueOf(data));
//    }
//
//    /**
//     * called if this record is the first(best) in the whole list, will change the background image accordingly
//     *
//     * @param type the type of this record: "Score" or "Time"
//     */
//    public void setFirst(String type) {
//        switch (type) {
//            case "Score" -> {
//                this.HighScoreItemImage.setImage((Image)ResourceFactory.getResource("SCORE_ITEM_FIRST_BACKGROUND", ResourceType.Image));
//            }
//            case "Time" -> {
//                this.HighScoreItemImage.setImage((Image)ResourceFactory.getResource("TIME_ITEM_FIRST_BACKGROUND", ResourceType.Image));
//            }
//        }
//    }
//}

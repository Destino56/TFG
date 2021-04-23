package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.util.Collection;

public class IntroToAnimation extends Application {

    final static javafx.scene.image.Image SHINOBI1 = new javafx.scene.image.Image(IntroToAnimation.class.getResource("../imgs/shinobi/shinobi_Idle1.png").toString());
    final static javafx.scene.image.Image SHINOBI2 = new javafx.scene.image.Image(IntroToAnimation.class.getResource("../imgs/shinobi/shinobi_Idle2.png").toString());
    final static javafx.scene.image.Image SHINOBI3 = new javafx.scene.image.Image(IntroToAnimation.class.getResource("../imgs/shinobi/shinobi_Idle3.png").toString());
    final static javafx.scene.image.Image SHINOBI4 = new javafx.scene.image.Image(IntroToAnimation.class.getResource("../imgs/shinobi/shinobi_Idle4.png").toString());
    final static javafx.scene.image.Image SHINOBI5 = new javafx.scene.image.Image(IntroToAnimation.class.getResource("../imgs/shinobi/shinobi_Idle5.png").toString());
    final static javafx.scene.image.Image SHINOBI6 = new javafx.scene.image.Image(IntroToAnimation.class.getResource("../imgs/shinobi/shinobi_Idle6.png").toString());
    final static javafx.scene.image.Image SHINOBI7 = new javafx.scene.image.Image(IntroToAnimation.class.getResource("../imgs/shinobi/shinobi_Idle7.png").toString());
    final static javafx.scene.image.Image SHINOBI8 = new javafx.scene.image.Image(IntroToAnimation.class.getResource("../imgs/shinobi/shinobi_Idle8.png").toString());
    final static javafx.scene.image.Image SHINOBI9 = new javafx.scene.image.Image(IntroToAnimation.class.getResource("../imgs/shinobi/shinobi_Idle9.png").toString());
    final static javafx.scene.image.Image SHINOBI10 = new javafx.scene.image.Image(IntroToAnimation.class.getResource("../imgs/shinobi/shinobi_Idle10.png").toString());

    private Group shinobi;

    @Override
    public void start(Stage primaryStage) throws IOException {
        final ImageView shinobi1 = new ImageView(SHINOBI1);
        final ImageView shinobi2 = new ImageView(SHINOBI2);
        final ImageView shinobi3 = new ImageView(SHINOBI3);
        final ImageView shinobi4 = new ImageView(SHINOBI4);
        final ImageView shinobi5 = new ImageView(SHINOBI5);
        final ImageView shinobi6 = new ImageView(SHINOBI6);
        final ImageView shinobi7 = new ImageView(SHINOBI7);
        final ImageView shinobi8 = new ImageView(SHINOBI8);
        final ImageView shinobi9 = new ImageView(SHINOBI9);
        final ImageView shinobi10 = new ImageView(SHINOBI10);

        shinobi = new Group(shinobi1);

        shinobi.setTranslateX(200);
        shinobi.setTranslateY(220);

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);

        timeline.getKeyFrames().add(new KeyFrame(
                Duration.millis(200),
                (ActionEvent event) ->{
                    shinobi.getChildren().setAll(shinobi2);
                }
        ));
        timeline.getKeyFrames().add(new KeyFrame(
                Duration.millis(300),
                (ActionEvent event) ->{
                    shinobi.getChildren().setAll(shinobi3);
                }
        ));
        timeline.getKeyFrames().add(new KeyFrame(
                Duration.millis(400),
                (ActionEvent event) ->{
                    shinobi.getChildren().setAll(shinobi4);
                }
        ));
        timeline.getKeyFrames().add(new KeyFrame(
                Duration.millis(500),
                (ActionEvent event) ->{
                    shinobi.getChildren().setAll(shinobi5);
                }
        ));
        timeline.getKeyFrames().add(new KeyFrame(
                Duration.millis(600),
                (ActionEvent event) ->{
                    shinobi.getChildren().setAll(shinobi6);
                }
        ));
        timeline.getKeyFrames().add(new KeyFrame(
                Duration.millis(700),
                (ActionEvent event) ->{
                    shinobi.getChildren().setAll(shinobi7);
                }
        ));
        timeline.getKeyFrames().add(new KeyFrame(
                Duration.millis(800),
                (ActionEvent event) ->{
                    shinobi.getChildren().setAll(shinobi8);
                }
        ));
        timeline.getKeyFrames().add(new KeyFrame(
                Duration.millis(900),
                (ActionEvent event) ->{
                    shinobi.getChildren().setAll(shinobi9);
                }
        ));
        timeline.getKeyFrames().add(new KeyFrame(
                Duration.millis(1000),
                (ActionEvent event) ->{
                    shinobi.getChildren().setAll(shinobi10);
                }
        ));
        timeline.play();

        primaryStage.setScene(new Scene(shinobi, 600, 400));
        primaryStage.setTitle("Prueba Animación");
        primaryStage.show();
    }
}

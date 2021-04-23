package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;

public class Main extends Application {

    final static javafx.scene.image.Image SHINOBI1 = new javafx.scene.image.Image(IntroToAnimation.class.getResource("../imgs/shinobi/shinobi_Idle1.png").toString());
    /*final static javafx.scene.image.Image SHINOBI2 = new javafx.scene.image.Image(IntroToAnimation.class.getResource("imgs/shinobi/shinobi_Idle2.png").toString());
    final static javafx.scene.image.Image SHINOBI3 = new javafx.scene.image.Image(IntroToAnimation.class.getResource("imgs/shinobi/shinobi_Idle3.png").toString());
    final static javafx.scene.image.Image SHINOBI4 = new javafx.scene.image.Image(IntroToAnimation.class.getResource("imgs/shinobi/shinobi_Idle4.png").toString());
    final static javafx.scene.image.Image SHINOBI5 = new javafx.scene.image.Image(IntroToAnimation.class.getResource("imgs/shinobi/shinobi_Idle5.png").toString());
    final static javafx.scene.image.Image SHINOBI6 = new javafx.scene.image.Image(IntroToAnimation.class.getResource("imgs/shinobi/shinobi_Idle6.png").toString());
    final static javafx.scene.image.Image SHINOBI7 = new javafx.scene.image.Image(IntroToAnimation.class.getResource("imgs/shinobi/shinobi_Idle7.png").toString());
    final static javafx.scene.image.Image SHINOBI8 = new javafx.scene.image.Image(IntroToAnimation.class.getResource("imgs/shinobi/shinobi_Idle8.png").toString());
    final static javafx.scene.image.Image SHINOBI9 = new javafx.scene.image.Image(IntroToAnimation.class.getResource("imgs/shinobi/shinobi_Idle9.png").toString());
    final static javafx.scene.image.Image SHINOBI10 = new javafx.scene.image.Image(IntroToAnimation.class.getResource("imgs/shinobi/shinobi_Idle10.png").toString());
*/
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Bosque");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setMinHeight(411);
        primaryStage.setMinWidth(470);
        primaryStage.setMaxWidth(470);
        primaryStage.setMaxHeight(411);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

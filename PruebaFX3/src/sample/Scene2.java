package sample;

import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Scene2 {

    private Group chests;
    private ImageView chest;


    public Group changeScene2(){

        ArrayList<ImageView> arrChest = new ArrayList<>();
        String ruta;
        Label dialogo;

        dialogo = new Label();
        dialogo.setTranslateX(25);
        dialogo.setTranslateY(525);
        dialogo.setMinWidth(600);
        dialogo.setMaxWidth(600);
        dialogo.setMinHeight(70);
        dialogo.setMaxHeight(70);
        dialogo.setStyle("-fx-background-color: #f7f1f0; -fx-padding: 20px; -fx-font-size: 15px");
        dialogo.setText("Has encontrado un cofre!");

        for (int i=1 ; i<=9 ; i++){
            ruta = "imgs/chest/chest" + i + ".png";
            chest = new ImageView(ruta);
            chest.setFitHeight(115);
            arrChest.add(chest);
        }
        chests = new Group(arrChest.get(0));
        chests.setTranslateX(400);
        chests.setTranslateY(275);

        Timeline timelineC = new Timeline();
        timelineC.setCycleCount(Timeline.INDEFINITE);
        new Animaciones().animacion(arrChest, timelineC, chests, 8);
        timelineC.play();

        Button btnAbrir = new Button("Abrir cofre");
        btnAbrir.setTranslateX(300);
        btnAbrir.setTranslateY(600);
        btnAbrir.setOnAction(event -> {
            timelineC.stop();
            chests.getChildren().setAll(arrChest.get(8));
            dialogo.setText("Has abierto el cofre, por desgracia estaba vacío");
        });

        Group groupScene2 = new Group(chests, btnAbrir, dialogo);
        return groupScene2;
    }
}

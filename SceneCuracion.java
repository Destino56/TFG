package view;

import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import sample.Animaciones;

import java.util.ArrayList;
import java.util.Random;

public class SceneCuracion {

    private Group fountains;
    private ImageView fountain;

    public Group changeSceneCuracion(){

        String ruta;
        Label dialogo;
        ArrayList<ImageView> arrFountains = new ArrayList<>();

        dialogo = new Label();
        dialogo.setTranslateX(25);
        dialogo.setTranslateY(525);
        dialogo.setMinWidth(600);
        dialogo.setMaxWidth(600);
        dialogo.setMinHeight(100);
        dialogo.setMaxHeight(100);
        dialogo.setStyle("-fx-background-color: #f7f1f0; -fx-padding: 20px; -fx-font-size: 15px");
        dialogo.setText("Has encontrado una fuente con unas aguas cristalinas!");

        for (int i=1 ; i<=5 ; i++){
            ruta = "imgs/fountain/fuente" + i + ".png";
            fountain = new ImageView(ruta);
            fountain.setFitWidth(275);
            fountain.setFitHeight(350);
            arrFountains.add(fountain);
        }

        fountains = new Group(arrFountains.get(0));
        fountains.setTranslateX(350);
        fountains.setTranslateY(85);

        Timeline timelineF = new Timeline();
        timelineF.setCycleCount(Timeline.INDEFINITE);
        new Animaciones().animacion(arrFountains, timelineF, fountains, 4);
        timelineF.play();

        Button btnBeber = new Button("Beber de la fuente");
        btnBeber.setTranslateX(275);
        btnBeber.setTranslateY(640);
        btnBeber.setOnAction(event -> {
            timelineF.stop();
            fountains.getChildren().setAll(arrFountains.get(4));
            dialogo.setText("Has bebido de la fuente y has recuperado 20Hp!");
        });

        Group groupSceneCuracion = new Group(fountains, btnBeber, dialogo);
        return groupSceneCuracion;
    }
}

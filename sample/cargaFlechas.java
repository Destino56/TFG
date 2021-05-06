package sample;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Map;

public class cargaFlechas {

    public Group cargaFlechas(Stage primaryStage, Map map, int cordXActual, int cordYActual, int numFlechas){

        ImageView flecha1=null, flecha2=null,flecha3=null,flecha4=null;
        for (int i=0 ; i<numFlechas ; i++){
            switch (i){
                case 0:
                    flecha1 = createFlecha(primaryStage, i);
                    break;

                case 1:
                    flecha2 = createFlecha(primaryStage, i);
                    break;

                case 2:
                    flecha3 = createFlecha(primaryStage, i);
                    break;

                case 3:
                    flecha4 = createFlecha(primaryStage, i);
                    break;
            }
        }
        Group groupFlechas = null;
        switch (numFlechas){
            case 1:
                groupFlechas = new Group(flecha1);
                break;

            case 2:
                groupFlechas = new Group(flecha1, flecha2);
                break;

            case 3:
                groupFlechas = new Group(flecha1, flecha2, flecha3);
                break;

            case 4:
                groupFlechas = new Group(flecha1, flecha2, flecha3, flecha4);
                break;
        }

        return groupFlechas;
    }

    private ImageView createFlecha(Stage primaryStage, int i){

        ImageView btnNext = new ImageView("imgs/icons/flecha.png");
        switch (i){
            case 0:
                btnNext.setTranslateX(575);
                btnNext.setTranslateY(225);
                break;

            case 1:
                btnNext.setTranslateX(575);
                btnNext.setTranslateY(225);
                break;
        }

        btnNext.setFitWidth(60);
        btnNext.setFitHeight(50);
        btnNext.setVisible(true);
        btnNext.getStyleClass().add("btnNext");

        btnNext.setOnMouseClicked(event -> {
            Group root2 = new Group();
            Scene scene2 = new Scene(root2);
            primaryStage.setScene(scene2);
        });

        return btnNext;
    }
}

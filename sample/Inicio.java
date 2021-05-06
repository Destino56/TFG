package sample;

import javafx.application.Application;
import javafx.stage.Stage;

public class Inicio extends Application {

    @Override
    public void start(Stage primaryStage){

        primaryStage.setMinHeight(711);
        primaryStage.setMinWidth(670);
        primaryStage.setMaxWidth(670);
        primaryStage.setMaxHeight(711);
        primaryStage.setTitle("Piso - 1");
        SalasInicio salasInicio = new SalasInicio();
        salasInicio.cargaSalaInicio(primaryStage);
    }


    public static void main(String[] args) { launch(args); }
}

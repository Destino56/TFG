package sample;

import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Map;
import model.Sala;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class SalasInicio {

    private Group characters;
    private ImageView character;
    private Map map;

    public void cargaSalaInicio(Stage primaryStage){

        cargaInfoMapa();

        ArrayList<ImageView> arrCharacter = new ArrayList<>();
        String rutaRaiz = readRutaRaiz();

        String ruta;
        for (int i=1 ; i<=10 ; i++) {
                ruta = rutaRaiz + i + ".png";
                character = new ImageView(ruta);
                arrCharacter.add(character);
        }

        characters = new Group(arrCharacter.get(0));
        characters.setTranslateX(200);
        characters.setTranslateY(245);

        Timeline timelineCharacter = new Timeline();
        timelineCharacter.setCycleCount(Timeline.INDEFINITE);

        new Animaciones().animacion(arrCharacter, timelineCharacter, characters, 10);

        timelineCharacter.play();

        ImageView background = new ImageView("imgs/background/"+map.getNombrePiso()+map.getArrSalas().get(0).getTipoFondo()+".png");
        background.setFitHeight(511);
        background.setFitWidth(670);

        Label dialogo = new Label();
        dialogo.setTranslateX(25);
        dialogo.setTranslateY(525);
        dialogo.setMinWidth(600);
        dialogo.setMaxWidth(600);
        dialogo.setMinHeight(100);
        dialogo.setMaxHeight(100);
        dialogo.setStyle("-fx-background-color: #f7f1f0; -fx-padding: 20px; -fx-font-size: 15px");

        Group root = new Group(background, characters, dialogo);
        Scene scene = new Scene(root);
        scene.getStylesheets().add("styles/styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private String readRutaRaiz(){

        BufferedReader bufferedReader;
        String rutaRaiz="";

        try {
            bufferedReader = new BufferedReader(new FileReader("files/stats.txt"));
            String line="";
            line=bufferedReader.readLine();
            String[] fields = line.split(";");
            rutaRaiz = "imgs/"+fields[7]+"/"+fields[8];

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rutaRaiz;
    }

    private void cargaInfoMapa(){

        BufferedReader bufferedReader;

        try {
            bufferedReader = new BufferedReader(new FileReader("files/maps.txt"));
            String line="";
            line=bufferedReader.readLine();
            String[] fields = line.split(";");

            map = new Map();
            map.setNumPiso(Integer.parseInt(fields[0]));
            map.setNombrePiso(fields[1]);
            map.setNumMapa(Integer.parseInt(fields[2]));
            ArrayList<Sala> arrSalas = new ArrayList<>();

            for (int i=0 ; i<(fields.length-2)/4 ; i++){

                Sala sala = new Sala();

                sala.setCordX(Integer.parseInt(fields[(i*4)+3]));
                sala.setCordY(Integer.parseInt(fields[(i*4)+4]));
                sala.setTipoSala(Integer.parseInt(fields[(i*4)+5]));
                sala.setTipoFondo(fields[(i*4)+6]);

                arrSalas.add(sala);
            }

            map.setArrSalas(arrSalas);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

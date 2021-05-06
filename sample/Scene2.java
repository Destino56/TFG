package sample;

import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import model.Item;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

public class Scene2 {

    private Group chests;
    private ImageView chest;
    private ArrayList<Item> arrItems = new ArrayList<>();


    public Group changeScene2(){

        loadItems();

        ArrayList<ImageView> arrChest = new ArrayList<>();
        String ruta;
        Label dialogo;

        dialogo = new Label();
        dialogo.setTranslateX(25);
        dialogo.setTranslateY(525);
        dialogo.setMinWidth(600);
        dialogo.setMaxWidth(600);
        dialogo.setMinHeight(100);
        dialogo.setMaxHeight(100);
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

        Random r = new Random();
        int itemElegido = r.nextInt(arrItems.size());
        ImageView item = new ImageView("imgs/items/"+arrItems.get(itemElegido).getRuta());
        item.setFitWidth(100);
        item.setFitHeight(100);
        item.setTranslateX(415);
        item.setTranslateY(225);
        item.setVisible(false);

        Button btnAbrir = new Button("Abrir cofre");
        btnAbrir.setTranslateX(300);
        btnAbrir.setTranslateY(640);
        btnAbrir.setOnAction(event -> {
            openChest(timelineC, arrChest, dialogo,  itemElegido, item);
            timelineC.stop();
        });

        Group groupScene2 = new Group(chests, btnAbrir, dialogo, item);
        return groupScene2;
    }

    public void openChest(Timeline timelineC, ArrayList<ImageView> arrChest, Label dialogo, int itemElegido, ImageView item){
        timelineC.stop();
        chests.getChildren().setAll(arrChest.get(8));
        item.setVisible(true);
        dialogo.setText("Has abierto el cofre, has encontrado: "+arrItems.get(itemElegido).getName()+"\n-"+
                arrItems.get(itemElegido).getDescription()+"-");
    }

    public void loadItems(){

        BufferedReader bufferedReader;

        try {

            bufferedReader = new BufferedReader(new FileReader("files/items.txt"));
            String line="";
            while ((line=bufferedReader.readLine())!=null) {
                String[] fields = line.split(";");

                Item item = new Item();
                item.setId(Integer.parseInt(fields[0]));
                item.setName(fields[1]);
                item.setDescription(fields[2]);
                item.setPositionStat(Integer.parseInt(fields[3]));
                item.setNewValue(Integer.parseInt(fields[4]));
                item.setRuta(fields[5]);
                arrItems.add(item);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package sample;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

public class Main extends Application {

    private Group shinobi;
    private Group enemigos;
    private ImageView shinobis, enemigo;
    private ArrayList<Entity> arrEntitys = new ArrayList<>();
    private Label dialogo;


    @Override
    public void start(Stage primaryStage){

        primaryStage.setMinHeight(711);
        primaryStage.setMinWidth(670);
        primaryStage.setMaxWidth(670);
        primaryStage.setMaxHeight(711);

        String ruta;

        ArrayList<ImageView> arrShinobi = new ArrayList<>();
        ArrayList<ImageView> arrEnemigos = new ArrayList<>();

        loadEntitys();
        Random r = new Random();
        int monstruoSeleccionado = r.nextInt((arrEntitys.size()-1))+1;
        //int monstruoSeleccionado = 6;

        for (int i=1 ; i<=11 ; i++){
            if (i<=10){
                ruta = "imgs/shinobi/shinobi_Idle"+i+".png";
                shinobis = new ImageView(ruta);
                arrShinobi.add(shinobis);

            }
            if (i<=arrEntitys.get(monstruoSeleccionado).getNumSprites()){
                ruta = "imgs/monsters/"+arrEntitys.get(monstruoSeleccionado).getFolder()+
                        "/"+arrEntitys.get(monstruoSeleccionado).getSprite()+ i + ".png";
                enemigo = new ImageView(ruta);
                enemigo.setFitWidth(arrEntitys.get(monstruoSeleccionado).getWidht());
                enemigo.setFitHeight(arrEntitys.get(monstruoSeleccionado).getHeight());
                arrEnemigos.add(enemigo);
            }
        }

        ImageView bosque = new ImageView("imgs/fondoBosque.png");
        bosque.setFitHeight(511);
        bosque.setFitWidth(670);

        shinobi = new Group(arrShinobi.get(0));
        enemigos = new Group(arrEnemigos.get(0));


        shinobi.setTranslateX(10);
        shinobi.setTranslateY(245);

        enemigos.setTranslateX(arrEntitys.get(monstruoSeleccionado).getPosX());
        enemigos.setTranslateY(arrEntitys.get(monstruoSeleccionado).getPosY());

        Timeline timelineS = new Timeline();
        timelineS.setCycleCount(Timeline.INDEFINITE);
        Timeline timelineE = new Timeline();
        timelineE.setCycleCount(Timeline.INDEFINITE);

        new Animaciones().animacion(arrShinobi, timelineS, shinobi, 10);
        new Animaciones().animacion(arrEnemigos, timelineE, enemigos, arrEnemigos.size());

        timelineS.play();
        timelineE.play();

        ProgressBar vidaShinobi = new ProgressBar(1);
        vidaShinobi.setStyle("-fx-accent: green");
        vidaShinobi.setTranslateX(60);
        vidaShinobi.setTranslateY(210);

        ProgressBar vidaEnemigo = new ProgressBar(1);
        vidaEnemigo.setStyle("-fx-accent: red");
        vidaEnemigo.setTranslateX(arrEntitys.get(monstruoSeleccionado).getPosXVida());
        vidaEnemigo.setTranslateY(arrEntitys.get(monstruoSeleccionado).getPosYVida());

        dialogo = new Label();
        dialogo.setTranslateX(25);
        dialogo.setTranslateY(525);
        dialogo.setMinWidth(600);
        dialogo.setMaxWidth(600);
        dialogo.setMinHeight(100);
        dialogo.setMaxHeight(100);
        dialogo.setStyle("-fx-background-color: #f7f1f0; -fx-padding: 20px; -fx-font-size: 15px");

        ImageView btnNext = new ImageView("imgs/icons/flecha.png");
        btnNext.setTranslateX(575);
        btnNext.setTranslateY(225);
        btnNext.setFitWidth(60);
        btnNext.setFitHeight(50);
        btnNext.setVisible(false);
        btnNext.getStyleClass().add("btnNext");

        Button btnAtacar = new Button("Atacar");
        btnAtacar.setTranslateX(300);
        btnAtacar.setTranslateY(640);
        btnAtacar.setOnAction(event -> {

            int valueVidaEnemigo = atacar(vidaEnemigo, 0, arrEntitys.get(monstruoSeleccionado).getId(), enemigos);
            if (valueVidaEnemigo<=0){
                dialogo.setText("Has acabado con el enemigo: "+arrEntitys.get(monstruoSeleccionado).getName());
                btnAtacar.setVisible(false);
                btnNext.setVisible(true);
            }else{
                int vidaJugador = atacar(vidaShinobi, 1, 0, shinobi);
                if (vidaJugador<=0){
                    dialogo.setText("Has sido asesinado a manos de el enemigo: "+arrEntitys.get(monstruoSeleccionado).getName());
                    btnAtacar.setVisible(false);
                }
            }
        });

        Group root = new Group(bosque, shinobi, enemigos, btnAtacar, btnNext, vidaShinobi, vidaEnemigo, dialogo);
        primaryStage.setTitle("Bosque - Combate");
        Scene scene = new Scene(root);
        scene.getStylesheets().add("styles/styles.css");
        primaryStage.setScene(scene);

        btnNext.setOnMouseClicked(event -> {
            Scene2 Scene2 = new Scene2();
            Group groupScene2 = Scene2.changeScene2();
            Group root2 = new Group(bosque, shinobi, groupScene2);
            primaryStage.setTitle("Bosque - Tesoro");
            Scene scene2 = new Scene(root2);
            primaryStage.setScene(scene2);
        });

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void loadEntitys(){

        BufferedReader bufferedReader;

        try {

            bufferedReader = new BufferedReader(new FileReader("files/stats.txt"));
            String line="";
            while ((line=bufferedReader.readLine())!=null) {
                String[] fields = line.split(";");

                Entity entity = new Entity();
                entity.setId(Integer.parseInt(fields[0]));
                entity.setName(fields[1]);
                entity.setHealth(Integer.parseInt(fields[2]));
                entity.setDice(Integer.parseInt(fields[3]));
                entity.setDamage(Integer.parseInt(fields[4]));
                entity.setDodge(Integer.parseInt(fields[5]));
                entity.setPrecission(Integer.parseInt(fields[6]));
                entity.setFolder(fields[7]);
                entity.setSprite(fields[8]);
                entity.setWidht(Integer.parseInt(fields[9]));
                entity.setHeight(Integer.parseInt(fields[10]));
                entity.setPosX(Integer.parseInt(fields[11]));
                entity.setPosY(Integer.parseInt(fields[12]));
                entity.setPosXVida(Integer.parseInt(fields[13]));
                entity.setPosYVida(Integer.parseInt(fields[14]));
                entity.setNumSprites(Integer.parseInt(fields[15]));
                arrEntitys.add(entity);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int atacar(ProgressBar barraVida, int atacante, int enemigo, Group enemigoG){
        Random r = new Random();
        int acierto = r.nextInt(20)+1;
        if (acierto+arrEntitys.get(atacante).getPrecission()>=10){

        }
        int damage = r.nextInt(arrEntitys.get(atacante).getDice())+1;
        int vidaAnterior = arrEntitys.get(enemigo).getHealth();
        Entity entity = arrEntitys.get(enemigo);

        entity.setHealth(vidaAnterior - damage);
        arrEntitys.set(enemigo, entity);
        Double valorActualBarra =  barraVida.getProgress();
        if(arrEntitys.get(enemigo).getHealth()<=0){
            enemigoG.setVisible(false);
            barraVida.setVisible(false);
            barraVida.setProgress(0);
        }else{
            barraVida.setProgress((arrEntitys.get(enemigo).getHealth()*valorActualBarra)/vidaAnterior);
        }
        System.out.println("Vida "+arrEntitys.get(enemigo).getName()+" restante: "+arrEntitys.get(enemigo).getHealth());
        return arrEntitys.get(enemigo).getHealth();
    }
}

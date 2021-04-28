package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.ArrayList;

public class Animaciones {

    public void animacion(ArrayList<ImageView> arr, Timeline timeline, Group group, int max){
        int tiempoAnimacion;
        for (int i=0 ; i<max ; i++){
            tiempoAnimacion = i + 1;
            int finalI = i;
            timeline.getKeyFrames().add(new KeyFrame(
                    Duration.millis(tiempoAnimacion*100),
                    (ActionEvent event) ->{
                        group.getChildren().setAll(arr.get(finalI));
                    }
            ));
        }
    }
}

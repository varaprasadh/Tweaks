/*
*written by Varaprasadh Alajangi
* @ 16/03/18
*/
import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.geometry.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaView;
import javafx.scene.media.MediaPlayer;
import javafx.scene.control.Slider;
import javafx.util.Duration;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
public class MoviePlayer extends Application{

  public static void main(String[] args){
    launch(args);
  }

public void start(Stage prestage){
  prestage.setTitle("movie player");

  Group root=new Group();
  Media media=new Media("file:///Atom//javafx//song.mp4");
  //int width=media.getWidth();

  MediaPlayer player=new MediaPlayer(media);
  MediaView view=new MediaView(player);
  final VBox vbox=new VBox();
  Slider slider=new Slider();
  vbox.getChildren().add(slider);

  root.getChildren().add(view);
  root.getChildren().add(vbox);

  Scene scene =new Scene(root,400,400,Color.BLACK);
  prestage.setScene(scene);
  prestage.show();
  player.play();
  player.setOnReady(new Runnable(){
    public void run(){
      int w=player.getMedia().getWidth();
      int h=player.getMedia().getHeight();
      prestage.setMinWidth(w);
      prestage.setMinHeight(h);
      vbox.setMinSize(w,100);
      vbox.setTranslateY(h-100);
      slider.setMin(0.0);
      slider.setValue(0.0);
      slider.setMax(player.getTotalDuration().toSeconds());
    }
  });
  player.currentTimeProperty().addListener(new ChangeListener<Duration>(){
    public void changed(ObservableValue<? extends Duration> observableValue,Duration old,Duration current){
       slider.setValue(current.toSeconds());
    }
  });
}

}

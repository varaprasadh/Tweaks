import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class javafx3 extends Application{
	Button b;
  public static void main(String[] a){
  	launch();
  }
  @Override
  public void start(Stage primaryStage) throws Exception{
   primaryStage.setTitle("javafx-1");
   b=new Button("click me");
   b.setOnAction(new EventHandler<ActionEvent>(){

    public void handle(ActionEvent ae){
  	if(ae.getSource()==b){
  	System.out.println("just clicked");}
  }



   });
   StackPane layout=new StackPane();
   layout.getChildren().add(b);
   Scene scene=new Scene(layout,500,500);
   primaryStage.setScene(scene);
   primaryStage.show();

  }
 

}
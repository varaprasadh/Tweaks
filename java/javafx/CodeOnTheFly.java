import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class CodeOnTheFly extends Application{
	Button b;
	public static void main(String args[]){
		launch(args);
	}
	public void start(Stage prestage) throws Exception{
        // b=new Button("cskdcnsdlcs");
         //b.se
	    Object layout =new StackPane().getChildren().add(new Button("hooo"));
		prestage.setScene(new Scene(layout,400,400));
		prestage.setTitle("hooohha");
	

	}
}
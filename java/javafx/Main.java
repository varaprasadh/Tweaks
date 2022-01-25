

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class Alerter {
    Button b;
    Label l;


    public void display(String title,String message){
        b=new Button("close");
        b.setOnAction(e->window1.close());
        l=new Label(message);
        Stage window1=new Stage();
        window1.initModality(Modality.APPLICATION_MODAL);
        StackPane sp=new StackPane();
        sp.getChildren().addAll(b,l);
        Scene s=new Scene(sp,300,300);
        window1.setScene(s);
        window1.SetTitle(title);
        window1.show();
    }
}


public class Main extends Application {
     Button b;
     Label l1;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);

      }
      public void start(Stage prestage) throws Exception{
        b=new Button("click me boss!");
        l1=new Label("alert box ..");
        b.setOnAction(e->Alerter.Display("app","this is message"));
        StackPane sp=new StackPane();
        sp.getChildren().addAll(b,l1);
        Scene s=new Scene(sp,500,500);
        prestage.setScene(s);
        prestage.show();
      }
}

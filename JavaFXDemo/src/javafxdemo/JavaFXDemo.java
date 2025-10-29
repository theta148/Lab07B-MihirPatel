/* https://github.com/theta148/Lab07B-MihirPatel
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javafxdemo;

import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author 6316704
 */
public class JavaFXDemo extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }
   
    @Override
    public void start(Stage primaryStage) {
        Random random = new Random();
        int min = 101;
        int max = 120;
        
        int num = random.nextInt(min, max + 1);
        
        primaryStage.setTitle("Java Games");
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 250, 300);
        
        StackPane middle = new StackPane();
        Label top = new Label("Random Game");
        //Label bottom = new Label("Waiting..");
        Label lblimage = new Label();
        Button playOrPauseBtn = new Button("Play");
        Button speedUpBtn = new Button("Speed+");
        Button slowDownBtn = new Button("Speed-");
        
        HBox hb = new HBox(10, playOrPauseBtn, speedUpBtn, slowDownBtn);
        
        Image img = new Image("file:images/" + num + ".jpg");
       
        
        
        lblimage.setGraphic(new ImageView(img));
        
        root.setTop(top);
        root.setBottom(hb);
        middle.getChildren().add(lblimage);
        root.setCenter(middle);
        
        primaryStage.setScene(scene);
        primaryStage.show(); 
    }
}

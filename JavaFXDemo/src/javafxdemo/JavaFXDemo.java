/* https://github.com/theta148/Lab07B-MihirPatel
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javafxdemo;

import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
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
import javafx.util.Duration;

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
        primaryStage.setTitle("Java Games");
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 250, 300);
        
        StackPane middle = new StackPane();
        Label top = new Label("Random Game");
        Label lblImage = new Label();
        Button playOrPauseBtn = new Button("Play");
        Button speedUpBtn = new Button("Speed+");
        Button slowDownBtn = new Button("Speed-");
        
        HBox hb = new HBox(10, playOrPauseBtn, speedUpBtn, slowDownBtn);
        
        Image[] imgs = new Image[20];
        for (int i = 0; i < 20; i++) {
            String path = String.format("file:images/" + (i + 101) + ".jpg");
            imgs[i] = new Image(path); 
            lblImage.setGraphic(new ImageView(imgs[i]));
        }
        
        SequentialTransition st = new SequentialTransition();
        
        for (int i = 0; i < 20; i++) {
            int idx = i;
            
            FadeTransition ft = new FadeTransition(Duration.millis(2000), lblImage);
            lblImage.setGraphic(new ImageView(imgs[idx]));
            ft.setOnFinished(e -> {
                lblImage.setGraphic(new ImageView(imgs[idx + 1]));
            });
            
            st.getChildren().addAll(ft);
        }
        
        st.setCycleCount(Timeline.INDEFINITE);
        
        playOrPauseBtn.setOnAction(e -> {
            if () {
                st.play();
                playOrPauseBtn = new Button("Pause");
            } else {
                st.pause();
                playOrPauseBtn = new Button("Play");
            }
            
        });
         
        speedUpBtn.setOnAction(e -> {
            st.setRate(1.01);
        });
        
        slowDownBtn.setOnAction(e -> {
            st.setRate(0.99);
        });
        
        root.setTop(top);
        root.setBottom(hb);
        middle.getChildren().add(lblImage);
        root.setCenter(middle);
        
        primaryStage.setScene(scene);
        primaryStage.show(); 
    }
}

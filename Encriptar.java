
package encriptacion;

import java.util.Base64;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Encriptar extends Application {
    
    @Override
    public void start(Stage primaryStage)
    {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Scene scene = new Scene(grid, 400, 400);

        Label lb = new Label("PALABRA");
        grid.add(lb, 0, 1);
        
        TextField numero = new TextField();
        grid.add(numero, 1, 1);
        
        
        Button btn = new Button("Encriptar");
        grid.add(btn, 1, 2);
        
        Button de = new Button("Desincriptar");
        grid.add(de, 1, 3);
        
        Label resultado = new Label();
        grid.add(resultado, 2, 1);

        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event)
            {
                byte[] palabra = numero.getText().getBytes();
                String palabraEncriptada = Base64.getEncoder().encodeToString(palabra);
                resultado.setText(palabraEncriptada);  
            }            
        });
        de.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event)
            {
                Base64.Decoder decoder = Base64.getDecoder();
                String a = resultado.getText();
                byte[] decodedByteArray = decoder.decode(a);
        
                String b = new String(decodedByteArray); 
                resultado.setText(b);
            }            
        });
        primaryStage.setTitle("xxxxxxxx");
        primaryStage.setScene(scene);
        primaryStage.show(); 
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
    
}

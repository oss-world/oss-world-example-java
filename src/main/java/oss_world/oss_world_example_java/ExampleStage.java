/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oss_world.oss_world_example_java;

import java.util.Map;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import oss_world.api;

/**
 *
 * @author daniel
 */
public class ExampleStage extends Stage {
    
    private Map config;
    
    public ExampleStage() {
        config = api.getConfig(Core.id);
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(10);
        pane.setHgap(10);
        
        Label lbl = new Label("Config Value: ");
        pane.add(lbl, 0, 0, 1, 1);
        final TextField field = new TextField();
        if (config.containsKey("val")) {
            field.setText(config.get("val").toString()); // This will be a string anyway
        }
        pane.add(field, 1, 0, 1, 1);
        
        Button setBtn = new Button("Set config value");
        setBtn.setOnAction((ActionEvent event) -> {
            config.put("val", field.getText());
            api.addRecentActivity(ExampleStage.class.getResource("/oss_world_example_java/activity.png").toString(),
                    "Config value set to: " + field.getText());
        });
        pane.add(setBtn, 0, 1, 1, 1);
        
        Button closeBtn = new Button("Close");
        closeBtn.setOnAction((ActionEvent event) -> {
            ExampleStage.this.hide();
            api.setStageVisibility(true);
        });
        pane.add(closeBtn, 1, 1, 1, 1);
                
        Scene scene = new Scene(pane);
        scene.setRoot(pane);
        // Every stage should have main.css in its list of stylesheets
        scene.getStylesheets().add("main.css");
        this.setScene(scene);
        this.setTitle("Example Activity");
        
        this.setOnHiding((WindowEvent event) -> {
            api.saveConfig(Core.id, config);
        });
        
        this.show();
    }
    
}

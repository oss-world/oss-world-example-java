/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oss_world.oss_world_example_java;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import oss_world.api;

/**
 *
 * @author daniel
 */
public class Core {
    
    public static final String id = "oss_world_example_java";
    
    private static final Runnable startActivity = new Runnable() {

                                                    @Override
                                                    public void run() {
                                                        System.out.println("Starting example activity.");
                                                        int x = 3;
                                                        System.out.println("Created x");
                                                        Stage stage = new ExampleStage();
                                                        System.out.println("Stage shown");
                                                        api.setStageVisibility(false);
                                                        System.out.println("Starting example2 activity.");
                                                    }};
                                                
    
    public static void entry() {
        Image img = new Image(Core.class.getResource("/oss_world_example_java/icon.png").toString());
        api.addActivity("oss_world_example_java_activity", img, "Example Activity",
                () -> Platform.runLater(startActivity));
    }   
}

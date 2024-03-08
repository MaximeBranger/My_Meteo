package com.example.my_meteo.Controller;

import com.example.my_meteo.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.Desktop;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class CefimController {
    @FXML
    public void returnToMain(ActionEvent event) {
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("landing.fxml"));
            Parent root = loader.load();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void openRepository(ActionEvent event) {
        System.out.println("event");
        try {
            URI uri = new URI("https://gitlab.cefim-formation.org/francois.lg/mymeteo");

            System.out.println("Open");
            Desktop.getDesktop().browse(uri);
        } catch (IOException | URISyntaxException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

}

package com.mdz.application.hotel.controllers;

import com.mdz.application.hotel.App;
import com.mdz.application.hotel.models.Reservacion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.time.LocalDate;
import java.util.ArrayList;

public class ActualizarController {

    @FXML
    private Button actualizarBtn;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Button exitButton;

    @FXML
    private ComboBox<String> habitacionComboBox;

    @FXML
    private TextField idTxt;

    @FXML
    private ComboBox<String> peopleComboBox;

    @FXML
    private ComboBox<String> tipoComboBox;



    @FXML
    void OnMouseClickActualizarBtn(MouseEvent event) {
        ArrayList<Reservacion> Habi = App.getHotel().getReservaciones();
        try{
            String id=idTxt.getText();
            String people = peopleComboBox.getValue();
            int numhabi =   Integer.parseInt(habitacionComboBox.getValue());
            String tipo = tipoComboBox.getValue();
            LocalDate date = datePicker.getValue();

            Reservacion habitaciones = new Reservacion(date,id,numhabi);
            for (int i = 0; i < Habi.size(); i++) {
                if (Habi.get(i).getId().equals(id)){
                    App.getHotel().getReservaciones().set(i,habitaciones);
                }

            }
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Notificación");
            alert.setContentText("Se ha actualizado correctamente");
            alert.showAndWait();
        }catch (Exception e) {
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Notificación");
            alert.setContentText("Complete correctamente los datos");
            alert.showAndWait();
        }

    }

    @FXML
    void onClickExitButton(MouseEvent event) {
    }

    @FXML
    void tipoSelectedComboBox(ActionEvent event) {
    }
    public void initialize(){
        ObservableList<String> list = FXCollections.observableArrayList("Individual", "Doble",  "Suite");
        ObservableList<String> people = FXCollections.observableArrayList("1", "2",  "3","4", "5");
        ObservableList<String> numhabi = FXCollections.observableArrayList("101", "104",  "110","202", "220", "250", "404", "401", "408");
        tipoComboBox.setItems(list);
        peopleComboBox.setItems(people);
        habitacionComboBox.setItems(numhabi);
    }

}

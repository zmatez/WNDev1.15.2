package net.matez.pokeUniverseBiomeBuilder;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.*;
import net.matez.pokeUniverseBiomeBuilder.sponge.module.source.Perlin;

import javax.tools.Tool;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

import static net.matez.pokeUniverseBiomeBuilder.Controller.rint;

public class FXUtils {
    public static void fieldOnlyInteger(JFXTextField field) {
        field.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()) {
                try {
                    int i = Integer.parseInt(newValue);
                } catch (NumberFormatException e) {
                    field.setText(oldValue);
                    Alert alert = new Alert(Alert.AlertType.ERROR, "This field can contain only integers!");
                    alert.showAndWait();
                }
            }
        });
        Tooltip tt = new Tooltip();
        tt.setText("Accepts only integers");
        field.setTooltip(tt);
    }

    public static void fieldOnlyDouble(JFXTextField field) {
        field.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()) {
                try {
                    double i = Double.parseDouble(newValue);
                } catch (NumberFormatException e) {
                    field.setText(oldValue);
                    Alert alert = new Alert(Alert.AlertType.ERROR, "This field can contain only floats!");
                    alert.showAndWait();
                }
            }
        });
        Tooltip tt = new Tooltip();
        tt.setText("Accepts only floats");
        field.setTooltip(tt);
    }

    public static void cannotToggleTwoAtOnce(JFXToggleButton button1, JFXToggleButton button2) {
        button1.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue && button2.isSelected()) {
                button2.setSelected(false);

            }
        });
        button2.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue && button1.isSelected()) {
                button1.setSelected(false);

            }
        });
    }

    public static void firstHaveToBeToggled(JFXToggleButton button, JFXToggleButton toggled) {
        button.setSelected(toggled.isSelected());
        toggled.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                button.setSelected(true);
            }
        });
        button.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                toggled.setSelected(false);
            }
        });
    }

    public static void disableNode(JFXToggleButton toggle, Node node) {
        node.setDisable(!toggle.isSelected());
        toggle.selectedProperty().addListener((observable, oldValue, newValue) -> {
            node.setDisable(!newValue);
        });
    }

    public static void treeStructures(Structures s, boolean onlyTrees, JFXListView<String> treeList, JFXListView<String> selectedTreeList, JFXTextField searchBar) {
        treeList.getItems().clear();

        for (String structure : s.structures) {
            if (onlyTrees) {
                if (structure.contains("trees/")) {
                    if (searchBar.getText().isEmpty()) {
                        treeList.getItems().add(structure);
                    } else {
                        if (structure.contains(searchBar.getText())) {
                            treeList.getItems().add(structure);
                        }
                    }
                }
            } else {
                if (searchBar.getText().isEmpty()) {
                    treeList.getItems().add(structure);
                } else {
                    if (structure.contains(searchBar.getText())) {
                        treeList.getItems().add(structure);
                    }
                }
            }
        }
        treeList.setCellFactory(cell -> {
            ListCell<String> list = new ListCell<String>() {
                Tooltip t = new Tooltip();

                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    t.setText(item);
                    setText(item);
                    setTooltip(t);
                }

                @Override
                public void updateIndex(int i) {
                    super.updateIndex(i);
                    if(FXUtils.contains(selectedTreeList,getItem())!=-1){
                        setStyle("-fx-font-weight: bold");
                    }else{
                        setStyle("-fx-font-weight: normal");
                        treeList.refresh();
                    }
                }
            };
            list.setOnMouseClicked(event -> {
                String add = list.getItem();
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Add tree");
                dialog.setHeaderText("What weight should have " + add + "? Bigger = more common (from the whole list)");
                dialog.setContentText("Enter weight integer:");
                Optional<String> result = dialog.showAndWait();
                int weight = 0;
                if (result.isPresent()) {
                    try {
                        weight = Integer.parseInt(result.get());
                        if (weight <= 0) {
                            Alert alert = new Alert(Alert.AlertType.ERROR, "Choose positive value, normally it is from 1 to 10");
                            alert.showAndWait();
                        }
                    } catch (NumberFormatException e) {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "This field can contain only integers! Try again...");
                        alert.showAndWait();
                    }
                }
                if (weight > 0) {
                    int contains = FXUtils.contains(selectedTreeList,add);
                    if(contains!=-1){
                        Alert alert = new Alert(Alert.AlertType.ERROR, "That ID already is added to the list.\nDo you want to join these values?");
                        alert.getButtonTypes().clear();
                        alert.getButtonTypes().add(new ButtonType("Join them"));
                        alert.getButtonTypes().add(new ButtonType("Cancel"));
                        alert.showAndWait();
                        if(alert.getResult().getText().equals("Join them")){
                            String oldValue = selectedTreeList.getItems().get(contains);
                            selectedTreeList.getItems().remove(oldValue);
                            selectedTreeList.getItems().add(contains, add + " x " + (weight+Integer.parseInt(oldValue.substring(oldValue.indexOf(" x "),oldValue.length()).replace(" x ",""))));
                            list.updateIndex(treeList.getItems().indexOf(add));
                        }else{

                        }

                    }else {
                        System.out.println("adding " + add);
                        selectedTreeList.getItems().add(add + " x " + weight);
                        list.updateIndex(treeList.getItems().indexOf(add));
                    }
                }
                treeList.getSelectionModel().clearSelection();
                
            });

            return list;
        });

        selectedTreeList.setCellFactory(cell -> {
            ListCell<String> list = new ListCell<String>() {
                Tooltip t = new Tooltip();

                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    t.setText(item);
                    setText(item);
                    setTooltip(t);
                }
            };
            list.setOnMouseClicked(event -> {
                String sel = list.getItem();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "What to do with selected value \"" + sel + "\"?");
                alert.getButtonTypes().clear();
                alert.getButtonTypes().add(new ButtonType("Edit"));
                alert.getButtonTypes().add(new ButtonType("Delete"));
                alert.getButtonTypes().add(new ButtonType("Cancel"));
                alert.showAndWait();
                if (alert.getResult().getText().equals("Edit")) {
                    TextInputDialog dialog = new TextInputDialog();
                    dialog.setTitle("Edit tree");
                    dialog.setHeaderText("What weight should have " + sel.substring(0, sel.indexOf(" x ")) + "? Bigger = more common (from the whole list)");
                    dialog.setContentText("Enter weight integer:");
                    Optional<String> result = dialog.showAndWait();
                    int weight = 0;
                    if (result.isPresent()) {
                        try {
                            weight = Integer.parseInt(result.get());
                            if (weight <= 0) {
                                Alert alert2 = new Alert(Alert.AlertType.ERROR, "Choose positive value, normally it is from 1 to 10");
                                alert2.showAndWait();
                            }
                        } catch (NumberFormatException e) {
                            Alert alert2 = new Alert(Alert.AlertType.ERROR, "This field can contain only integers! Try again...");
                            alert2.showAndWait();
                        }
                    }
                    if (weight > 0) {
                        int index = selectedTreeList.getItems().indexOf(sel);
                        selectedTreeList.getItems().remove(sel);
                        selectedTreeList.getItems().add(index, sel.substring(0, sel.indexOf(" x ")) + " x " + weight);
                    }
                } else if (alert.getResult().getText().equals("Delete")) {
                    selectedTreeList.getItems().remove(sel);
                    treeList.getCellFactory().call(treeList).updateIndex(treeList.getItems().indexOf(sel.substring(0,sel.indexOf(" x "))));
                } else {

                }
                selectedTreeList.getSelectionModel().clearSelection();
                
            });

            return list;
        });
    }

    public static void ambientStructures(Structures s, JFXListView<String> ambientList, JFXListView<String> selectedAmbientList, JFXTextField searchBar) {
        ambientList.getItems().clear();
        for (String structure : s.structures) {
            if (searchBar.getText().isEmpty()) {
                ambientList.getItems().add(structure);
            } else {
                if (structure.contains(searchBar.getText())) {
                    ambientList.getItems().add(structure);
                }
            }
        }
        ambientList.setCellFactory(cell -> {
            ListCell<String> list = new ListCell<String>() {
                Tooltip t = new Tooltip();

                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    t.setText(item);
                    setText(item);
                    setTooltip(t);
                }

                @Override
                public void updateIndex(int i) {
                    super.updateIndex(i);
                    if(FXUtils.contains(selectedAmbientList,getItem())!=-1){
                        setStyle("-fx-font-weight: bold");
                    }else{
                        setStyle("-fx-font-weight: normal");
                        ambientList.refresh();
                    }
                }
            };
            list.setOnMouseClicked(event -> {
                String add = list.getItem();
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Add structure");
                dialog.setHeaderText("What weight should have " + add + "? Bigger = more common (from the whole list)");
                dialog.setContentText("Enter weight integer:");
                Optional<String> result = dialog.showAndWait();
                int weight = 0;
                if (result.isPresent()) {
                    try {
                        weight = Integer.parseInt(result.get());
                        if (weight <= 0) {
                            Alert alert = new Alert(Alert.AlertType.ERROR, "Choose positive value, normally it is from 1 to 10");
                            alert.showAndWait();
                        }
                    } catch (NumberFormatException e) {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "This field can contain only integers! Try again...");
                        alert.showAndWait();
                    }
                }
                if (weight > 0) {
                    int contains = FXUtils.contains(selectedAmbientList,add);
                    if(contains!=-1){
                        Alert alert = new Alert(Alert.AlertType.ERROR, "That ID already is added to the list.\nDo you want to join these values?");
                        alert.getButtonTypes().clear();
                        alert.getButtonTypes().add(new ButtonType("Join them"));
                        alert.getButtonTypes().add(new ButtonType("Cancel"));
                        alert.showAndWait();
                        if(alert.getResult().getText().equals("Join them")){
                            String oldValue = selectedAmbientList.getItems().get(contains);
                            selectedAmbientList.getItems().remove(oldValue);
                            selectedAmbientList.getItems().add(contains, add + " x " + (weight+Integer.parseInt(oldValue.substring(oldValue.indexOf(" x "),oldValue.length()).replace(" x ",""))));
                            list.updateIndex(ambientList.getItems().indexOf(add));

                        }else{

                        }

                    }else {
                        selectedAmbientList.getItems().add(add + " x " + weight);
                        list.updateIndex(ambientList.getItems().indexOf(add));

                    }
                }
                ambientList.getSelectionModel().clearSelection();
                
            });

            return list;
        });

        selectedAmbientList.setCellFactory(cell -> {
            ListCell<String> list = new ListCell<String>() {
                Tooltip t = new Tooltip();

                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    t.setText(item);
                    setText(item);
                    setTooltip(t);
                }
            };
            list.setOnMouseClicked(event -> {
                String sel = list.getItem();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "What to do with selected value \"" + sel + "\"?");
                alert.getButtonTypes().clear();
                alert.getButtonTypes().add(new ButtonType("Edit"));
                alert.getButtonTypes().add(new ButtonType("Delete"));
                alert.getButtonTypes().add(new ButtonType("Cancel"));
                alert.showAndWait();
                if (alert.getResult().getText().equals("Edit")) {
                    TextInputDialog dialog = new TextInputDialog();
                    dialog.setTitle("Edit structure");
                    dialog.setHeaderText("What weight should have " + sel.substring(0, sel.indexOf(" x ")) + "? Bigger = more common (from the whole list)");
                    dialog.setContentText("Enter weight integer:");
                    Optional<String> result = dialog.showAndWait();
                    int weight = 0;
                    if (result.isPresent()) {
                        try {
                            weight = Integer.parseInt(result.get());
                            if (weight <= 0) {
                                Alert alert2 = new Alert(Alert.AlertType.ERROR, "Choose positive value, normally it is from 1 to 10");
                                alert2.showAndWait();
                            }
                        } catch (NumberFormatException e) {
                            Alert alert2 = new Alert(Alert.AlertType.ERROR, "This field can contain only integers! Try again...");
                            alert2.showAndWait();
                        }
                    }
                    if (weight > 0) {
                        int index = selectedAmbientList.getItems().indexOf(sel);
                        selectedAmbientList.getItems().remove(sel);
                        selectedAmbientList.getItems().add(index, sel.substring(0, sel.indexOf(" x ")) + " x " + weight);
                    }
                } else if (alert.getResult().getText().equals("Delete")) {
                    selectedAmbientList.getItems().remove(sel);
                    ambientList.getCellFactory().call(ambientList).updateIndex(ambientList.getItems().indexOf(sel.substring(0,sel.indexOf(" x "))));
                } else {

                }
                selectedAmbientList.getSelectionModel().clearSelection();
                
            });

            return list;
        });
    }

    public static void flowerList(JFXListView<String> selectedFlowerList) {
        selectedFlowerList.setCellFactory(cell -> {
            ListCell<String> list = new ListCell<String>() {
                Tooltip t = new Tooltip();

                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    t.setText(item);
                    setText(item);
                    setTooltip(t);
                }
            };
            list.setOnMouseClicked(event -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "What to do with selected value \"" + list.getItem() + "\"?");
                alert.getButtonTypes().clear();
                alert.getButtonTypes().add(new ButtonType("Edit"));
                alert.getButtonTypes().add(new ButtonType("Delete"));
                alert.getButtonTypes().add(new ButtonType("Cancel"));
                alert.showAndWait();
                if (alert.getResult().getText().equals("Edit")) {
                    TextInputDialog dialog = new TextInputDialog();
                    dialog.setTitle("Edit plant");
                    dialog.setHeaderText("What weight should have " + list.getItem().substring(0, list.getItem().indexOf(" x ")) + "? Bigger = more common (from the whole list)");
                    dialog.setContentText("Enter weight integer:");
                    Optional<String> result = dialog.showAndWait();
                    int weight = 0;
                    if (result.isPresent()) {
                        try {
                            weight = Integer.parseInt(result.get());
                            if (weight <= 0) {
                                Alert alert2 = new Alert(Alert.AlertType.ERROR, "Choose positive value, normally it is from 1 to 10");
                                alert2.showAndWait();
                            }
                        } catch (NumberFormatException e) {
                            Alert alert2 = new Alert(Alert.AlertType.ERROR, "This field can contain only integers! Try again...");
                            alert2.showAndWait();
                        }
                    }
                    if (weight > 0) {
                        int index = selectedFlowerList.getItems().indexOf(list.getItem());
                        String old = list.getItem();
                        selectedFlowerList.getItems().remove(list.getItem());
                        selectedFlowerList.getItems().add(index, old.substring(0, old.indexOf(" x ")) + " x " + weight);
                    }
                } else if (alert.getResult().getText().equals("Delete")) {
                    selectedFlowerList.getItems().remove(list.getItem());
                } else {

                }
                selectedFlowerList.getSelectionModel().clearSelection();
                

            });

            return list;
        });
    }

    public static int contains(JFXListView<String> listView, String containing){
        int i = 0;
        for (String item : listView.getItems()) {
            try {
                if (item.substring(0, item.indexOf(" x ")).equals(containing)) {
                    return i;
                }
            }catch (Exception e){
                return -1;
            }
            i++;
        }
        return -1;
    }

    public static String[] deobfuscate(JFXTextField field){
        String type = field.getText().substring(0, field.getText().indexOf("$"));
        String chance = field.getText().substring(field.getText().indexOf("$")+1, field.getText().lastIndexOf("$"));
        String id = field.getText().substring(field.getText().lastIndexOf("$")+1, field.getText().length());
        return new String[]{type,chance,id};
    }

    public static ArrayList<Integer[]> drawCircle(int x, int y, int r) {
        ArrayList<Integer[]> pos = new ArrayList<>();
        double PI = Math.PI;
        double i, angle, x1, y1;

        for (i = 0; i < 360; i += 1) {
            angle = i;
            x1 = r * Math.cos(angle * PI / 180);
            y1 = r * Math.sin(angle * PI / 180);

            int ElX = (int) Math.round(x + x1);
            int ElY = (int) Math.round(y + y1);
            pos.add(new Integer[]{ElX,ElY});
        }
        return pos;
    }
    public static ArrayList<Integer[]> getBlocksInMutable(int x1, int y1, int x2, int y2){
        ArrayList<Integer[]> integers = new ArrayList<>();
        int validX1 = Math.min(x1, x2);
        int validX2 = Math.max(x1, x2);
        int validY1 = Math.min(y1, y2);
        int validY2 = Math.max(y1, y2);
        for(int x = validX1; x < validX2; x++){
            for(int y = validY1; y < validY2; y++){
                integers.add(new Integer[]{x,y});
            }
        }
        return integers;
    }

    public static ArrayList<String> importArray(String array){
        try {
            return new ArrayList<>(Arrays.asList(array.split(";")));
        }catch (Exception e){
            System.out.println("Cannot import array");
        }
        return new ArrayList<>();
    }

    public static String exportArray(ObservableList<String> array){
        String s = "";
        for (String s1 : array) {
            if(s.isEmpty()){
                s = s1;
            }else{
                s = s + ";"+ s1;
            }
        }
        s = s + ";";
        return s;
    }


}

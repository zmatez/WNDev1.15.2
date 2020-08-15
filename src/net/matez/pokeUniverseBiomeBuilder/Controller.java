package net.matez.pokeUniverseBiomeBuilder;

import com.jfoenix.controls.*;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import net.matez.pokeUniverseBiomeBuilder.sponge.module.source.Perlin;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;


public class Controller {
    @FXML
    protected Pane root;
    @FXML
    protected Pane tab1;
    @FXML
    protected Pane tab2;
    @FXML
    protected Pane tab3;
    @FXML
    protected Pane tab4;
    @FXML
    protected Pane tab5;
    @FXML
    protected Pane tab6;
    @FXML
    protected Pane tab7;
    @FXML
    protected Pane tab8;

    @FXML
    protected ImageView imageTop;
    @FXML
    protected ImageView imageBottom;
    @FXML
    protected JFXButton button_seed;
    @FXML
    protected JFXButton button_update;
    @FXML
    protected JFXTextField field_size;
    @FXML
    protected JFXTextField field_seed;

    //Terrain Properties
    @FXML
    protected JFXTextField field_baseHeight;
    @FXML
    protected JFXTextField field_heightVariation;

    //Temperature and Rain
    @FXML
    protected JFXTextField field_rainfall;
    @FXML
    protected JFXTextField field_temperature;
    @FXML
    protected JFXToggleButton toggle_rain;
    @FXML
    protected JFXToggleButton toggle_snow;

    //Colors
    @FXML
    protected JFXColorPicker color_grass1;
    @FXML
    protected JFXToggleButton toggle_grassColor1;
    @FXML
    protected JFXColorPicker color_grass2;
    @FXML
    protected JFXToggleButton toggle_grassColor2;
    @FXML
    protected JFXColorPicker color_foliage1;
    @FXML
    protected JFXToggleButton toggle_foliageColor1;
    @FXML
    protected JFXColorPicker color_foliage2;
    @FXML
    protected JFXToggleButton toggle_foliageColor2;
    @FXML
    protected JFXColorPicker color_sky;
    @FXML
    protected JFXToggleButton toggle_skyColor;
    @FXML
    protected JFXColorPicker color_water;
    @FXML
    protected JFXToggleButton toggle_waterColor;

    //Decorator Settings
    @FXML
    protected JFXTextField field_waterLily;
    @FXML
    protected JFXTextField field_cacti;
    @FXML
    protected JFXTextField field_gravel;
    @FXML
    protected JFXTextField field_sand;
    @FXML
    protected JFXTextField field_clay;
    @FXML
    protected JFXTextArea area_devComment;
    @FXML
    protected JFXToggleButton toggle_generateFalls;

    @FXML
    protected JFXTextField field_topSurfaceBlock1;
    @FXML
    protected JFXTextField field_topSurfaceBlock2;
    @FXML
    protected JFXTextField field_topSurfaceBlock3;
    @FXML
    protected JFXTextField field_fillerBlock;
    @FXML
    protected JFXTextField field_underwaterBlock;

    //Trees
    @FXML
    protected JFXTextField field_treesPerChunk;
    @FXML
    protected JFXTextField field_treeExtra;
    @FXML
    protected JFXListView<String> list_trees;
    @FXML
    protected JFXTextField field_treeSearch;
    @FXML
    protected JFXToggleButton toggle_treeIndexFolder;
    @FXML
    protected JFXListView<String> list_selTrees;

    //Plants
    @FXML
    protected JFXTextField field_grassPerChunk;
    @FXML
    protected JFXTextField field_flowersPerChunk;
    @FXML
    protected JFXTextField field_grassId;
    @FXML
    protected JFXListView<String> list_selFlowers;
    @FXML
    protected JFXTextField field_flowerId;
    @FXML
    protected JFXTextField field_flowerWeight;
    @FXML
    protected JFXButton button_addFlower;

    //Ambient Structures
    @FXML
    protected JFXListView<String> list_structures;
    @FXML
    protected JFXTextField field_ambientSearch;
    @FXML
    protected JFXListView<String> list_selStructures;
    @FXML
    protected JFXTextField field_structureRarity;
    @FXML
    protected JFXTextField field_structureExtra;

    //Build
    @FXML
    protected JFXTextField field_biomeId;
    @FXML
    protected JFXListView<String> list_biomeDictionary;
    @FXML
    protected JFXTextField field_biomeWeight;
    @FXML
    protected JFXTextField field_parentBiome;
    @FXML
    protected JFXButton button_generate;

    @FXML
    protected JFXButton button_import;
    @FXML
    protected JFXButton button_export;

    //App
    protected Structures structures = new Structures();
    protected BufferedImage readerTop, readerBottom;
    protected Perlin surfaceNoise = new Perlin();
    protected int seed = 0;
    protected VWorld vWorldSurface, vWorldMountain;
    protected int size = 5;
    protected Tooltip imageTooltipTop, imageTooltipBottom;
    @FXML
    protected void initialize(){
        vWorldSurface=new VWorld((int)imageTop.getFitWidth()/size,(int)imageTop.getFitHeight()/size);
        vWorldMountain=new VWorld((int)imageBottom.getFitWidth()/size,(int)imageBottom.getFitHeight()/size);
        //KNOWN BLOCKS
        new Block("minecraft:air",new Color(255, 255, 255));
        new Block("minecraft:grass_block",new Color(65, 177, 45));
        new Block("minecraft:dirt",new Color(95, 44, 12));
        new Block("minecraft:coarse_dirt",new Color(107, 56, 11));
        new Block("minecraft:gravel",new Color(151, 151, 163));
        new Block("minecraft:stone",new Color(91, 91, 98));
        new Block("minecraft:sand",new Color(217, 216, 126));
        new Block("minecraft:sandstone",new Color(185, 184, 107));
        new Block("minecraft:water",new Color(47, 71, 163));
        new Block("minecraft:clay",new Color(226, 225, 218));
        new Block("minecraft:netherrack",new Color(156, 4, 0));
        new Block("minecraft:lava",new Color(217, 113, 7));
        new Block("minecraft:podzol",new Color(69, 35, 6));



        FXUtils.fieldOnlyDouble(field_baseHeight);
        FXUtils.fieldOnlyDouble(field_heightVariation);
        FXUtils.fieldOnlyDouble(field_temperature);
        FXUtils.fieldOnlyDouble(field_rainfall);
        FXUtils.fieldOnlyInteger(field_waterLily);
        FXUtils.fieldOnlyInteger(field_cacti);
        FXUtils.fieldOnlyInteger(field_gravel);
        FXUtils.fieldOnlyInteger(field_sand);
        FXUtils.fieldOnlyInteger(field_clay);
        FXUtils.fieldOnlyInteger(field_treesPerChunk);
        FXUtils.fieldOnlyDouble(field_treeExtra);
        FXUtils.fieldOnlyInteger(field_grassPerChunk);
        FXUtils.fieldOnlyInteger(field_waterLily);
        FXUtils.fieldOnlyInteger(field_flowersPerChunk);
        FXUtils.fieldOnlyInteger(field_flowerWeight);
        FXUtils.fieldOnlyInteger(field_structureRarity);
        FXUtils.fieldOnlyInteger(field_structureExtra);
        FXUtils.fieldOnlyInteger(field_biomeWeight);
        FXUtils.fieldOnlyInteger(field_seed);
        FXUtils.fieldOnlyInteger(field_size);

        FXUtils.cannotToggleTwoAtOnce(toggle_rain,toggle_snow);


        FXUtils.disableNode(toggle_grassColor1,color_grass1);
        FXUtils.disableNode(toggle_grassColor2,color_grass2);
        FXUtils.disableNode(toggle_foliageColor1,color_foliage1);
        FXUtils.disableNode(toggle_foliageColor2,color_foliage2);
        FXUtils.disableNode(toggle_skyColor,color_sky);
        FXUtils.disableNode(toggle_waterColor,color_water);
        FXUtils.firstHaveToBeToggled(toggle_grassColor1,toggle_grassColor2);
        FXUtils.firstHaveToBeToggled(toggle_foliageColor1,toggle_foliageColor2);

        FXUtils.treeStructures(structures,toggle_treeIndexFolder.isSelected(),list_trees,list_selTrees,field_treeSearch);
        FXUtils.ambientStructures(structures,list_structures,list_selStructures,field_ambientSearch);

        FXUtils.flowerList(list_selFlowers);
        toggle_treeIndexFolder.selectedProperty().addListener(((observable, oldValue, newValue) -> {
            FXUtils.treeStructures(structures,newValue,list_trees,list_selTrees,field_treeSearch);
        }));
        field_treeSearch.textProperty().addListener(((observable, oldValue, newValue) -> {
            FXUtils.treeStructures(structures,toggle_treeIndexFolder.isSelected(),list_trees,list_selTrees,field_treeSearch);
        }));
        field_ambientSearch.textProperty().addListener(((observable, oldValue, newValue) -> {
            FXUtils.ambientStructures(structures,list_structures,list_selStructures,field_ambientSearch);
        }));

        list_trees.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        list_selTrees.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        button_update.setOnAction(event -> {
            button_update.setDisable(true);
            updateVisualization(size);
        });
        button_seed.setOnAction(event -> {
            seed = new Random().nextInt();
            field_seed.setText(seed+"");
        });

        field_seed.textProperty().addListener((observable, oldValue, newValue) -> {
            try{
                seed = Integer.parseInt(newValue);
            }catch (Exception e){

            }
        });

        field_size.textProperty().addListener((observable, oldValue, newValue) -> {
            try{
                size = Integer.parseInt(newValue);
            }catch (Exception e){

            }
        });

        button_import.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Import .biome file. All current settings will be overrided.");
            alert.showAndWait();
            if(alert.getResult().getText().equals("OK")){
                FileChooser fileChooser = new FileChooser();

                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("Biome Files", "*.biome")
                );
                File file = fileChooser.showOpenDialog(new Stage());
                if(file!=null){
                    try {
                        importBiome(file, "");
                    }catch (Exception e){
                        Alert aa = new Alert(Alert.AlertType.ERROR,e.getLocalizedMessage());
                        aa.showAndWait();
                    }
                }
            }
        });
        button_export.setOnAction(event -> {
            if(field_biomeId.getText().isEmpty()){
                Alert aa = new Alert(Alert.AlertType.ERROR,"Please define biome ID");
                aa.showAndWait();
                return;
            }
            DirectoryChooser fileChooser = new DirectoryChooser();

            File file = fileChooser.showDialog(new Stage());
            if(file!=null){
                File f = new File(file.getPath()+"\\"+field_biomeId.getText()+".biome");
                String export = exportBiome();
                if(export==null){
                    return;
                }
                try {
                    FileWriter fileWriter = new FileWriter(f);
                    PrintWriter printWriter = new PrintWriter(fileWriter);
                    printWriter.print(export);
                    printWriter.close();
                }catch (Exception e){

                }
            }
        });


        imageTop.setSmooth(false);

        button_addFlower.setOnAction(event -> {
            if(field_flowerId.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR, "FlowerID field cannot be empty");
                alert.showAndWait();
                return;
            }if(field_flowerWeight.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR, "FlowerWeight field cannot be empty");
                alert.showAndWait();
                return;
            }
            if(!field_flowerId.getText().contains(":")){
                Alert alert = new Alert(Alert.AlertType.ERROR, "FlowerID should contain namespace like \"minecraft:\".");
                alert.showAndWait();
            }
            int contains = FXUtils.contains(list_selFlowers,field_flowerId.getText());
            if(contains!=-1){
                Alert alert = new Alert(Alert.AlertType.ERROR, "FlowerID already is added to the list.\nDo you want to join these values?");
                alert.getButtonTypes().clear();
                alert.getButtonTypes().add(new ButtonType("Join them"));
                alert.getButtonTypes().add(new ButtonType("Cancel"));
                alert.showAndWait();
                if(alert.getResult().getText().equals("Join them")){
                    String oldValue = list_selFlowers.getItems().get(contains);
                    list_selFlowers.getItems().remove(oldValue);
                    list_selFlowers.getItems().add(contains, field_flowerId.getText() + " x " + (Integer.parseInt(field_flowerWeight.getText())+Integer.parseInt(oldValue.substring(oldValue.indexOf(" x "),oldValue.length()).replace(" x ",""))));
                }else{

                }

            }else {
                list_selFlowers.getItems().add(field_flowerId.getText() + " x " + field_flowerWeight.getText());
            }
        });

        list_biomeDictionary.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        for (BiomeDict.Type type : BiomeDict.Type.getAll()) {
            list_biomeDictionary.getItems().add(type.getName());
        }
        list_biomeDictionary.addEventFilter(MouseEvent.MOUSE_PRESSED, evt -> {
            Node node = evt.getPickResult().getIntersectedNode();

            // go up from the target node until a list cell is found or it's clear
            // it was not a cell that was clicked
            while (node != null && node != list_biomeDictionary && !(node instanceof ListCell)) {
                node = node.getParent();
            }

            // if is part of a cell or the cell,
            // handle event instead of using standard handling
            if (node instanceof ListCell) {
                // prevent further handling
                evt.consume();

                ListCell<String> cell = (ListCell<String>) node;
                ListView<String> lv = cell.getListView();

                // focus the listview
                lv.requestFocus();

                if (!cell.isEmpty()) {
                    // handle selection for non-empty cells
                    int index = cell.getIndex();
                    if (cell.isSelected()) {
                        lv.getSelectionModel().clearSelection(index);
                    } else {
                        lv.getSelectionModel().select(index);
                    }
                }
            }
        });

        updateVisualization(size);
    }


    public boolean updateInProgress = false;
    public Thread visualization;
    private String errorMsg = "";
    private double baseHeight = 0;
    private double heightVariation = 0;
    protected void updateVisualization(int size){
        System.out.println("Updating visualization");
        surfaceNoise.setOctaveCount(1);
        surfaceNoise.setFrequency(0.35);
        if(visualization==null || !visualization.isAlive()) {
            System.out.println("Running");

            try{
                baseHeight = Double.parseDouble(field_baseHeight.getText());
                heightVariation = Double.parseDouble(field_heightVariation.getText());
            }catch (Exception e){
                Alert a = new Alert(Alert.AlertType.ERROR,"Cannot parse height or base height to double. Maybe it is empty?");
                a.showAndWait();
                return;
            }

            double imagex = imageTop.getLayoutX();
            double imagey = imageTop.getLayoutY();
            double imagewidth = imageTop.getFitWidth();
            double imageheight = imageTop.getFitHeight();
            double imagex2 = imageBottom.getLayoutX();
            double imagey2 = imageBottom.getLayoutY();
            double imagewidth2 = imageBottom.getFitWidth();
            double imageheight2 = imageBottom.getFitHeight();
            root.getChildren().remove(imageTop);
            root.getChildren().remove(imageBottom);
            imageTop = new PixelatedImageView();
            imageTop.setLayoutX(imagex);
            imageTop.setLayoutY(imagey);
            imageTop.setFitWidth(imagewidth);
            imageTop.setFitHeight(imageheight);
            imageTop.setSmooth(false);
            root.getChildren().add(imageTop);
            imageBottom = new PixelatedImageView();
            imageBottom.setLayoutX(imagex2);
            imageBottom.setLayoutY(imagey2);
            imageBottom.setFitWidth(imagewidth2);
            imageBottom.setFitHeight(imageheight2);
            imageBottom.setSmooth(false);
            root.getChildren().add(imageBottom);
            errorMsg = "";
            visualization = new Thread(new Runnable() {
                @Override
                public void run() {
                    if (!updateInProgress) {
                        readerTop = null;
                        readerBottom=null;
                        vWorldSurface.blocks.clear();
                        vWorldMountain.blocks.clear();
                        imageTop.setImage(null);
                        imageBottom.setImage(null);
                        updateInProgress = true;
                        surfaceNoise.setSeed(seed);
                        Random random = new Random(seed);
                        readerTop = new BufferedImage((int) imageTop.getFitWidth() / size, (int) imageTop.getFitHeight() / size, BufferedImage.TYPE_INT_ARGB);
                        readerBottom = new BufferedImage((int) imageBottom.getFitWidth() / size, (int) imageBottom.getFitHeight() / size, BufferedImage.TYPE_INT_ARGB);

                        ArrayList<VWorld.BlockPosArray> blobs = new ArrayList<>();
                        for (int x = 0; x < imageTop.getFitWidth() / size; x++) {
                            for (int y = 0; y < imageTop.getFitHeight() / size; y++) {
                                Color c = new Color(0, 0, 0);
                                String blockId = field_topSurfaceBlock1.getText();
                                if (!field_topSurfaceBlock1.getText().isEmpty()) {
                                    c = Block.getRandomColor(field_topSurfaceBlock1.getText());
                                }
                                if (!field_topSurfaceBlock2.getText().isEmpty()) {
                                    try {
                                        String[] settings = FXUtils.deobfuscate(field_topSurfaceBlock2);
                                        double iChance = Double.parseDouble(settings[1]);
                                        if (settings[0].equals("random")) {
                                            int canc = Integer.parseInt((iChance + "").replace(".0",""));
                                            if (rint(0, canc, random) == 0) {
                                                c = Block.getRandomColor(settings[2]);
                                                blockId = settings[2];
                                            }
                                        } else if (settings[0].equals("noise")) {
                                            double noise = surfaceNoise.getValue(x, 0, y);
                                            if(noise>iChance){
                                                c = Block.getRandomColor(settings[2]);
                                                blockId = settings[2];
                                            }
                                        }else if (settings[0].equals("blob")) {
                                            int canc = Integer.parseInt((iChance + "").replace(".0",""));
                                            if (rint(0, canc, random) == 0) {
                                                blobs.add(new VWorld.BlockPosArray(new Block(settings[2],Block.getRandomColor(settings[2])),x,y));
                                            }
                                        }
                                    }catch (Exception e){
                                        errorMsg = e.getMessage();
                                        System.out.println(e);
                                        imageTop.setImage(SwingFXUtils.toFXImage(readerTop, null));
                                        updateInProgress = false;
                                        button_update.setDisable(false);
                                        visualization.stop();
                                        return;
                                    }
                                }
                                if (!field_topSurfaceBlock3.getText().isEmpty()) {
                                    try {
                                        String[] settings = FXUtils.deobfuscate(field_topSurfaceBlock3);
                                        double iChance = Double.parseDouble(settings[1]);
                                        if (settings[0].equals("random")) {
                                            int canc = Integer.parseInt((iChance + "").replace(".0",""));
                                            if (rint(0, canc, random) == 0) {
                                                c = Block.getRandomColor(settings[2]);
                                                blockId = settings[2];
                                            }
                                        } else if (settings[0].equals("noise")) {
                                            double noise = surfaceNoise.getValue(x, 0, y);
                                            if(noise>iChance){
                                                c = Block.getRandomColor(settings[2]);
                                                blockId = settings[2];
                                            }
                                        }else if (settings[0].equals("blob")) {
                                            int canc = Integer.parseInt((iChance + "").replace(".0",""));
                                            if (rint(0, canc, random) == 0) {
                                                blobs.add(new VWorld.BlockPosArray(new Block(settings[2],Block.getRandomColor(settings[2])),x,y));
                                            }
                                        }
                                    }catch (Exception e){
                                        errorMsg = e.getMessage();
                                        System.out.println(e);
                                        imageTop.setImage(SwingFXUtils.toFXImage(readerTop, null));
                                        updateInProgress = false;
                                        button_update.setDisable(false);
                                        visualization.stop();
                                        return;
                                    }
                                }

                                Block b = new Block(blockId, c);
                                vWorldSurface.setBlock(b, x, y);
                                readerTop.setRGB(x, y, vWorldSurface.getBlock(x, y) == null ? 0x000000 : c.getRGB());
                                imageTop.setImage(SwingFXUtils.toFXImage(readerTop, null));

                            }
                        }

                        for (VWorld.BlockPosArray blob : blobs) {
                            for (Integer[] integers : FXUtils.drawCircle(blob.getX(), blob.getY(), 4)) {
                                if(integers[0]>=0 && integers[1]>=0 && integers[0]<readerTop.getWidth() && integers[1]<readerTop.getHeight()) {
                                    vWorldSurface.setBlock(blob.getBlock(), integers[0], integers[1]);
                                    readerTop.setRGB(integers[0], integers[1], blob.getBlock().getColor().getRGB());
                                }

                            }
                        }

                        int seaLevel = 15;
                        int relativeSeaLevel = (int)imageBottom.getFitHeight()/size-seaLevel;
                        for (int x = 0; x < imageBottom.getFitWidth() / size; x++) {
                            for (int y = 0; y < imageBottom.getFitHeight() / size; y++) {
                                try {
                                    int height = (int) (seaLevel * (baseHeight * 1.6 + 1));
                                    int variation = (int) (-seaLevel * heightVariation  + x * heightVariation);
                                    height = height + variation;
                                    int relativeHeight = (int) imageBottom.getFitHeight() / size - height;
                                    String blockId = "minecraft:air";
                                    Color c = Block.getRandomColor(blockId);
                                    if (y > relativeSeaLevel) {
                                        c = Block.getRandomColor("minecraft:water");
                                        blockId = "minecraft:water";
                                    }
                                    if (y > relativeHeight) {
                                        if (y - 1 <= relativeHeight) {
                                            if (y > relativeSeaLevel) {
                                                blockId = field_underwaterBlock.getText();
                                                if (!field_underwaterBlock.getText().isEmpty()) {
                                                    c = Block.getRandomColor(field_underwaterBlock.getText());
                                                }
                                            }else {
                                                blockId = field_topSurfaceBlock1.getText();
                                                if (!field_topSurfaceBlock1.getText().isEmpty()) {
                                                    c = Block.getRandomColor(field_topSurfaceBlock1.getText());
                                                }
                                            }
                                        } else if (y - 5 <= relativeHeight) {
                                            blockId = field_fillerBlock.getText();
                                            if (!field_fillerBlock.getText().isEmpty()) {
                                                c = Block.getRandomColor(field_fillerBlock.getText());
                                            }
                                        } else {
                                            blockId = "minecraft:stone";
                                            c = Block.getRandomColor(blockId);
                                        }
                                    }


                                    Block b = new Block(blockId, c);
                                    vWorldMountain.setBlock(b, x, y);
                                    readerBottom.setRGB(x, y, vWorldMountain.getBlock(x, y) == null ? 0x000000 : c.getRGB());
                                    imageBottom.setImage(SwingFXUtils.toFXImage(readerBottom, null));
                                }catch (Exception e){

                                }
                            }
                        }

                        imageTop.setImage(SwingFXUtils.toFXImage(readerTop, null));
                        imageBottom.setImage(SwingFXUtils.toFXImage(readerBottom, null));
                        updateInProgress = false;
                        button_update.setDisable(false);
                        visualization.stop();

                    }
                }
            });
            visualization.start();

            imageTop.setOnMouseMoved(event -> {
                int x = (int)event.getX()/size;
                int y = (int)event.getY()/size;
                String id = "";
                Block b= vWorldSurface.getBlock(x,y);
                if(b!=null) {
                    id = b.getId();
                    if(imageTooltipTop==null) {

                        imageTooltipTop = new Tooltip(id);
                        imageTooltipTop.setX(event.getSceneX());
                        imageTooltipTop.setY(event.getSceneY());
                        Tooltip.install(imageTop, imageTooltipTop);
                    }else{
                        imageTooltipTop.setX(event.getScreenX());
                        imageTooltipTop.setY(event.getScreenY());
                    }

                }
            });
            imageBottom.setOnMouseMoved(event -> {
                int x = (int)event.getX()/size;
                int y = (int)event.getY()/size;
                String id = "";
                Block b= vWorldMountain.getBlock(x,y);
                if(b!=null) {
                    id = b.getId();
                    if(imageTooltipBottom==null) {
                        imageTooltipBottom = new Tooltip(id);
                        imageTooltipBottom.setX(event.getSceneX());
                        imageTooltipBottom.setY(event.getSceneY());
                        Tooltip.install(imageBottom, imageTooltipBottom);
                    }else{
                        imageTooltipBottom.setX(event.getScreenX());
                        imageTooltipBottom.setY(event.getScreenY());
                    }

                }
            });

        }




    }

    public static double lerp(double pct, double start, double end) {
        return start + pct * (end - start);
    }
    public static int rint(int min, int max, Random rand) {

        if(min==max){
            return min;
        }

        if (min >= max) {
            return max;
        }


        return rand.nextInt((max - min) + 1) + min;
    }

    protected void importBiome(File f, String a) throws FileNotFoundException {

            Scanner s = null;
            if(f!=null){
                s = new Scanner(f);
            }else{
                s = new Scanner(a);
            }
            while (s.hasNextLine()){
                String line = s.nextLine();
                if(line.contains("###")){
                    continue;
                }
                String field = line.substring(0,line.indexOf("=="));
                String value = line.substring(line.indexOf("==")+1);
                if(field.equals("base_height")){
                    field_baseHeight.setText(Double.parseDouble(value)+"");
                }else if(field.equals("height_variation")){
                    field_heightVariation.setText(Double.parseDouble(value)+"");
                }else if(field.equals("temperature")){
                    field_temperature.setText(Double.parseDouble(value)+"");
                }else if(field.equals("rainfall")){
                    field_rainfall.setText(Double.parseDouble(value)+"");
                }else if(field.equals("rain")){
                    if(value.equals("true")){
                        toggle_rain.setSelected(true);
                    }else{
                        toggle_rain.setSelected(false);
                    }
                }else if(field.equals("snow")){
                    if(value.equals("true")){
                        toggle_snow.setSelected(true);
                    }else{
                        toggle_snow.setSelected(false);
                    }
                }else if(field.equals("grass_color1_sel")){
                    if(value.equals("true")){
                        toggle_grassColor1.setSelected(true);
                    }else{
                        toggle_grassColor1.setSelected(false);
                    }
                }else if(field.equals("grass_color2_sel")){
                    if(value.equals("true")){
                        toggle_grassColor2.setSelected(true);
                    }else{
                        toggle_grassColor2.setSelected(false);
                    }
                }else if(field.equals("foliage_color1_sel")){
                    if(value.equals("true")){
                        toggle_foliageColor1.setSelected(true);
                    }else{
                        toggle_foliageColor1.setSelected(false);
                    }
                }else if(field.equals("foliage_color2_sel")){
                    if(value.equals("true")){
                        toggle_foliageColor2.setSelected(true);
                    }else{
                        toggle_foliageColor2.setSelected(false);
                    }
                }else if(field.equals("sky_color_sel")){
                    if(value.equals("true")){
                        toggle_skyColor.setSelected(true);
                    }else{
                        toggle_skyColor.setSelected(false);
                    }
                }else if(field.equals("water_color_sel")){
                    if(value.equals("true")){
                        toggle_waterColor.setSelected(true);
                    }else{
                        toggle_waterColor.setSelected(false);
                    }
                }else if(field.equals("grass_color1")){
                    color_grass1.setValue(javafx.scene.paint.Color.valueOf(value));
                }else if(field.equals("grass_color2")){
                    color_grass2.setValue(javafx.scene.paint.Color.valueOf(value));
                }else if(field.equals("foliage_color1")){
                    color_foliage1.setValue(javafx.scene.paint.Color.valueOf(value));
                }else if(field.equals("foliage_color2")){
                    color_foliage2.setValue(javafx.scene.paint.Color.valueOf(value));
                }else if(field.equals("sky_color")){
                    color_sky.setValue(javafx.scene.paint.Color.valueOf(value));
                }else if(field.equals("water_color")){
                    color_water.setValue(javafx.scene.paint.Color.valueOf(value));
                }else if(field.equals("water_lily")){
                    field_waterLily.setText(Integer.parseInt(value)+"");
                }else if(field.equals("cacti")){
                    field_cacti.setText(Integer.parseInt(value)+"");
                }else if(field.equals("gravel")){
                    field_gravel.setText(Integer.parseInt(value)+"");
                }else if(field.equals("sand")){
                    field_sand.setText(Integer.parseInt(value)+"");
                }else if(field.equals("clay")){
                    field_clay.setText(Integer.parseInt(value)+"");
                }else if(field.equals("generate_falls")){
                    if(value.equals("true")){
                        toggle_generateFalls.setSelected(true);
                    }else{
                        toggle_generateFalls.setSelected(false);
                    }
                }else if(field.equals("top_surface_block1")){
                    field_topSurfaceBlock1.setText(value);
                }else if(field.equals("top_surface_block2")){
                    field_topSurfaceBlock2.setText(value);
                }else if(field.equals("top_surface_block3")){
                    field_topSurfaceBlock3.setText(value);
                }else if(field.equals("filler_block")){
                    field_fillerBlock.setText(value);
                }else if(field.equals("underwater_block")){
                    field_underwaterBlock.setText(value);
                }else if(field.equals("trees_per_chunk")){
                    field_treesPerChunk.setText(Integer.parseInt(value)+"");
                }else if(field.equals("tree_extra")){
                    field_rainfall.setText(Double.parseDouble(value)+"");
                }else if(field.equals("selected_trees")){
                    list_selTrees.getItems().addAll(FXUtils.importArray(value));
                }else if(field.equals("grass_per_chunk")){
                    field_grassPerChunk.setText(Integer.parseInt(value)+"");
                }else if(field.equals("grass_id")){
                    field_grassId.setText(value);
                }else if(field.equals("flowers_per_chunk")){
                    field_flowersPerChunk.setText(Integer.parseInt(value)+"");
                }else if(field.equals("selected_flowers")){
                    list_selFlowers.getItems().addAll(FXUtils.importArray(value));
                }else if(field.equals("structure_rarity")){
                    field_structureRarity.setText(Integer.parseInt(value)+"");
                }else if(field.equals("structure_extra")){
                    field_structureExtra.setText(Integer.parseInt(value)+"");
                }else if(field.equals("selected_structures")){
                    list_selStructures.getItems().addAll(FXUtils.importArray(value));
                }else if(field.equals("biome_id")){
                    field_biomeId.setText(value);
                }else if(field.equals("biome_dictionary")){
                    for (String s1 : FXUtils.importArray(value)) {
                        list_biomeDictionary.getSelectionModel().select(s1);
                    }
                }else if(field.equals("biome_weight")){
                    field_biomeWeight.setText(Integer.parseInt(value)+"");
                }else if(field.equals("parent_biome")){
                    field_parentBiome.setText(value);
                }
            }

    }

    protected String exportBiome(){
        String s = "";
        s=s + "base_height" + "="+field_baseHeight.getText() + "\n";
        s=s + "height_variation" + "="+field_heightVariation.getText()+ "\n";
        s=s + "temperature" + "="+field_temperature.getText()+ "\n";
        s=s + "rainfall" + "="+field_rainfall.getText()+ "\n";
        s=s + "rain" + "="+toggle_rain.isSelected()+ "\n";
        s=s + "snow" + "="+toggle_snow.isSelected()+ "\n";
        s=s + "grass_color1_sel" + "="+toggle_grassColor1.isSelected()+ "\n";
        s=s + "grass_color2_sel" + "="+toggle_grassColor2.isSelected()+ "\n";
        s=s + "foliage_color1_sel" + "="+toggle_foliageColor1.isSelected()+ "\n";
        s=s + "foliage_color2_sel" + "="+toggle_foliageColor2.isSelected()+ "\n";
        s=s + "sky_color_sel" + "="+toggle_skyColor.isSelected()+ "\n";
        s=s + "water_color_sel" + "="+toggle_waterColor.isSelected()+ "\n";
        s=s + "grass_color1" + "="+color_grass1.getValue().toString()+ "\n";
        s=s + "grass_color2" + "="+color_grass2.getValue().toString()+ "\n";
        s=s + "foliage_color1" + "="+color_foliage1.getValue().toString()+ "\n";
        s=s + "foliage_color2" + "="+color_foliage2.getValue().toString()+ "\n";
        s=s + "sky_color" + "="+color_sky.getValue().toString()+ "\n";
        s=s + "water_color" + "="+color_water.getValue().toString()+ "\n";
        s=s + "water_lily" + "="+field_waterLily.getText() + "\n";
        s=s + "cacti" + "="+field_cacti.getText() + "\n";
        s=s + "gravel" + "="+field_gravel.getText() + "\n";
        s=s + "sand" + "="+field_sand.getText() + "\n";
        s=s + "clay" + "="+field_clay.getText() + "\n";
        s=s + "generate_falls" + "="+toggle_generateFalls.isSelected()+ "\n";
        s=s + "top_surface_block1" + "="+field_topSurfaceBlock1.getText() + "\n";
        s=s + "top_surface_block2" + "="+field_topSurfaceBlock2.getText() + "\n";
        s=s + "top_surface_block3" + "="+field_topSurfaceBlock3.getText() + "\n";
        s=s + "filler_block" + "="+field_fillerBlock.getText() + "\n";
        s=s + "underwater_block" + "="+field_underwaterBlock.getText() + "\n";
        s=s + "trees_per_chunk" + "="+field_treesPerChunk.getText() + "\n";
        s=s + "tree_extra" + "="+field_treeExtra.getText() + "\n";
        s=s + "selected_trees" + "="+FXUtils.exportArray(list_selTrees.getItems()) + "\n";
        s=s + "grass_per_chunk" + "="+field_grassPerChunk.getText() + "\n";
        s=s + "grass_id" + "="+field_grassId.getText() + "\n";
        s=s + "flowers_per_chunk" + "="+field_flowersPerChunk.getText() + "\n";
        s=s + "selected_flowers" + "="+FXUtils.exportArray(list_selFlowers.getItems()) + "\n";
        s=s + "structure_rarity" + "="+field_structureRarity.getText() + "\n";
        s=s + "structure_extra" + "="+field_structureExtra.getText() + "\n";
        s=s + "selected_structures" + "="+FXUtils.exportArray(list_selStructures.getItems()) + "\n";
        s=s + "biome_id" + "="+field_biomeId.getText() + "\n";
        s=s + "biome_dictionary" + "="+FXUtils.exportArray(list_biomeDictionary.getSelectionModel().getSelectedItems()) + "\n";
        s=s + "biome_weight" + "="+field_biomeWeight.getText() + "\n";
        s=s + "parent_biome" + "="+field_parentBiome.getText() + "\n";
        try {
            importBiome(null, s);
        }catch (Exception e){
            Alert aa = new Alert(Alert.AlertType.ERROR,e.getLocalizedMessage());
            aa.showAndWait();
            return "";
        }

        return s;
    }
}

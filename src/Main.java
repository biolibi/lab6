import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class Main extends Application {
    public static void main(String[] args) {
    launch(args);
}
    public void start (Stage primaryStage) {

        Image image = new Image("file:default.jpg");
        Image image1 = new Image("file:image1.jpg");
        Image image2 = new Image("file:image2.jpg");
        Image image3 = new Image("file:image3.jpg");

        ImageView imageView = new ImageView(image);
        ImageView imageView1 = new ImageView(image1);
        ImageView imageView2 = new ImageView(image2);
        ImageView imageView3 = new ImageView(image3);

        imageView.setPreserveRatio(true);
        imageView1.setPreserveRatio(true);
        imageView2.setPreserveRatio(true);
        imageView3.setPreserveRatio(true);
        imageView.setFitWidth(500);
        imageView1.setFitWidth(500);
        imageView2.setFitWidth(500);
        imageView3.setFitWidth(500);
        primaryStage.setTitle("Paint-2000");
        primaryStage.setWidth(1000);
        primaryStage.setHeight(1000);
        primaryStage.setResizable(true);
        MenuItem reset = new MenuItem("Reset");
        Menu fichiers = new Menu("Fichiers");
        Menu actions = new Menu("Actions");
        MenuItem photo1 = new MenuItem("Image1");
        MenuItem photo2 = new MenuItem("Image2");
        MenuItem photo3 = new MenuItem("Image3");
        actions.getItems().addAll(reset);
        fichiers.getItems().addAll(photo1,photo2,photo3);
        MenuBar menuBar = new MenuBar(fichiers,actions);
        Slider luminosité = new Slider(-1,1,0);
        Slider contraste = new Slider(-1,1,0);
        Slider teinte = new Slider(-1,1,0);
        Slider saturation = new Slider(-1,1,0);
        Label labelLuminosité = new Label("Luminosité");
        Label labelContraste = new Label("Contraste");
        Label labelTeinte = new Label("Teinte");
        Label labelSaturation = new Label("Saturation");
        Tooltip tooltipLuminosité = new Tooltip("Rend l'image plus claire ou plus sombre");
        Tooltip tooltipContraste = new Tooltip("Diminue ou augmente la différence entre les couleurs");
        Tooltip tooltipTeinte = new Tooltip("Change la couleur de l'image");
        Tooltip tooltipSaturation = new Tooltip("Diminue ou augmente l'intensité des couleurs");
        luminosité.setTooltip(tooltipLuminosité);
        contraste.setTooltip(tooltipContraste);
        teinte.setTooltip(tooltipTeinte);
        saturation.setTooltip(tooltipSaturation);
        final Label reset_des_ajustements = new Label("");
        ContextMenu contextMenu = new ContextMenu(fichiers,actions);
        TextField tx = new TextField();
        tx.setContextMenu(contextMenu);



        VBox effet = new VBox(labelLuminosité,luminosité,labelContraste,contraste,labelTeinte,teinte,labelSaturation,saturation);
        effet.setSpacing(10);
        effet.setAlignment(Pos.CENTER_RIGHT);

        //reset cancer
        reset.setOnAction((event)->{

            ColorAdjust colorAdjust = new ColorAdjust();
            colorAdjust.setContrast(0);
            colorAdjust.setSaturation(0);
            colorAdjust.setBrightness(0);
            colorAdjust.setHue(0);
            imageView.setEffect(colorAdjust);
            imageView1.setEffect(colorAdjust);
            imageView2.setEffect(colorAdjust);
            imageView3.setEffect(colorAdjust);
            luminosité.setValue(0);
            contraste.setValue(0);
            teinte.setValue(0);
            saturation.setValue(0);
            reset_des_ajustements.setText("Reset des ajustements");



        });
        tx.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
            @Override
            public void handle(ContextMenuEvent event) {
                contextMenu.show(tx, event.getScreenX(), event.getScreenY());
            }
        });

        photo1.setOnAction((event)->{
            BorderPane root = new BorderPane(imageView1);
            reset_des_ajustements.setText("L'image 1 a été sélectionner");
            root.setTop(menuBar);
            root.setRight(effet);
            root.setBottom(reset_des_ajustements);
            root.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (event.isSecondaryButtonDown()) {
                        contextMenu.show(root, event.getScreenX(), event.getScreenY());
                    }
                }
            });
            primaryStage.setScene(new Scene(root));
            primaryStage.setMaximized(true);
            primaryStage.show();
        });

        photo2.setOnAction((event)->{
            BorderPane root = new BorderPane(imageView2);
            reset_des_ajustements.setText("L'image 2 a été sélectionner");
            root.setTop(menuBar);
            root.setRight(effet);
            root.setBottom(reset_des_ajustements);
            root.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (event.isSecondaryButtonDown()) {
                        contextMenu.show(root, event.getScreenX(), event.getScreenY());
                    }
                }
            });
            primaryStage.setScene(new Scene(root));
            primaryStage.setMaximized(true);
            primaryStage.show();
        });

        photo3.setOnAction((event)->{
            BorderPane root = new BorderPane(imageView3);
            reset_des_ajustements.setText("L'image 3 a été sélectionner");
            root.setTop(menuBar);
            root.setRight(effet);
            root.setBottom(reset_des_ajustements);
            root.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (event.isSecondaryButtonDown()) {
                        contextMenu.show(root, event.getScreenX(), event.getScreenY());
                    }
                }
            });
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        });

        luminosité.valueProperty().addListener((that,oldValue, newValue)->{
            ColorAdjust colorAdjust = new ColorAdjust();
            colorAdjust.setBrightness((double)newValue);
            imageView.setEffect(colorAdjust);
            imageView1.setEffect(colorAdjust);
            imageView2.setEffect(colorAdjust);
            imageView3.setEffect(colorAdjust);
        });

        contraste.valueProperty().addListener((that,oldValue, newValue)->{
            ColorAdjust colorAdjust = new ColorAdjust();
            colorAdjust.setContrast((double)newValue);
            imageView.setEffect(colorAdjust);
            imageView1.setEffect(colorAdjust);
            imageView2.setEffect(colorAdjust);
            imageView3.setEffect(colorAdjust);
        });

        saturation.valueProperty().addListener((that,oldValue, newValue)->{
            ColorAdjust colorAdjust = new ColorAdjust();
            colorAdjust.setSaturation((double)newValue);
            imageView.setEffect(colorAdjust);
            imageView1.setEffect(colorAdjust);
            imageView2.setEffect(colorAdjust);
            imageView3.setEffect(colorAdjust);
        });

        teinte.valueProperty().addListener((that,oldValue, newValue)->{
            ColorAdjust colorAdjust = new ColorAdjust();
            colorAdjust.setHue((double)newValue);
            imageView.setEffect(colorAdjust);
            imageView1.setEffect(colorAdjust);
            imageView2.setEffect(colorAdjust);
            imageView3.setEffect(colorAdjust);
        });


        BorderPane root = new BorderPane(imageView);
         root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.isSecondaryButtonDown()) {
                    contextMenu.show(root, event.getScreenX(), event.getScreenY());
                }
            }
        });

        root.setTop(menuBar);
        root.setRight(effet);
        reset_des_ajustements.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        root.setBottom(reset_des_ajustements);


        primaryStage.setScene(new Scene(root));
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}

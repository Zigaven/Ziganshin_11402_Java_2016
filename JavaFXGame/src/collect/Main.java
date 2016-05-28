package collect;

import javafx.animation.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Iterator;

public class Main extends Application {
    boolean aDone = false;
    boolean bDone = false;

    Sprite comics;
    int i = 0;


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage theStage) {
        theStage.setTitle("Ruslan, collect the Comics!");
        long start = System.currentTimeMillis();

        Group root = new Group();
        Scene theScene = new Scene(root, 512, 512);
        theStage.setScene(theScene);

        Canvas canvas = new Canvas(512, 512);
        root.getChildren().add(canvas);


        ArrayList<String> input = new ArrayList<String>();

        theScene.setOnKeyPressed(
                new EventHandler<KeyEvent>() {
                    public void handle(KeyEvent e) {
                        String code = e.getCode().toString();
                        if (!input.contains(code))
                            input.add(code);
                    }
                });

        theScene.setOnKeyReleased(
                new EventHandler<KeyEvent>() {
                    public void handle(KeyEvent e) {
                        String code = e.getCode().toString();
                        input.remove(code);
                    }
                });

        GraphicsContext gc = canvas.getGraphicsContext2D();

        Font theFont = Font.font("Helvetica", FontWeight.BOLD, 24);
        gc.setFont(theFont);
        gc.setFill(Color.YELLOW);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);

        Sprite ruslan = new Sprite();
        ruslan.setImage("collect/images/ruslan.png");
        ruslan.setPosition(200, 0);

        ArrayList<Sprite> comicsList = new ArrayList<Sprite>();

        for (int i = 0; i < 15; i++) {
            comics = new Sprite();
            comics.setImage("collect/images/comics.png");
            double px = 350 * Math.random() + 50;
            double py = 350 * Math.random() + 50;
            comics.setPosition(px, py);
            comicsList.add(comics);
        }




        LongValue lastNanoTime = new LongValue(System.nanoTime());

        IntValue score = new IntValue(0);

        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                // calculate time since last update.
                double elapsedTime = (currentNanoTime - lastNanoTime.value) / 1000000000.0;
                lastNanoTime.value = currentNanoTime;

                // game logic
                long fin = System.currentTimeMillis();
                long res = fin - start;
                ruslan.setVelocity(0, 0);
                if (input.contains("LEFT")) {
                    ruslan.setImage("collect/images/ruslan.png");
                    ruslan.addVelocity(-50, 0);
                }
                if (input.contains("RIGHT")) {
                    ruslan.setImage("collect/images/ruslan.png");
                    ruslan.addVelocity(50, 0);
                }
                if (input.contains("UP")) {
                    ruslan.setImage("collect/images/ruslan.png");
                    ruslan.addVelocity(0, -75);
                }
                if (input.contains("DOWN")) {
                    ruslan.setImage("collect/images/ruslan.png");
                    ruslan.addVelocity(0, 75);
                }
                if ((10 - res / 1000) > 0) {
                    if (input.contains("LEFT") && (input.contains("SHIFT"))) {
                        ruslan.setImage("collect/images/sparta.png");
                        ruslan.addVelocity(-100, 0);
                    }
                    if (input.contains("RIGHT") && (input.contains("SHIFT"))) {
                        ruslan.setImage("collect/images/sparta.png");
                        ruslan.addVelocity(100, 0);
                    }
                    if (input.contains("UP") && (input.contains("SHIFT"))) {
                        ruslan.setImage("collect/images/sparta.png");
                        ruslan.addVelocity(0, -100);
                    }
                    if (input.contains("DOWN") && (input.contains("SHIFT"))) {
                        ruslan.setImage("collect/images/sparta.png");
                        ruslan.addVelocity(0, 100);
                    }
                }


                ruslan.update(elapsedTime);

                // collision detection

                Iterator<Sprite> comicsIter = comicsList.iterator();
                while (comicsIter.hasNext()) {
                    Sprite comics = comicsIter.next();
                    if (ruslan.intersects(comics)) {
                        comicsIter.remove();
                        score.value++;
                    }
                }
                if (score.value == 15) {
                    i = 1;
                    stop();
                    what(theStage);
                }
                boolean b = false;
                boolean a = false;
                if((score.value == 5)&&(!aDone)) {
                    a = true;
                }
                if((score.value == 10)&&(!bDone)) {
                    b = true;
                }

                if(a) {
                    aDone = true;
                    System.out.println("AAAAA");
                    Rectangle rect = new Rectangle(100, 40, 65, 65);


                    rect.setArcHeight(20);
                    Image image1 = new Image(getClass().getResourceAsStream("images/just.png"));
                    ImagePattern imagePattern = new ImagePattern(image1);
                    rect.setFill(imagePattern);
                    rect.setArcWidth(20);



                    TranslateTransition trans= TranslateTransitionBuilder.create()

                            .duration(Duration.seconds(9))

                            .node(rect)

                            .fromX(-100)

                            .toX(1500)

                            .cycleCount(Timeline.INDEFINITE)

                            .autoReverse(true)

                            .build();

                    trans.play();
                    root.getChildren().add(rect);
                }
                if(b) {
                    bDone = true;
                    Rectangle rect = new Rectangle(100, 40, 65, 65);


                    rect.setArcHeight(20);
                    Image image1 = new Image(getClass().getResourceAsStream("images/good.png"));
                    ImagePattern imagePattern = new ImagePattern(image1);
                    rect.setFill(imagePattern);
                    rect.setArcWidth(20);



                    TranslateTransition trans= TranslateTransitionBuilder.create()

                            .duration(Duration.seconds(9))

                            .node(rect)

                            .fromX(-100)

                            .toX(1500)

                            .cycleCount(Timeline.INDEFINITE)

                            .autoReverse(true)

                            .build();

                    trans.play();

                    root.getChildren().add(rect);
                }

                Image image1 = new Image(getClass().getResourceAsStream("images/ruslan.png"));
                ImagePattern imagePattern = new ImagePattern(image1);
                final Rectangle rectBasicTimeline = new Rectangle(300, 50, 100, 50);
                rectBasicTimeline.setFill(imagePattern);

                final Timeline timeline = new Timeline();
                timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.setAutoReverse(true);
                final KeyValue kv = new KeyValue(rectBasicTimeline.xProperty(), 100);
                final KeyFrame kf = new KeyFrame(Duration.millis(500), kv);
                timeline.getKeyFrames().add(kf);
                timeline.play();

                // render

                gc.clearRect(0, 0, 512, 512);
                ruslan.render(gc);
                if (11 - (res / 1000) >= 0) {
                    gc.fillText("Your nitro " + (String.valueOf(11 - (res / 1000))), 30, 500);
                    gc.strokeText("Your nitro " + (String.valueOf(11 - (res / 1000))), 30, 500);
                } else {
                    gc.fillText("Your nitro " + 0, 30, 500);
                    gc.strokeText("Your nitro " + 0, 30, 500);
                }


                for (Sprite comics : comicsList)
                    comics.render(gc);
                String pointsText = (5 * score.value) + " comics";
                gc.fillText(pointsText, 360, 36);
                gc.strokeText(pointsText, 360, 36);
                long end = System.currentTimeMillis();
                long min = end - start;
                gc.fillText("Your time is " + (String.valueOf(15 - (min / 1000))), 30, 36);
                gc.strokeText("Your time is " + (String.valueOf(15 - (min / 1000))), 30, 36);


                if (15 - (min / 1000) == 0) {
                    stop();
                    what(theStage);
                }
            }


        }.start();


        theStage.show();
    }


    /////////////
    public void what(Stage stage) {

        System.out.println("check");
        if (i == 1) {
            stage.setTitle("You did collect all comics!");
        } else {
            stage.setTitle("Game Over!");

        }
        Text text = new Text();
        text.setX(60);
        text.setY(60);
        Button button = new Button();
        button.setLayoutX(60);
        button.setLayoutY(60);
        button.setBlendMode(BlendMode.HARD_LIGHT);
        button.setCursor(Cursor.CLOSED_HAND);
        button.setText("Start New Game");
        DropShadow effect = new DropShadow();
        effect.setOffsetX(5);
        effect.setOffsetY(5);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        start(stage);
                    }
                });

            }
        });
        Text text2 = new Text();
        text2.setX(220);
        text2.setY(60);
        Button button2 = new Button();
        button2.setLayoutX(220);
        button2.setLayoutY(60);
        button2.setBlendMode(BlendMode.HARD_LIGHT);
        button2.setCursor(Cursor.CLOSED_HAND);
        button2.setText("Exit");
        DropShadow effect2 = new DropShadow();
        effect2.setOffsetX(10);
        effect2.setOffsetY(5);
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        Platform.exit();
                    }
                });

            }
        });

        Group root = new Group();
        root.getChildren().add(button);
        root.getChildren().add(button2);

        Scene theScene = new Scene(root, 300, 150);
        stage.setScene(theScene);

    }
}

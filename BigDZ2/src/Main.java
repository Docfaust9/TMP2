import gui.Gui;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.fxml.FXMLLoader;
import java.io.*;
import field.Field;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.VBox;
public class Main extends Application
{
    private Label label1;
    public static void main(String args[])
    {
        Application.launch();
    }
    public int sum_score;
    public void start(Stage primaryStage) throws Exception
    {

        primaryStage.setTitle("Сапёр");
        primaryStage.setResizable(false);                                       //параметры окна
        primaryStage.setWidth(600);
        primaryStage.setHeight(600);

        InputStream iconStream = getClass().getResourceAsStream("/icon.png");
        Image image = new Image(iconStream);
        primaryStage.getIcons().add(image);                                         //иконка приложения

        final Field[] field1 = {new Field()};
        int label_buf[] = new int[64];
        int k=0;
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(2,2,2,2));
        gridpane.setGridLinesVisible(true);
        ArrayList<Label> labels =new ArrayList<>();
        ArrayList<Button> buttons =new ArrayList<>();
        Label score = new Label("Score: 0");
        score.setFont(Font.font("Comic Sans MS",30));
        sum_score = 0;
        for(int i=0; i<8;i++)
        {
            for(int j=0; j<8; j++)
            {
                label_buf[k]= field1[0].field[i][j];
                k++;
                Label label1 = new Label("    "+Integer.toString(field1[0].field[i][j]));
                labels.add(label1);
                label1.setMinSize(50,50);
                gridpane.add(label1,i,j);

                Button button = new Button();
                buttons.add(button);
                button.setOnAction(new EventHandler<ActionEvent>()
                {
                    @Override
                    public void handle(ActionEvent actionEvent)
                    {
                        sum_score=1+sum_score;
                        System.out.println(sum_score);
                        score.setText("Score: "+sum_score);
                        gridpane.getChildren().remove(button);
                        if(labels.get(buttons.indexOf(button)).getText().equals("    -1"))
                        {
                            Stage stage2 = new Stage();
                            Label label_loose = new Label("Вы проиграли");
                            label_loose.setFont(Font.font("Comic Sans MS",30));



                            stage2.initOwner(primaryStage);
                            stage2.initModality(Modality.WINDOW_MODAL);
                            VBox vbox = new VBox(label_loose);
                            Scene scene2 = new Scene(vbox);
                            stage2.setScene(scene2);
                            stage2.show();
                        }
                    }
                });
                button.setMinSize(50,50);
                gridpane.add(button,i,j);

            }
        }




        VBox vBox = new VBox(score,gridpane);
        Scene newscene = new Scene(vBox);
        primaryStage.setScene(newscene);



        primaryStage.show();

    }
    void labels()
    {

    }
}




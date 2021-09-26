
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    double x, y;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/fxml/layout.fxml"));
        Parent root = fxmlLoader.load();
        Scene tela = new Scene(root);
        primaryStage.initStyle(StageStyle.UNDECORATED);

        root.setOnMousePressed(evt -> {
            x = evt.getSceneX();
            y = evt.getSceneY();

        });

        root.setOnMouseDragged(evt -> {
            primaryStage.setX(evt.getScreenX() - x);
            primaryStage.setY(evt.getScreenY() - y);

        });

        primaryStage.setScene(tela);
        primaryStage.show();
    }
}

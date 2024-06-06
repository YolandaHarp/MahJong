package MainScreen;

import javafx.application.Platform;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import net.Client;

import java.io.IOException;
import java.util.Optional;

// Decorator pattern
class ClientGame extends StartGame{
    @Override
    void mode() {
        // Offer pop-up window to input the IP address

        Platform.runLater(() -> {
        Dialog dialog = new Dialog();
        TextField textField = new TextField();
        textField.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.ENTER) {
                dialog.setResult(textField.getText());
                dialog.close();
            }
        });
        dialog.getDialogPane().setContent(textField);
        dialog.setTitle("IP");
        Optional<String> result = dialog.showAndWait();

        // Start client
        result.ifPresent(ip -> {
            try {
                Client.getClient().startClient(ip, 10008);
            } catch (IOException e) {
                new MainScreen().startMainScreen();
            }
        });
    });
    }

}

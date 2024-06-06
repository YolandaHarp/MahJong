package screen.cardsScreen;

import javafx.scene.canvas.GraphicsContext;

public interface ChooseDrawable {
    // Choose the thing need to be drawn for every thing

    void chooseDraw(int i, GraphicsContext g, double x, double y, double a);
}

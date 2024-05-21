package screen.cardsScreen;

import javafx.scene.canvas.GraphicsContext;

import java.awt.*;

public interface Drawable {
    void draw(GraphicsContext g, int x, int y, double a);
}

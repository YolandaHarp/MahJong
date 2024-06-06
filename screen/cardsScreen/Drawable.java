package screen.cardsScreen;

import javafx.scene.canvas.GraphicsContext;

public interface Drawable {
    // Use to draw the cards

    void draw(GraphicsContext g, double x, double y, double a);
}

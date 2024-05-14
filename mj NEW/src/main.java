import javax.swing.*;

public class main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mahjong");
        frame.setSize(1280, 830);
        GameScreen mahjongTile = new GameScreen();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mahjongTile);
        frame.setVisible(true);
    }
}
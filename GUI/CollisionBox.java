package fx;

import javafx.scene.layout.Pane;

public class CollisionBox extends Pane{
	public CollisionBox(Pane pane) {
		this.getChildren().add(pane);
        // 添加鼠标进入事件处理器
        this.setOnMouseEntered(event -> {
            System.out.println("Mouse entered collision box.");
            // 返回 true 或执行其他操作
        });

        // 添加鼠标退出事件处理器
        this.setOnMouseExited(event -> {
            System.out.println("Mouse exited collision box.");
            // 返回 false 或执行其他操作
        });
    }

}

package fx.gui.uicomponents;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXScrollPane;
import com.jfoenix.svg.SVGGlyph;
import io.datafx.controller.ViewController;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@ViewController(value = "/fxml/ui/SendMail.fxml", title = "Material Design Example")
public class SendMailController {

    public static final String CONTENT_PANE = "ContentPane";
    @FXMLViewFlowContext
    private ViewFlowContext context;
    @FXML
    private JFXButton sendButton;
    @FXML
    private JFXListView<String> contentList;
    @FXML
    private JFXScrollPane mailscroll;

    @PostConstruct
    public void init() {

        for (int i = 0; i < 100; i++) {
            contentList.getItems().add("Item " + i);
        }
        contentList.setMaxHeight(3400);

        JFXScrollPane.smoothScrolling((ScrollPane) mailscroll.getChildren().get(0));

        SVGGlyph arrow = new SVGGlyph(0,
                "FULLSCREEN",
                "M402.746 877.254l-320-320c-24.994-24.992-24.994-65.516 0-90.51l320-320c24.994-24.992 65.516-24.992 90.51 0 24.994 24.994 "
                        + "24.994 65.516 0 90.51l-210.746 210.746h613.49c35.346 0 64 28.654 64 64s-28.654 64-64 64h-613.49l210.746 210.746c12.496 "
                        + "12.496 18.744 28.876 18.744 45.254s-6.248 32.758-18.744 45.254c-24.994 24.994-65.516 24.994-90.51 0z",
                Color.WHITE);
        arrow.setSize(20, 16);
    }

    @FXML
    public void hanldeButtonAction(ActionEvent event) {
        System.out.println(1111);
        LocalDateTime now = LocalDateTime.now();

            contentList.getItems().add(now.toString());

//        label.setText("文本框输入内容为:" + textField.getText());
    }
}

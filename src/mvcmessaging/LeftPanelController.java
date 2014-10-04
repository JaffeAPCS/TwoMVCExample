package mvcmessaging;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.mrjaffesclass.apcs.messages.*;

/**
 *
 * @author Roger
 */
public class LeftPanelController implements MessageController {

  private final Messages messages;
  private final LeftPanelView view;
  
  /**
   * Constructor gets passed the view from the appController
   * @param _messages The app's messages class
   * @param _view The view for this controller
   */
  public LeftPanelController(Messages _messages, LeftPanelView _view) {
    view = _view;
    messages = _messages;
  }
  
  public void init() {
    messageSubscriptions();
    view.setController(this);
  }
  
  public void messageSubscriptions() {
    messages.subscribe("Message1", this);
    messages.subscribe("Message2", this);
    messages.subscribe("Message3", this);
  }
  
  @Override
  public void messageHandler(String messageName, Object messageData) {
    System.out.println("MessageReceived in LeftPanelController: "+messageName+" "+messageData.toString());
  }
  
  public void buttonPressed(int buttonNumber, Color color) {
    System.out.println("LeftPanelController: Button "+buttonNumber+" pressed");
    System.out.println("MessageSent from LeftPanelController: Message"+buttonNumber+" "+color.toString());
    messages.notify("Message"+buttonNumber, color);
  }
  
}

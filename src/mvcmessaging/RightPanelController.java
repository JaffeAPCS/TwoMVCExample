package mvcmessaging;
import javax.swing.*;
import java.util.*;
import com.mrjaffesclass.apcs.messages.*;
import java.awt.Color;

/**
 *
 * @author Roger
 */
public class RightPanelController implements MessageController {

  private final Messages messages;
  private final RightPanelView view;
  
  /**
   * Constructor gets passed the view from the appController
   * @param _messages The app's messages class
   * @param _view The view for this controller
   */
  public RightPanelController(Messages _messages, RightPanelView _view) {
    messages = _messages;
    view = _view;
  }
  
  public void init() {
    messageSubscriptions();
    view.setController(this);
  }
  
  public void messageSubscriptions() {
    messages.subscribe("Message4", this);
    messages.subscribe("Message5", this);
    messages.subscribe("Message6", this);
  }
  
  @Override
  public void messageHandler(String messageName, Object messageData) {
    System.out.println("MessageReceived in RightPanelController: "+messageName+" "+messageData.toString());
  }
  
  public void buttonPressed(int buttonNumber, Color color) {
    System.out.println("RightPanelController: Button "+buttonNumber+" pressed");
    System.out.println("MessageSent from RightPanelController: Message"+buttonNumber+" "+color.toString());
    messages.notify("Message"+buttonNumber, color);
  }  
}

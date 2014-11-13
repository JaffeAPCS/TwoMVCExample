package com.mrjaffesclass.apcs.mvc.template.twowindow;

import com.mrjaffesclass.apcs.messenger.*;

/**
 *
 * @author Roger
 */
public class LeftPanelController implements MessageHandler {

  private final Messenger messages;
  
  /**
   * Constructor gets passed the view from the appController.
   * 
   * @param _messages The app's messages class
   * @param _view The view for this controller
   */
  public LeftPanelController(Messenger _messages, LeftPanelView _view) {
    messages = _messages;
    LeftPanelView view = _view;
    view.init(messages);    // Send the message object to the view
  }

  /**
   * Initialization code for this controller
   */
  public void init() {
    messages.subscribe("view:buttonPressed", this);
  }
  
  /**
   * This method is fired in response to the messages to which this 
   * object has subscribed
   * @param messageName Message name
   * @param messageData Message payload (button number and color)
   */
  @Override
  public void messageHandler(String messageName, Object messageData) {
    // If we receive the buttonPressed message, we'll re-send it 
    // from the controller
    if (messageName.equals("view:buttonPressed")) {
      messages.notify("controller:buttonPressed", messageData, true);
    }
  }  
}

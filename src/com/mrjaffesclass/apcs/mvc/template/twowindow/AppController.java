package com.mrjaffesclass.apcs.mvc.template.twowindow;
import com.mrjaffesclass.apcs.messages.*;

/**
 * A multiple view app using a simple MVC framework and messaging to 
 * facilitate controller to controller communication.  The message library
 * is contained in the messages.jar file included in the code folder
 * @author Roger Jaffe
 * @version 2014-10-02
 */
public class AppController {
  
  /**
   * Constructor will instantiate the main AppView which will instantiate the
   * left and right panel views.  It will also instantiate the messages class
   * and then it will instantiate the left and right
   * controllers, passing the messages instance. Finally it sets the AppView 
   * visible flag to true to display the views.
   */
  public AppController() {
    // Create the app messenger class.  There are two sets of messengers -- one
    // for the application that will handle controller to controller communication
    // and one for each controller that will handle communication between model
    // view and controller within one MVC framework.
    Messaging messages = new Messaging();
    
    // Instantiate the view and all the subviews (left and right panels)
    AppView appView = new AppView();
    
    // Instantiate the controllers, passing the messenger class and the corresponding view
    // so the controller can do some initialization.
    LeftPanelController left = new LeftPanelController(messages, appView.getLeftPanelView());
    left.init();
    RightPanelController right = new RightPanelController(messages, appView.getRightPanelView());
    right.init();
    
    // Set the view visible
    appView.setVisible(true);
  }

  /**
   * Bootstrap the application
   * @param args the command line arguments (not used for now)
   */
  public static void main(String[] args) {
    // Bootstrap the application here!
    AppController app = new AppController();
  }
  
}

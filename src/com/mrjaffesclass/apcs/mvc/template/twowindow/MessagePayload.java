package com.mrjaffesclass.apcs.mvc.template.twowindow;
import java.awt.Color;

/**
 * Class used as the payload for some messages.  It will hold
 * the button number that was clicked and the color that is sent
 * 
 * @author Roger Jaffe
 * @version 1.0
 */
public class MessagePayload {
  
  private final int buttonNumber;
  private final Color color;
  
  /**
   * Constructor initializes the button number and color values
   * @param _buttonNumber Button number
   * @param _color Color
   */
  public MessagePayload(int _buttonNumber, Color _color) {
    buttonNumber = _buttonNumber;
    color = _color;
  }
  
  /**
   * Print the payload information for the console messages when
   * the message should be logged
   * @return Button number and color
   */
  @Override
  public String toString() {
    return "Btn#:"+buttonNumber+" Color:"+color.toString();
  }
  
  /**
   * Getter for the button number
   * @return The button number
   */
  public int getButtonNumber() {
    return buttonNumber;
  }
  
  /**
   * Getter for the color object
   * @return The color object
   */
  public Color getColor() {
    return color;
  }
  
}

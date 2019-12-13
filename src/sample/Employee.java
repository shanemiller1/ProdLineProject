package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * class for employee.
 * @author Shane Miller
 */

public class Employee {

  @FXML
  private Label searcgLbl;

  @FXML
  private Label firstLbl;

  @FXML
  private Label lastLbl;

  @FXML
  private TextField searchField;

  @FXML
  private TextField setFirst;

  @FXML
  private TextField setLast;

  /**
   * first method to start.
   */
  private void initialize() {
    firstLbl.setText(name);
    lastLbl.setText(password);
  }

  public String name;
  public String username;
  public String password;
  public String email;

  /**
   * checks name.
   *
   * @param name name user chooses.
   * @return gets the flag.
   */
  public int checkName(String name) {
    char c = ' ';
    int flag = 0;
    int i;
    int length = name.length();
    for (i = 0; i < length; i++) {
      if (name.charAt(i) == c) {
        flag = 1;
      }
    }
    return flag; //returns 1 if name contains space
  }

  /**
   * checks if valid parameters.
   *
   * @param password the password.
   * @return rets zero.
   */
  public int isValidPassword(String password) {

    int flaglo = 0;
    int flagup = 0;
    int flagspe = 0;
    int flagother = 0;
    int i;
    int length = password.length();
    for (i = 0; i < length; i++) {
      char ch = password.charAt(i);
      if (Character.isUpperCase(ch)) {
        flagup = 1;
      } else if (Character.isLowerCase(ch)) {
        flaglo = 1;
      } else if (ch == '"' || ch == '!' || ch == '@' || ch == '&' || ch == '$'
              || ch == '#' || ch == '%' || ch == '^' || ch == '*') {
        flagspe = 1;
      } else {
        flagother = 1;
      }
    }
    if (flaglo == 1 && flagup == 1 && flagspe == 1 && flagother == 0) {
      return 1; //password valid
    } else {
      return 0; //password invalid
    }
  }

  /**
   * sets the username.
   *
   * @param name the name is a string.
   */
  public void setUsername(String name) {
    int i;
    int pos = 0;
    char c = ' ';
    String username = "";
    name.toLowerCase();

    int length = name.length();
    for (i = 0; i < length; i++) {
      if (name.charAt(i) == c) {
        pos = i + 1;
        break;
      }
    }
    username = username + name.charAt(0);
    for (i = pos; i < length; i++) {
      username = username + name.charAt(i);
      this.username = username.toLowerCase();
    }
  }

  /**
   * sets the email.
   *
   * @param name name is string and used same here as previous methods.
   */
  public void setEmail(String name) {
    char c = ' ';
    int i;
    String email = "";
    name.toLowerCase();
    int length = name.length();
    for (i = 0; i < length; i++) {
      if (name.charAt(i) == c) {
        email = email + ".";
      } else {
        email = email + name.charAt(i);
      }
    }
    email = email.toLowerCase() + "@oracleacademy.Test";
    this.email = email;
  }

  /**
   * prints employee details.
   *
   * @return rets strings.
   */
  public String toString() {
    return "\nEmployee Details\nName : " + this.name + "\nUsername : "
            + this.username + "\nEmail : " + this.email + "\nInitial Password : " + this.password;
  }

  /**
   * contructor for employee.
   * @param name the name.
   * @param password the password.
   */
  Employee(String name, String password) {
    this.name = name;
    if (checkName(name) == 1) {
      setUsername(name);
      setEmail(name);
    } else {
      this.username = "default";
      this.email = "user@oracleacademy.Test";
    }
    if (isValidPassword(password) == 1) {
      this.password = password;
    } else {
      this.password = "pw";
    }

  }
}
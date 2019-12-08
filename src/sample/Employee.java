package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public abstract class Employee extends Controller {

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

  private void initialize() {
    firstLbl.setText(name);
    lastLbl.setText(password);
  }

  public String name, username, password, email;

  public int checkName(String name) {
    char c = ' ';
    int flag = 0, i;
    int length = name.length();
    for (i = 0; i < length; i++) {
      if (name.charAt(i) == c)
        flag = 1;
    }
    return flag; //returns 1 if name contains space
  }

  public int isValidPassword(String password) //to check password is valid or not
  {

    int flaglo = 0, flagup = 0, flagspe = 0, flagother = 0, i;
    int length = password.length();
    for (i = 0; i < length; i++) {
      char ch = password.charAt(i);
      if (Character.isUpperCase(ch))
        flagup = 1;
      else if (Character.isLowerCase(ch))
        flaglo = 1;
      else if (ch == '"' || ch == '!' || ch == '@' || ch == '&' || ch == '$' || ch == '#' || ch == '%' || ch == '^' || ch == '*')
        flagspe = 1;
      else
        flagother = 1;
    }
    if (flaglo == 1 && flagup == 1 && flagspe == 1 && flagother == 0)
      return 1; //password valid
    else
      return 0; //password invalid
  }

  public void setUsername(String name) // method to set username
  {
    int i, pos = 0;
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
    for (i = pos; i < length; i++)
      username = username + name.charAt(i);
    this.username = username.toLowerCase();
  }

  public void setEmail(String name) //email method
  {
    char c = ' ';
    int i;
    String email = "";
    name.toLowerCase();
    int length = name.length();
    for (i = 0; i < length; i++) {
      if (name.charAt(i) == c)
        email = email + ".";
      else
        email = email + name.charAt(i);
    }
    email = email.toLowerCase() + "@oracleacademy.Test";
    this.email = email;
  }

  //overload toString()
  public String toString() {
    return "\nEmployee Details\nName : " + this.name + "\nUsername : " + this.username + "\nEmail : " + this.email + "\nInitial Password : " + this.password;
  }

  Employee(String name, String password) //constructor
  {
    this.name = name;
    if (checkName(name) == 1) //if there is a valid username
    {
      setUsername(name);
      setEmail(name);
    } else {
      this.username = "default";
      this.email = "user@oracleacademy.Test";
    }
    if (isValidPassword(password) == 1) //if the password is valid
      this.password = password;
    else
      this.password = "pw";

  }
}
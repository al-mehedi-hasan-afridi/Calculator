/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Afridi
 */
public class CalculatorViewController implements Initializable {
	float number1;
	float number2;
	int calculation;
	@FXML
	private Label label;
	@FXML
	private Button clear;
	@FXML
	private Button percentage;
	@FXML
	private Button inverse;
	@FXML
	private Button sqrt;
	@FXML
	private Button seven;
	@FXML
	private Button eight;
	@FXML
	private Button nine;
	@FXML
	private Button div;
	@FXML
	private Button four;
	@FXML
	private Button five;
	@FXML
	private Button six;
	@FXML
	private Button mul;
	@FXML
	private Button one;
	@FXML
	private Button two;
	@FXML
	private Button three;
	@FXML
	private Button minus;
	@FXML
	private Button point;
	@FXML
	private Button zero;
	@FXML
	private Button equals;
	@FXML
	private Button plus;
	@FXML
	private TextField display;
	@FXML
	private Button square;
	@FXML
	private Button makenegative;
	@FXML
	private Button cube;
	@FXML
	private Button pi;

        // Function to store calculation 
	void store(String log) {
            File file=new File("F:\\COURSES\\Project (mine)\\Calculator Project (Java)\\src\\project\\store.txt"); 
		try {
			FileWriter fw = new FileWriter(file, true);
			Date date = new Date();
			fw.write(date.toString() + "\n");
			fw.write(log + "\n\n");
			fw.close();
		} catch (IOException e) {
			e.getMessage();
		}
	}

	@FXML
	private void handleButtonAction(ActionEvent event) {
		if (event.getSource() == one) {
			display.setText(display.getText() + "1");
		} else if (event.getSource() == two) {
			display.setText(display.getText() + "2");
		} else if (event.getSource() == three) {
			display.setText(display.getText() + "3");
		} else if (event.getSource() == four) {
			display.setText(display.getText() + "4");
		} else if (event.getSource() == five) {
			display.setText(display.getText() + "5");
		} else if (event.getSource() == six) {
			display.setText(display.getText() + "6");
		} else if (event.getSource() == seven) {
			display.setText(display.getText() + "7");
		} else if (event.getSource() == eight) {
			display.setText(display.getText() + "8");
		} else if (event.getSource() == nine) {
			display.setText(display.getText() + "9");
		} else if (event.getSource() == zero) {
			display.setText(display.getText() + "0");
		} else if (event.getSource() == point) {
			display.setText(display.getText() + ".");
		} else if (event.getSource() == clear) {
			display.setText("");
		} else if (event.getSource() == plus) {
			try {
				number1 = Float.parseFloat(display.getText());
			} catch (Exception e) {
                                e.getMessage();
			}
			// For addition
			calculation = 1;
			display.setText("");
		} else if (event.getSource() == minus) {
			try {
				number1 = Float.parseFloat(display.getText());
			} catch (Exception e) {
                               e.getMessage();
			}
			// For Subtraction
			calculation = 2;
			display.setText("");
		} else if (event.getSource() == mul) {
			try {
				number1 = Float.parseFloat(display.getText());
			} catch (Exception e) {
                               e.getMessage();
			}
			// For Multiplication
			calculation = 3;
			display.setText("");
		} else if (event.getSource() == div) {
			try {
				number1 = Float.parseFloat(display.getText());
			} catch (Exception e) {
                               e.getMessage();
			}
			// For Division
			calculation = 4;
			display.setText("");
		} // For root
		else if (event.getSource() == sqrt) {
			try {
				number1 = Float.parseFloat(display.getText());
				float ans = Operation.root(number1);
				display.setText(String.valueOf(ans));
				String log = "sqrt(" + number1 + ") = " + ans;
				store(log);
			} catch (Exception e) {
				display.setText("Error");
			}
		} // For Equals
		else if (event.getSource() == equals) {
			switch (calculation) {
			case 1: // Addition
				try {
					number2 = Float.parseFloat(display.getText());
					float ans = Operation.add(number1, number2);
					display.setText(String.valueOf(ans));
					String log = number1 + " + " + number2 + " = " + ans;
					store(log);
				} catch (Exception e) {
					display.setText("Error");
				}
				break;
			case 2: // Subtraction
				try {
					number2 = Float.parseFloat(display.getText());
					float ans = Operation.substract(number1, number2);
					display.setText(String.valueOf(ans));
					String log = number1 + " - " + number2 + " = " + ans;
					store(log);
				} catch (Exception e) {
					display.setText("Error");
				}
				break;
			case 3: // Multiplication
				try {
					number2 = Float.parseFloat(display.getText());
					float ans = Operation.multiply(number1, number2);
					display.setText(String.valueOf(ans));
					String log = number1 + " * " + number2 + " = " + ans;
					store(log);
				} catch (Exception e) {
					display.setText("Error");
				}
				break;
			case 4: // Division
				try {
					number2 = Float.parseFloat(display.getText());
					float ans = Operation.divide(number1, number2);
					display.setText(String.valueOf(ans));
					String log = number1 + " / " + number2 + " = " + ans;
					store(log);
				} catch (Exception e) {
					display.setText("Error");
				}
				break;
			}
		} // For Percentage
		else if (event.getSource() == percentage) {
			float ans = (Float.parseFloat(display.getText()) / 100);
                        String log= display.getText()+"%"+"="+ans;
                        store(log);
			display.setText(String.valueOf(ans));
                        
		} // For Inverse
		else if (event.getSource() == inverse) {

			try {
				float ans = Operation.divide(1, Float.parseFloat(display.getText()));
				String log = "1 / " + display.getText() + " = " + ans;
				display.setText(String.valueOf(ans));
				store(log);
			} catch (Exception e) {
				display.setText("Error");
			}

		} // For square
		else if (event.getSource() == square) {
			float ans = (Float.parseFloat(display.getText()));
			display.setText(String.valueOf(ans * ans));
			String log = ans + "^2 = " + (ans * ans);
			store(log);
		} // For Cube
		else if (event.getSource() == cube) {
			float ans = (Float.parseFloat(display.getText()));
			display.setText(String.valueOf(ans * ans * ans));
			String log = ans + "^3 = " + (ans * ans * ans);
			store(log);
		} // For Making a Number Negative
		else if (event.getSource() == makenegative) {
			float ans = (-1)*Float.parseFloat(display.getText());
			display.setText(String.valueOf(ans));
			String log = ans + " * (-1) = " + (ans);
			store(log);
		} // For Printing PI value
		else if (event.getSource() == pi) {
			float ans = (float) Math.PI;
			display.setText(String.valueOf(ans));
                         String log= String.valueOf(ans) ;
                         store(log);
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}

	
}

package calculator;

import javax.script.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import java.lang.String;

public class Calculator extends Application {
	
	// Containers declaration
	private VBox root;
	private HBox columnsWrapper;
	private VBox column1, column2, column3, column4;

	// Components declaration
	private Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bPoint,bClear,bPlus,bMinus,bProduct,bQuot,bResult;
	private Label display;
	
	// Support variables
	private String str;
	private boolean resultShowing,	// True when a result is shown
					decimalPart;	// True when writing the decimal part of a number
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Calculator");

		// Scripting engine setup
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
		
		// Components instantiation
		root = new VBox(5);
		display = new Label();
		
		// Buttons instantiation
		b1 = new Button("1");
		b2 = new Button("2");
		b3 = new Button("3");
		b4 = new Button("4");
		b5 = new Button("5");
		b6 = new Button("6");
		b7 = new Button("7");
		b8 = new Button("8");
		b9 = new Button("9");
		b0 = new Button("0");
		bPoint = new Button(",");
		bClear = new Button("C");
		bPlus = new Button("+");
		bMinus = new Button("-");
		bProduct = new Button("×");
		bQuot = new Button("/");
		bResult = new Button("=");
		
		// Containers instantiation
		columnsWrapper = new HBox(5);
		column1 = new VBox(3);
		column2 = new VBox(3);
		column3 = new VBox(3);
		column4 = new VBox(3);

		// Alignment setup
		root.setAlignment(Pos.CENTER);
		column1.setAlignment(Pos.CENTER);
		column2.setAlignment(Pos.CENTER);
		column3.setAlignment(Pos.CENTER);
		column4.setAlignment(Pos.CENTER);
		columnsWrapper.setAlignment(Pos.CENTER);
		
		// Content wrap
		column1.getChildren().addAll(b7,b4,b1,bClear);
		column2.getChildren().addAll(b8,b5,b2,b0);
		column3.getChildren().addAll(b9,b6,b3,bPoint);
		column4.getChildren().addAll(bPlus,bMinus,bProduct,bQuot);
		columnsWrapper.getChildren().addAll(column1, column2, column3, column4);
		root.getChildren().addAll(display, columnsWrapper, bResult);
		
		// Buttons handling
		b1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				str = display.getText();
				if(resultShowing) {	// Result scenario handling
					str = "";
					resultShowing = false;
				}
				// Text appending
				display.setText(str+"1");
			}
		});
		b2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				str = display.getText();
				if(resultShowing) {	// Result scenario handling
					str = "";
					resultShowing = false;
				}
				// Text appending
				display.setText(str+"2");
			}
		});
		b3.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				str = display.getText();
				if(resultShowing) {	// Result scenario handling
					str = "";
					resultShowing = false;
				}
				// Text appending
				display.setText(str+"3");
			}
		});
		b4.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				str = display.getText();
				if(resultShowing) {	// Result scenario handling
					str = "";
					resultShowing = false;
				}
				// Text appending
				display.setText(str+"4");
			}
		});
		b5.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				str = display.getText();
				if(resultShowing) {	// Result scenario handling
					str = "";
					resultShowing = false;
				}
				// Text appending
				display.setText(str+"5");
			}
		});
		b6.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				str = display.getText();
				if(resultShowing) {	// Result scenario handling
					str = "";
					resultShowing = false;
				}
				// Text appending
				display.setText(str+"6");
			}
		});
		b7.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				str = display.getText();
				if(resultShowing) {	// Result scenario handling
					str = "";
					resultShowing = false;
				}
				// Text appending
				display.setText(str+"7");
			}
		});
		b8.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				str = display.getText();
				if(resultShowing) {	// Result scenario handling
					str = "";
					resultShowing = false;
				}
				// Text appending
				display.setText(str+"8");
			}
		});
		b9.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				str = display.getText();
				if(resultShowing) {	// Result scenario handling
					str = "";
					resultShowing = false;
				}
				// Text appending
				display.setText(str+"9");
			}
		});
		b0.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				str = display.getText();
				if(str != "")	// Check this prior to prevent out of index error
					if(!str.substring(str.length() - 1).matches("/"))	// Avoiding dividing by zero
						if(!resultShowing)	// Result scenario handling
							display.setText(str+"0");	// Text appending
			}
		});
		bPoint.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				str = display.getText();
				if(str != "")
					// The following prevents: a point after a result, a point after !numbers, a second point for the same number
					if(!resultShowing && str.substring(str.length() - 1).matches("[0-9]") && !decimalPart) {
						display.setText(str+".");	// Text appending
						decimalPart = true;			// Marking the following numbers as decimal part till a symbol breaks in, or result is pressed
					}
			}
		});
		bPlus.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				decimalPart = false;
				str = display.getText();
				if(str != "")	// Check this prior to prevent out of index error
					// The following prevents: a symbol after a result, a symbol after a symbol
					if(!resultShowing && str.substring(str.length() - 1).matches("[0-9]"))
						display.setText(str+"+");	// Text appending
			}
		});
		bMinus.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				decimalPart = false;
				str = display.getText();
				if(str != "")	// Check this prior to prevent out of index error
					// The following prevents: a symbol after a result, a symbol after a symbol
					if(!resultShowing && str.substring(str.length() - 1).matches("[0-9]"))
						display.setText(str+"-");	// Text appending
			}
		});
		bProduct.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				decimalPart = false;
				str = display.getText();
				if(str != "")	// Check this prior to prevent out of index error
					// The following prevents: a symbol after a result, a symbol after a symbol
					if(!resultShowing && str.substring(str.length() - 1).matches("[0-9]"))
						display.setText(str+"×");	// Text appending
			}
		});
		bQuot.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				decimalPart = false;
				str = display.getText();
				if(str != "")	// Check this prior to prevent out of index error
					// The following prevents: a symbol after a result, a symbol after a symbol
					if(!resultShowing && str.substring(str.length() - 1).matches("[0-9]"))
						display.setText(str+"/");	// Text appending
			}
		});
		bClear.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				display.setText("");
			}
		});
		
		// Calculation
		bResult.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				decimalPart = false;
				str = display.getText();
				try {
					// Parsing the label content with the JavaScript engine (Replacing X with *)
					str = String.valueOf(engine.eval(str.replace("×","*")));
				} catch (ScriptException e) {
					str = "Unexpected. Press C.";
				}
				display.setText(str);
				resultShowing = true;
			}
		});
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		
		stage.show();
	}

}

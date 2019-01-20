import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.event.*;
public class WorkingLoanCalculator extends Application
{
	private TextField TInterest;//nodes are set as datafield to give innerclass access to nodes
	private TextField TYear;
	private TextField TAmount;
	private TextField TMPayment;
	private TextField TTPayment;
	private Button CalcButton;
	public void start (Stage CalcStage)//start method override
	{
		CalcStage.setTitle("Loan Calculator");//stage
		GridPane Root = new GridPane();//root
		Scene CalcScene = new Scene(Root, 375, 230);//root on a scene
		CalcStage.setResizable(false);
		Root.setPadding(new Insets(15));//spacing
		Root.setHgap(5);
		Root.setVgap(5);

		Label Interest = new Label("Annual Interest Rate: ");
		Root.add(Interest,0,0);//add label at index 0, 0
		TInterest = new TextField();
		Root.add(TInterest,1,0);//add text field at index 1, 0
		

		Label Year = new Label("Number of Years: ");
		Root.add(Year,0,1);
		TYear = new TextField();
		Root.add(TYear,1,1);


		Label Amount = new Label("Loan Amount: ");
		Root.add(Amount,0,2);
		TAmount = new TextField();
		Root.add(TAmount,1,2);
		
		
		Label MPayment = new Label("Monthly Payment: ");
		Root.add(MPayment,0,3);
		TMPayment = new TextField();
		Root.add(TMPayment,1,3);
		
		Label TPayment = new Label("Total Payment: ");
		Root.add(TPayment,0,4);
		TTPayment = new TextField();
		TMPayment.setEditable(false);
		TTPayment.setEditable(false);//makes textfield uneditable
		Root.add(TTPayment,1,4);
		
		CalcButton = new Button("Calculate");
		Root.add(CalcButton,1,5);
		CalcButton.setOnAction(new CalculateHandler());//registers event handler 
		Root.setHalignment(CalcButton, HPos.RIGHT);//right aligns the calculate button
		CalcStage.setScene(CalcScene);//sets the scene with the nodes on the stage
		
		CalcStage.show();//shows stage
	}
	class CalculateHandler implements EventHandler<ActionEvent>//handles calculate button click
	{
		public void handle(ActionEvent e)
		{
			String StringInterest = TInterest.getText();//gets the text from textfields when calculate button is clicked
			String StringYear = TYear.getText();
			String StringAmount = TAmount.getText();
			double ConvertedInterest = Double.parseDouble(StringInterest);//textfields converted to doubles
			double ConvertedYear = Double.parseDouble(StringYear);
			double ConvertedAmount = Double.parseDouble(StringAmount);
			double MonthlyInterestRate = (ConvertedInterest/100)/12;//finding helpful values
			double MonthNum = ConvertedYear * 12;
			double Top = MonthlyInterestRate * ConvertedAmount;
			double Bottom = 1-(Math.pow((1+MonthlyInterestRate), ((-1)*(MonthNum))));
			double CalculatedMonthlyPayment = Top/Bottom;//simply computing monthly payment
			double CalculatedTotalPayment = MonthNum * CalculatedMonthlyPayment;
			String MonthlyText = "";//converting payments to string
			MonthlyText = Double.toString(CalculatedMonthlyPayment); 
			TMPayment.setText(MonthlyText);//displaying string in uneditable textfields
			String TotalText = "";
			TotalText = Double.toString(CalculatedTotalPayment); 
			TTPayment.setText(TotalText);
		}
		
	}

	public static void main(String [] args)
	{
		launch(args);
	}
}

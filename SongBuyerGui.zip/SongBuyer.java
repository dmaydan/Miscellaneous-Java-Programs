import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.event.*;
import javafx.collections.*;
import javafx.beans.value.*;
public class SongBuyer extends Application
{
	private Label ShoppingCart;//datafields that must be used by handlers
	private String ShoppingMessage = "Your Shopping Cart Contains: ";//goes into shopping cart 
	private Button CalcButton;
	private Button ExitButton;
	private double PurchaseCost;
	private Label PurchaseLabel;
	private ListView<String> SongListView;
	private Song Happy = new Song("Happy", "Will Pharrel", 1);
	private Song Firegirl = new Song("Girl On Fire", "Alicia Keys", 1);
	private Song Skyfall = new Song("SkyFall","Adele", 1);
	private Song Living = new Song("Livin' La Vida Loca", "Ricky Martin", 1);
	private Song Gangnam = new Song("Gangnam Style", "PSY", 1);
	public void start (Stage SongStage)//start method override
	{
		ShoppingCart = new Label(ShoppingMessage);
		SongStage.setTitle("Song Checkout");//stage
		GridPane Root = new GridPane();//root
		Scene SongScene = new Scene(Root, 425, 300);
		SongStage.setResizable(false);
		Root.setPadding(new Insets(15));
		Root.setHgap(10);
		Root.setVgap(15);
		Root.add(ShoppingCart, 0, 4);
		PurchaseLabel = new Label("Purchase Price: ");
		Root.add(PurchaseLabel, 0, 5);
		Label Name = new Label("Name: ");
		Root.add(Name, 0, 0);
		TextField TName = new TextField();
		Root.add(TName, 1, 0);
		Label Email = new Label("Email Address: ");
		Root.add(Email, 0, 1);
		TextField TEmail = new TextField();
		Root.add(TEmail, 1, 1);
		Label Song = new Label("Choose Your Song: ");
		Root.add(Song, 0, 2);//add songs to observable list of strings
		ObservableList<String> Songs = FXCollections.observableArrayList(Happy.GetTitle(), Firegirl.GetTitle(), Skyfall.GetTitle(), Living.GetTitle(), Gangnam.GetTitle());
		SongListView  = new ListView<String>(Songs);
		SongListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);//set selection mode to multiple
		MultipleSelectionModel<String>SelectionMod = SongListView.getSelectionModel();//get selection model
		SelectionMod.selectedItemProperty().addListener(new ListViewHandler());//add listener to multiple selection model
		Root.add(SongListView, 1, 2);
		Label Payment = new Label("Choose Your Payment");
		Root.add(Payment, 0, 3);
		ObservableList<String> CreditCards = FXCollections.observableArrayList("Amex", "Visa", "MasterCard");//observable list of string credit cards
		ListView<String> PaymentList  = new ListView<String>();
		PaymentList.setItems(CreditCards);
		PaymentList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);//(default)
		Root.add(PaymentList, 1, 3);
		CalcButton = new Button("Calculate");
		Root.add(CalcButton,1,5);
		ExitButton = new Button("Exit");
		Root.add(ExitButton, 1, 6);
		Root.setHalignment(ExitButton, HPos.RIGHT);//right align
		Root.setHalignment(CalcButton, HPos.RIGHT);//right align
		ExitButton.setOnAction(new ExitHandler());//register handler
		CalcButton.setOnAction(new CostHandler());//register handler
		GridPane.setColumnSpan(ShoppingCart, GridPane.REMAINING);//allow shopping cart label to span entire row
		SongStage.setScene(SongScene);//sets the scene with the nodes on the stage
		SongStage.show();//shows stage
	}
	class ListViewHandler implements ChangeListener<String>//change listener
	{
		public void changed(ObservableValue<? extends String> change, String oldVal, String newVal)
		{
			ShoppingMessage = "Your Shopping Cart Contains: ";//reset shopping cart label
			ObservableList<String>SelectedSongNames;
			SelectedSongNames = SongListView.getSelectionModel().getSelectedItems();//observable list of selected items
			for (String Song: SelectedSongNames)//loops through selected items
			{
				ShoppingMessage = ShoppingMessage + Song + " ";//add selected songs to shopping message
			}
			ShoppingCart.setText(ShoppingMessage);//display message on shopping cart label 
		}
	}
	class CostHandler implements EventHandler<ActionEvent>//handles calculate button click
	{
		public void handle(ActionEvent e)
		{
			ObservableList<String>SongObjectNames;
			SongObjectNames = SongListView.getSelectionModel().getSelectedItems();//observable list of selected items
			for (String Song: SongObjectNames)//loops through selected items and adds each item to total cost of cart
			{
				if (Song.equals("Happy"))
				{
					PurchaseCost = PurchaseCost + Happy.GetPrice();
				}
				if (Song.equals("Girl On Fire"))
				{
					PurchaseCost = PurchaseCost + Firegirl.GetPrice();
				}
				if (Song.equals("SkyFall"))
				{
					PurchaseCost = PurchaseCost + Skyfall.GetPrice();
				}
				if (Song.equals("Livin' La Vida Loca"))
				{
					PurchaseCost = PurchaseCost + Living.GetPrice();
				}
				if (Song.equals("Gangnam Style"))
				{
					PurchaseCost = PurchaseCost + Gangnam.GetPrice();
				}
			}
			PurchaseLabel.setText("Purchase Price: $" + PurchaseCost); 
			PurchaseCost = 0;
			
		}
	}
	class ExitHandler implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent e)
		{
			System.exit(0);//terminate program
		}
	}
	public static void main(String [] args)
	{
		launch(args);
	}
}


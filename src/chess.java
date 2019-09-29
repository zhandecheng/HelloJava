package chess;

import board.ChessBoard;
import board.Square;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
//import javafx.scene.layout.HBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.Font;
import javafx.scene.control.TextArea;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.geometry.Insets;
//import pieces.Bishop;
//import pieces.King;
//import pieces.Knight;
//import pieces.Pawn;
//import pieces.Queen;
import pieces.Rook;
import pieces.Queena;
import pieces.Bishopaa;
import pieces.Bishopab;
import pieces.Bishopba;
import pieces.Bishopbb;
import pieces.Kinga;
import pieces.Kingb;
import pieces.Knightaa;
import pieces.Knightab;
import pieces.Knightba;
import pieces.Knightbb;
import pieces.Pawnaa;
import pieces.Pawnab;
import pieces.Pawnac;
import pieces.Pawnad;
import pieces.Pawnae;
import pieces.Pawnaf;
import pieces.Pawnag;
import pieces.Pawnah;
import pieces.Pawnba;
import pieces.Pawnbb;
import pieces.Pawnbc;
import pieces.Pawnbd;
import pieces.Pawnbe;
import pieces.Pawnbf;
import pieces.Pawnbg;
import pieces.Pawnbh;
import pieces.Piece;
import pieces.Queena;
import pieces.Queenb;
import pieces.Rookaa;
import pieces.Rookab;
import pieces.Rookba;
import pieces.Rookbb;

public class chess extends Application {
	//public  static int i=1;
	public static Stage window;
    public	 Scene menuScene, gameScene;//�˵���������Ϸ����
	public  static Scene pawnUpScreen ;
	public static Scene gameOverScreen;
	public static Scene winScreen;//��������
	public Square qs = new Square(Color.WHITE);
	public static TextArea note= new TextArea();
	
	public void start(Stage primaryStage) throws Exception {
		
		window = primaryStage;
		Pane pane = new Pane();
		
		Image image = new Image("images/1.png");
		ImageView imageView = new ImageView("images/1.png");
		pane.getChildren().add(new ImageView(image));
 
		// Menu----------------------------------------------------------

		Label gameName = new Label(" �������ϵͳ");//��Ϸ��
		pane.getChildren().add(gameName);
		gameName.setLayoutY(150);//labelλ��
		gameName.setFont(new Font("KaiTi",100));//�����С
		
		Button startButton = new Button("Start");//��ʼ��ť
		Button exitButton = new Button("Exit");//ȡ����ť
		startButton.setPrefSize(170,70);
		exitButton.setPrefSize(170,70);
        startButton.setStyle("-fx-background-color:ALICEBLUE");
		exitButton.setStyle("-fx-background-color:ALICEBLUE");
		startButton.setFont(Font.font("Times New Roman",30));
		exitButton.setFont(Font.font("Times New Roman",30));

		String style1 = "-fx-font-size: 3em;";
//		String style2 = "-fx-background-color: linear-gradient(#f2f2f2, #d6d6d6), linear-gradient(#fcfcfc 0%, #d9d9d9 20%, #d6d6d6 100%), "
//						+ "linear-gradient(#dddddd 0%, #f6f6f6 50%); -fx-background-radius: 8,7,6; -fx-background-insets: 0,1,2; -fx-text-fill: black;"
//						+ "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 ); -fx-font-size: 1.9em; -fx-padding: 10px;";

		VBox menuVBox = new VBox(40);//�˵�����
		menuVBox.setAlignment(Pos.CENTER);//����
		

		menuVBox.getChildren().addAll(startButton, exitButton);
		menuVBox.setSpacing(80);
		menuVBox.setAlignment(Pos.CENTER);//��Ӱ�ť
		
		
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(pane);
		borderPane.setBottom(menuVBox);
		Scene menuScene = new Scene(borderPane,700,600);

		

		// Game----------------------------------------------------------

		ChessBoard board = new ChessBoard();//�������̶��󣬵�������
		//Text steps = new Text("steps");
		
		//steps.setX(150.0);
		
		
		//String StepsStyle = "-fx-font-size: 2em;";
		//steps.setStyle(StepsStyle);

//		note.setPrefRowCount(300);
//		note.setPrefColumnCount(15);
//	
//		note.setFont(Font.font("Times",15));
//	    note.setWrapText(true);
//		ScrollPane scoring = new ScrollPane(note);
//	
//		BorderPane root =new BorderPane();
//		root.setRight(scoring);
//		root.setLeft(board);
		
		
		Scene gameScene = new Scene(board, Square.SIZE * 8+300,Square.SIZE * 8);
		
		startButton.setOnAction(e -> primaryStage.setScene(gameScene));//�����ʼ��Ť����ʾ��Ϸ����
		exitButton.setOnAction(e -> System.exit(0));//���ȡ����ť���˳���Ϸ/����
		//�ѽ����С��Ƶøոպá�����

		// Win----------------------------------------------------------

		Label win = new Label("��ϲ�㣬Ӯ�ˣ�");

		win.setStyle(style1);

		VBox winVBox = new VBox(40);//����
		
		winVBox.setAlignment(Pos.CENTER);

		winVBox.getChildren().add(win);

		winScreen = new Scene(winVBox, Square.SIZE * 8, Square.SIZE * 8, Color.BLACK);//����ʤ������

		

		// Game Over----------------------------------------------------------

		Label gameOverLabel = new Label("GAME OVER");

		String style3 = "-fx-font-size: 3em;";

		gameOverLabel.setStyle(style3);//������

		VBox gameOverVBox = new VBox(40);
		gameOverVBox.setAlignment(Pos.CENTER);

		gameOverVBox.getChildren().add(gameOverLabel);

	 gameOverScreen = new Scene(gameOverVBox, Square.SIZE * 8, Square.SIZE * 8, Color.BLACK);
	

//	//pawnUp---------------------------------------------------------------
//	 Button uptoQueen = new Button("Queen");
//		Button uptoRook  = new Button("Rook");
//		Button uptoKnight = new Button("Knight");
//		Button  uptoBishop  = new Button("Rook");
//		VBox pawnUpVBox = new VBox(40);
//		pawnUpVBox.getChildren().add(uptoBishop);
//		pawnUpVBox.getChildren().add(uptoKnight);
//		pawnUpVBox.getChildren().add(uptoRook);
//		pawnUpVBox.getChildren().add(uptoQueen);
//		  pawnUpScreen = new Scene(pawnUpVBox,Square.SIZE * 4, Square.SIZE * 4, Color.BLACK);
	 
		window.getIcons().add(new Image("images/WHITE_KING.png"));
		window.setTitle("Chess scoring system");
	//	window.setResizable(false);//�����С���ɸı�
		window.setScene(menuScene);
		window.show();//��ʾ
	}
	public static void pawnUp(Square a,Square b) {//�������䷽��
		Stage pawnUpStage = new Stage();
		Button uptoQueen = new Button("Queen");
		Button uptoRook  = new Button("Rook");
		Button uptoKnight = new Button("Knight");
		Button  uptoBishop  = new Button("Rook");
		VBox pawnUpVBox = new VBox(40);
		pawnUpVBox.getChildren().add(uptoBishop);
		pawnUpVBox.getChildren().add(uptoKnight);
		pawnUpVBox.getChildren().add(uptoRook);
		pawnUpVBox.getChildren().add(uptoQueen);
		pawnUpScreen = new Scene(pawnUpVBox,Square.SIZE * 4, Square.SIZE * 4, Color.BLACK);
		pawnUpStage.setScene(pawnUpScreen);
		pawnUpStage.setTitle("pawnUp");
		pawnUpStage.setResizable(false);
	//	pawnUpScreen.setScene(menuScene);
		pawnUpStage.show();
	
		uptoQueen.setOnMouseClicked(e->{
			
			pawnUpStage.close();
			a.piece = null;//��active�����pieceΪnull
			b.removeMoveMark();
			b.makeInactive();
			b.addPiece(new Queena(Color.WHITE));
			Square.turnCounter++;
		Square.i=1;
		Square.stop = false;
		});
		uptoRook.setOnMouseClicked(e->{
			pawnUpStage.close();
			a.piece = null;//��active�����pieceΪnull
			b.removeMoveMark();
			b.makeInactive();
			b.addPiece(new Rookaa(Color.WHITE));
			Square.turnCounter++;
		Square.i=2;
		Square.stop = false;
		});
		uptoKnight.setOnMouseClicked(e->{
			pawnUpStage.close();
			a.piece = null;//��active�����pieceΪnull
			b.removeMoveMark();
			b.makeInactive();
			b.addPiece(new Knightaa(Color.WHITE));
			Square.turnCounter++;
		Square.i=3;
		Square.stop = false;
		});
		uptoBishop.setOnMouseClicked(e->{
			pawnUpStage.close();
			a.piece = null;//��active�����pieceΪnull
			b.removeMoveMark();
			b.makeInactive();
			b.addPiece(new Bishopaa(Color.WHITE));
			Square.turnCounter++;
		Square.i=4;
		Square.stop = false;
		});
	//	Square.stop = false;
	}

	public static void gameOver() {
		window.setScene(gameOverScreen);
	}//������

	public static void win() {
		window.setScene(winScreen);
	}//������
	
	

	public static void main(String[] args) {	 
		launch(args);
	}
	
}

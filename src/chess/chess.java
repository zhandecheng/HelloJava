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
//import javafx.geometry.Insets;
//import pieces.Bishop;
//import pieces.King;
//import pieces.Knight;
//import pieces.Pawn;
//import pieces.Queen;
//import pieces.Rook;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.URI;
import java.net.URL;

public class chess extends Application {
	//public  static int i=1;
	public static Stage window;
    public	 Scene menuScene, gameScene;//菜单界面与游戏界面
	public  static Scene pawnUpScreen ;
	public static Scene gameOverScreen;
	public static Scene winScreen;//结束界面
	public Square qs = new Square(Color.WHITE);
	public static TextArea note= new TextArea();
	
	 //背景音乐
    class Music extends Application {
        File f;
        URI uri;
        URL url;
        Music(){
            try{
                f = new File("");
                uri = f.toURI();
                url = uri.toURL(); //解析地址
                AudioClip aau;
                aau = Applet.newAudioClip(url);
                aau.loop(); //循环播放
            }catch (Exception e ){
                e.printStackTrace();
            }
        }
	
	public void start(Stage primaryStage) throws Exception {
		
		window = primaryStage;
		Pane pane = new Pane();
		
		Image image = new Image("images/1.png");
		ImageView imageView = new ImageView("images/1.png");
		pane.getChildren().add(new ImageView(image));
 
		// Menu----------------------------------------------------------

		Label gameName = new Label(" 国际象棋");//游戏名
		pane.getChildren().add(gameName);
		gameName.setLayoutY(150);//label位置
		gameName.setFont(new Font("KaiTi",100));//字体大小
		
		Button startButton = new Button("Start");//开始按钮
		Button exitButton = new Button("Exit");//取消按钮
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

		VBox menuVBox = new VBox(40);//菜单横行
		menuVBox.setAlignment(Pos.CENTER);//居中
		

		menuVBox.getChildren().addAll(startButton, exitButton);
		menuVBox.setSpacing(80);
		menuVBox.setAlignment(Pos.CENTER);//添加按钮
		
		
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(pane);
		borderPane.setBottom(menuVBox);
		Scene menuScene = new Scene(borderPane,700,600);

		

		// Game----------------------------------------------------------

		ChessBoard board = new ChessBoard();//创建棋盘对象，调出棋盘
		//Text steps = new Text("steps");
		
		//steps.setX(150.0);
		
		
		//String StepsStyle = "-fx-font-size: 2em;";
		//steps.setStyle(StepsStyle);

		note.setPrefRowCount(300);
		note.setPrefColumnCount(15);
	
		note.setFont(Font.font("Times",15));
	    note.setWrapText(true);
		ScrollPane scoring = new ScrollPane(note);
	
		BorderPane root =new BorderPane();
		root.setRight(scoring);
		root.setLeft(board);
		
		
		Scene gameScene = new Scene(root,Square.SIZE * 8+300,Square.SIZE * 8);
		
		startButton.setOnAction(e -> primaryStage.setScene(gameScene));//点击开始按扭，显示游戏界面
		exitButton.setOnAction(e -> System.exit(0));//点击取消按钮，退出游戏/程序
		//把界面大小设计得刚刚好。。。

		// Win----------------------------------------------------------

		Label win = new Label("恭喜你，赢了！");

		win.setStyle(style1);

		VBox winVBox = new VBox(40);//纵向
		
		winVBox.setAlignment(Pos.CENTER);

		winVBox.getChildren().add(win);

		winScreen = new Scene(winVBox, Square.SIZE * 8, Square.SIZE * 8, Color.BLACK);//创建胜利界面

		

		// Game Over----------------------------------------------------------

		Label gameOverLabel = new Label("GAME OVER");

		String style3 = "-fx-font-size: 3em;";

		gameOverLabel.setStyle(style3);//！！！

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
	//	window.setResizable(false);//窗体大小不可改变
		window.setScene(menuScene);
		window.show();//显示
	}
	public static void pawnUp() {
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
		Square.i=1;
		});
	}

	public static void gameOver() {
		window.setScene(gameOverScreen);
	}//！！！

	public static void win() {
		window.setScene(winScreen);
	}//！！！
	
	

	public static void main(String[] args) {	 
		new Music();
		launch(args);
	}
	
}

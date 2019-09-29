package board;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import chess.chess;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
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
import pieces.PieceRole;
import pieces.Queena;
import pieces.Queenb;
import pieces.Rookaa;
import pieces.Rookab;
import pieces.Rookba;
import pieces.Rookbb;

public class Square extends Group {
	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public  static int i;
	public  static boolean stop = true;
    public int n;
	public static final double SIZE = 100;//方块大小
	private Rectangle bg;//矩形
	private Color originalColor;//颜色
	public Piece piece;//piece类
	public static int mov=0;
	public String dir = null;
	public int counter ;
	public boolean CanBeClear = false;
	
	
	public static Square active;//square类,分清this,piece和active.piece的区别
	public static int turnCounter = 0;//计数器,记录当前是第几步
	int a = 1;
	public static ArrayList<Square> marked = new ArrayList<Square>();//square数组
public 	Piece b = piece;
	
	public Square(Color c) {//构造方法，参数为color
		originalColor = c;//让颜色的值等于color
		bg = new Rectangle(SIZE, SIZE, c);//80*80的方块，c为颜色
		this.getChildren().add(bg);//添加矩形，

		this.setOnMouseClicked(event -> {//点击事件
		
			if (marked.contains(this)) {//如果当前square在marked中
				this.CanBeClear = active.CanBeClear;
				System.out.println(marked.size());
			 Piece p = active.piece;//square active 里面的棋子为p;
				System.out.println(p);//
				System.out.println(this.piece);
				b=p;
				@SuppressWarnings("unused")
				int row = row();
				@SuppressWarnings("unused")
				int col = col();
             
				System.out.println("当前棋子坐标的为：("+ (row+1)+"," +(col+1)+")");
              
				chess.note.appendText("  to：("+ (row+1)+"," +(col+1)+")");
				try {
					File file =new File("D:\\2.txt");
					Writer out =new FileWriter(file, true);//FileWriter(file);
				
					out.write("  to：("+ (row+1)+"," +(col+1)+")/");
					out.close();
				}
				catch(IOException ex){
					
				}
				
//				
//			if(p instanceof Pawnaa && this.row() ==0) {
//				this.getChildren().remove(this.getChildren().size() - 1);
//				
//				this.addPiece(new Queena(Color.WHITE));
//				
//			}
				

				if (this.piece instanceof Kinga) {//如果当前的square是kinga的话
					if (this.piece.getColor() == Color.WHITE ) {//如果当前棋子的颜色是白色
						chess.gameOver();//调用gameover
						System.out.println("GAME OVER");
					}
					
					//return;
				}
				if (this.piece instanceof Kingb ) {{//如果当前square中的piece是kingb
					chess.win();//显示win界面
					System.out.println("Congratulations! You won in "+ Square.turnCounter + " turns!");
				}
				}
//				if(this.piece instanceof Pawnba) {
//					PieceRole.mov=PieceRole.mov+1;
//				}
//
//				active.piece = null;//让active里面的piece为null
//				this.makeInactive();//
//				turnCounter++;//计数器加一
				
				//stem.out.println("Turn #"+ turnCounter);
				
				
				
				//判断是否可以进行吃过路兵
				if(active.piece instanceof Pawnba && this.row()== 3&&active.row()==1) {
					if(ChessBoard.getSquare(this.col()+1,3).getPiece() instanceof Pawnaa) {
						dir = "rigth";
						
						
					}
					else	if(ChessBoard.getSquare(this.col()-1,3).getPiece() instanceof Pawnaa) {
						dir = "left";
					}
					mov++;
					counter = turnCounter;
				}
				
				
				
				if(active.piece instanceof Pawnaa && active.row() ==1) {
					
					chess.pawnUp(active,this);
	
					active.getChildren().remove(active.getChildren().size()-1);
				}
				else {
					active.piece = null;//让active里面的piece为null
					System.out.println(CanBeClear);
					if(this.CanBeClear==true) {
						
						ChessBoard.getSquare(col(),3).getChildren().remove(ChessBoard.getSquare(col(),3).piece);
						ChessBoard.getSquare(col(),3).piece =null;
						//ChessBoard.getSquare(col(),3).getChildren().remove(ChessBoard.getSquare(col(),3).getChildren().size()-1);
						//( ChessBoard.getSquare(col(),3)).getBackground().setFill(originalColor);
						this.CanBeClear = false;
					}
				this.makeInactive();//
				
				turnCounter++;//计数器加一
				
				this.addPiece(p);}
				
				
				
		//p.move();
				//return;
			}

			if (!hasPiece()) {
				return;
			}

			if (hasPiece()) {
				if (turnCounter % 2 == 0 && piece.getColor() == Color.BLACK) { // White
					return;
				}
				if (turnCounter % 2 == 1 && piece.getColor() == Color.WHITE) { // Black
					return;
				}
			//	PieceRole.GuoLuEatPawn(this);
				makeActive();
				if(this.piece instanceof Pawnaa && mov >0&& this.row()==3) {
					//if(dir == "left") {
				   this.CanBeClear = true;
						ChessBoard.getSquare(this.col()-1, this.row() - 1).moveMark();
					
					//}
					//if(dir=="rigth") {
					//	ChessBoard.getSquare(this.col()+1, this.row() - 1).moveMark();
					//}
				}
			//	CanBeClear = true;
				@SuppressWarnings("unused")
				int row = row();
				@SuppressWarnings("unused")
				int col = col();
//				if(this.piece instanceof Pawnaa&&row==0) {
//					this.getChildren().remove(this.getChildren().size() - 1);
//				
//					this.addPiece(new Queena(Color.WHITE));}    
					
				
				//	PieceRole.GuoLuEatPawn(this);	
						
					
				
				
				
			//	System.out.println(b.getClass().getSimpleName().toUpperCase());
				System.out.println("当前棋子的行数为："+ (row+1) +"当前棋子的列数为："+ (col+1));
				
				
					}
		//	} 

			 
//			else {
//				if (active != null) {
//					active.makeInactive();
//				}
//				mark(this.piece.getColor());
//			}
		});
	}

	public int col() {
		int y = row();
		for (int i = 0; i < 8; i++) {
			if (ChessBoard.all_squares.get(y).get(i) == this) {
				return i;
			}
		}
		return -1;
		
	}
	
	public int row() {
		for (int i = 0; i < 8; i++) {
			if (ChessBoard.all_squares.get(i).contains(this)) {
				return i;
			}
		}
		return -1;
	}

	public void moveMark() {
		Circle cir = new Circle(SIZE / 2, SIZE / 2, SIZE / 10, Color.YELLOW);
		this.getChildren().add(cir);
		marked.add(this);
	}

	public void mark(Color c) {
		if (!this.hasPiece()) {
			moveMark();
		} else {
			if (this.piece.getColor() != c) {
				attackMark();
			}
		}
	}

	public void attackMark() {
		Circle cir = new Circle(SIZE / 2, SIZE / 2, SIZE / 10, Color.RED);
		this.getChildren().add(cir);
		marked.add(this);
	}

	 public void removeMoveMark() {
		for (Square square : marked) {
			square.getChildren().remove(square.getChildren().size() - 1);//
			//System.out.print(square.getChildren().size() - 1+"/n");
		}
		
		marked.clear();//从list中删除所有元素
	}

	public  void makeActive() {
		if (active != null) {
			active.makeInactive();
		}
		active = this;
		this.piece.showMove(col(), row());
		//this.getBackground().setFill(Color.GREEN);
	}

	public void makeInactive() {
		removeMoveMark();
		active = null;
		this.getBackground().setFill(originalColor);
	}

	public void addPiece(Piece p) {
		if (hasPiece()) {
			this.getChildren().remove(piece);//remove 是自带函数
		}
		this.piece = p;
		this.getChildren().add(p);
	}

	
	public boolean hasPiece() {
		return this.piece != null;
	}

	public Rectangle getBackground() {
		return this.bg;
	}

	public Boolean turn(int i) {
		boolean whiteTurn =true;		
		if (i % 2 == 0) {
			return whiteTurn = false;
		} else {
			return whiteTurn;
		}		
	}	
}

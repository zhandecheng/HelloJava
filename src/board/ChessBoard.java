package board;



import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.paint.Color;
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
import pieces.Queena;
import pieces.Queenb;
import pieces.Rookaa;
import pieces.Rookab;
import pieces.Rookba;
import pieces.Rookbb;


public class ChessBoard extends Group {

	public static ArrayList<ArrayList<Square>> all_squares = new ArrayList<ArrayList<Square>>();

	public ChessBoard() {

		for (int row = 0; row < 8; row++) {
			ArrayList<Square> arrRow = new ArrayList<Square>();//创建方块数列共八个数列
			for (int col = 0; col < 8; col++) {

				Color bg = Color.DIMGRAY;//全为暗灰色
				if ((row + col) % 2 == 0) {
					bg = Color.WHITE;//横纵相加为偶数变为白色
				}

				Square s = new Square(bg);
				s.setTranslateX(col * Square.SIZE);//!!!
				s.setTranslateY(row * Square.SIZE);//!!!
				this.getChildren().add(s);
				arrRow.add(s);

				// PAWNS
				if (row == 1&&col==0) {
					s.addPiece(new Pawnba(Color.BLACK));
				}
				if (row == 1&&col==1) {
					s.addPiece(new Pawnbb(Color.BLACK));
				}
				if (row == 1&&col==2) {
					s.addPiece(new Pawnbc(Color.BLACK));
				}
				if (row == 1&&col==3) {
					s.addPiece(new Pawnbd(Color.BLACK));
				}
				if (row == 1&&col==4) {
					s.addPiece(new Pawnbe(Color.BLACK));
				}
				if (row == 1&&col==5) {
					s.addPiece(new Pawnbf(Color.BLACK));
				}
				if (row == 1&&col==6) {
					s.addPiece(new Pawnbg(Color.BLACK));
				}
				if (row == 1&&col==7) {
					s.addPiece(new Pawnbh(Color.BLACK));
				}

				if (row == 6&&col==0) {
					s.addPiece(new Pawnaa(Color.WHITE));
				}
				if (row == 6&&col==1) {
					s.addPiece(new Pawnab(Color.WHITE));
				}
				if (row == 6&&col==2) {
					s.addPiece(new Pawnac(Color.WHITE));
				}
				if (row == 6&&col==3) {
					s.addPiece(new Pawnad(Color.WHITE));
				}
				if (row == 6&&col==4) {
					s.addPiece(new Pawnae(Color.WHITE));
				}
				if (row == 6&&col==5) {
					s.addPiece(new Pawnaf(Color.WHITE));
				}
				if (row == 6&&col==6) {
					s.addPiece(new Pawnag(Color.WHITE));
				}
				if (row == 6&&col==7) {
					s.addPiece(new Pawnah(Color.WHITE));
				}
				

				// ROOKS
				if (row == 0) {
					if (col == 0 ) {
						s.addPiece(new Rookba(Color.BLACK));
					}
				}
				if (row == 0) {
					if (col == 7 ) {
						s.addPiece(new Rookbb(Color.BLACK));
					}
				}

				if (row == 7) {
					if (col == 0 ) {
						s.addPiece(new Rookaa(Color.WHITE));
					}
				}
				if (row == 7) {
					if (col == 7 ) {
						s.addPiece(new Rookab(Color.WHITE));
					}
				}

				// KNIGHTS
				if (row == 0) {
					if (col == 1 ) {
						s.addPiece(new Knightba(Color.BLACK));
					}
				}
				if (row == 0) {
					if (col == 6 ) {
						s.addPiece(new Knightbb(Color.BLACK));
					}
				}

				if (row == 7) {
					if (col == 1 ) {
						s.addPiece(new Knightaa(Color.WHITE));
					}
				}
				if (row == 7) {
					if (col == 6 ) {
						s.addPiece(new Knightab(Color.WHITE));
					}
				}


				// BISHOPS
				if (row == 0) {
					if (col == 2 ) {
						s.addPiece(new Bishopba(Color.BLACK));
					}
				}
				if (row == 0) {
					if (col == 5 ) {
						s.addPiece(new Bishopbb(Color.BLACK));
					}
				}

				if (row == 7) {
					if (col == 2 ) {
						s.addPiece(new Bishopaa(Color.WHITE));
					}
				}
				if (row == 7) {
					if (col == 5 ) {
						s.addPiece(new Bishopab(Color.WHITE));
					}
				}

				// QUEENS
				if (row == 0) {
					if (col == 3) {
						s.addPiece(new Queenb(Color.BLACK));
					}
				}

				if (row == 7) {
					if (col == 3) {
						s.addPiece(new Queena(Color.WHITE));
					}
				}

				// KINGS
				if (row == 0) {
					if (col == 4 ) {
						s.addPiece(new Kingb(Color.BLACK));
					}
				}

				if (row == 7) {
					if (col == 4) {
						s.addPiece(new Kinga(Color.WHITE));
					}
				}//以上都是添加棋子
			}
			all_squares.add(arrRow);//arraylist语法
		}
	}

	public static Square getSquare(int x, int y) {//！！！
		return all_squares.get(y).get(x);
	}
}

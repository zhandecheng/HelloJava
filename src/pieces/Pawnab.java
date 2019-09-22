package pieces;

import board.ChessBoard;
import board.Square;
import javafx.scene.paint.Color;

public class Pawnab extends Piece {

	private boolean hasMoved = false;
	public   static int a;
	 public   static int b;
	 public   static int c; 
	 public   static int d;

	public Pawnab(Color c) {
		super(c);
	}

	public void showMove(int x, int y) {
		a=x;
		b=y;
		
		if (this.getColor() == Color.WHITE) {
			Square s1 = ChessBoard.getSquare(x, y - 1);
			if (!s1.hasPiece()) {
				s1.moveMark();
				c=x;
				d=y-1;
			} else {
				return;
			}
			if (!hasMoved) {
				Square s2 = ChessBoard.getSquare(x, y - 2);
				Square s9 = ChessBoard.getSquare(x, y - 1);
				if (!s2.hasPiece()&&!s9.hasPiece()) {
					s2.moveMark();
				} else {
					return;
				}
			}
		} 

		if (x - 1 >= 0 || y - 1 >= 0 || x + 1 < 8 || y + 1 < 8) {
	//		return;
	//	} else {
	//		// White Right Up
			if (this.getColor() == Color.WHITE) {
				Square s5 = ChessBoard.getSquare(x + 1, y - 1);
				Square s6 = ChessBoard.getSquare(x - 1, y - 1);
				if (s5.hasPiece() ) {
					s5.mark(getColor());
				}

				// White Left Up
				
			else	if (s6.hasPiece() ) {
					s6.mark(getColor());
				} else 
				{
					return;
				}
			}

			// Black Right Down
			
		}
	}
	
	public void changePawnToQueen() {
		
	}

	public void move() {
		hasMoved = true;
	}


	public void hideMove() {

	}
}
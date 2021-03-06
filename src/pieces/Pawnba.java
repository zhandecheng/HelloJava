package pieces;

import board.ChessBoard;
import board.Square;
import javafx.scene.paint.Color;

public class Pawnba extends Piece {

	private boolean hasMoved = false;
	public   static int a;
	 public   static int b;
	 public   static int c; 
	 public   static int d;

	public Pawnba(Color c) {
		super(c);
	}

	public void showMove(int x, int y) {
		a=x;
		b=y;
		if (this.getColor() == Color.WHITE) {
			Square s1 = ChessBoard.getSquare(x, y - 1);
			if (!s1.hasPiece()) {
				s1.moveMark();
				
			}
			else {
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
		} else {
			Square s3 = ChessBoard.getSquare(x, y + 1);
			if (!s3.hasPiece()) {
				s3.moveMark();
			}
			if (!hasMoved) {
				Square s4 = ChessBoard.getSquare(x, y + 2);
				Square s10 = ChessBoard.getSquare(x, y + 1);
				if (!s4.hasPiece()&&!s10.hasPiece()) {
					s4.moveMark();
				}
			}
		}

		if (x - 1 >= 0 || y - 1 >= 0 || x + 1 < 8 || y + 1 < 8) {
	//		return;
	//	} else {
//			// Black Right Down
			if (this.getColor() == Color.BLACK) {
				if(x!=0&&x!=7) {
				Square s7 = ChessBoard.getSquare(x + 1, y + 1);
				Square s8 = ChessBoard.getSquare(x - 1, y + 1);
				if (s7.hasPiece() ) {
					s7.mark(getColor());
				}

				// Black Left Down
			
				else	if (s8.hasPiece() ) {
					s8.mark(getColor());
				} else {
					return;
				}
			}
		}
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
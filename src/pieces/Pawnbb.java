package pieces;

import board.ChessBoard;
import board.Square;
import javafx.scene.paint.Color;

public class Pawnbb extends Piece {

	private boolean hasMoved = false;

	public Pawnbb(Color c) {
		super(c);
	}

	public void showMove(int x, int y) {
		if (this.getColor() == Color.WHITE) {
			Square s1 = ChessBoard.getSquare(x, y - 1);
			if (!s1.hasPiece()) {
				s1.moveMark();
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
			if (this.getColor() == Color.BLACK) {
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
	
	
	public void changePawnToQueen() {
		
	}

	public void move() {
		hasMoved = true;
	}
	

	public void hideMove() {

	}
}
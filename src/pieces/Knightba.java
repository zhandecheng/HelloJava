package pieces;

import board.ChessBoard;
import board.Square;
import javafx.scene.paint.Color;

public class Knightba extends Piece {

	public Knightba(Color c) {
		super(c);
	}

	public void showMove(int x, int y) {

		// Up Right
		if (x + 1 < 8 && y + 2 < 8) {
			Square s1 = ChessBoard.getSquare(x + 1, y + 2);
			if (!s1.hasPiece()) {
				s1.mark(getColor());
			} else {
				s1.mark(getColor());
				
			}
		}

		// Right Up
		if (x + 2 < 8 && y + 1 < 8) {
			Square s1 = ChessBoard.getSquare(x + 2, y + 1);
			if (!s1.hasPiece()) {
				s1.mark(getColor());
			} else {
				s1.mark(getColor());
				
			}
		}
		

		// Right Down
		if (x + 2 < 8 && y - 1 >= 0) {
			Square s1 = ChessBoard.getSquare(x + 2, y - 1);
			if (!s1.hasPiece()) {
				s1.mark(getColor());
			} else {
				s1.mark(getColor());
				
			}
		}

		// Down Right
		if (x + 1 < 8 && y - 2 >= 0) {
			Square s1 = ChessBoard.getSquare(x + 1, y - 2);
			if (!s1.hasPiece()) {
				s1.mark(getColor());
			} else {
				s1.mark(getColor());
			
			}
		}

		// Down Left
		if (x - 1 >= 0 && y - 2 >= 0) {
			Square s1 = ChessBoard.getSquare(x - 1, y - 2);
			if (!s1.hasPiece()) {
				s1.mark(getColor());
			} else {
				s1.mark(getColor());
				
			}
		}

		// Left Down
		if (x - 2 >= 0 && y - 1 >= 0) {
			Square s1 = ChessBoard.getSquare(x - 2, y - 1);
			if (!s1.hasPiece()) {
				s1.mark(getColor());
			} else {
				s1.mark(getColor());
				
			}
		}

		// Left Up
		if (x - 2 >= 0 && y + 1 < 8) {
			Square s1 = ChessBoard.getSquare(x - 2, y + 1);
			if (!s1.hasPiece()) {
				s1.mark(getColor());
			} else {
				s1.mark(getColor());
				
			}
		}

		// Up Left
		if (x - 1 >= 0 && y + 2 < 8) {
			Square s1 = ChessBoard.getSquare(x - 1, y + 2);
			if (!s1.hasPiece()) {
				s1.mark(getColor());
			} else {
				s1.mark(getColor());
				
			}
		}
	}

	public void hideMove() {

	}
}

package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	private ChessMatch chessMatch;
	
	public Pawn(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}
	@Override
	public String toString() {
		return "P";
	}
	

	@Override
	public boolean[][] possibleMoves() {
		boolean [][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0, 0);
		
		if(getColor() == Color.WHITE) {
			
			p.setValues(position.getRow() -1, position.getColumn());
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			p.setValues(position.getRow() -2, position.getColumn());
			Position p2 = new Position(position.getRow() -1, position.getColumn());
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getMoveCount() == 0 && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2)){	
				mat[p.getRow()][p.getColumn()] = true;			
			}
			
			p.setValues(position.getRow() -1, position.getColumn()-1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			p.setValues(position.getRow() -1, position.getColumn() +1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}	
			
			// enPassant white
			if(position.getRow() == 3) {
				Position left = new Position(position.getRow(), position.getColumn()-1);
				if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getenPassantVulnerable() ) {
					mat[left.getRow() -1][left.getColumn()] = true;
				}	
				
				Position rigth = new Position(position.getRow(), position.getColumn()+1);
				if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getenPassantVulnerable() ) {
					mat[left.getRow() -1][left.getColumn()] = true;
				
				}
			}
		}else {
			
			p.setValues(position.getRow() +1, position.getColumn());
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			p.setValues(position.getRow() +2, position.getColumn());
			Position p2 = new Position(position.getRow() +1, position.getColumn());
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getMoveCount() == 0 && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2)){	
				mat[p.getRow()][p.getColumn()] = true;			
			}
			
			p.setValues(position.getRow() +1, position.getColumn()+1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			p.setValues(position.getRow() +1, position.getColumn() -1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			// enPassant black
			
			if(position.getRow() == 4) {
				Position left = new Position(position.getRow(), position.getColumn()-1);
				if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getenPassantVulnerable() ) {
					mat[left.getRow() +1][left.getColumn()] = true;
				}	
				
				Position rigth = new Position(position.getRow(), position.getColumn()+1);
				if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getenPassantVulnerable() ) {
					mat[left.getRow() +1][left.getColumn()] = true;
				
				}
			}
			
		}
		
		return mat;
	}

	
}
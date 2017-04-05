package ai;

import java.util.List;
import java.util.Random;

import model.AbstractState.MOVE;
import model.State;

public class RolloutAI extends AbstractPlayer {

	

	@Override
	public MOVE getMove(State game) {
		State gameState = game.copy(); 
		List<MOVE> moves = gameState.getMoves();
		Integer max = Integer.MIN_VALUE;
		MOVE bestMove = MOVE.DOWN;
		
		for (MOVE move : moves) {
			gameState.move(move);
			int rolloutValue = 0;
			int rollouts = 400;
			
			for (int x = 0; x < rollouts; x++) {
				rolloutValue += gameState.rollout();
			}
			
			rolloutValue /= rollouts;
			
			if(rolloutValue > max){
				bestMove = move;
				max = rolloutValue;
			}
			gameState.undo();
		}
		
		return bestMove;
		
		
		
		
	}

	@Override
	public int studentID() {
		return 201181111;
	}

	@Override
	public String studentName() {
		return "Phil Rodgers";
	}
}


import java.util.ArrayList;

public class Board {
   public static ArrayList<Piece> black = new ArrayList<Piece>();
	public static ArrayList<Piece> white = new ArrayList<Piece>();

   public final int[][] BLACK_TRAP = {{2,0}, {3,1}, {4,0}};
   public final int[][] WHITE_TRAP = {{2,8}, {3,7}, {4,8}};
   public final int[] BLACK_BASE = {3,0};
   public final int[] WHITE_BASE = {3,8};
   public final int[][] RIVER = {{1,3}, {2,3}, {4,3}, {5,3}, {1,4}, {2,4}, {4,4}, {5,4}, {1,5}, {2,5}, {4,5}, {5,5}};
	
   static Piece board[][] = new Piece[8][8];
   
}
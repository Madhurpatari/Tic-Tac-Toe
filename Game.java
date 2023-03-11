
import java.util.Scanner;

public class Game {
    
    Board board;
    Player[] players;
    int turn; /*if turn even->p1 ; if odd turn -> p2 */
    int number_of_moves;
    boolean game_over;
    String zero_pattern;
    String cross_pattern;

    Scanner sc = new Scanner(System.in);

    Game(Board board, Player[] players){
        this.board = board;
        this.players = players;
        this.turn =0;
        this.number_of_moves =0;
        this.game_over = false;
        zero_pattern ="";
        cross_pattern =""; 
        for(int i =0;i<board.size;i++){
            zero_pattern += 'O';
            cross_pattern += 'X';
        }
    }

    public void play(){
        System.out.println(board);
        while(!this.game_over){
            this.number_of_moves++;
            if(this.number_of_moves > board.size*board.size){
                System.out.print("Match Draw");
                return;
            }
            int idxs[] = getIndex();
            int row_number = idxs[0];
            int column_number = idxs[1];
            board.board[row_number][column_number] = players[turn].symbol;
            if(this.number_of_moves >= 2*board.size-1 && checkIfGameIsEnded()){
                System.out.println(board);
                this.game_over = true;
                System.out.println(players[turn].name+" "+"has won !!");
                return;
            }
            turn =(turn + 1)%2; /* %2 so that it keep oscillating between 0 and 1 */
            System.out.println(board);
        }
    }

    public int[] getIndex(){
        while(true){
            System.out.println("Player; "+" "+players[turn].name +"'s turn , Give index: ");
            int idx = sc.nextInt()-1;
            int row_number = idx /  board.size;
            int column_number = idx % board.size;
            if(row_number < 0 || column_number < 0 || row_number >= board.size || column_number >= board.size){
                System.out.println("Invalid position");
                continue;
            }
            if(board.board[row_number][column_number] != '-'){
                System.out.println("position already filled, try again");
                continue;
            }
            return new int[]{row_number, column_number};
        }
    }

    public boolean checkIfGameIsEnded(){
        //Rows
        StringBuilder sb;
        for (int i = 0; i < board.size; i++) {
            sb = new StringBuilder();
            for(int j =0;j<board.size;j++){
                sb.append(board.board[i][j]);
                if(sb.toString().equals(zero_pattern) || sb.toString().equals(cross_pattern)){
                    return true;
                }
            }
        }

        //Column
        for (int i = 0; i < board.size; i++) {
            sb = new StringBuilder();
            for(int j =0;j<board.size;j++){
                sb.append(board.board[j][i]);
                if(sb.toString().equals(zero_pattern) || sb.toString().equals(cross_pattern)){
                    return true;
                }
            }
        }

        //Major digonal
        int i=0, j=0;
        sb = new StringBuilder();
        while(i < board.size){
            sb.append(board.board[i++][j++]);
        }
        if(sb.toString().equals(zero_pattern) || sb.toString().equals(cross_pattern)){
            return true;
        }

        //Minor digonal
        j=board.size-1;
        sb = new StringBuilder();
        while(i < board.size){
            sb.append(board.board[i++][j--]);
        }
        if(sb.toString().equals(zero_pattern) || sb.toString().equals(cross_pattern)){
            return true;
        }

        return false;
    }

}

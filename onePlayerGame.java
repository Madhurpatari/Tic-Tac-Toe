
public class onePlayerGame extends Game{

    onePlayerGame(Board board, Player[] players) {
        super(board, players);
    }
    @Override
    public int[] getIndex(){
        if(this.turn==1){
            while(true){
                int idx = (int)(Math.random()*(board.size*board.size-1)+1);
                int row_number = idx /  board.size;
                int column_number = idx % board.size;
                if(board.board[row_number][column_number] != '-'){
                    System.out.println("position already filled, try again");
                    continue;
                }
                return new int[]{row_number, column_number};
            }
        }
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
    
}

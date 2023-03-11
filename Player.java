
public class Player {
    String name;
    char symbol;
    static Player obj = null;
    static int PlayerCount = 0;

    Player(String name){
        this.name = name;
        this.symbol = PlayerCount ==0 ? 'X': 'O';
        PlayerCount++;
    }

    // public static Player getInstance(){
    //     if(PlayerCount<2){
    //         PlayerCount++;
    //         obj = new Player(name);
    //     }
    //     System.out.println("Only two players can play at a time");
    //     return obj;
    // }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(this.name).append("\n").append("Symbol: ").append(this.symbol).append("\n");
        return sb.toString();
    }
}

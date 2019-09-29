import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
public class Main {
    public static void main(String[] args)throws IOException{
        /*1
        3 2 1
        1 2
        2 3
        2*/
        Scanner input = new Scanner(new File("Case 12.dat"));
        int tests = input.nextInt();
        input.nextLine();
        while(tests > 0){
            int NUM_DOMINO = input.nextInt();//3
            int NUM_CONN = input.nextInt();//2
            int NUM_HAND = input.nextInt();//1
            input.nextLine();

            Graph graph = new Graph();
            for (int i = 1; i < NUM_DOMINO+1; i++) {
                graph.addDomino(new Domino(i));
            }
            int i = 0;
            while(i < NUM_CONN){
                String[] nums = input.nextLine().split(" ");
                int first = Integer.parseInt(nums[0]);
                int second = Integer.parseInt(nums[1]);
                if (!graph.contains(first)){
                    Domino d = new Domino(first);
                    graph.addDomino(d);
                }
                if (!graph.contains(second)){
                    Domino l = new Domino(second);
                    graph.addDomino(l);
                }
                if (first != second){
                    graph.get(first).addConnection(graph.get(second));
                }
                i++;
            }

            for(int j = 0; j < NUM_HAND; j++){
                int dom = input.nextInt();
                if (input.hasNextLine()){
                    input.nextLine();
                }
                Domino d = graph.get(dom);
                if (d == null){

                }else{
                    graph.over(dom);
                }
            }
            System.out.println(graph.numberK());
            System.out.println(graph.getSize());
            tests--;
        }
    }
}
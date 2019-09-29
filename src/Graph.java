import java.util.ArrayList;

public class Graph {
    //basically just an ArrayList of Domino's Graph Representation
    ArrayList<Domino> graph;
    public Graph(){
        graph = new ArrayList();
    }

    public boolean contains(Domino d){
        for(Domino i : graph){
            if (i == d){
                return true;
            }
        }
        return false;
    }

    public boolean contains(int num){
        for(Domino d : graph){
            if (d.NUM == num){
                return true;
            }
        }
        return false;
    }

    public Domino get(int num){
        for(Domino d : graph){
            if (d.NUM == num){
                return d;
            }
        }
        return null;
    }

    public void over(int dom){
        ArrayList<Domino> list = new ArrayList<>();
        list.add(get(dom));
        over(list);
    }

    private void over(ArrayList<Domino> list){
        if (list != null) {
            for(Domino d : list){
                over(get(d.NUM).knock());
            }
        }
    }

    public void addDomino(Domino d){
        if (!contains(d)){
            graph.add(d);
        }
    }

    public int numberK(){
        int i = 0;
        for(Domino d : graph){
            if (d.knocked){
                i++;
            }
        }
        return i;
    }

    public int getSize(){
        return graph.size();
    }

    public String toString(){
        String str = "";
        for(Domino d : graph){
            str += d;
        }
        return str;
    }

}

import java.util.ArrayList;
public class Domino {
    ArrayList<Domino> connected;
    int NUM;
    //If knocked == true that means it has fallen over
    boolean knocked = false;
    public Domino(int num){
        NUM = num;
        connected = new ArrayList();
    }

    public Domino addConnection(Domino d){
        if (!contains(d)){
            connected.add(d);
        }
        return this;
    }
    //returns whether or not this domino is in connected
    public boolean contains(Domino d){
        for(Domino i : connected){
            if (i == d){
                return true;
            }
        }
        return false;
    }
    //this knocks over this domino if it hasn't already been
    public Domino knockOver(){
        if (knocked){
            //if it's already been knocked over
            return this;
        }else{
            //this means it hasn't been knocked over yet
            //initiate knocking over
            knocked = true;
            //this now means it has been knocked over
            for(Domino d : connected){
                d.knockOver();
            }
            return this;
        }
    }
    //this method will replace knockOver
    public ArrayList<Domino> knock(){
        if (knocked)return null;
        //this means this domino has been knocked over
        knocked = true;
        ArrayList<Domino> list = new ArrayList<>();
        for(Domino d : connected){
            if (!d.knocked){
                list.add(d);
            }
        }
        return list;
    }

    public String toString(){
        String str = "";
        str += NUM+"";
        if (knocked){
            str += "K ";
        }
        str += ": ";
        for(Domino d : connected){
            str += d.NUM+", ";
        }
        return str;
    }
}

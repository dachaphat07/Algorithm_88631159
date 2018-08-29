/**
 * Created by DT11ST on 8/20/2018.
 */
import java.util.*;
public class mod2 {
    static Scanner kb = new Scanner(System.in);
    static Queue<Integer> td = new LinkedList<>();
    static   String[][] arrmn = new String[kb.nextInt()][kb.nextInt()];
    static int time = 0;
    static boolean flag = false;
    public static void main(String[] args) {

        final int x = kb.nextInt();
        for (int i = 0; i < x ; i++) {
            td.offer(kb.nextInt());
        }
        for (int i = 0; i <arrmn.length  ; i++) {
            for (int j = 0; j <arrmn[0].length ; j++) {
                arrmn[i][j]="-";
            }

        }

        System.out.println( run(arrmn.length-1,arrmn[0].length-1,arrmn.length-1,arrmn[0].length-1));
        print();
    }

    public static void print (){

        for (int i = 0; i <arrmn.length  ; i++) {
            for (int j = 0; j <arrmn[0].length ; j++) {
                System.out.print(arrmn[i][j]);
            }
            System.out.println();
        }

        System.out.println("_____________________");

    }

    public static int run (int x , int y , int ox , int oy){
        print();
        int X = 0;
        time++;
        if(!td.isEmpty()){
            if(time==td.peek()){
                td.poll();
                arrmn[x][y] = "x";
                return X+run(ox,oy,x,y);
            }else {
                if(arrmn[x][y]=="-"){
                    X++;
                    arrmn[x][y]= "h";
                    if(x!=ox || y != oy){
                        arrmn[ox][oy]="o";
                    }

                    if (time == 1){

                        if(x-1 >= 0 ){
                            return X+run(x-1, y ,x,y);
                        }else if (y-1 >= 0){
                            return  X+run(y,y-1,x,y);
                        }else if (x+1 < arrmn.length ){
                            return X+run(x+1,y,x,y);
                        }else if (y+1 < arrmn[0].length-1){
                            return X+run(x,y+1,x,y);
                        }else{
                            return X;
                        }

                    }else {
                        if(x-1 >= 0 && ((x!=ox || y!=oy))){
                            return X+run(x-1, y ,x,y);
                        }else if (y-1 >= 0&&((x!=ox || y!=oy))){
                            return  X+run(y,y-1,x,y);
                        }else if (x+1 < arrmn.length&&((x!=ox || y!=oy)) ){
                            return X+run(x+1,y,x,y);
                        }else if (y+1 < arrmn[0].length-1&& ((x!=ox || y!=oy))){
                            return X+run(x,y+1,x,y);
                        }else{
                            return X;
                        }
                    }


//                    if(x-1 >= 0 && ((x!=ox && y!=oy)||time==1)){
//                        return X+run(x-1, y ,x,y);
//                    }else if (y-1 >= 0&&((x!=ox && y!=oy)||time==1)){
//                        return  X+run(y,y-1,x,y);
//                    }else if (x+1 < arrmn.length&&((x!=ox && y!=oy)||time==1) ){
//                        return X+run(x+1,y,x,y);
//                    }else if (y+1 < arrmn[0].length-1&& ((x!=ox && y!=oy)||time==1)){
//                        return X+run(x,y+1,x,y);
//                    }else{
//                        return X;
//                    }


                }else{
                    if(arrmn[x][y]=="o"){
                        arrmn[x][y]="h";
                    }
                    if(x>ox){
                        if (y-1 >= 0){
                            return  X+run(x,y-1,x,y);
                        }else if (x+1 < arrmn.length ){
                            return X+run(x+1,y,x,y);
                        }else if (y+1 < arrmn[0].length-1){
                            return X+run(x,y+1,x,y);
                        }else{
                            return X;
                        }
                    }else if (y>oy){
                        if (x+1 < arrmn.length ){
                            return X+run(x+1,y,x,y);
                        }else if (y+1 < arrmn[0].length-1){
                            return X+run(x,y+1,x,y);
                        }else{
                            return X;
                        }
                    }else if(x > ox){
                        if (y+1 < arrmn[0].length-1){
                            return X+run(x,y+1,x,y);
                        }else{
                            return X;
                        }
                    }else {
                        System.out.println("ปล่อยงงไปก่อน");
                        return X;
                    }
                }
            }
        }else{

            if(arrmn[x][y]=="-"){
                X++;
                arrmn[x][y]= "h";
                if(x!=ox || y != oy){

                    arrmn[ox][oy]="o";
                }


                if(x-1 >= 0 && ((x!=ox || y!=oy))){
                    return X+run(x-1, y ,x,y);
                }else if (y-1 >= 0&&((x!=ox || y!=oy))){
                    return  X+run(y,y-1,x,y);
                }else if (x+1 < arrmn.length&&((x!=ox || y!=oy)) ){
                    return X+run(x+1,y,x,y);
                }else if (y+1 < arrmn[0].length-1&& ((x!=ox || y!=oy))){
                    return X+run(x,y+1,x,y);
                }else{
                    return X;
                }

//                if(x-1 >= 0){
//                    return X+run(x-1, y ,x,y);
//                }else if (y-1 >= 0){
//                    return  X+run(x,y-1,x,y);
//                }else if (x+1 < arrmn.length){
//                    return X+run(x+1,y,x,y);
//                }else if (y+1 < arrmn[0].length-1){
//                    return X+run(x,y+1,x,y);
//                }else{
//                    return X;
//                }
            }else{
                if(arrmn[x][y]=="o"){

                }
                if(x>ox){
                    if (y-1 >= 0){
                        return  X+run(x,y-1,x,y);
                    }else if (x+1 < arrmn.length ){
                        return X+run(x+1,y,x,y);
                    }else if (y+1 < arrmn[0].length-1){
                        return X+run(x,y+1,x,y);
                    }else{
                        return X;
                    }
                }else if (y>oy){
                    if (x+1 < arrmn.length ){
                        return X+run(x+1,y,x,y);
                    }else if (y+1 < arrmn[0].length-1){
                        return X+run(x,y+1,x,y);
                    }else{
                        return X;
                    }
                }else if(x < ox){
                    if (y+1 < arrmn[0].length-1){
                        return X+run(x,y+1,x,y);
                    }else{
                        return X;
                    }
                }else {
                    System.out.println("ปล่อยงงไปก่อน");
                    return X;
                }
            }

        }


    }


}

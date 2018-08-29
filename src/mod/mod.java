/**
 * Created by DT11ST on 8/19/2018.
 */
import java.util.*;
public class mod {

    static Scanner kb = new Scanner (System.in);
    static String[][] mn = new String [kb.nextInt()][kb.nextInt()];
    static    Queue<Integer> td = new LinkedList<>();
    static  int time = 0 ;

    public static void main(String[] args) {

         int t = kb.nextInt();

        for (int i = 0; i < t ; i++) {
            td.offer(kb.nextInt());
        }
        //System.out.println(mn.length +" : "+mn[0].length );

        System.out.println(  modei(mn.length-1,mn[0].length-1,mn.length-1,mn[0].length-1));
        printmn();

    }


    public static void printmn(){

        for (int i = 0; i <mn.length ; i++) {
            for (int j = 0; j < mn[0].length; j++) {
                System.out.print(mn[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int modei(int x ,int y,int xo,int yo){
        printmn();

     //   System.out.println(time);
        int xx = 0;

       try{
           time++;
          // System.out.println(time);

           if(!td.isEmpty()){
               if(time==td.peek()){
                   mn[x][y]="x";
                   td.poll();
                   if(mn[x+1][y]=="o"){
                       mn[x+1][y]="h";
                   }else if(mn[x-1][y]=="o"){
                       mn[x-1][y]="h";
                   }else if(mn[x][y-1]=="o"){
                       mn[x][y-1]="h";
                   }else if(mn[x][y+1]=="o"){
                       mn[x][y+1]="h";
                   }

                   return xx+modei(xo,yo,x,y);

               }
           }


               mn[x][y]="h";

               if(mn[x-1][y]==(null)){
                   xx++;
                   mn[x-1][y]="h";
                   mn[x][y]="o";
                   return xx+=modei(x-1,y,x,y);
               } if(mn[x][y-1]==(null)){
                   xx++;
                   mn[x][y-1]="h";
                   mn[x][y]="o";
                   return xx+=modei(x,y-1,x,y);
               } if(mn[x+1][y]==(null)){
                   xx++;
                   mn[x+1][y]="h";
                   mn[x][y]="o";
                   return xx+=modei(x+1,y,x,y);
               } if(mn[x][y+1]==(null)){
                   xx++;
                   mn[x][y+1]="h";
                   mn[x][y]="o";
                   return xx+=modei(x,y+1,x,y);
               }else{
                   return xx;
               }



        }catch (Exception e){
            System.out.println(e);
            return xx;
       }

    }

}

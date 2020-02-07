/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iot;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author AJith
 */
public class IOT {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException{
        // TODO code application logic here
       Scanner key=new Scanner(System.in);
       Random rnd=new Random();
       System.out.println("Enter the STOP time");   //Milliseconds
       int stoptime=key.nextInt();
       LinkedList <String> res =new LinkedList <String>();
       res.add("S1");
       boolean running;
       Timer timer0=new Timer();
       timer0.schedule(new terminate(),stoptime);
       
       while((running=true)&&(!res.isEmpty() )){
           
       int clocktime=(7+rnd.nextInt(15))*1000;
       s1.run(res,clocktime);
       int simclock=(7+rnd.nextInt(15)*100);
       int perclock=(7+rnd.nextInt(15)*100);
       Timer timer=new Timer();
       Timer timer1=new Timer();
       timer.schedule(new s2(res,clocktime),20000);
       Thread.sleep(15000);
       timer1.schedule(new s3(res,clocktime),35000);
       
       timer.cancel();
       timer1.cancel();
       }
    }
}
class Str{
    
    public static void disp(LinkedList<String> res){
        System.out.println(res+" :"+res.size());
    }
    static int test=0;
    public static void current(LinkedList<String> res) throws InterruptedException{
       
        if(test>0){
        System.out.println("On to the NEXT EVENT :"+res.getLast());
        }
        test+=1;
        Thread.sleep(2000);
        System.out.println("EVENT call");
        Thread.sleep(2000);
        System.out.println(res.getLast()+": running");
    }
    static int j=2;
    public static void updatesevent(LinkedList<String> res){
        if(j==4){
            j=1;
        }
        res.add("S"+j);
        j++;
    }
    public static void log(LinkedList<String> res) throws InterruptedException{
         System.out.println("END S"+(j-1));
         Thread.sleep(2000);
         Str.updatesevent(res);   
         Str.disp(res);
    }
}
class s1 {
    public static void run(LinkedList<String> res,int p) throws InterruptedException{
        Str.disp(res);
        Str.current(res);
        Thread.sleep(p);  //time of current event
        Str.log(res);  
    }
}
class s2 extends TimerTask{
    LinkedList<String> res0;
    int q;
    public s2(LinkedList<String> res,int p){
        this.res0=res;
        this.q=p;
    }
    @Override
    public void run(){
        try {
            Str.current(res0);
        } catch (InterruptedException ex) {
            Logger.getLogger(s2.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Thread.sleep(q);     //time of current event
        } catch (InterruptedException ex) {
            Logger.getLogger(s2.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Str.log(res0);
        } catch (InterruptedException ex) {
            Logger.getLogger(s2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
class s3 extends TimerTask{
    LinkedList<String> res1;
    int r;
    public s3(LinkedList<String> res,int p){
        this.res1=res;
        this.r=p;
    }
    @Override
    public void run(){
         try {
            Str.current(res1);
        } catch (InterruptedException ex) {
            Logger.getLogger(s2.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Thread.sleep(r);      //time of current event
        } catch (InterruptedException ex) {
            Logger.getLogger(s2.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Str.log(res1);
        } catch (InterruptedException ex) {
            Logger.getLogger(s2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
class terminate extends TimerTask{
      @Override
    public void run(){
       System.exit(0); 
    }
    }

    
 









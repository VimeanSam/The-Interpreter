/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;
import interpreter.VirtualMachine;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Vimean Sam
 */
public class ReadCode extends ByteCode{
    
    public void init(ArrayList<String> args){}
        
    public void execute(VirtualMachine v){
        System.out.println("Please Enter a Number: ");
        try{
            Scanner userinput = new Scanner(System.in);
            int toPush = userinput.nextInt();
            v.pushRunStack(toPush);
        }catch(java.util.InputMismatchException e){
            System.out.println("Invalid Input. Please try again");
            execute(v);
        }
        if(v.DumpModeVerifier()){
            print();
        }
    }  
    
    public void print(){
        System.out.println("READ");
    }
}        
    


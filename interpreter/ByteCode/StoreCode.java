/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;
import java.util.ArrayList;
import interpreter.VirtualMachine;
/**
 *
 * @author Vimean Sam
 */
public class StoreCode extends ByteCode{
    private int offset;
    private String varName;
    private int argSize;
    private int valPopped;
    
    public void init(ArrayList<String> args){
        argSize = args.size();
        offset = Integer.parseInt(args.get(0));
        if(argSize > 1){
            varName = args.get(1);
        }
    }
    
    public void execute(VirtualMachine v){
        valPopped = v.peekRunStack();
        v.StoreRunStack(offset);
        
        if(v.DumpModeVerifier()){
            print();
        }
    }
    
    public void print(){
        
        if(argSize <= 1){
            System.out.println("STORE "+offset);
        }else if(argSize > 1){
            System.out.println("STORE "+offset+" "+varName+ "\t"+varName+" = "+valPopped);
        }
    }
}

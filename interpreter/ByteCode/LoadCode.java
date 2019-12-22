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
public class LoadCode extends ByteCode{
    private int value;
    private int argSize;
    private String varName;
    
    public void init(ArrayList<String> args){
        argSize = args.size();
        value = Integer.parseInt(args.get(0));
        if(argSize <= 1){
            varName = "";
        }else if(argSize > 1){
            varName = args.get(1);
        }
    }
    
    public void execute(VirtualMachine v){
        v.loadRunStack(value);
        
        if(v.DumpModeVerifier()){
            print();
        }
    }
    
    public void print(){
        if(argSize == 1){
            System.out.println("LOAD "+value);
        }else{
        System.out.println("LOAD "+value+" "+varName+"\t"+"<"+"load "+varName+">");
        }
    }
}

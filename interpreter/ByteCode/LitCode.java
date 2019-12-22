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
public class LitCode extends ByteCode{
    private int value;
    private String varName;
    private int argSize;
    
    public void init(ArrayList<String> args){
        value = Integer.parseInt(args.get(0));
        argSize = args.size();
        
        if(argSize > 1){
            varName = args.get(1);
        }else{
            varName = "";
        }
    }
    
    public void execute(VirtualMachine v){
        v.pushRunStack(value);
        if(v.DumpModeVerifier()){
            print();
        }
    }
    
    public void print(){
        if(argSize == 1){
            System.out.println("LIT "+value);
        }else{
            System.out.println("LIT "+value+"\t"+"int "+varName);
        }
    }
}

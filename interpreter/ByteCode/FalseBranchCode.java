/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;
import java.util.ArrayList;
import interpreter.VirtualMachine;
import interpreter.RunTimeStack;

/**
 *
 * @author Vimean Sam
 */
public class FalseBranchCode extends ByteCode{
    private String label;
    private int address;
    
    public void init(ArrayList<String> args){
        label = args.get(0);
    }   
    
    public void setBranchAddress(int n){
        address = n;
    }
    
    public void execute(VirtualMachine v){
        
        if(v.popRunStack() == 0){
            v.setPC(address);
        }
        
        if(v.DumpModeVerifier()){
            print();
        }
    }
    
    public String returnLabel(){
        return label;
    }
    
    public void print(){
        System.out.println("FALSEBRANCH "+label);
    }
}

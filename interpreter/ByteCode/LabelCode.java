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
public class LabelCode extends ByteCode{
    private String label;
    
    public void init(ArrayList<String> args){
         label = args.get(0);
    }      
    
    public void execute(VirtualMachine v){
        if(v.DumpModeVerifier()){
            print();
        }
    }
     
    public String returnLabel(){
        return label;
    }
    
    public void print(){
        System.out.println("LABEL "+label);
    }
}

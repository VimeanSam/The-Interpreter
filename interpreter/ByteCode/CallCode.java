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
public class CallCode extends ByteCode{
    private String label;
    private int address;
    private String topVal = "";
    
    public void init(ArrayList<String> args){
        label = args.get(0);
    }       
    
    public void setBranchAddress(int n){
        address = n;
    }    
    
    public void execute(VirtualMachine v){
        v.pushReturnAddress(v.getPC());
        v.setPC(address);
        
        if(v.RunStackSize() > 0){
            topVal = String.valueOf(v.peekRunStack());
        }
        if(v.DumpModeVerifier()){
            print();
        }
    }

    public String returnLabel(){
        return label;
    }
    
    public void print(){
        String newLabel;
        if(label.contains("<")){
            newLabel = label.substring(0, label.indexOf("<"));
            System.out.println("CALL "+newLabel+"\t"+newLabel+"("+topVal+")");
        }else{
            System.out.println("CALL "+label+"\t"+label+"("+topVal+")");
        }
    }
}

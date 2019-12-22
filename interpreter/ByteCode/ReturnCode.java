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
public class ReturnCode extends ByteCode{
    private String funcname;
    private int returnedPC;
    private int returnedVal;
    
    public void init(ArrayList<String> args){
        if(args.size() > 0){
            funcname = args.get(0);
        }else{
            funcname = "";
        }
    }
    
    public void execute(VirtualMachine v){
        returnedPC = v.peekReturnAddress();
        returnedVal = v.peekRunStack();
        v.popRunStackFrame();
        v.setPC(v.popReturnAddress());
        if(v.DumpModeVerifier()){
            print();
        }
        //System.out.println(v.peekReturnAddress());
    }   
    
    public void print(){
        String newLabel;
        if(funcname.contains("<")){
            newLabel = funcname.substring(0, funcname.indexOf("<"));
            System.out.println("RETURN "+newLabel+" "+"exit "+newLabel+": "+returnedVal);
        }else{
            System.out.println("RETURN "+funcname+" "+"exit "+funcname+": "+returnedVal);
        }
    }
}     

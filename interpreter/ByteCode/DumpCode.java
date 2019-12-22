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
public class DumpCode extends ByteCode{
    private String flag;
    
    public void init(ArrayList<String> args){
        flag = args.get(0);
    }
    
    public void execute(VirtualMachine v){
        v.setDumpMode(flag);
    }    
}

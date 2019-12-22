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
public class WriteCode extends ByteCode{
    public void init(ArrayList<String> args){}
        
    public void execute(VirtualMachine v) {
        System.out.println(v.peekRunStack());
        
        if(v.DumpModeVerifier()){
            print();
        }
    }
    
    public void print(){
        System.out.println("WRITE");
    }
}

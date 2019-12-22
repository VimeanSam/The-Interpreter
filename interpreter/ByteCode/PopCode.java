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
public class PopCode extends ByteCode{
    private int level;
    
    public void init(ArrayList<String> args) {
        level = Integer.parseInt(args.get(0));
    }
    
    public void execute(VirtualMachine v) {
        if(level <= v.FrameSize()){
            for(int i = 0; i < level; i++) {
                v.popRunStack();
            }
        }else{
            for(int i = v.RunStackSize()-1; i >= v.FrameSize()-1; i--) {
                v.popRunStack();
            }
        }
        
        if(v.DumpModeVerifier()){
            print();
        }
    }
    
    public void print(){
        System.out.println("POP "+level);
    }

}

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
public class ArgsCode extends ByteCode{
    private int label;
        
    public void init(ArrayList<String> args){
        label = Integer.parseInt(args.get(0));
    }   
    
    public void execute(VirtualMachine v){
         v.newRunStackFrameAt(label);
         
         if(v.DumpModeVerifier()){
             print();
         }
    } 
    
    public void print(){
        System.out.println("ARGS "+label);
    }
}       

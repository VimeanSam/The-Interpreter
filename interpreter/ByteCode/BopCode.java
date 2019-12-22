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
public class BopCode extends ByteCode{
    private String operator;
    
    public void init(ArrayList<String> args){
        operator = args.get(0);
    }
    
    public void execute(VirtualMachine v){
        int top_level = v.popRunStack();
        int second_level = v.popRunStack();
        switch (operator) {
            case "+":
                v.pushRunStack(second_level + top_level);
                break;
            case "-":
                v.pushRunStack(second_level - top_level);
                break;
            case "/":
                v.pushRunStack(second_level / top_level);
                break;
            case "*":
                v.pushRunStack(second_level * top_level);
                break;
            case "==":
                if(second_level == top_level){
                    v.pushRunStack(1);
                }else{
                    v.pushRunStack(0);
                }   
                break;
            case "!=":
                if(second_level != top_level){
                    v.pushRunStack(1);
                }else{
                    v.pushRunStack(0);
                }   
                break;
            case "<=":
                if(second_level <= top_level){
                    v.pushRunStack(1);
                }else{
                    v.pushRunStack(0);
                }   
                break;
            case ">":
                if(second_level > top_level){
                    v.pushRunStack(1);
                }else{
                    v.pushRunStack(0);
                }   
                break;
            case ">=":
                if(second_level >= top_level){
                    v.pushRunStack(1);
                }else{
                    v.pushRunStack(0);
                }   
                break;
            case "<":
                if(second_level < top_level){
                    v.pushRunStack(1);
                }else{
                    v.pushRunStack(0);
                }   
                break;
            case "|":
                if(second_level == 0 && top_level == 0){
                    v.pushRunStack(0);
                }else{
                    v.pushRunStack(1);
                }   
                break;
            case "&":
                if(second_level == 1 && top_level == 1){ 
                    v.pushRunStack(1);
                }else{
                    v.pushRunStack(0);
                }   
                break;
            default:
                break;
        }
        
        if(v.DumpModeVerifier()){
            print();
        }
    }
    
    public void print(){
        System.out.println("BOP "+operator);
    }
}


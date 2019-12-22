package interpreter;

import java.util.ArrayList;
import java.util.Stack;

public class RunTimeStack {

    private ArrayList runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() 
    {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        //Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    public void dump(){
        //start of frame iteration
        int start = framePointer.get(0);
        //end of frame iteration
        int stop;
        for (int i = 0; i < framePointer.size(); i++) { 
            System.out.print("[");
            //The goal is to create a loop that prints the stack contents from one
            //frame to another until the end of runtimestack's size. 
            if ((i+1) < framePointer.size()){
                //stop will be start's next index in order to loop from one frame
                //to another
                stop = framePointer.get(i+1);
            }else{
                //set stop to loop until runTimeStack's size to print out
                //the rest of the runTimeStack contents
                stop = runTimeStack.size();
            }
            for (int j = start; j < stop; j++){
                System.out.print(runTimeStack.get(j));
                //Don't put comma before the frame
                if(j < stop-1){
                    System.out.print(",");
                }
            }
            //set the start index to last framepointer iteration. 
            //Ex: framePointer contains 0,2,4 and runTimeStack's size is 6
            //The idea is to loop from the first frame index to next until
            //the the last index of runTimeStack
            //Algorithm illustration: Start 0-> stop 2 then 2->runTimeStack's size
            start = stop;
            System.out.print("]");
        }
        System.out.println();
    }    
    //retrieves the last element in runtimestack (not removing it)
    public int peek() {      
        if(runTimeStack.size() > 1){
            return (int) runTimeStack.get(runTimeStack.size() - 1);
        }
        return (int) runTimeStack.get(0);
    }   
    //removes the last element in the runtimestack
    public int pop() {        
        if(runTimeStack.size() > 1){
            return (int) runTimeStack.remove(runTimeStack.size() - 1);
        }
        return (int) runTimeStack.remove(0);
    }  
    //add an element to the top of the runtimestack
    public int push(int i) {      
        runTimeStack.add(i);
        return i;
    }
    //create a new frame at index that is offset amount away from top of stack
    public void newFrameAt(int offset) {
        if(offset <= runTimeStack.size()){
            framePointer.push(runTimeStack.size() - offset);
        }
    }
    //pop the value on top of a stack and store it to a local variable.
    //Removes elements from the top of the stack to the index of the 
    //framepointer that will be popped. Then pop the framepointer index  
    //add the popped value to the top of the remaining stack
    public void popFrame() {
        int value = (int) runTimeStack.get(runTimeStack.size()-1);
        for (int i = runTimeStack.size() - 1; i >= framePointer.peek(); i--) {
            runTimeStack.remove(i);
        }
        framePointer.pop();
        runTimeStack.add(value);
    }   
    //pop the last element in the runtimestack at replace the element an 
    //offset amount away from the last framepointer index with the popped value
    public int store(int offset) {
        if(runTimeStack.size() == 1 && !framePointer.isEmpty()){
            int temp = (int) runTimeStack.get(0);
            return temp;
        }else if((framePointer.peek() + offset) > runTimeStack.size()-1){
            int temp = (int) runTimeStack.get(runTimeStack.size()-1);
            runTimeStack.set(runTimeStack.size()-1, temp);
            return temp;
        }
        int value = (int) runTimeStack.get(runTimeStack.size()-1);
        runTimeStack.remove(runTimeStack.size()-1);
        runTimeStack.set(framePointer.peek() + offset, value);
        return value;
    }
    //Add a value that is an offset amount away from the last framepointer index
    //push it to the top of stack
    public int load(int offset) {
        if((framePointer.peek() + offset) > runTimeStack.size()-1){
            int temp = (int) runTimeStack.get(runTimeStack.size()-1);
            runTimeStack.add(temp);
            return temp;
        }
        int value = (int) runTimeStack.get(framePointer.peek() + offset);
        runTimeStack.add(value);
        return value;
    }
    //Not sure why this is here. Had to implement it based on the instruction
    public Integer push(Integer i) {
        runTimeStack.add(i);
        return i;
    }
    //Extras
    //Retrieve the size of runTimeStack
    public int runstacksize(){
        return runTimeStack.size();
    }
    //Retrieve the size of framepointer stack
    public int FrameSize(){
        return framePointer.size();
    }
}
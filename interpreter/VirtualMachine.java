package interpreter;

import java.util.Stack;
import interpreter.ByteCode.ByteCode;


public class VirtualMachine {

    private RunTimeStack runStack;
    private Stack returnAddrs;
    private Program program;
    private int pc;
    private boolean isRunning;
    private String dumpFlag;
  
    protected VirtualMachine(Program program) {
        this.program = program;
    }
    
    public void executeProgram(){
        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack<Integer>();
        isRunning = true;
        dumpFlag = "OFF";
        //System.out.println(runStack.empty());
        while(isRunning){
            ByteCode code = program.getCode(pc);
            //System.out.println(pc+": "+program.getCode(pc));
            code.execute(this);
            if("ON".equals(dumpFlag)){
                runStack.dump();  
            }
            pc++;
        }   
    }   
    
    public int popRunStack(){
        return runStack.pop();
    }
    
    public int pushRunStack(int n){
        return runStack.push(n);
    }
    
    public void newRunStackFrameAt(int n){
        runStack.newFrameAt(n);
    }
    
    public void loadRunStack(int n){
        runStack.load(n);
    }
    
    public int peekRunStack(){
        return runStack.peek();        
    } 
    
    public void pushReturnAddress(int n){
        returnAddrs.push(n);
    }
    
    public void run(boolean flag){
        this.isRunning = flag;
    }
    
    public int getPC(){
        return this.pc;
    }
    
    public void setPC(int n){
        this.pc = n;
    }
    
    public int popReturnAddress(){
        return (int) returnAddrs.pop();
    }
    
    public int peekReturnAddress(){
        return (int) returnAddrs.peek();
    }
   
    public void popRunStackFrame(){
        runStack.popFrame();
    }
    
    public void StoreRunStack(int n){
        runStack.store(n);
    }
    
    public int RunStackSize(){
        return runStack.runstacksize();
    }
    
    public int FrameSize(){
        return runStack.FrameSize();
    }
    
    public String setDumpMode(String flag){
        return dumpFlag = flag;
    }
    
    public boolean DumpModeVerifier(){
        return "ON".equals(dumpFlag);
    }
}

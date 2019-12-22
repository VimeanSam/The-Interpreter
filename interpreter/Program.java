package interpreter;

import java.util.ArrayList;
import interpreter.ByteCode.*;
import java.util.TreeMap;

public class Program {

    private ArrayList<ByteCode> program;
    private static TreeMap<String, Integer> labelCode = new TreeMap<String, Integer>();
    
    public Program() {
        program = new ArrayList<>();
    }

    protected ByteCode getCode(int pc) {
        return this.program.get(pc);
    }

    public int getSize() {
        return this.program.size();
    }
     
    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     *
     * @param program Program object that holds a list of ByteCodes
     */
    
    
    public void addByteCode(ByteCode byteCode) {
        if (byteCode instanceof LabelCode){
            LabelCode code = (LabelCode)byteCode;
            //System.out.println(code.returnLabel());
            labelCode.put(code.returnLabel(), program.size()-1);
        }
        program.add(byteCode);
    }
    
    public void resolveAddrs(Program program) {
        int branchAddress;
        //System.out.println(program.getSize());
        for (int i = 0; i < program.getSize(); i++){
            //System.out.println(i+1+": "+program.program.get(i));
            if (program.program.get(i) instanceof FalseBranchCode){
                FalseBranchCode br = (FalseBranchCode)program.program.get(i);
                branchAddress = labelCode.get(br.returnLabel());
                //System.out.println(branchAddress);
                br.setBranchAddress(branchAddress);
            }
           
            if (program.program.get(i) instanceof GotoCode){
                GotoCode br = (GotoCode)program.program.get(i);
                branchAddress = labelCode.get(br.returnLabel());
                //System.out.println(br.returnLabel());
                //System.out.println(branchAddress);
                br.setBranchAddress(branchAddress);
            }
            
            if (program.program.get(i) instanceof CallCode){
                CallCode br = (CallCode)program.program.get(i);
                branchAddress = labelCode.get(br.returnLabel());
                //System.out.println(branchAddress);
                br.setBranchAddress(branchAddress);
            }
        }
    }
}

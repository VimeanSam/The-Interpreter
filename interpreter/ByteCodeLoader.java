
package interpreter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import interpreter.ByteCode.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    private Program program;

    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     */
    public Program loadCodes()  {
        try {
            program = new Program();
            ArrayList <String> arr = new ArrayList<String>();
            String x = this.byteSource.readLine();
            
            while (x != null){
                //clear the arraylist whenever new labels are being initialize
                arr.clear();
                Scanner scan = new Scanner(x);
                String className = CodeTable.getClassName(scan.next());
                //System.out.println(className);
                while(scan.hasNext()){
                    arr.add(scan.next());
                }
                x = this.byteSource.readLine();
                //System.out.println(x);
                ByteCode byteCode = (ByteCode)(Class.forName("interpreter.ByteCode."+className).newInstance());
                byteCode.init(arr);
                program.addByteCode(byteCode);
            }
        } catch (IOException ex) {
            Logger.getLogger(ByteCodeLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ByteCodeLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ByteCodeLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ByteCodeLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        program.resolveAddrs(program);
        return program;
    }
    
}

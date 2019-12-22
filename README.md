# Interpreter
In this project, I am writing an interpreter program for a fake “X” language. I am given 2 files of factorial.x.cod and fib.x.cod and I am supposed to load the bytecode contents of the X language from the .x.cod file in order to execute the .x.cod file based on the bytecode by storing each bytecode instructions and their arguments to an arraylist. Using Netbeans IDE 8.2, I load the contents of the .x.cod file and store in an arraylist. While bytecode instructions are loaded in an arraylist, I isolated any arguments that are instances of labelCode class and stored them into a Map based on their indexes in program size (line number) in order to keep track of the code that re-branch program counter. Then, I loaded literal values to the runtime Stack in order to perform binary operations based on the instruction

## Run Instruction
1. Using Netbeans IDE, click on scroll-down button <default config>
2. Click customize
3. Set main class to Interpreter.java and working directory to YOUR_LOCATION/The-Interpreter/
4. Input the .x file to run

## Output
![](/Screenshots/interpreter_2.jpg)
![](/Screenshots/interpreter_5.jpg)
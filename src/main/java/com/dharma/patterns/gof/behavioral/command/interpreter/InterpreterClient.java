package com.dharma.patterns.gof.behavioral.command.interpreter;

//领域（句子）
class InterpreterContext {

    public String getBinaryFormat(int i){
        return Integer.toBinaryString(i);
    }

    public String getHexadecimalFormat(int i){
        return Integer.toHexString(i);
    }
}

//语法结构
interface Syntax {

    String interpret(InterpreterContext ic);
}

class IntToBinaryExpression implements Syntax {

    private int i;

    IntToBinaryExpression(int c){
        this.i=c;
    }
    @Override
    public String interpret(InterpreterContext ic) {
        return ic.getBinaryFormat(this.i);
    }

}

class IntToHexExpression implements Syntax {

    private int i;

    IntToHexExpression(int c){
        this.i=c;
    }

    @Override
    public String interpret(InterpreterContext ic) {
        return ic.getHexadecimalFormat(i);
    }

}

//解释器
public class InterpreterClient {

    private InterpreterContext ic;

    private InterpreterClient(InterpreterContext i){
        this.ic=i;
    }

    private String interpret(String str){
        Syntax exp = null;
        if(str.contains("Hexadecimal")){
            exp=new IntToHexExpression(Integer.parseInt(str.substring(0,str.indexOf(" "))));
        }else if(str.contains("Binary")){
            exp=new IntToBinaryExpression(Integer.parseInt(str.substring(0,str.indexOf(" "))));
        }else return str;

        return exp.interpret(ic);
    }

    public static void main(String args[]){
        String str1 = "28 in Binary";
        String str2 = "28 in Hexadecimal";

        InterpreterClient ec = new InterpreterClient(new InterpreterContext());
        System.out.println(str1+"= "+ec.interpret(str1));
        System.out.println(str2+"= "+ec.interpret(str2));

    }
}
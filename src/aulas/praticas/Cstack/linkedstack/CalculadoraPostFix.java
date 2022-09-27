package aulas.praticas.Cstack.linkedstack;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculadoraPostFix<T> {
    LinkedStack<T> stack = new LinkedStack<>();
    private static final DecimalFormat df = new DecimalFormat("0.00");
    String expressao;

    {
        Scanner inputExpression = new Scanner(System.in);
        this.expressao = inputExpression.nextLine();
    }

    public String calcularExpressao() {
        float resultado = 0;
        char elementoDaExpressao;
        if (expressao.length() == 0) {
            System.out.println("Expressão inválida.");
            return null;
        }
        for (int i = 0; i < expressao.length(); i++) {
            elementoDaExpressao = expressao.charAt(i);
            switch (elementoDaExpressao) {
                case '*':
                    resultado = ((float) stack.pop() * (float) stack.pop());
                    stack.push(resultado);
                    break;
                case '/':
                    float secondNum = (float) stack.pop();
                    float firstNum = (float) stack.pop();
                    if (secondNum == 0) {
                        System.out.println("Can't divide by Zero");
                        return "";
                    } else {
                        resultado = firstNum / secondNum;
                        stack.push(resultado);
                        break;
                    }
                case '+':
                    firstNum = (float) stack.pop();
                    //System.out.println("primeiro retirado +" + firstNum);
                    secondNum = (float) stack.pop();
                    //System.out.println("segundo retirado +" + secondNum);
                    resultado = firstNum + secondNum;
                    stack.push(resultado);
                    //System.out.println(resultado);
                    break;
                case '-':
                    resultado = (float) stack.pop() - (float) stack.pop();
                    stack.push(resultado);
                    break;
                default:
                    if(expressao.charAt(i)==' ')break;
                    float num = Float.parseFloat(String.valueOf(elementoDaExpressao));
                    stack.push(num);
                    //System.out.println("adicionado " + num);
            }
        }
        resultado = Float.parseFloat(String.valueOf(resultado));
        df.format(resultado);
        return String.valueOf(resultado);
    }
}

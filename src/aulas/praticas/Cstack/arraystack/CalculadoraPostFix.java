package aulas.praticas.Cstack.arraystack;

import java.util.Scanner;

public class CalculadoraPostFix<T> extends ArrayStack<T> {

    ArrayStack<T> arrayPostFix = new ArrayStack<>();
    String expressao;

    {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira a Expressão Matemática PostFix");
        expressao = input.nextLine();
    }

    public int conta() {
        int resultado = 0;
        for (int i = 0; i < expressao.length(); i++) {
            char charNoIndex = expressao.charAt(i);
            switch (charNoIndex) {
                case '*':
                    resultado = (int) arrayPostFix.pop() * (int) arrayPostFix.pop();
                    arrayPostFix.push(resultado);
                    break;
                case '/':
                    resultado = (int) arrayPostFix.pop() / (int) arrayPostFix.pop();
                    arrayPostFix.push(resultado);
                    break;
                case '+':
                    resultado = (int) arrayPostFix.pop() + (int) arrayPostFix.pop();
                    arrayPostFix.push(resultado);
                    break;
                case '-':
                    resultado = (int) arrayPostFix.pop() - (int) arrayPostFix.pop();
                    arrayPostFix.push(resultado);
                    break;
                default:
                    if (expressao.charAt(i) == ' ') break;
                    int num = Integer.parseInt(String.valueOf(charNoIndex));
                    arrayPostFix.push(num);
            }
        }
        System.out.println("Resultado: " + resultado);
        return resultado;
    }
}

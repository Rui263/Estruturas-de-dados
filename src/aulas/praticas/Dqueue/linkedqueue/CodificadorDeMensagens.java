package aulas.praticas.Dqueue.linkedqueue;

import java.util.Scanner;

public class CodificadorDeMensagens {

    private String stringMensagem;

    private int[] chaveSecreta = {1, 2, 3, 4, 5, 6};
    private LinkedQueue queueMensagem = new LinkedQueue();
    private LinkedQueue queueChave = new LinkedQueue();

    private LinkedQueue mensagemCodificada = new LinkedQueue();

    private final char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private final char[] lettersUpper = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
            'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};


    public CodificadorDeMensagens() {

        Scanner mensagem = new Scanner(System.in);

        System.out.println("Mensagem a codificar: ");
        this.stringMensagem = mensagem.nextLine();
        stringMensagem = stringMensagem.replaceAll("[^a-zA-Z]", "");

        for (int i = 0; i < stringMensagem.length(); i++) {
            queueMensagem.enqueue(stringMensagem.charAt(i));
        }

        System.out.println("\nChave de Codificação: {1, 2, 3, 4, 5, 6}");
        preencherQueueChave();
    }

    public void codificarMensagem() {

        int j, chave = 0;

        while (queueMensagem.dequeue() != null) {
            char letra = (char) queueMensagem.first();
            int i = 0;

            for (j = 0; j < letters.length; j++) {
                if (letra == letters[j] || letra == lettersUpper[j]) {
                    chave = (int) queueChave.first();
                    queueChave.dequeue();
                    if (queueChave.isEmpty()) preencherQueueChave();
                    letra = letters[j + chave];
                    mensagemCodificada.enqueue(letra);
                    //char letraMensagem = (char) queueMensagem.first();

                    System.out.println(mensagemCodificada.first());
                }
            } i++;queueMensagem.dequeue();
        }

//        System.out.println("size " + queueMensagem.size());
//        for (int i = 0; i < queueMensagem.size(); i++) {
//            char letra = (char) queueMensagem.first();
//            System.out.println("---------");
//            for (j = 0; j < letters.length; j++) {
//                if (letra == letters[j] || letra == lettersUpper[j]) {
//                    chave = (int) queueChave.first();
//                    queueChave.dequeue();
//                    if (queueChave.isEmpty()) preencherQueueChave();
//                    letra = letters[j + chave];
//                    mensagemCodificada.enqueue(letra);
//                    //char letraMensagem = (char) queueMensagem.first();
//                    queueMensagem.dequeue();
//                    System.out.println(mensagemCodificada.first());
//                }
//            }
//        }
    }

    public void preencherQueueChave() {

        for (int i = 0; i < this.chaveSecreta.length; i++) {
            queueChave.enqueue(this.chaveSecreta[i+1]);
        }
    }
}

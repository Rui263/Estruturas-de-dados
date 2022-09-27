package aulas.praticas.Dqueue.arrayqueue;

import java.util.Scanner;

public class CodificadorDeMensagens {

    private char[] message;
    Character[] mensagemCodificada = new Character[200];
    private final char[] secretKey = {1, 2, 3, 4, 5, 6};

    private final char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private final char[] lettersUpper = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
            'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private ArrayQueue<Integer> keyQueue = new ArrayQueue<>();
    private ArrayQueue<Character> lettersQueue = new ArrayQueue<>();

    public CodificadorDeMensagens() {

        Scanner mensagem = new Scanner(System.in);

        System.out.println("Mensagem a codificar: ");
        String stringMessage = mensagem.nextLine();
        stringMessage = stringMessage.replaceAll("[^a-zA-Z]", "");
        message = stringMessage.toCharArray();

        System.out.println("\nChave de Codificação: {1, 2, 3, 4, 5, 6}");
        verificaKeyQueue();
        verificaLettersQueue();
    }

    public void codificaMensagem() {
        System.out.println("\n***Codificando a mensagem***");

        obterCarateresCodificados();
        //read the codified message
        System.out.println("\nMensagem codificada:\n");
        for (int j = 0; j < mensagemCodificada.length; j++) {
            if (mensagemCodificada[j] == null) return;
            System.out.print(mensagemCodificada[j]);
        }
    }

    private void obterCarateresCodificados() {

        int k, i;

        for (i = 0; i < message.length; i++) {
            //se a msg contiver carateres especiais, substitui por ' '
            if (message[i] == ' ' || message[i] == ',' || message[i] == '.' ||
                    message[i] == '-') mensagemCodificada[i] = ' ';
            //verifica se o carater é igual ao primeiro elemento da queue de letras
            while (this.message[i] != lettersQueue.first()) {
                lettersQueue.dequeue();
                verificaLettersQueue();
            }
            k = 0;
            while (k < keyQueue.first()) {
                verificaLettersQueue();
                lettersQueue.dequeue();
                verificaLettersQueue();
                k++;
            }
            mensagemCodificada[i] = lettersQueue.first();
            keyQueue.dequeue();
            verificaKeyQueue();
        }
    }

    private void verificaKeyQueue() {
        if (keyQueue.isEmpty()) {
            for (char c : this.secretKey) {
                keyQueue.enqueue((int) c);
            }
        }

    }

    private void verificaLettersQueue() {
        if (lettersQueue.isEmpty()) {
            for (char letter : letters) {
                lettersQueue.enqueue(letter);
            }
        }
    }
}
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        char[][] tabuleiro = new char[3][3];
        char jogadorAtual = 'X';
        boolean jogoTerminado = false;

        inicializarTabuleiro(tabuleiro);

        while (!jogoTerminado) {
            exibirTabuleiro(tabuleiro);

            System.out.println("Vez do jogador " + jogadorAtual);
            int linha = obterJogada("Digite a linha: ");
            int coluna = obterJogada("Digite a coluna: ");

            if (jogadaValida(tabuleiro, linha, coluna)){
                tabuleiro[linha][coluna] = jogadorAtual;
                if(verificarVitoria(tabuleiro, jogadorAtual)){
                    exibirTabuleiro(tabuleiro);
                    System.out.println("Jogador " + jogadorAtual + " Venceu!");
                     jogoTerminado = true;
                } else if (verificarEmpate(tabuleiro)) {
                    exibirTabuleiro(tabuleiro);
                    System.out.println("Empate!");
                    jogoTerminado = true;
                }else {
                    jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
                }
            }else {
                System.out.println("Jogada inválida!");
            }
        }

    }

    // Inicializando o tabuleiro
    public static void inicializarTabuleiro(char[][] tabuleiro) {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
    }

    // exibir tabuleiro
    public static void exibirTabuleiro(char[][] tabuleiro) {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print(tabuleiro[i][j]);
                if (j < tabuleiro[i].length - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < tabuleiro.length - 1) {
                System.out.println("---------");

            }
        }
    }

    // Obter uma jogada
    public static int obterJogada(String mensagem) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mensagem);
        return scanner.nextInt();
    }

    // Validar jogada
    public static boolean jogadaValida(char[][] tabuleiro, int linha, int coluna) {
        if (linha < 0 || linha >= tabuleiro.length || coluna < 0 || coluna >= tabuleiro[linha].length) {
            return false;
        }
        return tabuleiro[linha][coluna] == ' ';
    }

    // Verificar vitória
    public static boolean verificarVitoria(char[][] tabuleiro, char jogador) {
        // verificar linha
        for (int i = 0; i < tabuleiro.length; i++) {
            if (tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) {
                return true;
            }
        }
        // Verificar coluna
        for (int j = 0; j < tabuleiro[0].length; j++){
            if (tabuleiro[0][j] == jogador && tabuleiro[1][j] == jogador && tabuleiro[2][j] == jogador){
                return true;
            }
        }
        // Verificar diagonal
        if ((tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) ||
                (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador)){
           return true ;
        }
        return false;
    }
    public static boolean verificarEmpate(char[][] tabuleiro){
        for (int i = 0; i < tabuleiro.length; i++){
            for (int j = 0; j < tabuleiro[i].length; j++){
                if (tabuleiro[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}



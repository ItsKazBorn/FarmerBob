package lucasPereiraPlayer;

import jogo.*;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Lucas Pereira da Silva & Kaz Born
 */
public class Player extends AbstractPlayer {

    public Player(int depth) {
        super(depth);
    }

    public static void main(String[] args) {

    }

    @Override
    public Casa jogar(int[][] tab) {

        var jogo = getJogo();
        var copyJogo = jogo;

        List<Jogada> minhasJogadas =  copyJogo.getJogadasValidas(tab, getMinhaMarcaTabuleiro());
        List<Jogada> oponenteJogadas = copyJogo.getJogadasValidas(tab, getMarcaTabuleiroOponente());

        Jogada melhorJogada = minhasJogadas.get(0);
        int bestMinMax = 0;

        for (int i = 0; i < minhasJogadas.size(); i++){
            var test = copyJogo;
            int minMax = CheckMinMax(copyJogo, tab, minhasJogadas.get(i));

            if (minMax > bestMinMax) {
                melhorJogada = minhasJogadas.get(i);
                bestMinMax = minMax;
            }
        }

        return melhorJogada.getCasa();
    }

    private int testJogada (int[][] tab, Jogada jogada) {
        var testJogo = getJogo();
        testJogo.efetuar_jogada(tab, jogada.getCasa(), this);



        return 0;
    }

    private int CheckMinMax (AbstractJogo jogoVelha, int[][] tabOriginal, Jogada jogada) {

        var tab = FazerJogada(CloneTab(tabOriginal), jogada, getMinhaMarcaTabuleiro());
        //System.out.println(Arrays.deepToString(tab));

        List<Jogada> minhasJogadas = jogoVelha.getJogadasValidas(tab, getMinhaMarcaTabuleiro());
        List<Jogada> jogadasOponente = jogoVelha.getJogadasValidas(tab, getMarcaTabuleiroOponente());

        int[][] opTab = FazerJogadas(CloneTab(tab), jogadasOponente, getMarcaTabuleiroOponente());
        int derrotas = CheckWins(opTab, getMarcaTabuleiroOponente());

        var myTab = FazerJogadas(CloneTab(tab), minhasJogadas, getMinhaMarcaTabuleiro());
        int vitorias = CheckWins(myTab, getMinhaMarcaTabuleiro());

        //System.out.println(Arrays.deepToString(myTab));
        //System.out.println(Arrays.deepToString(opTab));

        int minMax = vitorias - derrotas;
        //System.out.println(minMax);

        return vitorias - derrotas;
    }

    private int[][] FazerJogada (int[][] tab, Jogada jogada, int marcaTabuleiro) {
        tab[jogada.getCasa().getLinha()][jogada.getCasa().getColuna()] = marcaTabuleiro;
        return tab;
    }

    private int[][] FazerJogadas (int[][] tabOriginal, List<Jogada> jogadas, int marcaTabuleiro) {
        var tab = CloneTab(tabOriginal);
        for (Jogada jogada: jogadas) {
            tab[jogada.getCasa().getLinha()][jogada.getCasa().getColuna()] = marcaTabuleiro;
        }
        return tab;
    }

    private int CheckWins(int[][] tab, int marcaTabuleiro) {
        JogoVelha jogo = new JogoVelha();
        int vitorias = 0;

        // check linhas
        for (int i = 0; i < jogo.tam; i++) {
            if (jogo.ganhouLinha(tab, i, marcaTabuleiro)) {
                vitorias += 1;
            }
            if (jogo.ganhouColuna(tab, i, marcaTabuleiro)) {
                vitorias += 1;
            }
        }
        // check diagonais
        if (jogo.ganhouDiag1(tab, marcaTabuleiro)) {
            vitorias += 1;
        }
        if (jogo.ganhouDiag2(tab, marcaTabuleiro)) {
            vitorias += 1;
        }

        return vitorias;
    }


    private int[][] CloneTab(int[][] tab) {
        int[][] newTab = new int[3][3];

        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                switch (tab[i][j]) {
                    case -1:
                        newTab[i][j] = -1;
                        break;
                    case 0:
                        newTab[i][j] = 0;
                        break;
                    case 1:
                        newTab[i][j] = 1;
                        break;
                }
            }
        }
        return newTab;
    }
}

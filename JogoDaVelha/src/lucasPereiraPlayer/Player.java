package lucasPereiraPlayer;

import jogo.AbstractPlayer;
import jogo.Casa;
import jogo.Jogada;
import jogo.JogoVelha;

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

        JogoVelha jogo = new JogoVelha();
        JogoVelha copyJogo = jogo;

        List<Jogada> minhasJogadas =  copyJogo.getJogadasValidas(tab, getMinhaMarcaTabuleiro());
        List<Jogada> oponenteJogadas = copyJogo.getJogadasValidas(tab, getMarcaTabuleiroOponente());

        Jogada melhorJogada = minhasJogadas.get(0);

        for (int i = 0; i < minhasJogadas.size(); i++){
            JogoVelha test = copyJogo;
            test.efetuar_jogada(tab, minhasJogadas.get(0).getCasa(), this);





        }

        return minhasJogadas.get(0).getCasa();
    }

    private int testJogada (int[][] tab, Jogada jogada) {
        var testJogo = getJogo();
        testJogo.efetuar_jogada(tab, jogada.getCasa(), this);
        


        return 0;
    }


}

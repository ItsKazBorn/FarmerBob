package lucasPereiraPlayer;

import jogo.AbstractPlayer;
import jogo.Casa;
import jogo.Jogada;
import jogo.JogoVelha;

import java.util.List;

/**
 *
 * @author Lucas Pereira da Silva
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

        for (int i = 0; i < minhasJogadas.size(); i++){
            for (int j = 0; j < oponenteJogadas.size(); j++){

            }
        }

        return minhasJogadas.get(0).getCasa();
    }
}

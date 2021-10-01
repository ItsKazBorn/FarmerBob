package ghosts;

public class GhostIdeas {

    /*
        1 -> SHY GHOST - Lucas
        - Se movimenta 2 quadrados por vez (igual Blinky)
        - Para de se movimentar caso o Pac Man esteja olhando pra ele
            - Fica 3 segundos parado depois que o Pac Man para de olhar pra ele

        2 -> SAVE ME GHOST - Lucas
        - Se movimenta normal (igual Blinky)
        - Quando o Pac Man come uma pellet que deixa os ghost assustado, o SAVE ME GHOST não é afetado
        - O SAVE ME GHOST muda de comportamento:
            - Ele começa a perseguir os outros fantasmas, para retira-los do modo FRIGHTENED

        3 -> DASHER GHOST - Kaz
        - Anda fazendo um circulo no mapa (patrol)
        - Quando o PacMan está numa linha direta de visão do DASHER, o DASHER da um dash na direção do Pac Man
        - o DASHER não muda de direção: ele continua se movimentando numa linha reta até bater em uma parede

        4 -> CAMPER GHOST - Kaz
        - Ele faz patrol entre as comidinhas
        - Caso sobre só uma comidinha, ele campa ela
        - Persegue o player se o player chegar perto da ultima comidinha
     */
}

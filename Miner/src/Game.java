public class Game {

    public static void main(String[] args) {
        FarmerBob bob = new FarmerBob();

        int action = 4;

        while (true)
        {
            switch (bob.state)
            {
                case GoHomeAndSleepTilRested:
                    bob.Rest();
                    bob.PrintStats();
                    System.out.println("Acabei de acordar, estou disposto novamente para mais um dia de trabalho!");
                    break;
                case EnterMineAndDigForNugget:
                    bob.Mine();
                    bob.PrintStats();
                    System.out.println("Minerando estou, minerando estou.");
                    break;
                case QuenchThirst:
                    bob.Drink();
                    bob.PrintStats();
                    System.out.println("Estou matando aquela sede danada.");
                    break;
                case VisitBankAndDepositGold:
                    bob.DepositGold();
                    bob.PrintStats();
                    System.out.println("Uma pedra mineirada para mim, uma moeda para o banco.");
            }
        }
    }
}
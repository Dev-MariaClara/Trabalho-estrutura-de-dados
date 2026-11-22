public class FilaMatchmaking {

    private String[] jogadores;
    private int quantidade;
    private int capacidade;

    public FilaMatchmaking() {
        capacidade = 100;
        jogadores = new String[capacidade];
        quantidade = 0;
    }

    public void adicionar(String jogador) {

        if (quantidade == capacidade) {
            System.out.println("Fila cheia!");
            return;
        }

        jogadores[quantidade] = jogador;
        quantidade++;

        System.out.println(jogador + " entrou na fila!");
    }

    public int buscar(String jogador) {

        for (int i = 0; i < quantidade; i++) {

            if (jogadores[i].equalsIgnoreCase(jogador)) {
                return i;
            }
        }

        return -1;
    }

    public void remover() {

        if (quantidade == 0) {
            System.out.println("A fila está vazia!");
            return;
        }

        String removido = jogadores[0];

        for (int i = 0; i < quantidade - 1; i++) {
            jogadores[i] = jogadores[i + 1];
        }

        jogadores[quantidade - 1] = null;
        quantidade--;

        System.out.println(removido + " saiu da fila!");
    }

    public void remover(String jogador) {

        int posicao = buscar(jogador);

        if (posicao == -1) {
            System.out.println("Jogador não encontrado!");
            return;
        }

        for (int i = posicao; i < quantidade - 1; i++) {
            jogadores[i] = jogadores[i + 1];
        }

        jogadores[quantidade - 1] = null;
        quantidade--;

        System.out.println(jogador + " foi removido da fila!");
    }

    public void listar() {

        if (quantidade == 0) {
            System.out.println("Não existem jogadores aguardando.");
            return;
        }

        System.out.println("\n=== FILA DE MATCHMAKING ===");

        for (int i = 0; i < quantidade; i++) {
            System.out.println((i + 1) + " - " + jogadores[i]);
        }
    }

    public void formarPartida() {

        if (quantidade < 2) {
            System.out.println("Jogadores insuficientes para formar uma partida!");
            return;
        }

        String jogador1 = jogadores[0];
        String jogador2 = jogadores[1];

        remover();
        remover();

        System.out.println("\n=== PARTIDA FORMADA ===");
        System.out.println("Jogador 1: " + jogador1);
        System.out.println("Jogador 2: " + jogador2);
    }
}

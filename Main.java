
import java.util.Scanner;
//Alunos : ARTHUR GABRIEL BRANDÃO DE FREITAS, Maria Clara De Sá Rocha, Beatriz de Sant’ Ana dos Santos


public class Main {

    private static Scanner entrada = new Scanner(System.in);

    private static ArvorePersonagens arvore = new ArvorePersonagens();
    private static FilaMatchmaking fila = new FilaMatchmaking();

    private static final int LIMITE = 100;

    private static int[] idsInventarios = new int[LIMITE];
    private static PilhaInventario[] inventarios = new PilhaInventario[LIMITE];

    private static int quantidadeInventarios = 0;

    public static void main(String[] args) {

        int opcao;

        do {

            System.out.println("\n========== RPG ARENA ==========");
            System.out.println("1 - Cadastrar personagem");
            System.out.println("2 - Buscar personagem por ID");
            System.out.println("3 - Buscar personagens por nivel");
            System.out.println("4 - Remover personagem");
            System.out.println("5 - Listar personagens");
            System.out.println("6 - Mostrar personagens em pre-ordem");
            System.out.println("7 - Mostrar personagens em pos-ordem");
            System.out.println("8 - Entrar no matchmaking");
            System.out.println("9 - Buscar jogador na fila");
            System.out.println("10 - Remover jogador da fila");
            System.out.println("11 - Listar fila");
            System.out.println("12 - Formar partida");
            System.out.println("13 - Adicionar item ao inventario");
            System.out.println("14 - Buscar item no inventario");
            System.out.println("15 - Remover item do inventario");
            System.out.println("16 - Listar inventario");
            System.out.println("0 - Sair");
            System.out.println("================================");

            opcao = lerInt("Escolha uma opcao: ");

            switch (opcao) {

                case 1:
                    cadastrarPersonagem();
                    break;

                case 2:
                    buscarPersonagem();
                    break;

                case 3:
                    buscarNivel();
                    break;

                case 4:
                    removerPersonagem();
                    break;

                case 5:
                    System.out.println("\n=== PERSONAGENS EM ORDEM ===");
                    arvore.emOrdem();
                    break;

                case 6:
                    System.out.println("\n=== PERCURSO PRE-ORDEM ===");
                    arvore.preOrdem();
                    break;

                case 7:
                    System.out.println("\n=== PERCURSO POS-ORDEM ===");
                    arvore.posOrdem();
                    break;

                case 8:
                    entrarFila();
                    break;

                case 9:
                    buscarJogadorFila();
                    break;

                case 10:
                    removerJogadorFila();
                    break;

                case 11:
                    fila.listar();
                    break;

                case 12:
                    fila.formarPartida();
                    break;

                case 13:
                    adicionarItem();
                    break;

                case 14:
                    buscarItem();
                    break;

                case 15:
                    removerItem();
                    break;

                case 16:
                    listarInventario();
                    break;

                case 0:
                    System.out.println("Encerrando RPG Arena...");
                    break;

                default:
                    System.out.println("Opcao invalida!");
            }

        } while (opcao != 0);

        entrada.close();
    }

    private static int lerInt(String mensagem) {

        while (true) {

            System.out.print(mensagem);

            try {
                return Integer.parseInt(entrada.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Digite um numero valido!");
            }
        }
    }

    private static void cadastrarPersonagem() {

        System.out.println("\n=== CADASTRO DE PERSONAGEM ===");

        int id = lerInt("ID do personagem: ");

        if (!arvore.buscar(id).equals("Personagem nao encontrado.")) {
            System.out.println("Esse ID ja esta cadastrado!");
            return;
        }

        System.out.print("Nome do personagem: ");
        String nome = entrada.nextLine();

        int nivel = lerInt("Nivel do personagem: ");

        if (nivel < 1) {
            System.out.println("O nivel deve ser maior que zero!");
            return;
        }

        arvore.inserir(nome, id, nivel);

        System.out.println("Personagem cadastrado com sucesso!");
    }

    private static void buscarPersonagem() {

        int id = lerInt("Digite o ID do personagem: ");

        System.out.println(arvore.buscar(id));
    }

    private static void buscarNivel() {

        int nivel = lerInt("Digite o nivel desejado: ");

        System.out.println("\n=== PERSONAGENS DO NIVEL " + nivel + " ===");

        arvore.buscarPorNivel(nivel);
    }

    private static void removerPersonagem() {

        int id = lerInt("Digite o ID do personagem: ");

        if (arvore.buscar(id).equals("Personagem nao encontrado.")) {
            System.out.println("Personagem nao encontrado!");
            return;
        }

        fila.remover(String.valueOf(id));

        int posicao = localizarInventario(id);

        if (posicao != -1) {

            while (!inventarios[posicao].estaVazia()) {
                inventarios[posicao].remover();
            }

            inventarios[posicao] = null;
            idsInventarios[posicao] = -1;
        }

        arvore.remover(id);

        System.out.println("Personagem removido com sucesso!");
    }

    private static void entrarFila() {

        int id = lerInt("Digite o ID do personagem: ");

        if (arvore.buscar(id).equals("Personagem nao encontrado.")) {
            System.out.println("Cadastre o personagem antes de entrar na fila!");
            return;
        }

        String jogador = String.valueOf(id);

        if (fila.buscar(jogador) != -1) {
            System.out.println("Esse personagem ja esta na fila!");
            return;
        }

        fila.adicionar(jogador);
    }

    private static void buscarJogadorFila() {

        String id = String.valueOf(lerInt("Digite o ID do personagem: "));

        int posicao = fila.buscar(id);

        if (posicao == -1) {
            System.out.println("Personagem nao encontrado na fila!");
        } else {
            System.out.println("Personagem encontrado na posicao " + (posicao + 1));
        }
    }

    private static void removerJogadorFila() {

        String id = String.valueOf(lerInt("Digite o ID do personagem: "));

        fila.remover(id);
    }

    private static int localizarInventario(int id) {

        for (int i = 0; i < LIMITE; i++) {

            if (idsInventarios[i] == id) {
                return i;
            }
        }

        return -1;
    }

    private static int obterInventario(int id) {

        int posicao = localizarInventario(id);

        if (posicao != -1) {
            return posicao;
        }

        for (int i = 0; i < LIMITE; i++) {

            if (idsInventarios[i] == 0 || inventarios[i] == null) {

                idsInventarios[i] = id;
                inventarios[i] = new PilhaInventario();

                return i;
            }
        }

        return -1;
    }

    private static boolean personagemExiste(int id) {

        return !arvore.buscar(id).equals("Personagem nao encontrado.");
    }

    private static void adicionarItem() {

        int idPersonagem = lerInt("ID do personagem: ");

        if (!personagemExiste(idPersonagem)) {
            System.out.println("Personagem nao encontrado!");
            return;
        }

        int posicao = obterInventario(idPersonagem);

        if (posicao == -1) {
            System.out.println("Limite de inventarios atingido!");
            return;
        }

        int idItem = lerInt("ID do item: ");

        if (inventarios[posicao].buscar(idItem) != null) {
            System.out.println("Esse ID de item ja existe no inventario!");
            return;
        }

        System.out.print("Nome do item: ");
        String nome = entrada.nextLine();

        PilhaInventario.Item item =
                new PilhaInventario.Item(idItem, nome);

        inventarios[posicao].adicionar(item);
    }

    private static void buscarItem() {

        int idPersonagem = lerInt("ID do personagem: ");

        if (!personagemExiste(idPersonagem)) {
            System.out.println("Personagem nao encontrado!");
            return;
        }

        int posicao = localizarInventario(idPersonagem);

        if (posicao == -1) {
            System.out.println("Esse personagem nao possui itens!");
            return;
        }

        int idItem = lerInt("ID do item: ");

        PilhaInventario.Item item = inventarios[posicao].buscar(idItem);

        if (item == null) {
            System.out.println("Item nao encontrado!");
        } else {
            System.out.println(item);
        }
    }

    private static void removerItem() {

        int idPersonagem = lerInt("ID do personagem: ");

        if (!personagemExiste(idPersonagem)) {
            System.out.println("Personagem nao encontrado!");
            return;
        }

        int posicao = localizarInventario(idPersonagem);

        if (posicao == -1 || inventarios[posicao].estaVazia()) {
            System.out.println("Inventario vazio!");
            return;
        }

        inventarios[posicao].remover();
    }

    private static void listarInventario() {

        int idPersonagem = lerInt("ID do personagem: ");

        if (!personagemExiste(idPersonagem)) {
            System.out.println("Personagem nao encontrado!");
            return;
        }

        int posicao = localizarInventario(idPersonagem);

        if (posicao == -1) {
            System.out.println("Esse personagem nao possui itens!");
            return;
        }

        inventarios[posicao].listar();
    }
}

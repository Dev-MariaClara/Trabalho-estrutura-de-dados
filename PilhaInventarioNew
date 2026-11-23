
public class PilhaInventario {

    public static class Item {

        private int id;
        private String nome;

        public Item(int id, String nome) {
            this.id = id;
            this.nome = nome;
        }

        public int getId() {
            return id;
        }

        public String getNome() {
            return nome;
        }

        @Override
        public String toString() {
            return "ID: " + id + " | Item: " + nome;
        }
    }

    private Item[] itens;
    private int topo;
    private int capacidade;

    public PilhaInventario() {
        capacidade = 10;
        itens = new Item[capacidade];
        topo = -1;
    }

    public boolean estaVazia() {
        return topo == -1;
    }

    public boolean estaCheia() {
        return topo == capacidade - 1;
    }

    public void adicionar(Item item) {
        if (estaCheia()) {
            System.out.println("Inventário cheio!");
            return;
        }

        topo++;
        itens[topo] = item;

        System.out.println(item.getNome() + " adicionado ao inventário!");
    }

    public Item remover() {
        if (estaVazia()) {
            System.out.println("Inventário vazio!");
            return null;
        }

        Item removido = itens[topo];
        itens[topo] = null;
        topo--;

        System.out.println(removido.getNome() + " removido do inventário!");

        return removido;
    }

    public Item buscar(int id) {
        for (int i = topo; i >= 0; i--) {
            if (itens[i].getId() == id) {
                return itens[i];
            }
        }

        return null;
    }

    public void listar() {
        if (estaVazia()) {
            System.out.println("Inventário vazio!");
            return;
        }

        System.out.println("\n=== INVENTÁRIO DO PERSONAGEM ===");

        for (int i = topo; i >= 0; i--) {
            System.out.println(itens[i]);
        }
    }
}

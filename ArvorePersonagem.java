
public class ArvorePersonagens {

    private class No {

        private String nomePersonagem;
        private int id;
        private int nivel;
        private No esquerda;
        private No direita;

        public No(String nomePersonagem, int id, int nivel) {
            this.nomePersonagem = nomePersonagem;
            this.id = id;
            this.nivel = nivel;
        }
    }

    private No raiz;

    public void inserir(String nomePersonagem, int id, int nivel) {
        raiz = inserirRecursivo(raiz, nomePersonagem, id, nivel);
    }

    private No inserirRecursivo(No atual, String nomePersonagem, int id, int nivel) {

        if (atual == null) {
            return new No(nomePersonagem, id, nivel);
        }

        if (id < atual.id) {
            atual.esquerda = inserirRecursivo(atual.esquerda, nomePersonagem, id, nivel);
        } else if (id > atual.id) {
            atual.direita = inserirRecursivo(atual.direita, nomePersonagem, id, nivel);
        } else {
            System.out.println("ID ja cadastrado!");
        }

        return atual;
    }

    public String buscar(int id) {
        No resultado = buscarRecursivo(raiz, id);

        if (resultado == null) {
            return "Personagem nao encontrado.";
        }

        return "ID: " + resultado.id
                + " | Nome: " + resultado.nomePersonagem
                + " | Nivel: " + resultado.nivel;
    }

    private No buscarRecursivo(No atual, int id) {

        if (atual == null || atual.id == id) {
            return atual;
        }

        if (id < atual.id) {
            return buscarRecursivo(atual.esquerda, id);
        }

        return buscarRecursivo(atual.direita, id);
    }

    public void buscarPorNivel(int nivel) {
        buscarNivelRecursivo(raiz, nivel);
    }

    private void buscarNivelRecursivo(No atual, int nivel) {

        if (atual != null) {

            buscarNivelRecursivo(atual.esquerda, nivel);

            if (atual.nivel == nivel) {
                System.out.println("ID: " + atual.id
                        + " | Nome: " + atual.nomePersonagem
                        + " | Nivel: " + atual.nivel);
            }

            buscarNivelRecursivo(atual.direita, nivel);
        }
    }

    public void remover(int id) {
        raiz = removerRecursivo(raiz, id);
    }

    private No removerRecursivo(No atual, int id) {

        if (atual == null) {
            return null;
        }

        if (id < atual.id) {
            atual.esquerda = removerRecursivo(atual.esquerda, id);
        } else if (id > atual.id) {
            atual.direita = removerRecursivo(atual.direita, id);
        } else {

            if (atual.esquerda == null && atual.direita == null) {
                return null;
            }

            if (atual.esquerda == null) {
                return atual.direita;
            }

            if (atual.direita == null) {
                return atual.esquerda;
            }

            No sucessor = menorValor(atual.direita);

            atual.id = sucessor.id;
            atual.nomePersonagem = sucessor.nomePersonagem;
            atual.nivel = sucessor.nivel;

            atual.direita = removerRecursivo(atual.direita, sucessor.id);
        }

        return atual;
    }

    private No menorValor(No atual) {

        while (atual.esquerda != null) {
            atual = atual.esquerda;
        }

        return atual;
    }

    public void emOrdem() {
        emOrdemRecursivo(raiz);
    }

    private void emOrdemRecursivo(No atual) {

        if (atual != null) {
            emOrdemRecursivo(atual.esquerda);
            System.out.println(atual.id + " - " + atual.nomePersonagem + " - Nivel: " + atual.nivel);
            emOrdemRecursivo(atual.direita);
        }
    }

    public void preOrdem() {
        preOrdemRecursivo(raiz);
    }

    private void preOrdemRecursivo(No atual) {

        if (atual != null) {
            System.out.println(atual.id + " - " + atual.nomePersonagem + " - Nivel: " + atual.nivel);
            preOrdemRecursivo(atual.esquerda);
            preOrdemRecursivo(atual.direita);
        }
    }

    public void posOrdem() {
        posOrdemRecursivo(raiz);
    }

    private void posOrdemRecursivo(No atual) {

        if (atual != null) {
            posOrdemRecursivo(atual.esquerda);
            posOrdemRecursivo(atual.direita);
            System.out.println(atual.id + " - " + atual.nomePersonagem + " - Nivel: " + atual.nivel);
        }
    }
}

import java.util.ArrayList;
import java.util.List;

/**
 * EXERCÍCIO 1: O Castelo Animado
 * Classes: Castelo, Personagem, Mago, Divisao
 * Conceitos: Herança, Encapsulamento, Agregação com ArrayList
 */
public class Desafio1_Impl {

    // Classe Castelo (classe principal do desafio)
    public static class Castelo {
        private String nome;
        private List<Divisao> divisoes;

        public Castelo(String nome, ArrayList<Divisao> divisoes) {
            this.nome = nome;
            this.divisoes = divisoes;
        }
        
        public Castelo(String nome) {
            this.nome = nome;
            this.divisoes = new ArrayList<>();
        }

        public void adicionarDivisao(Divisao divisao) {
            this.divisoes.add(divisao);
            System.out.println("Divisão " + divisao.getNome() + " adicionada ao " + this.nome);
        }

        public List<Divisao> getDivisoes() {
            return divisoes;
        }

        public String getNome() {
            return nome;
        }
    }

    // Classe Personagem (base para herança)
    public static class Personagem {
        private String nome;
        private int idade;

        public Personagem(String nome, int idade) {
            this.nome = nome;
            this.idade = idade;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public int getIdade() {
            return idade;
        }

        public void setIdade(int idade) {
            this.idade = idade;
        }
    }

    // Classe Mago (herda de Personagem)
    public static class Mago extends Personagem {
        private String magia;

        public Mago(String nome, int idade, String magia) {
            super(nome, idade);
            this.magia = magia;
        }

        public String lancarFeitico() {
            return getNome() + " lança " + this.magia + "!";
        }

        public String getMagia() {
            return magia;
        }
    }

    // Classe Divisao
    public static class Divisao {
        private String nome;
        private int andar;

        public Divisao(String nome, int andar) {
            this.nome = nome;
            this.andar = andar;
        }

        public String getNome() {
            return nome;
        }

        public int getAndar() {
            return andar;
        }

        @Override
        public String toString() {
            return nome + " (Andar " + andar + ")";
        }
    }
}
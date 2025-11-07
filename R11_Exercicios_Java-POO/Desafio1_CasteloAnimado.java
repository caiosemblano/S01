/**
 * Classe principal para executar o Desafio 1: O Castelo Animado
 */
public class Desafio1_CasteloAnimado {
    public static void main(String[] args) {
        // Criando o castelo
        Desafio1_Impl.Castelo howl = new Desafio1_Impl.Castelo("Castelo Animado de Howl");
        
        // Criando algumas divisões
        Desafio1_Impl.Divisao sala = new Desafio1_Impl.Divisao("Sala Principal", 1);
        Desafio1_Impl.Divisao cozinha = new Desafio1_Impl.Divisao("Cozinha da Calcifer", 1);
        Desafio1_Impl.Divisao quarto = new Desafio1_Impl.Divisao("Quarto do Howl", 2);
        
        // Adicionando divisões ao castelo
        howl.adicionarDivisao(sala);
        howl.adicionarDivisao(cozinha);
        howl.adicionarDivisao(quarto);
        
        // Criando personagens
        Desafio1_Impl.Mago howlMago = new Desafio1_Impl.Mago("Howl Jenkins Pendragon", 27, "Transformação");
        Desafio1_Impl.Personagem sophie = new Desafio1_Impl.Personagem("Sophie", 18);
        
        // Demonstrando funcionalidades
        System.out.println("\nInformações do Castelo:");
        System.out.println("Nome: " + howl.getNome());
        
        System.out.println("\nDivisões do Castelo:");
        for (Desafio1_Impl.Divisao div : howl.getDivisoes()) {
            System.out.println("- " + div.toString());
        }
        
        System.out.println("\nDemonstrando magia:");
        System.out.println(howlMago.lancarFeitico());
        
        System.out.println("\nInformações dos personagens:");
        System.out.println("Mago: " + howlMago.getNome() + ", Idade: " + howlMago.getIdade() + ", Magia: " + howlMago.getMagia());
        System.out.println("Personagem: " + sophie.getNome() + ", Idade: " + sophie.getIdade());
    }
}
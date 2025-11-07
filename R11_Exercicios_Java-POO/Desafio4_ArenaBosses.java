/**
 * Classe principal para executar o Desafio 4: Arena de Bosses
 */
public class Desafio4_ArenaBosses {
    public static void main(String[] args) {
        // Criando a arena
        Desafio4_Impl.Batalha arena = new Desafio4_Impl.Batalha();
        
        // Criando padrões de ataque
        Desafio4_Impl.PadraoAtaque ataque1 = new Desafio4_Impl.PadraoAtaque("Golpe Pesado", 50);
        Desafio4_Impl.PadraoAtaque ataque2 = new Desafio4_Impl.PadraoAtaque("Investida", 30);
        Desafio4_Impl.PadraoAtaque ataque3 = new Desafio4_Impl.PadraoAtaque("Bola de Fogo", 40);
        Desafio4_Impl.PadraoAtaque ataque4 = new Desafio4_Impl.PadraoAtaque("Nova de Gelo", 45);
        
        // Criando bosses normais
        Desafio4_Impl.Boss boss1 = new Desafio4_Impl.Boss("Cavaleiro Negro", "KN-001", "Luz");
        boss1.adicionarAtaque(ataque1);
        boss1.adicionarAtaque(ataque2);
        
        // Criando boss mágico
        Desafio4_Impl.BossMagico boss2 = new Desafio4_Impl.BossMagico("Arquimago", "AM-001", "Silêncio");
        boss2.adicionarAtaque(ataque3);
        boss2.adicionarAtaque(ataque4);
        
        // Adicionando bosses à arena
        arena.adicionarBoss(boss1);
        arena.adicionarBoss(boss2);
        
        // Demonstrando funcionalidades
        System.out.println("\nListando ataques dos bosses:");
        boss1.listarAtaques();
        boss2.listarAtaques();
        
        System.out.println("\nIniciando batalhas:");
        arena.iniciarBatalha("KN-001");
        arena.iniciarBatalha("AM-001");
        
        // Tentando iniciar batalha com ID inexistente
        System.out.println("\nTentando batalha com ID inválido:");
        arena.iniciarBatalha("INVALID-ID");
    }
}
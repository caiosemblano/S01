/**
 * Classe principal para executar o Desafio 3: Detetives Ocultos
 */
public class Desafio3_DetetivesOcultos {
    public static void main(String[] args) {
        // Criando o registro de uma equipe
        Desafio3_Impl.RegistroOculto equipeInvestigadores = new Desafio3_Impl.RegistroOculto("Equipe Alpha");
        
        // Criando alguns aliens
        Desafio3_Impl.Alien alien1 = new Desafio3_Impl.Alien("ET Verde", "Marte", "OVNI-X", "Setor 7");
        Desafio3_Impl.Alien alien2 = new Desafio3_Impl.Alien("Predador", "Yautja Prime", "OVNI-Y", "Floresta");
        
        // Criando poderes para os youkais
        Desafio3_Impl.Poder poderFogo = new Desafio3_Impl.Poder("Chamas Místicas");
        Desafio3_Impl.Poder poderSombra = new Desafio3_Impl.Poder("Controle das Sombras");
        
        // Criando youkais com seus poderes
        Desafio3_Impl.Youkai youkai1 = new Desafio3_Impl.Youkai("Kitsune", "Templo Antigo", poderFogo);
        Desafio3_Impl.Youkai youkai2 = new Desafio3_Impl.Youkai("Kappa", "Lago Místico", poderSombra);
        
        // Demonstrando funcionalidades
        System.out.println("=== Início dos Registros ===\n");
        
        // Registrando avistamentos
        equipeInvestigadores.registrarAvistamento(alien1);
        equipeInvestigadores.registrarAvistamento(alien2);
        equipeInvestigadores.registrarAvistamento(youkai1);
        equipeInvestigadores.registrarAvistamento(youkai2);
        
        // Tentando registrar uma entidade duplicada
        System.out.println("\nTentando registrar alien duplicado:");
        equipeInvestigadores.registrarAvistamento(alien1);
        
        // Listando todos os avistamentos
        equipeInvestigadores.listarAvistamentos();
        
        // Buscando e mostrando detalhes de uma entidade específica
        System.out.println("\nBuscando entidade específica:");
        Desafio3_Impl.IRastreavel entidade = equipeInvestigadores.buscarAvistamento("Kitsune");
        if (entidade != null) {
            System.out.println("Encontrado: " + entidade.obterCoordenadas());
            if (entidade instanceof Desafio3_Impl.Youkai) {
                Desafio3_Impl.Youkai y = (Desafio3_Impl.Youkai) entidade;
                System.out.println("Poder: " + y.getPoder().getNome());
            }
        }
    }
}
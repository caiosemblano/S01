import java.util.HashMap;
import java.util.Map;

/**
 * EXERCÍCIO 3: Detetives Ocultos
 * Classes: RegistroOculto, Poder, Alien, Youkai
 * Interface: IRastreavel
 * Conceitos: Interface, Composição, HashMap
 */

// Requisito 4: Classe principal com HashMap
public class Desafio3_Impl {

    public static class RegistroOculto {
    
    private String nomeEquipe;

    // Requisito 4: Uso de HashMap.
    // O requisito pede unicidade pelo NOME (String)
    private Map<String, IRastreavel> avistamentos;

    // Construtor
    public RegistroOculto(String nomeEquipe) {
        this.nomeEquipe = nomeEquipe;
        this.avistamentos = new HashMap<>(); // Inicializa o HashMap
    }

    /**
     * Registra um avistamento.
     * Adaptado para seguir o requisito 4
     * (usar o nome da entidade como chave).
     */
    public boolean registrarAvistamento(IRastreavel entidade) {
        
        String nome;
        // Precisamos extrair o nome, que está nas classes concretas
        if (entidade instanceof Alien) {
            nome = ((Alien) entidade).getNome();
        } else if (entidade instanceof Youkai) {
            nome = ((Youkai) entidade).getNome();
        } else {
            System.out.println("ERRO: Tipo de entidade desconhecido.");
            return false;
        }

        // Requisito 4: Garante que a entidade (pelo nome) seja adicionada apenas uma vez
        if (avistamentos.containsKey(nome)) {
            System.out.println("ERRO: Entidade " + nome + " já registrada.");
            return false;
        } else {
            avistamentos.put(nome, entidade);
            System.out.println("SUCESSO: " + nome + " registrado pela " + this.nomeEquipe);
            return true;
        }
    }
    
    public IRastreavel buscarAvistamento(String nome) {
        return avistamentos.get(nome);
    }

    public void listarAvistamentos() {
        System.out.println("\nRegistros da equipe " + this.nomeEquipe + ":");
        for (Map.Entry<String, IRastreavel> entry : avistamentos.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue().obterCoordenadas());
        }
    }
}

/**
 * Requisito 1: Criação da Interface Rastreavel
 */
public interface IRastreavel {
    String obterCoordenadas();
}

/**
 * Requisito 3: Classe Poder (Componente)
 */
public static class Poder {
    private String nome;

    // Construtor
    public Poder(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

/**
 * Requisito 2: Alien deve implementar a interface Rastreavel
 */
public static class Alien implements IRastreavel {

    private String nome;
    private String planetaOrigem;
    private String Ovni;
    private String localizacao;
    
    // Requisito 3 pede "Alien OU Youkai". 
    // O diagrama não lista Poder no Alien.

    // Construtor
    public Alien(String nome, String planeta, String Ovni, String localizacao) {
        this.nome = nome;
        this.planetaOrigem = planeta;
        this.Ovni = Ovni;
        this.localizacao = localizacao;
    }

    // Requisito 2: Implementação do método da interface
    @Override
    public String obterCoordenadas() {
        return "Sinal de Radar: " + this.localizacao + " | Origem: " + this.planetaOrigem;
    }

    public String getNome() {
        return nome;
    }
}

/**
 * Requisito 2: Youkai deve implementar a interface Rastreavel
 */
public static class Youkai implements IRastreavel {

    private String nome;
    private String localizacao;
    
    // Requisito 3: O Poder deve ser criado por Composição
    private final Poder _poder;

    // Construtor
    public Youkai(String nome, String localizacao, Poder poder) {
        this.nome = nome;
        this.localizacao = localizacao;
        this._poder = poder;
    }

    // Requisito 2: Implementação do método da interface
    @Override
    public String obterCoordenadas() {
        return this.localizacao;
    }

    public String getNome() {
        return nome;
    }

    public Poder getPoder() {
        return _poder;
    }
}}
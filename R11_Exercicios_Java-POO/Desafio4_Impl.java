import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * EXERCÍCIO 4: Arena de Bosses
 * Classes: Batalha, Boss, BossMagico, PadraoAtaque
 * Conceitos: Composição com LinkedHashSet, Herança, Agregação com HashMap
 */

// Requisito 2: Classe principal com Agregação
public class Desafio4_Impl {

    public static class Batalha {

    // Requisito 2: Agregação. A Batalha "agrega" Bosses
    // Requisito 2: Uso de HashMap<String, Boss> para mapear o ID
    private Map<String, Boss> _arena;

    // Construtor
    public Batalha(HashMap<String, Boss> arena) {
        this._arena = arena;
    }
    
    // Construtor alternativo
    public Batalha() {
        this._arena = new HashMap<>();
    }

    // Método
    public void adicionarBoss(Boss boss) {
        // A chave é o ID do boss
        this._arena.put(boss.getIdBoss(), boss);
        System.out.println(boss.nome + " foi adicionado à arena.");
    }

    // Requisito 3: Método deve usar o HashMap para localizar o Boss
    public void iniciarBatalha(String idBoss) {
        // Requisito 3: Localizando o Boss pelo ID no HashMap
        Boss boss = this._arena.get(idBoss);

        if (boss != null) {
            // Demonstração de Polimorfismo:
            // Se for 'BossMagico', chamará o 'iniciarFase' dele.
            boss.iniciarFase();
        } else {
            System.out.println("Boss com ID " + idBoss + " não encontrado na arena!");
        }
    }
}

/**
 * Classe PadraoAtaque (o componente)
 */
public static class PadraoAtaque {
    private String nome;
    private int dano;

    // Construtor
    public PadraoAtaque(String nome, int dano) {
        this.nome = nome;
        this.dano = dano;
    }

    public String getNome() {
        return nome;
    }

    // Métodos equals e hashCode são essenciais para o LinkedHashSet
    // identificar ataques únicos corretamente.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PadraoAtaque that = (PadraoAtaque) o;
        return Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}

/**
 * Classe base Boss
 */
public static class Boss {
    public String nome;
    private String idBoss;
    private String PontoFraco;

    // Requisito 1: Composição. O Boss "possui um" moveset
    // Requisito 1: Uso de LinkedHashSet
    private Set<PadraoAtaque> _moveset;

    // Construtor
    public Boss(String nome, String id, String fracoContra) {
        this.nome = nome;
        this.idBoss = id;
        this.PontoFraco = fracoContra;
        // Inicializa o Set (Composição)
        this._moveset = new LinkedHashSet<>();
    }

    // Método
    public void adicionarAtaque(PadraoAtaque ataque) {
        this._moveset.add(ataque);
    }

    // Método
    public void iniciarFase() {
        System.out.println(this.nome + " iniciou a batalha! Fraco contra: " + this.PontoFraco);
    }
    
    public String getIdBoss() {
        return idBoss;
    }

    // Método para listar os ataques do boss
    public void listarAtaques() {
        System.out.println("\nMoveset do " + this.nome + ":");
        for (PadraoAtaque ataque : this._moveset) {
            System.out.println("- " + ataque.getNome());
        }
    }
}

/**
 * Requisito 1: Classe BossMagico (Herança)
 */
public static class BossMagico extends Boss {

    // Construtor
    public BossMagico(String nome, String id, String fracoContra) {
        super(nome, id, fracoContra);
    }

    // Polimorfismo (@Override)
    @Override
    public void iniciarFase() {
        System.out.println(this.nome + " (Mágico) conjura sua arena mística!");
        super.iniciarFase(); // Chama o comportamento do pai
    }
}}
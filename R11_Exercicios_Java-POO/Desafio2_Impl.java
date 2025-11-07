import java.util.ArrayList;
import java.util.List;

/**
 * EXERCÍCIO 2: Cafeteria Leblanc
 * Classes: CafeLeblanc, Menu, Cafe, CafeGourmet
 * Conceitos: Herança, Polimorfismo, Composição com ArrayList
 */

// Requisito 3: Classe principal com Composição
public class Desafio2_Impl {

    public static class CafeLeblanc {

    // Requisito 3: Composição. A Cafeteria "é composta" por um Menu
    private final Menu _menu;

    // Construtor
    public CafeLeblanc(Menu menu) {
        this._menu = menu; // O Menu é obrigatório (Composição)
    }

    // Método
    public void receberPedido(Cafe cafe) {
        System.out.println("Pedido recebido: " + cafe.getNome());
    }
    
    public Menu getMenu() {
        return _menu;
    }
}

/**
 * Requisito 3: Implementação da classe Menu
 */
public static class Menu {

    // Requisito 3: Composição. O Menu "é composto" de Cafés
    // Requisito 4: Uso de ArrayList<Cafe> para manter a ordem
    private List<Cafe> itens;

    // Construtor
    public Menu(ArrayList<Cafe> itens) {
        this.itens = itens;
    }
    
    // Construtor alternativo
    public Menu() {
        this.itens = new ArrayList<>();
    }

    // Método para adicionar item
    public void adicionarItem(Cafe cafe) {
        this.itens.add(cafe);
    }

    // Listar menu
    public void listarMenu() {
        System.out.println("\nMenu da Cafeteria:");
        for (Cafe cafe : itens) {
            System.out.printf("- %s: R$ %.2f%n", cafe.getNome(), cafe.calcularPrecoFinal());
        }
    }

    public List<Cafe> getItens() {
        return itens;
    }
}

/**
 * Requisito 1: Implementação da classe base Cafe
 */
public static class Cafe {

    protected String nome;
    protected double precoBase;

    // Construtor
    public Cafe(String nome, double precoBase) {
        this.nome = nome;
        this.precoBase = precoBase;
    }

    // Método base para cálculo de preço
    public double calcularPrecoFinal() {
        return this.precoBase;
    }

    public String getNome() {
        return nome;
    }
}

/**
 * Requisito 1: Implementação da classe CafeGourmet
 * Requisito 1: Uso de Herança (Extends Cafe)
 */
public static class CafeGourmet extends Cafe {

    private double bonusAroma;

    // Construtor
    public CafeGourmet(String nome, double precoBase, double bonus) {
        super(nome, precoBase); // Chama construtor da classe pai
        this.bonusAroma = bonus;
    }

    // Requisito 2: Polimorfismo (@Override)
    // O preço final do Gourmet adiciona o bônus
    @Override
    public double calcularPrecoFinal() {
        // Retorna o preço base (do pai) + o bônus
        return super.calcularPrecoFinal() + this.bonusAroma;
    }
}}
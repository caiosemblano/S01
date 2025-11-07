/**
 * Classe principal para executar o Desafio 2: Cafeteria Leblanc
 */
public class Desafio2_CafeteriaLeblanc {
    public static void main(String[] args) {
        // Criando o menu da cafeteria
        Desafio2_Impl.Menu menu = new Desafio2_Impl.Menu();
        
        // Criando a cafeteria com o menu
        Desafio2_Impl.CafeLeblanc cafeteria = new Desafio2_Impl.CafeLeblanc(menu);
        
        // Criando alguns cafés normais
        Desafio2_Impl.Cafe cafeSimples = new Desafio2_Impl.Cafe("Café Coado", 5.0);
        Desafio2_Impl.Cafe cafeExpresso = new Desafio2_Impl.Cafe("Café Expresso", 7.0);
        
        // Criando cafés gourmet
        Desafio2_Impl.CafeGourmet cafeArabia = new Desafio2_Impl.CafeGourmet("Café Arábica Especial", 10.0, 5.0);
        Desafio2_Impl.CafeGourmet cafeEtiopian = new Desafio2_Impl.CafeGourmet("Café Etíope Premium", 12.0, 8.0);
        
        // Adicionando cafés ao menu
        menu.adicionarItem(cafeSimples);
        menu.adicionarItem(cafeExpresso);
        menu.adicionarItem(cafeArabia);
        menu.adicionarItem(cafeEtiopian);
        
        // Demonstrando funcionalidades
        System.out.println("Bem-vindo à Cafeteria Leblanc!");
        
        // Listando o menu com os preços
        menu.listarMenu();
        
        // Demonstrando o recebimento de pedidos
        cafeteria.receberPedido(cafeSimples);
        cafeteria.receberPedido(cafeArabia);
        
        // Demonstrando o polimorfismo no cálculo de preços
        System.out.println("\nDetalhes dos preços:");
        System.out.printf("%s: R$ %.2f%n", cafeSimples.getNome(), cafeSimples.calcularPrecoFinal());
        System.out.printf("%s: R$ %.2f%n", cafeArabia.getNome(), cafeArabia.calcularPrecoFinal());
    }
}
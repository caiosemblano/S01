use std::io;

fn imprimir_tabuada(numero: i32, limite_inferior: i32, limite_superior: i32) {
    for contador in limite_inferior..=limite_superior {
        let resultado = numero * contador;
        println!("{} x {} = {}", numero, contador, resultado);
    }
}

fn main() {
    println!("=== GERADOR DE TABUADA ===\n");
    
    // Pedir o número da tabuada
    println!("Digite o número da tabuada:");
    let mut numero_str = String::new();
    io::stdin()
        .read_line(&mut numero_str)
        .expect("Erro ao ler entrada");
    let numero: i32 = numero_str.trim().parse().expect("Digite um número válido");
    
    // Pedir o limite inferior
    println!("Digite o limite inferior:");
    let mut limite_inferior_str = String::new();
    io::stdin()
        .read_line(&mut limite_inferior_str)
        .expect("Erro ao ler entrada");
    let limite_inferior: i32 = limite_inferior_str.trim().parse().expect("Digite um número válido");
    
    // Pedir o limite superior
    println!("Digite o limite superior:");
    let mut limite_superior_str = String::new();
    io::stdin()
        .read_line(&mut limite_superior_str)
        .expect("Erro ao ler entrada");
    let limite_superior: i32 = limite_superior_str.trim().parse().expect("Digite um número válido");
    
    // Chamar a função imprimir_tabuada
    println!("\n=== TABUADA DO {} ===", numero);
    imprimir_tabuada(numero, limite_inferior, limite_superior);
}
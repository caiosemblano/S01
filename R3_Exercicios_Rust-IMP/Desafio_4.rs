fn calcular_media(nota1: f64, nota2: f64, nota3: f64) -> f64 {
    let peso1 = 2.0;
    let peso2 = 3.0;
    let peso3 = 5.0;
    
    let media_ponderada = (nota1 * peso1 + nota2 * peso2 + nota3 * peso3) / (peso1 + peso2 + peso3);
    media_ponderada
}

fn main() {
    let nota1 = 7.5;
    let nota2 = 8.0;
    let nota3 = 9.2;
    
    let resultado = calcular_media(nota1, nota2, nota3); // Chamando a função para calcular a média ponderada
    println!("Nota 1: {}", nota1);
    println!("Nota 2: {}", nota2);
    println!("Nota 3: {}", nota3);
    println!("Média ponderada: {:.2}", resultado);
    
    // Verificar se a média é maior ou igual a 7
    if resultado >= 7.0 {
        println!("Aprovado");
    } else {
        println!("Reprovado");
    }
}
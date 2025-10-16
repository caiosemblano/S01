        use std::io;

        fn eh_par(numero: i32) -> bool {
            numero % 2 == 0
        }

        fn main() {
            println!("=== JOGO DE PAR OU ÍMPAR ===\n");

            // Pedir para o Jogador 1 escolher "par" ou "ímpar"
            println!("Jogador 1, escolha 'par' ou 'impar':");
            let mut escolha_j1 = String::new();
            io::stdin()
                .read_line(&mut escolha_j1)
                .expect("Erro ao ler entrada");
            let escolha_j1 = escolha_j1.trim().to_lowercase();

            // Verificar se a escolha é válida
            if escolha_j1 != "par" && escolha_j1 != "impar" {
                println!("Escolha inválida! Digite 'par' ou 'impar'");
                return;
            }

            // Pedir número do Jogador 1
            println!("Jogador 1, digite seu número:");
            let mut numero_j1 = String::new();
                 io::stdin()
                .read_line(&mut numero_j1)
                .expect("Erro ao ler entrada");
            let numero_j1: i32 = numero_j1.trim().parse().expect("Digite um número válido");

            // Pedir número do Jogador 2
            println!("Jogador 2, digite seu número:");
            let mut numero_j2 = String::new();
            io::stdin()
                .read_line(&mut numero_j2)
                .expect("Erro ao ler entrada");
            let numero_j2: i32 = numero_j2.trim().parse().expect("Digite um número válido");
            
            let soma = numero_j1 + numero_j2;
            let resultado_eh_par = eh_par(soma);

            // Determinar quem venceu
            let vencedor = if (escolha_j1 == "par" && resultado_eh_par) || (escolha_j1 == "impar" && !resultado_eh_par) {
                "Jogador 1"
            } else {
                "Jogador 2"
            };

            println!("\n=== RESULTADO ===");
            println!("Jogador 1 escolheu: {}", escolha_j1);
            println!("Número do Jogador 1: {}", numero_j1);
            println!("Número do Jogador 2: {}", numero_j2);
            println!("Soma dos números: {}", soma);
            println!("A soma é: {}", if resultado_eh_par { "PAR" } else { "ÍMPAR" });
            println!("{} venceu!", vencedor);
        }
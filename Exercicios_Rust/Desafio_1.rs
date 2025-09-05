use std::io;

fn validar_senha(senha: &str) -> bool {
    if senha.len() < 8 {
        return false;
    }
    if !senha.chars().any(|c| c.is_numeric()) {
        return false;
    }
    if !senha.chars().any(|c| c.is_uppercase()) {
        return false;
    }
    
    true
}

fn main() {
    println!("Validador de Senhas");
    println!("Requisitos: pelo menos 8 caracteres, 1 número, 1 maiúscula\n");
    
    loop {
        println!("Digite uma senha:");
        
        let mut senha = String::new();
        io::stdin()
            .read_line(&mut senha)
            .expect("Erro ao ler entrada");
        
        // Remove o \n do final
        let senha = senha.trim();
        
        if validar_senha(senha) {
            println!("Senha válida! Acesso concedido.\n");
            break;
        } else {
            println!("Senha inválida. Tente novamente.\n");
        }
    }
}


package main

import "fmt"

func verificarLogin(usuario, senha string) bool {
	if usuario == "senha" && senha == "admin" {
		return true
	}
	return false
}

func main() {
	var usuario, senha string
	resultado := false
	for resultado == false {
		println("Digite o usuário e a senha:")
		fmt.Scanln(&usuario, &senha)
		if verificarLogin(usuario, senha) {
			fmt.Println("Acesso concedido")
			return
		} else {
			fmt.Println("Acesso negado")
		}
	}
}
package main

import "fmt"


func main() {
    var numero int
    fmt.Scanln(&numero)
    
	switch numero%2 {
	case 0:
		fmt.Println("Par")
		return

	default:
		fmt.Println("Ímpar")
		return
	}
	
}
#include <iostream>

using namespace std;

int main() {
    int quantidadeNotas;
    float nota;
    float soma = 0.0;
    float media;

    cout << "Digite quantas notas voce quer inserir: ";
    cin >> quantidadeNotas;

    for (int i = 0; i < quantidadeNotas; ++i) {
        cout << "Insira uma nota: ";
        cin >> nota;

        while (nota < 0 || nota > 10) {
            cout << "Nota invalida. Insira uma nota entre 0 e 10: ";
            cin >> nota;
        }
        soma += nota;
    }

    if (quantidadeNotas > 0) {
        media = soma / quantidadeNotas;
        cout << "A media final e: " << media << endl;

        if (media >= 7) {
            cout << "Aprovado" << endl;
        } else {
            cout << "Reprovado" << endl;
        }
    }

    return 0;
}
#include <iostream>

using namespace std;

float somarArray(float arr[], int tamanho)
{
	float soma = 0;
	for(int i = 0; i < tamanho; i++)
	{
		soma += arr[i];
	}
	return soma;
}

int main()
{
	int n;
	cout << "Digite o tamanho do array, em seguida seus valores:" << endl << endl;
	cin >> n;
	float arr[n];
	
	for(int i = 0; i < n; i++)
	{
		cin >> arr[i];
	}
	cout << somarArray(arr, n) << endl;
	
	
	
	return 0;	
}
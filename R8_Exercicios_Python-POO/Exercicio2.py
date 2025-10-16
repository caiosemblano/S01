# Para criar uma classe abstrata e forçar a implementação de métodos,
# importamos ABC (Abstract Base Class) e abstractmethod do módulo abc.
from abc import ABC, abstractmethod

# Tarefa 1: Crie uma classe base Heroi.
class Heroi(ABC):
    """
    Representa uma classe base abstrata para todos os heróis.
    Força as classes filhas a implementarem o método usar_ultimate().
    """
    def __init__(self, nome, funcao):
        """
        Inicializa um novo Herói.

        Args:
            nome (str): O nome do herói.
            funcao (str): A função do herói (ex: "Tanque", "Dano", "Suporte").
        """
        self.nome = nome
        self.funcao = funcao

    # Tarefa 2: Crie um método que força as classes filhas a implementá-lo.
    @abstractmethod
    def usar_ultimate(self):
        """
        Este método é um "contrato" que deve ser implementado por qualquer
        classe que herde de Heroi.
        """
        pass

# Tarefa 3: Crie duas classes filhas, Tanque e Dano.
class Tanque(Heroi):
    """
    Representa um herói da função Tanque.
    """
    def __init__(self, nome):
        # Chama o __init__ da classe pai (Heroi) definindo a função como "Tanque".
        super().__init__(nome, "Tanque")

    # Tarefa 4: Sobrescreva o método usar_ultimate() para a ação específica.
    def usar_ultimate(self):
        """Implementação da Ultimate para a classe Tanque."""
        print(f"O Tanque {self.nome} usa sua Ultimate para criar uma barreira intransponível!")

class Dano(Heroi):
    """
    Representa um herói da função Dano.
    """
    def __init__(self, nome):
        # Chama o __init__ da classe pai (Heroi) definindo a função como "Dano".
        super().__init__(nome, "Dano")

    # Tarefa 4: Sobrescreva o método usar_ultimate() para a ação específica.
    def usar_ultimate(self):
        """Implementação da Ultimate para a classe Dano."""
        print(f"O herói de Dano {self.nome} usa sua Ultimate para causar dano massivo em área!")

# --- Demonstração de uso (Main) ---
if __name__ == "__main__":
    # Tarefa 5: Crie uma lista e adicione instâncias.
    lista_de_herois = [
        Tanque("Reinhardt"),
        Dano("Genji"),
        Tanque("Winston"),
        Dano("Pharah")
    ]

    print("--- Ativando as Ultimates de todos os heróis! ---")
    
    # Tarefa 6: Percorra a lista e chame o método usar_ultimate().
    # Isso demonstra o Polimorfismo: o mesmo método (usar_ultimate)
    # se comporta de maneiras diferentes dependendo do objeto (Tanque ou Dano).
    for heroi in lista_de_herois:
        heroi.usar_ultimate()
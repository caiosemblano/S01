# Tarefa 1: Crie uma classe base chamada Personagem.
class Personagem:

    # Tarefa 3: Implemente o método __init__ para inicializar esses atributos.
    def __init__(self, vida, resistencia):
        """
        Inicializa um novo personagem.

        Atributos:
            vida (int): A quantidade de pontos de vida do personagem.
            resistencia (int): O valor de resistência do personagem.
        """
        # Tarefa 2: Defina os atributos _vida e _resistencia usando a convenção de atributos privados.
        self._vida = vida
        self._resistencia = resistencia

    # Tarefa 4: Use as Propriedades para criar getters e setters controlados para a vida.
    @property
    def vida(self):
        """Getter: Retorna o valor atual da vida."""
        return self._vida

    @vida.setter
    def vida(self, novo_valor):
        """Setter: Define um novo valor para a vida, garantindo que não seja negativo."""
        if novo_valor < 0:
            self._vida = 0
            print("A vida não pode ser negativa. Foi definida como 0.")
        else:
            self._vida = novo_valor

    # Tarefa 7: Implemente o método __str__ para retornar uma descrição formatada.
    def __str__(self):
        """Retorna uma representação em string do objeto Personagem."""
        return f"Personagem com {self.vida} de vida e {self._resistencia} de resistência."


# Tarefa 5: Crie uma classe filha chamada Cavaleiro que herde de Personagem.
class Cavaleiro(Personagem):
    """
    Representa um Cavaleiro, um tipo de Personagem que possui armadura pesada.
    """
    def __init__(self, vida, resistencia):
        """
        Inicializa um novo Cavaleiro.

        Args:
            vida (int): A quantidade de pontos de vida do Cavaleiro.
            resistencia (int): O valor de resistência do Cavaleiro.
        """
        # Chama o __init__ da classe pai (Personagem) para inicializar vida e resistencia.
        super().__init__(vida, resistencia)
        # Tarefa 6: Adicione o atributo armadura_pesada (booleano) exclusivo.
        self.armadura_pesada = True

    # Tarefa 7: Implemente o método __str__ para a classe Cavaleiro.
    def __str__(self):
        """Retorna uma representação em string do objeto Cavaleiro."""
        status_armadura = "Sim" if self.armadura_pesada else "Não"
        return f"Cavaleiro com {self.vida} de vida, {self._resistencia} de resistência e Armadura Pesada: {status_armadura}."

# --- Demonstração de uso ---
if __name__ == "__main__":
    # Criando um objeto da classe base Personagem
    personagem_comum = Personagem(vida=100, resistencia=50)
    print("--- Informações do Personagem Comum ---")
    print(personagem_comum)

    # Usando o setter para alterar a vida
    print("\nPersonagem comum sofreu dano...")
    personagem_comum.vida -= 30
    print(f"Nova vida: {personagem_comum.vida}")

    print("-" * 20)

    # Criando um objeto da classe filha Cavaleiro
    cavaleiro = Cavaleiro(vida=150, resistencia=80)
    print("--- Informações do Cavaleiro ---")
    print(cavaleiro)

    # O Cavaleiro também pode usar o getter e setter herdados
    print("\nCavaleiro sofreu dano crítico...")
    cavaleiro.vida = -10 # Testando a lógica do setter para valores negativos
    print(f"Nova vida do cavaleiro: {cavaleiro.vida}")
    print(cavaleiro)
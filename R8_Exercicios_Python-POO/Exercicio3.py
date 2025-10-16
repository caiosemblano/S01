# Tarefa 1: Crie uma classe ArmaCorpoACorpo (para Composição).
class ArmaCorpoACorpo:
    """
    Representa a arma pessoal do Joker.
    Esta classe será "composta" pela classe Joker.
    """
    def __init__(self, nome_arma, dano):
        self.nome_arma = nome_arma
        self.dano = dano

    def __str__(self):
        """Retorna uma descrição da arma."""
        return f"[{self.nome_arma} (Dano: {self.dano})]"


# Tarefa 2: Crie uma classe PhantomThief (para Agregação).  
class PhantomThief:
    """
    Representa um membro da equipe dos Phantom Thieves.
    Esta classe será "agregada" pela classe Joker.
    """
    # O __init__ recebe nome e arma, conforme a tarefa[cite: 96].
    def __init__(self, nome_membro, arma_principal):
        self.nome_membro = nome_membro
        self.arma_principal = arma_principal

    def __str__(self):
        """Retorna os dados do membro."""
        return f"Membro: {self.nome_membro} (Arma: {self.arma_principal})"


# Tarefa 3: Crie a classe Joker.
class Joker:
    """
    Representa o protagonista, Joker.
    Ele "compõe" sua própria arma e "agrega" uma equipe.
    """
    def __init__(self, equipe: list[PhantomThief]):
        """
        Inicializa o Joker.

        Args:
            equipe (list[PhantomThief]): Uma lista de objetos PhantomThief
                                        que já existem.
        """
        
        # Tarefa 3 - Composição:
        # O objeto ArmaCorpoACorpo é criado DENTRO do construtor de Joker.
        # A "faca" pertence ao Joker e é gerenciada por ele.
        self.arma_joker = ArmaCorpoACorpo("Faca Tática", 50)

        # Tarefa 3 - Agregação:
        # A lista de membros (equipe) é recebida como parâmetro.
        # Joker apenas armazena a referência a essa lista.
        self.equipe = equipe

    # Tarefa 4: Crie um método para mostrar a equipe agregada.
    def mostrar_equipe(self):
        """
        Itera sobre a lista agregada e imprime os dados de cada membro.
        """
        print(f"--- Equipe de {self.__class__.__name__} ---")
        if not self.equipe:
            print("Joker está agindo sozinho.")
            return
            
        for membro in self.equipe:
            print(f"- {membro}") # Usa o __str__ da classe PhantomThief
        print("------------------------------")

    def mostrar_status_pessoal(self):
        """Mostra os itens compostos do Joker."""
        print(f"Equipamento pessoal de Joker: {self.arma_joker}")


# --- Demonstração de uso (Main) ---
if __name__ == "__main__":
    
    # 1. Criei os objetos "agregados" primeiro.
    # Eles existem independentemente do Joker.
    ryuji = PhantomThief(nome_membro="Ryuji", arma_principal="Cano de Metal")
    ann = PhantomThief(nome_membro="Ann", arma_principal="Chicote")
    yusuke = PhantomThief(nome_membro="Yusuke", arma_principal="Katana")

    # 2. Criei a lista que será agregada.
    minha_equipe = [ryuji, ann, yusuke]

    # 3. Criei o Joker, passando a lista (Agregação).
    # A arma de Joker (Faca Tática) será criada automaticamente
    # dentro do __init__ (Composição).
    joker = Joker(equipe=minha_equipe)

    # 4. Usei os métodos para ver o resultado.
    joker.mostrar_status_pessoal()
    joker.mostrar_equipe()
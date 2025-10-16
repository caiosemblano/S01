# Importamos ABC e abstractmethod para criar a "Interface"
from abc import ABC, abstractmethod

# [cite_start]Tarefa 1: Crie uma classe Interface base chamada Cibernetico. [cite: 105]
# [cite_start]Tarefa 2: Defina um método abstrato chamado realizar_hack(). [cite: 105]
class Cibernetico(ABC):
    """
    Interface (Classe Base Abstrata) para qualquer entidade "hackeável".
    Define um contrato que obriga as subclasses a implementarem 'realizar_hack'.
    """
    @abstractmethod
    def realizar_hack(self):
        """Método abstrato que deve ser implementado por qualquer classe filha."""
        pass

# [cite_start]Tarefa 3: Crie uma classe Implante (Composição). [cite: 106]
class Implante:
    """
    Representa um implante cibernético.
    Esta classe será "composta" por um NetRunner.
    """
    def __init__(self, custo: int, funcao: str):
        """
        [cite_start]Inicializa o implante com seu custo e função. [cite: 106]
        """
        self.custo = custo
        self.funcao = funcao

    def __str__(self):
        return f"Implante de {self.funcao} (Custo: ${self.custo})"


# [cite_start]Tarefa 4: Crie a classe NetRunner que herda de Cibernetico. [cite: 107]
class NetRunner(Cibernetico):
    """
    Representa um NetRunner.
    Ele herda de Cibernetico (cumprindo a interface) e
    compõe um objeto Implante.
    """
    def __init__(self, nome: str):
        self.nome = nome
        
        # [cite_start]Composição: O NetRunner cria e gerencia seu próprio Implante. [cite: 107]
        # O Implante não existe fora do NetRunner.
        self.implante_neural = Implante(custo=15000, funcao="QuickHacking Avançado")

    # [cite_start]Implementação obrigatória do método da interface. [cite: 107]
    def realizar_hack(self):
        """Implementação específica do hack para um NetRunner."""
        print(f"O NetRunner {self.nome} usa seu '{self.implante_neural.funcao}' para invadir o sistema.")


# [cite_start]Tarefa 5: Crie uma classe Faccao que agregue uma lista de Cibernetico. [cite: 108]
class Faccao:
    """
    Representa uma facção que "agrega" membros.
    Os membros são do tipo Cibernetico (a interface).
    """
    def __init__(self, nome_faccao: str, membros: list[Cibernetico]):
        """
        Inicializa a facção.
        
        Args:
            nome_faccao (str): O nome da facção.
            [cite_start]membros (list[Cibernetico]): A lista de membros (agregados). [cite: 108]
        """
        self.nome_faccao = nome_faccao
        self.membros = membros # Agregação: A lista é recebida de fora.

    def executar_hack_em_massa(self):
        """
        Demonstração: Manda todos os membros agregados executarem 
        [cite_start]o método 'realizar_hack()'. [cite: 110]
        """
        print(f"\n--- Facção '{self.nome_faccao}' iniciando hack em massa! ---")
        if not self.membros:
            print(f"A facção '{self.nome_faccao}' não possui membros para a operação.")
            return
            
        for membro in self.membros:
            membro.realizar_hack() # Polimorfismo em ação!


# --- Demonstração de uso (Main) ---
if __name__ == "__main__":
    
    # [cite_start]Tarefa 6: Crie instâncias de NetRunners. [cite: 109]
    # Note que poderíamos ter outras classes que herdam de 'Cibernetico'
    # (ex: VeiculoHackeavel, RoboSeguranca), mas o exercício pede NetRunners.
    netrunner_v = NetRunner(nome="V")
    netrunner_judy = NetRunner(nome="Judy")
    netrunner_tbug = NetRunner(nome="T-Bug")

    # Criamos as listas de membros que serão "agregadas".
    membros_mox = [netrunner_judy]
    membros_mercenarios = [netrunner_v, netrunner_tbug]

    # [cite_start]Tarefa 6: Crie uma instância de Faccao. [cite: 109]
    # Agregação: Passamos as listas de membros no construtor.
    faccao_mox = Faccao(nome_faccao="Mox", membros=membros_mox)
    faccao_mercenarios = Faccao(nome_faccao="Mercenários", membros=membros_mercenarios)

    # [cite_start]Tarefa 6: Demonstre que a Faccao pode mandar todos executarem o método. [cite: 110]
    faccao_mox.executar_hack_em_massa()
    faccao_mercenarios.executar_hack_em_massa()
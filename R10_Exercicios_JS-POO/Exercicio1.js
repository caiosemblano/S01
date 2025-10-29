/**
 * Classe base que define as características básicas de um Pokémon[cite: 140].
 */
class Pokemon {
    // A vida deve ser protegida de alterações externas [cite: 139]
    #vida; // [cite: 145]
    nome;  // [cite: 145]
    tipo;  // [cite: 145]

    constructor(nome, tipo, vidaInicial) { // [cite: 146]
        this.nome = nome;
        this.tipo = tipo;
        this.#vida = vidaInicial; // [cite: 145]
    }

    /**
     * Getter público para o atributo privado #vida.
     * @returns {Number} A vida atual do Pokémon.
     */
    getVida() { // 
        return this.#vida;
    }

    /**
     * Método público para aplicar dano, modificando o estado interno.
     * @param {Number} dano - A quantidade de dano a receber.
     */
    receberDano(dano) { // 
        this.#vida -= dano;
        if (this.#vida < 0) {
            this.#vida = 0;
        }
        console.log(`${this.nome} recebeu ${dano} de dano. Vida restante: ${this.#vida}`);
    }

    /**
     * Método "protegido" (convenção JS) para cura, acessível pelas subclasses.
     * A vida é modificada apenas internamente.
     * @param {Number} cura - A quantidade de vida a recuperar.
     */
    _aplicarCura(cura) {
        this.#vida += cura;
        console.log(`${this.nome} recuperou ${cura} de vida. Vida atual: ${this.#vida}`);
    }

    /**
     * Ataque genérico[cite: 140].
     * @param {Pokemon} alvo - O Pokémon a ser atacado.
     */
    atacar(alvo) { // [cite: 149]
        console.log(`${this.nome} (tipo ${this.tipo}) usa um ataque genérico em ${alvo.nome}.`);
        alvo.receberDano(10);
    }
}

/**
 * Subclasse para ataques especializados[cite: 142].
 * Herda de Pokemon[cite: 144].
 */
class PokemonFogo extends Pokemon { // [cite: 151]
    bonusAtaque; // 

    constructor(nome, vidaInicial, bonus) { // [cite: 153]
        // Chama o construtor da classe pai (Pokemon)
        super(nome, "Fogo", vidaInicial); // [cite: 146]
        this.bonusAtaque = bonus; // 
    }

    /**
     * Polimorfismo: Sobrescreve o método atacar com lógica única[cite: 142].
     * @param {Pokemon} alvo - O Pokémon a ser atacado.
     */
    atacar(alvo) { // [cite: 153]
        const danoTotal = 15 + this.bonusAtaque;
        console.log(`🔥 ${this.nome} usa Lança-chamas em ${alvo.nome}! (Dano: ${danoTotal})`);
        alvo.receberDano(danoTotal);
    }
}

/**
 * Subclasse para ataques especializados[cite: 142].
 * Herda de Pokemon[cite: 150].
 */
class PokemonAgua extends Pokemon { // [cite: 154]
    #curaBase; // 

    constructor(nome, vidaInicial, curaBase) { // [cite: 156]
        // Chama o construtor da classe pai (Pokemon)
        super(nome, "Agua", vidaInicial); // [cite: 146]
        this.#curaBase = curaBase; // 
    }

    /**
     * Polimorfismo: Sobrescreve o método atacar com lógica única[cite: 142].
     * Além de atacar, este Pokémon se cura.
     * @param {Pokemon} alvo - O Pokémon a ser atacado.
     */
    atacar(alvo) { // [cite: 156]
        const danoAtaque = 12;
        console.log(`💧 ${this.nome} usa Jato d'Água em ${alvo.nome}! (Dano: ${danoAtaque})`);
        alvo.receberDano(danoAtaque);

        // Lógica única adicional: curar-se
        console.log(`💧 ${this.nome} se recupera usando sua habilidade...`);
        // Chama o método "protegido" da classe pai para modificar a vida interna
        this._aplicarCura(this.#curaBase);
    }
}


// --- Demonstração da Batalha (Simulação) [cite: 140] ---

const charizard = new PokemonFogo("Charizard", 100, 10);
const blastoise = new PokemonAgua("Blastoise", 120, 5);

console.log("--- Início da Batalha ---");
console.log(`${charizard.nome} (Vida: ${charizard.getVida()}) vs ${blastoise.nome} (Vida: ${blastoise.getVida()})`);
console.log("--------------------------");

// Demonstração do Polimorfismo [cite: 142]
// Rodada 1: PokemonFogo ataca
charizard.atacar(blastoise);
console.log("--------------------------");

// Rodada 2: PokemonAgua ataca
blastoise.atacar(charizard);
console.log("--------------------------");

// Demonstração do Encapsulamento [cite: 139, 141]
console.log("Tentando modificar a vida de Charizard diretamente...");
try {
    charizard.#vida = 500; // Isso causará um erro
} catch (e) {
    console.error("ERRO: Não é possível acessar #vida. O atributo é privado!");
}

// Acesso correto (leitura)
console.log(`Vida atual de Charizard (via getVida()): ${charizard.getVida()}`); // 
console.log(`Vida atual de Blastoise (via getVida()): ${blastoise.getVida()}`);
console.log("--- Fim da Batalha ---");
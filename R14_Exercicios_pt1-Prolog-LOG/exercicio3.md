% =======================================================
% DATASET: Fatos e Relações
% =======================================================

% --- Progenitores ---
progenitor(urano, cronos).
progenitor(gaia, cronos).
progenitor(urano, oceano).
progenitor(gaia, oceano).
progenitor(cronos, zeus).
progenitor(reia, zeus).
progenitor(cronos, poseidon).
progenitor(reia, poseidon).
% (Inclusão do exercício 1)
progenitor(cronos, hades).
progenitor(reia, hades).
% -----------------------------
progenitor(zeus, atena).
progenitor(zeus, apolo).
progenitor(hera, apolo).
progenitor(zeus, artemis).
progenitor(letó, artemis).
progenitor(zeus, ares).
progenitor(hera, ares).
progenitor(zeus, hefesto).
progenitor(hera, hefesto).
progenitor(poseidon, tritao).
progenitor(zeus, perseu).
progenitor(dânae, perseu).
progenitor(atena, erictônio).

% --- Fatos: Poderes e Domínios ---
dominio(zeus, ceu).
dominio(zeus, trovão).
dominio(poseidon, mar).
dominio(poseidon, terremoto).
dominio(hades, submundo).
dominio(atena, sabedoria).
dominio(atena, guerra_estrategica).
dominio(ares, guerra_brutal).
dominio(apolo, sol).
dominio(apolo, musica).
dominio(artemis, caça).
dominio(artemis, lua).
dominio(hefesto, fogo).
dominio(hefesto, forja).
dominio(afrodite, beleza).
dominio(afrodite, amor).
dominio(cronos, tempo).

% --- Fatos: Armas e Artefatos ---
arma(zeus, raio).
arma(poseidon, tridente).
arma(hades, elmo_escuridao).
arma(atena, escudo_aegis).
arma(perseu, espada_adamantina).

% --- Fatos: Características e Títulos ---
caracteristica(zeus, rei).
caracteristica(hera, rainha).
caracteristica(hades, invisivel).
caracteristica(hefesto, ferreiro).
caracteristica(artemis, virgem).
caracteristica(perseu, mortal).

% --- Fatos: Relações de Aliança ---
aliado(zeus, poseidon).
aliado(poseidon, zeus).
aliado(atena, apolo).
aliado(apolo, atena).
aliado(ares, hades).
aliado(hades, ares).
aliado(hefesto, atena).
aliado(atena, hefesto).

% --- Fatos: Localização Principal ---
local_principal(zeus, olimpo).
local_principal(poseidon, atlântida).
local_principal(hades, submundo).
local_principal(apolo, olimpo).
local_principal(artemis, florestas).

% =======================================================
% REGRAS LÓGICAS (Todos os Exercícios)
% =======================================================

% Regra 1: Divindade Olímpica
divindade_olimpica(Deus) :-
    progenitor(cronos, Deus),
    (dominio(Deus, ceu); dominio(Deus, mar); dominio(Deus, submundo)).

% Regra 2: Deus Maior
deus_maior(Deus) :-
    local_principal(Deus, olimpo),
    dominio(Deus, D1),
    dominio(Deus, D2),
    D1 \= D2.

% -------------------------------------------------------
% NOVA REGRA: IRMÃOS GERMANOS (Irmãos de Sangue)
% Descrição: Verdadeira SE A e B tiverem o mesmo pai E a mesma mãe.
% -------------------------------------------------------

irmaos_germanos(A, B) :-
    progenitor(Pai, A),
    progenitor(Pai, B),    % Compartilham um progenitor (pai)
    progenitor(Mae, A),
    progenitor(Mae, B),    % Compartilham outro progenitor (mãe)
    Pai \= Mae,            % Garante que Pai e Mãe são entidades diferentes
    A \= B.                % Garante que A não é irmão dele mesmo

## Como Executar (Query)

irmaos_germanos(zeus, Irmao).

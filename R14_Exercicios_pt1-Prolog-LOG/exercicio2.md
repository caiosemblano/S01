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
% (Inclusão do exercício anterior)
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
% REGRAS LÓGICAS (EXERCÍCIOS)
% =======================================================

% Regra: Divindade Olímpica (Exercício anterior)
divindade_olimpica(Deus) :-
    progenitor(cronos, Deus),
    (dominio(Deus, ceu); dominio(Deus, mar); dominio(Deus, submundo)).

% -------------------------------------------------------
% NOVA REGRA: DEUS MAIOR
% Descrição: Verdadeira SE o Deus tiver pelo menos dois domínios
% E habitar o 'olimpo'.
% -------------------------------------------------------

deus_maior(Deus) :-
    local_principal(Deus, olimpo),   % Verifica se mora no Olimpo
    dominio(Deus, D1),               % Encontra um Domínio 1
    dominio(Deus, D2),               % Encontra um Domínio 2
    D1 \= D2.                        % Garante que D1 e D2 são diferentes

## Como Executar (Query)

deus_maior(Deus).

% =======================================================
% 1. DATASET (Copie e cole isso no seu interpretador)
% =======================================================

% disciplina(Nome, Creditos, Area).
disciplina(calculo_1, 6, matematica).
disciplina(calculo_2, 4, matematica).
disciplina(fisica_1, 4, exatas).
disciplina(geometria, 4, matematica). % Exemplo para a Query 2
disciplina(algoritmos, 4, computacao).

% prerequisito(Pre, Pos). -> "Pre" é requisito para fazer "Pos"
prerequisito(calculo_1, calculo_2).
prerequisito(calculo_1, fisica_1).
prerequisito(algoritmos, estruturas_dados).

% =======================================================
% 2. REGRAS (A Solução)
% =======================================================

% Regra: alto_impacto(D)
% Verdadeira SE créditos > 5 E for pré-requisito de pelo menos 2 matérias diferentes.
alto_impacto(D) :-
    disciplina(D, Creditos, _),
    Creditos > 5,
    prerequisito(D, A),
    prerequisito(D, B),
    A \= B.

% =======================================================
% 3. COMO RODAR (Queries)
% =======================================================

% Query 1: Testar a regra de alto impacto
% ?- alto_impacto(X).
% Esperado: X = calculo_1.

% Query 2 (Pedida no exercício):
% "Encontre disciplinas de 'matematica', com 4 créditos, que NÃO são pré-requisito de nada."
% ?- disciplina(D, 4, matematica), \+ prerequisito(D, _).
% Esperado: D = geometria (e calculo_2, dependendo se calculo_2 desbloqueia algo no futuro).

% =======================================================
% 1. DATASET
% =======================================================

% disciplina(Nome, Area).
disciplina(introducao_prog, computacao).
disciplina(etica, humanas).
disciplina(compiladores, computacao).
disciplina(tcc, aplicacoes).

% prerequisito(Pre, Pos).
prerequisito(introducao_prog, compiladores).
prerequisito(compiladores, tcc).
% 'etica' não tem pré-requisito e não trava nada.

% =======================================================
% 2. REGRAS (A Solução)
% =======================================================

% Regra: disciplina_raiz(D)
% Verdadeira SE a disciplina NÃO tem nenhum pré-requisito.
disciplina_raiz(D) :-
    disciplina(D, _),       % Garante que D é uma disciplina válida
    \+ prerequisito(_, D).  % Ninguém é pré-requisito de D

% Regra: disciplina_folha(D)
% Verdadeira SE a disciplina NÃO é pré-requisito para ninguém.
disciplina_folha(D) :-
    disciplina(D, _),       % Garante que D é uma disciplina válida
    \+ prerequisito(D, _).  % D não é pré-requisito de ninguém

% =======================================================
% 3. COMO RODAR (Queries)
% =======================================================

% Query: Disciplinas Raiz que NÃO são da área 'aplicacoes'
% ?- disciplina_raiz(D), disciplina(D, Area), Area \= aplicacoes.
% Esperado: D = introducao_prog, D = etica.
% (TCC seria folha, Compiladores não é raiz nem folha).

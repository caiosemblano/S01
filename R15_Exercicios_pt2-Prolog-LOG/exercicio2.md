% =======================================================
% 1. DATASET
% =======================================================

% disciplina(Nome, Creditos, Area).
disciplina(logica, 4, fundamental).
disciplina(algoritmos, 4, fundamental).
disciplina(ia, 4, computacao).
disciplina(web, 4, aplicacoes).

% prerequisito(Pre, Pos).
prerequisito(algoritmos, ia).
prerequisito(logica, ia).
prerequisito(algoritmos, web).

% concluiu(Aluno, Disciplina).
concluiu(joao, algoritmos).
concluiu(joao, logica).
concluiu(maria, algoritmos).

% =======================================================
% 2. REGRAS (A Solução)
% =======================================================

% Regra Auxiliar: falta_concluir(Aluno, Disciplina)
% Verifica se a disciplina é necessária para algo e o aluno não fez.
falta_concluir(Aluno, Disciplina) :-
    prerequisito(Disciplina, _),
    \+ concluiu(Aluno, Disciplina).

% Regra Principal: aluno_apto(Aluno, Disciplina)
% Verdadeira SE:
% 1. A disciplina NÃO é da área 'fundamental'.
% 2. O aluno concluiu TODOS os pré-requisitos (Não existe pré-requisito que ele não tenha feito).
aluno_apto(Aluno, Disciplina) :-
    disciplina(Disciplina, _, Area),
    Area \= fundamental,
    \+ (prerequisito(Pre, Disciplina), \+ concluiu(Aluno, Pre)).

% =======================================================
% 3. COMO RODAR (Queries)
% =======================================================

% Query 1: Quais disciplinas Joao está apto?
% ?- aluno_apto(joao, D).
% Esperado: D = ia, D = web (pois ele tem os requisitos e não são fundamentais).

% Query 2: Maria está apta a cursar inteligencia_artificial (ia)?
% ?- aluno_apto(maria, ia).
% Esperado: false (pois ela fez algoritmos, mas falta logica).

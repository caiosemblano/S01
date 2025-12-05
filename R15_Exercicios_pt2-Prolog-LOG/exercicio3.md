% =======================================================
% 1. DATASET
% =======================================================

% disciplina(Nome, Area).
disciplina(redes, computacao).
disciplina(banco_dados, computacao).
disciplina(calculo, matematica).
disciplina(algebra, matematica).

% concluiu(Aluno, Disciplina).
% Pedro: Fez muita computação, nenhuma matemática.
concluiu(pedro, redes).
concluiu(pedro, banco_dados).

% Ana: Fez computação e matemática.
concluiu(ana, redes).
concluiu(ana, banco_dados).
concluiu(ana, calculo).

% =======================================================
% 2. REGRAS (A Solução)
% =======================================================

% Regra: especialista_comp(Aluno)
% Verdadeira SE concluiu pelo menos duas disciplinas DIFERENTES de computacao.
especialista_comp(Aluno) :-
    concluiu(Aluno, D1), disciplina(D1, computacao),
    concluiu(Aluno, D2), disciplina(D2, computacao),
    D1 \= D2.

% Regra: deficiencia_mat(Aluno)
% Verdadeira SE o aluno NÃO concluiu nenhuma disciplina de matematica.
deficiencia_mat(Aluno) :-
    \+ (concluiu(Aluno, D), disciplina(D, matematica)).

% =======================================================
% 3. COMO RODAR (Queries)
% =======================================================

% Query: Alunos especialistas em comp E com deficiência em mat
% ?- especialista_comp(Aluno), deficiencia_mat(Aluno).
% Esperado: Aluno = pedro. (Ana falha pois tem matematica).

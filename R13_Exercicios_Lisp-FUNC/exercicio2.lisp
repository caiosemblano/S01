;; Exercício 2: Catálogo de Fauna

;; 1. Definição da Estrutura
(defstruct criatura
  nome
  ambiente
  periculosidade
  vida-media)

;; 2. Catálogo Inicial
(defparameter *catalogo*
  (list
   (make-criatura :nome "Peep" :ambiente "Safe Shallows" :periculosidade "Baixa" :vida-media 2)
   (make-criatura :nome "Reaper Leviathan" :ambiente "Dunes" :periculosidade "Alta" :vida-media 100)
   (make-criatura :nome "Ghost Leviathan" :ambiente "Deep" :periculosidade "Alta" :vida-media 200)
   (make-criatura :nome "Crab Squid" :ambiente "Deep" :periculosidade "Média" :vida-media 50)))

;; 3. HOF: Filtro de Perigo
(defun filtra-por-perigo (catalogo)
  (remove-if (lambda (c) (string-equal (criatura-periculosidade c) "Baixa"))
             catalogo))

;; 4. Mapeamento de Informações
(defun relatorio-profundidade (catalogo)
  (let ((criaturas-deep (remove-if-not (lambda (c) (string-equal (criatura-ambiente c) "Deep"))
                                       catalogo)))
    (mapcar (lambda (c)
              (format nil "~a: Vive em ~a" (criatura-nome c) (criatura-ambiente c)))
            criaturas-deep)))

;; Testes
(defun teste-exercicio2 ()
  (format t "--- Filtro de Perigo (Não Baixa) ---~%")
  (dolist (c (filtra-por-perigo *catalogo*))
    (format t "Nome: ~a, Perigo: ~a~%" (criatura-nome c) (criatura-periculosidade c)))
  
  (format t "~%--- Relatório Profundidade (Deep) ---~%")
  (dolist (s (relatorio-profundidade *catalogo*))
    (format t "~a~%" s)))

(teste-exercicio2)

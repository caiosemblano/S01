;; Exercício 1: Farmácia da Maomao

;; 1. Função Pura: calcula-dosagem
(defun calcula-dosagem (peso-kg idade-anos)
  (cond
    ((or (< idade-anos 5) (< peso-kg 20)) 10)
    ((and (>= idade-anos 5) (<= idade-anos 12) (>= peso-kg 20)) 25)
    (t 50)))

;; 2. Função Pura: ajusta-preco
(defun ajusta-preco (preco-base nome-da-erva)
  (cond
    ((string-equal nome-da-erva "Ginseng") (* preco-base 3.0))
    ((string-equal nome-da-erva "Lótus") (* preco-base 1.5))
    (t preco-base)))

;; 3. Teste: Preço final de uma dose de "Lótus" (base 10) para paciente 14 anos e 60kg
(defun teste-exercicio1 ()
  (let* ((nome-erva "Lótus")
         (preco-base 10)
         (idade 14)
         (peso 60)
         (dosagem (calcula-dosagem peso idade))
         (preco-ajustado (ajusta-preco preco-base nome-erva))
         ;; Assumindo que o preço final é o preço ajustado por dose? 
         ;; O enunciado diz "Calcule o preço final de uma dose".
         ;; Vou assumir que o preço calculado é por dose, então é só o preço ajustado.
         ;; Mas se o preço base for por ml, teria que multiplicar.
         ;; O enunciado diz "preço base 10 moedas" (não diz por ml).
         ;; E pede "preço final de uma dose".
         ;; Vou imprimir os resultados.
         )
    (format t "Paciente: ~d anos, ~d kg~%" idade peso)
    (format t "Erva: ~a, Preço Base: ~d~%" nome-erva preco-base)
    (format t "Dosagem Calculada: ~d ml~%" dosagem)
    (format t "Preço Ajustado (por dose): ~f~%" preco-ajustado)
    ))

(teste-exercicio1)

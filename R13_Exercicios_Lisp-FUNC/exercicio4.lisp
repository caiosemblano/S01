;; Exercício 4: Gerenciamento de Ocorrências

;; 1. Estrutura
(defstruct ocorrencia
  nome
  ritual
  nivel-medo
  agentes-enviados)

;; 2. Função Recursiva: soma-medo-recursiva
(defun soma-medo-recursiva (lista)
  (if (null lista)
      0
      (+ (ocorrencia-nivel-medo (car lista))
         (soma-medo-recursiva (cdr lista)))))

;; 3. Função de Alto Nível: analise-final
(defun analise-final (lista-ocorrencias)
  (let* ((total-medo (soma-medo-recursiva lista-ocorrencias))
         (quantidade (length lista-ocorrencias))
         (media-medo (if (> quantidade 0) (/ total-medo quantidade) 0))
         ;; b. Filtra Ocorrências Críticas
         (criticas (remove-if-not (lambda (o)
                                    (and (> (ocorrencia-agentes-enviados o) 3)
                                         (> (ocorrencia-nivel-medo o) media-medo)))
                                  lista-ocorrencias)))
    ;; c. Composição: Retorna apenas os nomes
    (mapcar #'ocorrencia-nome criticas)))

;; Teste Final
(defun teste-exercicio4 ()
  (let ((ocorrencias (list
                      (make-ocorrencia :nome "Invocação Sombria" :ritual "Necromancia" :nivel-medo 80 :agentes-enviados 5)
                      (make-ocorrencia :nome "Sussurros na Floresta" :ritual "Espiritual" :nivel-medo 30 :agentes-enviados 2)
                      (make-ocorrencia :nome "Poltergeist da Mansão" :ritual "Telecinese" :nivel-medo 60 :agentes-enviados 4)
                      (make-ocorrencia :nome "Culto do Abismo" :ritual "Dimensional" :nivel-medo 90 :agentes-enviados 6)
                      (make-ocorrencia :nome "Gato Preto" :ritual "Superstição" :nivel-medo 10 :agentes-enviados 1))))
    
    (format t "--- Análise de Ocorrências ---~%")
    (format t "Média de Medo: ~f~%" (/ (soma-medo-recursiva ocorrencias) (length ocorrencias)))
    (format t "Ocorrências Críticas (Agentes > 3 e Medo > Média):~%")
    (dolist (nome (analise-final ocorrencias))
      (format t "- ~a~%" nome))))

(teste-exercicio4)

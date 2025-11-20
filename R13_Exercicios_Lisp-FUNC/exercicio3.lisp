;; Exercício 3: A Loja de Iwai

;; 1. Estrutura e Catálogo
(defstruct item
  nome
  tipo
  preco
  forca-magica)

(defparameter *inventario*
  (list
   (make-item :nome "Espada Amaldiçoada" :tipo "Arma" :preco 1000 :forca-magica 90)
   (make-item :nome "Poção de Cura" :tipo "Pocao" :preco 50 :forca-magica 10)
   (make-item :nome "Machado de Guerra" :tipo "Arma" :preco 500 :forca-magica 70)
   (make-item :nome "Amuleto Antigo" :tipo "Artefato" :preco 2000 :forca-magica 150)))

;; 2. Funções de Transformação
(defun adiciona-imposto (preco)
  (* preco 1.15))

(defun bonus-maldicao (forca)
  (if (> forca 80)
      (* forca 1.5)
      forca))

;; 3. Processa Venda
(defun processa-venda (catalogo)
  (let* (;; a. Filtra: Mantém apenas os itens do tipo Arma
         (armas (remove-if-not (lambda (i) (string-equal (item-tipo i) "Arma"))
                               catalogo))
         ;; b. Transforma (1): Aumenta o preço (retorna nova lista de itens com preço atualizado)
         (armas-com-imposto (mapcar (lambda (i)
                                      (make-item :nome (item-nome i)
                                                 :tipo (item-tipo i)
                                                 :preco (adiciona-imposto (item-preco i))
                                                 :forca-magica (item-forca-magica i)))
                                    armas))
         ;; c. Transforma (2): Retorna nome e nova força mágica
         (resultado-final (mapcar (lambda (i)
                                    (list (item-nome i)
                                          (bonus-maldicao (item-forca-magica i))))
                                  armas-com-imposto)))
    resultado-final))

;; Testes
(defun teste-exercicio3 ()
  (format t "--- Processamento de Venda ---~%")
  (dolist (res (processa-venda *inventario*))
    (format t "Item: ~a, Nova Força: ~a~%" (first res) (second res))))

(teste-exercicio3)

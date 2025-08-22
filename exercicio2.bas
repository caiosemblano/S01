10 LET NUM = INT(RND(1) * 101)
20 PRINT "Tente adivinhar o numero entre 0 e 100"
30 INPUT "Digite seu palpite: "; PALPITE
40 IF PALPITE < NUM THEN PRINT "O numero correto eh MAIOR que "; PALPITE
50 IF PALPITE < NUM THEN GOTO 30
60 IF PALPITE > NUM THEN PRINT "O numero correto eh MENOR que "; PALPITE
70 IF PALPITE > NUM THEN GOTO 30
80 PRINT "Parabens! Voce acertou!"
90 END

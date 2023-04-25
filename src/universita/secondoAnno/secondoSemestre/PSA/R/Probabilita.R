library(stats)
# Madonna non so che canzone mettere
# Geometrica = geom, poisson = pois, binomiale = binom
# d = densità, p = ripartizione, q=quantile, r=generalizzazione
# Detto questo, iniziamo
# Calcolare la probabilità di ottenere 7, 8 oppure 9 il valore 6 lanciando 12 dadi contemporaneamente
# Comprendiamo che è una binomiale con N=12 e prob=1/6
# Dobbiamo trovare la densità con k=7, k=8, k=9
vals <- dbinom(x=c(7:9), size=12, prob=1/6)
val7 <- vals[1]
val8 <- vals[2]
val9 <- vals[3]
# Ora abbiamo calcolato la probabilità di 7, 8, 9
# Noi vogliamo però o 7, o 8 oppure 9, quindi la loro somma
res <- sum(vals)
# Lo stesso risultato lo si può anche ottenere usando la funzione di ripartizione
val9 <- pbinom(q=9, size=12, prob=1/6)
val6 <- pbinom(q=6, size=12, prob=1/6)
res <- dif(val9, val6)
# Disegniamo il grafico della funzione di ripartizione del lancio di X monete con teste
# La funzione è una binomiale con prob=1/2, size=3
# I possibili risultati sono: 0 successo -> 3 successi, quindi 4 possibilità
# A quanto pare la funzione di ripartizione con q = 0 fà 0.125, quindi q deve iniziare da -1 e finire a 3
funct <- pbinom(-1:3, size = 3, prob = 0.5)
# Ora disegniamo il grafico
plot(0, xlim = c(-1.2, 4.2), ylim = c(-0.04, 1.04), type = 'n', xlab = "Numero di successi", ylab = "Possibilità commulativa")
abline(h = c(0,1), lty = 2, col = "gray")
lines(stepfun(x=0:3, y=funct), verticals = FALSE)
# Non so che cosa sia questa "stepfun", però a quanto pare ci permette di are delle linee con i salti
# Ora invece calcoliamo la probabilità di ottenere X teste, aka densità
funct <- dbinom(0:4,4,prob=1/2)
plot(x=c(0:4), y=funct)
lines(x=c(0:4), y=funct, col="red")
text(x=c(0:4), y=funct, labels=funct, col="blue")
# Ora acciamo una poisson, ogni ora 5 auto in media arrivano
# Probabilità nessuna macchina arrivi
dpois(x=5, lambda=5)
# In 10 ore arrivino al massimo 30 clienti
ppois(q=30, lambda=5*10)
# In 10 ore arrivino al massimo 60 clienti
ppois(q=60, lambda=5*10)
# Ora che arrivino tra i 48 e 50 clienti in 10 ore
diff(ppois(c(47, 50), lambda=5*10))

# ?????????? Cioè mi hai spiegato tutto quanto, per poi dirmi che esiste un'altra classe che fa questo ma meglio?!?!?!?!?! Calmo ale calmo ale avrai capito male
library(distr)
#  Lancio di 3 monete
X <- Binom(size=3, prob=1/2)
# Densità
d(X)(1)
# Ripartizione con X=2
p(X)(2)
# Quantile
q(X)(0.7)
plot(X)
# Facciamo la poisson
X <- Pois(lambda=5)
plot(X)

# Quindi, tu mi hai spiegato una libreria per intero per poi dirci:"AH SI, NOI NON USEREMO QUESTA ma eccovi una migliore!"
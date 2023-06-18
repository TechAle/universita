# Importiamo le librerie che ci serviranno
library(datasets)
library(stats)
# Inizializziamo una variabile
x <- 0
# Creiamo un array con i primi 10 numeri ed il numero 20
x <- c(1:10, 20)
# Possiamo creare i **primi 10 numeri** anche così:
x <- seq(0, 10)
# Se li volessimo al contrario
x <- seq(10, 0)
# Se volessimo da 0 a 10 e solo i numeri pari (quindi salto di 2)
x <- seq(0, 10, 2)
# Ora aggiungiamoci 20
x <- c(seq(0, 10, 2), 20)
# Se lo volessimo duplicare 2 volte
x <- rep(x, 2)
# Accesso ad 1 elemento
x[1]
# Accesso ai primi 5 elementi
x[1:5]
# Prendiamo i numeri minori di 7 e maggiori di 9
v <- which(x < 7 | x > 9)
# Mostriamo il campo "abb" in console della variabile "states" che è importata dalla libreria "datasets"
str(state.abb)
# Mostriamo le prime 5 abbreviazioni
state.abb[1:5]
# Creiamo una matrice semplice con 2 righe e 5 colo
z <- matrix(c(1:10), nrow=2)
# Poi abbiamo gli array, che possiamo immaginare come aggregati di matrici
# ogni matrice è 1 tabella, ed abbiamo N tabelle nelle metrici
# Criamo un array che è composto dai numeri 1:24, ed ha 4 righe, 3 colonne e 2 tabelle
# Aka abbiamo 2 matrici composte da 4 righe e 3 colonne
z <- array(c(1:23), c(4,3,2))
# Abbiamo anche le liste, che diciamo mettiamo tutto ciò che vogliamo dentro
o1 <- c(1:3)
o2 <- c("a")
o3 <- c(T,F,T,T)
list1 <- list(o1, o2, o3)
list2 <- list(o1, o2, o3, list1) #Totale libertà
# So che la parte iniziale potrebbe sembrare pesante, e lo è, però la trovo necessaria.
# Il prof ci ha spiegato le funzioni senza spiegarci il core di R, le strutture.
# Peccato che noi dovremo lavorare con le strutture, e se non le sappiamo manipolare
# Come facciamo a lavorarci?
# Detto questo, spero di avervi motivati per l'ultima parte, i Factor
# I factor, praticamente noi trasformiamo stringhe -> Interi, facciamo un'associazione
data <- c("East","West","East","North","North","East","West","West","West","East","North")
f <- factor(data)
# In questo modo East = 1, West=2, North=3, South=4
# Nel caso volessimo North=1, West=2, South=3, East=4
f1 <- factor(data, levels=c("North", "West", "South", "East"))
# Ed infine abbiamo i dataframe, che possiamo immagine come dei dizionari
# Creiamo un dataframe
numeri <- c(1:3)
caratteri <- c("a", "b", "c")
logichee <- c(T, F, T) # T = True, F=False
df <- as.data.frame(cbind(numeri, caratteri, logichee))
# Punto estremamente importante, motivazione per cui mi sono fatto 1 ora di studio da autodidatta
# Quando abbiamo dei dataframe, per accedere ai dati dobbiamo usare $
# Aka usiamo $ quando dobbiamo accedere a delle liste dentro a delle strutture dati
# Usiamo il . in tutti gli altri i casi
df$numeri[0]
# Questo si applica anche quando abbiamo delle liste dentro a delle liste
list1 <- list(si=o1, no=o2, lol=o3)
list1$lol


# Creiamo una tabella con le divisioni, aka frequenze assolute
table <- table(state.division)
# Mostriamo le frequenze relative, per farlo dobbiamo prendere la somma e dividerlo per la tabella
print("Frequenze relative:")
print(table/sum(table))

# Mostriamo un grafico delle frequenze assolute delle regione
barplot(table(state.region))
# Ora vogliamo mostrare 3 grafici di "precip", per farlo prima di tutto dobbiamo dire ad R
# "Ehy, fammi stare 3 grafici in 1 riga
par(mfrow = c(1,3))
## Ed ora mostriamo i grafici in 3 modi diversi
# Overplot = I dati sono uno sopra l'altro
stripchart(precip, method = "overplot", xlab="overplot precip")
# Jitter = I dati sono sparpagliati nell'asse delle Y
stripchart(precip, method = "jitter", xlab="jitter precip")
# Stack = I dati sono uno sopra l'altro
stripchart(precip, method = "stack", xlab="stack precip")
# Ora invece mostriamo 2 istogrammi, uno con frequenze assolute, l'altro con relative
par(mfrow = c(1, 2))
hist(precip)
# Breaks aka dopo quanto dividiamo le nostre classi 
hist(precip, freq = FALSE, breaks=200)
# Diagramma a dispersione
par(mfrow = c(1,1))
plot(LakeHuron, type = "p")
# Boxplot
boxplot(rivers)
# e' possibile ottenere le informazioni specifiche sulle creazioni dei boxplot
# Es. il numero di valori non considerati (quelli fuori dal nostro 75%)
# per sapere tutto, help -> boxplot.stats
# Es. ciò che avevo detto prima
boxplot.stats(rivers)$n

## Indici di variabilità
# Quartili, li indichiamo dentro la c
quantile(rivers,c(0.25,0.5,0.75))
# Range interquartile
IQR(rivers)
# Range
range(rivers)
# Varianza
var(rivers)
# Deviazione standard
sd(rivers)
# Deviazione mediana assoluta
mad(rivers)

# Qualcuno mi può spiegare perchè il prof ha messo un file csv senza però spiegarci come leggerlo?
file <- read.csv("WCGSr.csv")
## Cosa mi dovrebbe rappresentare????!?!?!?!!?!?!!

# Qui if è come al solito lol
x <- 1
if (x == 1) {
  print("ciao")
} else 
  print("no")

# Ed il for è come quello python abbreviato, il range trattiamolo come l'array
for(i in c(seq(0, 10, 2),21, "a"))
     print(i) # Stampa i primi 5 numeri pari ed il numero 21 ed "a"

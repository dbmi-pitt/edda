setwd('/home/mitchellkj/rwork')
getwd()
rm(list = ls(all = TRUE))
ls()

Wingcrd <- c(59, 55, 53.5, 55.0, 52.5, 57.5, 53, 55)
Tarsus <- c(22.3, 19.7, 20.8, 20.3, 20.8, 21.5, 20.6, 21.5)
Head <- c(31.2, 30.4, 30.6, 30.3, 30.3, 30.8, 32.5, NA)
Wt <- c(9.5, 13.8, 14.8, 15.2, 15.5, 15.6, 15.6, 15.7)
BirdData <- c(Wingcrd, Tarsus, Head, Wt)
Id <- rep(c(1,2,3,4), each = 8)
Id <- rep(1:4, each = 8)
a <- seq(from = 1, to = 4, by = 1)
VarNames <- c("Wingcrd", "Tarsus", "Head", "Wt")
Id2 <- rep(VarNames, each = 8)
Z <- cbind(Wingcrd, Tarsus, Head, Wt)
Z
Z[,1]
Z[1:8, 1]
Z[2,]
Z[2, 1:4]
Z[, 2:3]
X <- Z[4,4]
Y <- Z[,4]
W <- Z[, -3]
D <- Z[, c(1,3,4)]
E <- Z[, c(-1, -3)]
dim(Z)
nrow <- dim(Z)[1]
Z2 <- rbind(Wingcrd, Tarsus, Head, Wt)
W <- vector(length = 8)
W[1] <- Wingcrd[1]
W[2] <- Wingcrd[2]
W[3] <- Wingcrd[3]
W[4] <- Wingcrd[4]
W[5] <- Wingcrd[5]
W[6] <- Wingcrd[6]
W[7] <- Wingcrd[7]
W[8] <- Wingcrd[8]
Dmat <- matrix(nrow = 8, ncol = 4)
Dmat[, 1] <- Wingcrd
Dmat[, 2] <- Tarsus
Dmat[, 3] <- Head
Dmat[, 4] <- Wt
colnames(Dmat) <- c("Wingcrd", "Tarsus", "Head", "Wt")
Dmat2 <- as.matrix(cbind(Wingcrd, Tarsus, Head, Wt))
is.matrix(Dmat)
is.matrix(Dmat2)
DmatTransposed <- t(Dmat)
MatrixProduct <- t(Dmat) %*% Dmat
Dfrm <- data.frame(WC = Wingcrd,
                   TS = Tarsus,
                   HD = Head,
                   W = Wt,
                   Wsq = sqrt(Wt))
rm(Wt)
Wt
Dfrm$W
x1 <- c(1,2,3)
x2 <- c("a","b","c","d")
x3 <- 3
x4 <- matrix(nrow = 2, ncol = 2)
x4[,1] <- c(1,2)
x4[,2] <- c(3,4)
Y <- list(x1 = x1, x2 = x2, x3 = x3, x4 = x4)
# Linear regression wing length as a function of weight
M <- lm(WC ~ W, data = Dfrm)
names(M)
Squid <- read.table(file = "/home/mitchellkj/rwork/RBook/squid.txt", header = TRUE)
setwd("/home/mitchellkj/rwork/RBook")
Squid <- read.table("squid.txt", header = TRUE)
names(Squid)
boxplot(GSI ~ factor(Location), data = Squid)
attach(Squid)
GSI
unique(Squid$Sex)
# Filtering out just Females
Sel <- Squid$Sex == 1
SquidM <- Squid[Sel,]
SquidM <- Squid[Squid$Sex == 1,]
SquidF <- Squid[Squid$Sex == 2,]
SquidM[1:5,]
SquidF[1:5,]
Squid123 <- Squid[Squid$Location == 1 | Squid$Location == 2 | Squid$Location == 3,]
Squid123 <- Squid[Squid$Location != 4,]
Squid123 <- Squid[Squid$Location < 4,]
Squid123 <- Squid[Squid$Location <= 3,]
Squid123 <- Squid[Squid$Location >= 1 & Squid$Location <= 3,]
MaleSquidsFromOne <- Squid[Squid$Sex == 1 & Squid$Location == 1,]
Ord1 <- order(Squid$Month)
SquidByMonth <- Squid[Ord1,]
Sq1 <- read.table(file = "squid1.txt", header = TRUE)
Sq2 <- read.table(file = "squid2.txt", header = TRUE)
SquidMerged <- merge(Sq1, Sq2, by = "Sample")
SquidMerged

SquidMerged <- merge(Sq1, Sq2, by = "Sample", all = TRUE)

SquidM <- Squid[Squid$Sex == 1,]
write.table(SquidM,
            file = "MaleSquid.txt",
            sep = " ", quote = FALSE, append = FALSE,
            na = "NA")

str(Squid)

Squid$fLocation <- factor(Squid$Location)
Squid$fSex <- factor(Squid$Sex)
Squid$fSex
Squid$fSex <- factor(Squid$Sex, levels = c(1,2),
                     labels = c("M", "F"))
Squid$fSex

boxplot(GSI ~ fSex, data = Squid)
M1 <- lm(GSI ~ fSex + fLocation, data = Squid)
summary(M1)
M2 <- lm(GSI ~ factor(Sex) + factor(Location), data = Squid)
summary(M2)

is.factor(Squid$fSex) # Returns true
is.factor(Squid$Sex)  # Returns false
is.factor(as.factor(Squid$Sex)) # Return true
is.factor(as.numeric(Squid$fSex)) # Return false

Squid$fLocation <- factor(Squid$Location, 
                          levels = c(2, 3, 1, 4))
Squid$fLocation
boxplot(GSI ~ fLocation, data = Squid)
SquidM <- Squid[Squid$fSex == "1",]

Squid$fSex <- factor(Squid$Sex, labels = c("M", "F"))
Squid$fLocation <- factor(Squid$Location)
str(Squid)


# biodiversity data study
setwd("/home/mitchellkj/rwork/RBook")
Veg <- read.table(file = "Vegetation2.txt",
                  header = TRUE)
names(Veg)
str(Veg)



m <- mean(Veg$R)
m1 <- mean(Veg$R[Veg$Transect == 1])
m2 <- mean(Veg$R[Veg$Transect == 2])
m3 <- mean(Veg$R[Veg$Transect == 3])
m4 <- mean(Veg$R[Veg$Transect == 4])
m5 <- mean(Veg$R[Veg$Transect == 5])
m6 <- mean(Veg$R[Veg$Transect == 6])
m7 <- mean(Veg$R[Veg$Transect == 7])
m8 <- mean(Veg$R[Veg$Transect == 8])
c(m, m1, m2, m3, m4, m5, m6, m7, m8)

tapply(Veg$R, Veg$Transect, mean)
tapply(X = Veg$, INDEX = Veg$Transact, FUN = mean)
Me <- tapply(Veg$R, Veg$Transect, mean)
Sd <- tapply(Veg$R, Veg$Transect, sd)
Le <- tapply(Veg$R, Veg$Transect, length)
cbind(Me, Sd, Le)

sapply(Veg[,5:9], FUN=mean)
lapply(Veg[,5:9], FUN=mean)

sapply(cbind(Veg$R, Veg$ROCK, Veg$LITTER, Veg$ML,
              Veg$BARESOIL), FUN = mean)

sapply(data.frame(cbind(Veg$R, Veg$ROCK, Veg$LITTER, Veg$ML,
              Veg$BARESOIL)), FUN = mean)



 m0 <- matrix(NA, 4, 0)
     rownames(m0)
     
     m2 <- cbind(1,1:4)
     colnames(m2, do.NULL = FALSE)
     colnames(m2) <- c("x","Y")
     rownames(m2) <- rownames(m2, do.NULL = FALSE, prefix = "Obs.")
     m2

Z <- cbind(Veg$R, Veg$ROCK, Veg$LITTER)
colnames(Z) <- c("R", "ROCK", "LITTER")
summary(Z)

summary(Veg[, c("R", "ROCK", "LITTER")])



Deer <- read.table(file="Deer.txt", header=TRUE)
names(Deer)
str(Deer)
table(Deer$Farm)
table(Deer$Sex, Deer$Year)

# Chapter 4





 





# ? Access help files
# # comment
# boxplot makes a boxplot
# log natural log
# log10 log base 10
# library loads a package
# setwd sets the working directory
# q() quits R
# citation generates the R citation


 ## boxplot on a formula:
     boxplot(count ~ spray, data = InsectSprays, col = "lightgray")
     # *add* notches (somewhat funny here):
     boxplot(count ~ spray, data = InsectSprays,
             notch = TRUE, add = TRUE, col = "blue")
     
     boxplot(decrease ~ treatment, data = OrchardSprays,
             log = "y", col = "bisque")
     
     rb <- boxplot(decrease ~ treatment, data = OrchardSprays, col="bisque")
     title("Comparing boxplot()s and non-robust mean +/- SD")
     
     mn.t <- tapply(OrchardSprays$decrease, OrchardSprays$treatment, mean)
     sd.t <- tapply(OrchardSprays$decrease, OrchardSprays$treatment, sd)

plot(x = Veg$BARESOIL, y = Veg$R, xlab = "Exposed soil", 
     ylab = "Species richness",
     main = "Scatter plot",
     xlim = c(0, 45), ylim = c(4, 19),
     pch = 16, cex = 1.5)

Veg$Cex2 <- Veg$Time
Veg$Cex2[Veg$Time == 2002] <- 2
Veg$Cex2[Veg$Time != 2002] <- 1
plot(x = Veg$BARESOIL, y = Veg$R, xlab = "Exposed soil", 
     ylab = "Species richness",
     main = "Scatter plot",
     xlim = c(0, 45), ylim = c(4, 19),
     pch = 16, cex = Veg$Cex2)

plot(x = Veg$BARESOIL, y = Veg$R, xlab = "Exposed soil", 
     ylab = "Species richness",
     main = "Scatter plot",
     xlim = c(0, 45), ylim = c(4, 19))
M.Loess <- loess(R ~ BARESOIL, data = Veg)
Fit <- fitted(M.Loess)
lines(Veg$BARESOIL, Fit)

plot(x = Veg$BARESOIL, y = Veg$R, xlab = "Exposed soil", 
     ylab = "Species richness",
     main = "Scatter plot",
     xlim = c(0, 45), ylim = c(4, 19))
M.Loess <- loess(R ~ BARESOIL, data = Veg)
Fit <- fitted(M.Loess)
Ord1 <- order(Veg$BARESOIL)
lines(Veg$BARESOIL[Ord1], Fit[Ord1], lwd = 3, lty = 2)

#
# For i is from 1 to 1000:
#   Extract dataset i
#   Choose appropriete labels for the graph dataset i
#   Make a graph for dataset i
#   Save the graph for dataset i
# End of loop
#

lines(Veg$BARESOIL, Fit)


setwd("/home/mitchellkj/rwork/RBook")
Owls <- read.table(file = "Owls.txt", header = TRUE)
names(Owls)
str(Owls)

unique(Owls$Nest)
Owls.ATV <- Owls[Owls$Nest=="AutavauxTV",]
plot(x = Owls.ATV$ArrivalTime,
     y = Owls.ATV$NegPerChick,
     main = "AutavauxTV",
     xlab = "Arrival Time",
     ylab = "Negotiation behaviour")

Owls.Bot <- Owls[Owls$Nest=="Bochet",]
plot(x = Owls.Bot$ArrivalTime,
     y = Owls.Bot$NegPerChick,
     main = "Bochet",
     xlab = "Arrival Time",
     ylab = "Negotiation behaviour")

Owls.i <- Owls[Owls$Nest == "Bochet",]
plot(x = Owls.i$ArrivalTime,
     y = Owls.i$NegPerChick,
     main = "Bochet",
     xlab = "Arrival Time",
     ylab = "Negotiation behaviour")


x <- seq(1:100)
y <- seq(1:100)
plot(x,y)
lines(x,y)
points(x,y)


setwd("/home/mitchellkj/rwork/AllGraphs")
Nest.i <- "Bochet"
Owls.i <- Owls[Owls$Nest == Nest.i,]
outputFileName <- paste(Nest.i, ".jpg", sep="")
jpeg(file = outputFileName)
plot(x = Owls.i$ArrivalTime,
     y = Owls.i$NegPerChick,
     main = Nest.i,
     xlab = "Arrival Time",
     ylab = "Negotiation behaviour")
dev.off()

setwd("/home/mitchellkj/rwork/AllGraphs")
AllNests <- unique(Owls$Nest)
for (i in 1:27) {
  Nest.i <- AllNests[i]
  Owls.i <- Owls[Owls$Nest == Nest.i,]
  outputFileName <- paste(Nest.i, ".jpg", sep="")
  jpeg(file = outputFileName)
  plot(x = Owls.i$ArrivalTime,
       y = Owls.i$NegPerChick,
       main = Nest.i,
       xlab = "Arrival Time",
       ylab = "Negotiation behaviour")
  dev.off()
}

setwd("/home/mitchellkj/rwork/RBook")
Veg <- read.table(file = "Vegetation2.txt", header = TRUE)
names(Veg)
NAPerVariable(Veg[,5:24])

Parasite <- read.table(file = "CodParasite.txt",
                       header = TRUE)
names(Parasite)
NAPerVariable(Parasite)
ZerosPerVariable(Parasite)
VariableInfo(Parasite, "abracadabra")
VariableInfoElseIf(Parasite, "Zeros")
VariableInfoElseIf(Parasite)
VariableInfoElseIf(Parasite, "NAs")
VariableInfoElseIf(Parasite, "junk")

Benthic <- read.table("/home/mitchellkj/rwork/RBook/RIKZ.txt",
                      header = TRUE)
Species <- Benthic[, 2:76]
n <- dim(Species)
sum(Species[1,], na.rm = TRUE)
sum(Species[2,], na.rm = TRUE)
TA <- vector(length = n[1])
for (i in 1:n[1]) {
  TA[i] <- sum(Species[i,], na.rm = TRUE)
}
TA <- rowSums(Species, na.rm = TRUE)
sum(Species[1,] > 0, na.rm = TRUE)
sum(Species[2,] > 0, na.rm = TRUE)
Richness <- vector(length = n[1])
for (i in 1:n[1]) {
  Richness[i] <- sum(Species[i,] > 0, na.rm = TRUE)
}
Richness <- rowSums(Species > 0, na.rm = TRUE)

RS <- rowSums(Species, na.rm = TRUE)
prop <- Species / RS
H <- -rowSums(prop * log10(prop), na.rm = TRUE)
H <- diversity(Species)

DiversityCalculator(Species, "Shannon")

setwd("/home/mitchellkj/rwork/RBook")
BFCases <- read.table(file = "BirdFluCases.txt", header = TRUE)
names(BFCases)
str(BFCases)
Cases <- rowSums(BFCases[, 2:16])
names(Cases) <- BFCases[, 1]
Cases

par(mfrow = c(2, 2), mar = c(3, 3, 2, 1))
pie(Cases, main = "Ordinary pie chart")
pie(Cases, col = gray(seq(0.4, 1.0, length = 6)))
pie(Cases, col = gray(seq(0.4, 1.0, length = 6)),
    clockwise = TRUE, main = "Grey colours")
library(plotrix)
pie3D(Cases, labels = names(Cases), explode = 0.1,
      main = "3D pie chart", labelcex = 0.6)

setwd("C:/Users/kjm84/Desktop/rwork/RBook")
BFDeaths <- read.table(file = "BirdFluDeaths.txt", header = TRUE)
Deaths <- rowSums(BFDeaths[, 2:16])
names(Deaths) <- BFDeaths[, 1]
Deaths

par(mfrow = c(2,2), mar = c(3, 3, 2, 1))
barplot(Cases, main = "Bird flu cases")
Counts <- cbind(Cases, Deaths)
barplot(Counts)
barplot(t(Counts), col = gray(c(0.5, 1)))
barplot(t(Counts), beside = TRUE)

setwd("/home/mitchellkj/rwork/RBook")
Benthic <- read.table(file = "RIKZ2.txt", header = TRUE)
Bent.M <- tapply(Benthic$Richness,
                 INDEX = Benthic$Beach, FUN = mean)
Bent.sd <- tapply(Benthic$Richness,
                  INDEX = Benthic$Beach,
                  FUN = sd)
barplot(Bent.M)
barplot(Bent.M, xlab = "Beach", ylim = c(0,20),
        ylab = "Richness", col = rainbow(9))
bp <- barplot(Bent.M, xlab = "Beach", ylim = c(0,20),
        ylab = "Richness", col = rainbow(9))
arrows(bp, Bent.M, bp, Bent.M + Bent.sd, lwd = 1.5,
       angle = 90, length = 0.1)
box()
bp
Bent.le <- tapply(Benthic$Richness, INDEX = Benthic$Beach, FUN = length)
Bent.se <- Bent.sd / sqrt(Bent.le)

stripchart(Benthic$Richness ~ Benthic$Beach,
           vert = TRUE, pch = 1, method = "jitter",
           jit = 0.05, xlab = "Beach", ylab = "Richness")
points(1:9, Bent.M, pch = 16, cex = 1.5)
arrows(1:9, Bent.M, 1:9, Bent.M + Bent.se, lwd = 1.5,
       angle = 90, length = 0.1)
arrows(1:9, Bent.M, 1:9, Bent.M - Bent.se, lwd = 1.5,
       angle = 90, length = 0.1)
box()
op <- par(mfrow = c(1, 1), mar = c(3, 3, 2, 1))

Owls <- read.table(file = "Owls.txt", header = TRUE)
boxplot(Owls$NegPerChick)
boxplot(NegPerChick ~ SexParent, data = Owls)
boxplot(NegPerChick ~ FoodTreatment, data = Owls)
boxplot(NegPerChick ~ SexParent * FoodTreatment, data = Owls)
boxplot(NegPerChick ~ SexParent * FoodTreatment,
        names = c("F/Dep", "M/Dep", "F/Sat", "M/Sat"), data = Owls)
boxplot(NegPerChick ~ Nest, data = Owls)

par(mar = c(2, 2, 3, 3))
boxplot(NegPerChick ~ Nest, data = Owls,
        axes = FALSE, ylim = c(-3, 8.5))
axis(2, at = c(0,  2, 4, 6, 8))
text(x = 1:27,
     y = -2, 
     labels = levels(Owls$Nest),
     cex = 0.75,
     srt = 65)

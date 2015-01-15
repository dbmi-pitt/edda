
EsA_Data = t(EsA_Data)


# ExampleSetA2 <- read.csv(file = "A.csv", sep=",", row.names = 1)
# ExampleSetA2 <- as.matrix(ExampleSetA2)
# y = matrix(1:21, ncol=7) 
# mean(y[2,2:3]) 
ExampleSetA[1,][27961:27964]

# metadata_path
# label
# metadata_file
# metadata_date
# id

## Example of setting row and column names
mdat <- matrix(c(1,2,3, 11,12,13), nrow = 2, ncol = 3, byrow = TRUE,
               dimnames = list(c("row1", "row2"),
                               c("C.1", "C.2", "C.3")))
mdat

EsA_NumberOfDocs = nrow(ExampleSetA)
EsA_NumberOfFtrs = ncol(ExampleSetA)
EsA_NumberOfMetaFtrs = 5
EsA_NumberOfRegularFtrs = EsA_NumberOfFtrs - EsA_NumberOfMetaFtrs

EsA_FileNames = as.vector(ExampleSetA$metadata_file);
EsA_FtrNames = colnames(ExampleSetA)[1:EsA_NumberOfRegularFtrs]
ExampleSetA$X.bb._interactions_characterization

EsA_Data = as.matrix(ExampleSetA[1:EsA_NumberOfDocs,1:EsA_NumberOfRegularFtrs],
                     nrow = EsA_NumberOfDocs, 
                     ncol = EsA_NumberOfRegularFtrs,
                     byrow = TRUE)
colnames(EsA_Data) <- EsA_FtrNames;
rownames(EsA_Data) <- EsA_FileNames;

EsA_Data = t(EsA_Data)

merge(x = df1, y = df2, by = "CustomerId", all = TRUE)

Left outer: merge(x = df1, y = df2, by = "CustomerId", all.x=TRUE)

Right outer: merge(x = df1, y = df2, by = "CustomerId", all.y=TRUE)

Cross join: merge(x = df1, y = df2, by = NULL)

alltime <-rbind(alltime,all2008)

esaFtrNum = ncol(esA)
esb2aFtrNum = ncol(esb2a)

esaRegFtrNum = esaFtrNum - metaFtrNum
esb2aRegFtrNum = esb2aFtrNum - metaFtrNum


esaFileNames = as.vector(esA$metadata_file)
esaFtrNames = colnames(esA)[1:esaRegFtrNum]
esaData = as.matrix(esA[1:esaDocNum,1:esaRegFtrNum],
                    nrow = esaDocNum, 
                    ncol = esaRegFtrNum,
                    byrow = TRUE)
rownames(esaData) <- esaFileNames;
colnames(esaData) <- esaFtrNames;

esb2aFileNames = as.vector(esb2a$metadata_file)
esb2aFtrNames = colnames(esb2a)[1:esb2aRegFtrNum]
esb2aData = as.matrix(esb2a[1:esb2aDocNum,1:esb2aRegFtrNum],
                      nrow = esb2aDocNum, 
                      ncol = esb2aRegFtrNum,
                      byrow = TRUE)
rownames(esb2aData) <- esb2aFileNames;
colnames(esb2aData) <- esb2aFtrNames;

#
# This fails with 
#
# Error in 1:nrow(m) : argument of length 0
results = ConsensusClusterPlus(esData,
                               maxK=3,
                               reps=50,
                               pItem=0.8,
                               pFeature=1,
                               title=myTitle,
                               clusterAlg="hc",
                               distance="pearson",
                               seed=1262118388.71279,
                               plot="pngBMP")

# to just train and test includes
esr <- es[((es$deck == 'train') | (es$label == 'include')),]

metaFtrNum = 6
docNum = nrow(esr)
ftrNum = ncol(esr)
regFtrNum = ftrNum - metaFtrNum
fileNames = as.vector(esr$metadata_file)
ftrNames = colnames(esr)[1:regFtrNum]
esData = as.matrix(esr[1:docNum,1:regFtrNum],
                   nrow = docNum, 
                   ncol = regFtrNum,
                   byrow = TRUE)
rownames(esData) <- fileNames
colnames(esData) <- ftrNames
esData = t(esData)

mads=apply(esData,1,mad)
esData=esData[rev(order(mads))[1:1500],]
esData = sweep(esData, 1, apply(esData,1,median,na.rm=T))

myTitle="T:\\EDDA\\WORKSPACE\\KEVIN\\clustering\\data\\galacto\\output2"
results = ConsensusClusterPlus(esData,
                               maxK=6,
                               reps=50,
                               pItem=0.8,
                               pFeature=1,
                               title=myTitle,
                               clusterAlg="hc",
                               distance="pearson",
                               seed=1262118388.71279,
                               plot="png")
icl = calcICL(results,title=myTitle,plot="png")
icl[["clusterConsensus"]]
icl[["itemConsensus"]][1:5,]
esr$cluster <- as.vector(results[[2]]$consensusClass)
#
# Determine # of train includes in cluster 1
#           # of train includes in cluster 2
trainIncludeClusterOne <- nrow(esr[(esr$deck == 'train') &
                                     (esr$label == 'include') & 
                                     (esr$cluster == 1),])
trainIncludeClusterTwo <- nrow(esr[(esr$deck == 'train') &
                                     (esr$label == 'include') & 
                                     (esr$cluster == 2),])
trainIncludeClusterOne
trainIncludeClusterTwo
estimatedIncludeCluster <- 2

# 
# True positives are number of test includes 
# in cluster 2
# 
TPs <-  nrow(esr[(esr$deck == 'test') &
                   (esr$label == 'include') & 
                   (esr$cluster == 2),])
FPs <-  nrow(esr[(esr$deck == 'test') &
                   (esr$label == 'include') & 
                   (esr$cluster == 1),])

esr$cluster <- NULL

#
# Train and test excludes
#
esr <- es[((es$deck == 'train') | (es$label == 'exclude')),]

metaFtrNum = 6
docNum = nrow(esr)
ftrNum = ncol(esr)
regFtrNum = ftrNum - metaFtrNum
fileNames = as.vector(esr$metadata_file)
ftrNames = colnames(esr)[1:regFtrNum]
esData = as.matrix(esr[1:docNum,1:regFtrNum],
                   nrow = docNum, 
                   ncol = regFtrNum,
                   byrow = TRUE)
rownames(esData) <- fileNames
colnames(esData) <- ftrNames
esData = t(esData)

mads=apply(esData,1,mad)
esData=esData[rev(order(mads))[1:1500],]
esData = sweep(esData, 1, apply(esData,1,median,na.rm=T))

myTitle="T:\\EDDA\\WORKSPACE\\KEVIN\\clustering\\data\\galacto\\output2"
results = ConsensusClusterPlus(esData,
                               maxK=2,
                               reps=25,
                               pItem=0.8,
                               pFeature=1,
                               title=myTitle,
                               clusterAlg="hc",
                               distance="pearson",
                               seed=1262118388.71279,
                               plot="pngBMP")
icl = calcICL(results,title=myTitle,plot="png")
icl[["clusterConsensus"]]
icl[["itemConsensus"]][1:5,]
esr$cluster <- as.vector(results[[2]]$consensusClass)
#
# Determine # of train excludes in cluster 1
#           # of train excludes in cluster 2
trainExcludeClusterOne <- nrow(esr[(esr$deck == 'train') &
                                     (esr$label == 'exclude') & 
                                     (esr$cluster == 1),])
trainExcludeClusterTwo <- nrow(esr[(esr$deck == 'train') &
                                     (esr$label == 'exclude') & 
                                     (esr$cluster == 2),])
trainExcludeClusterOne
trainExcludeClusterTwo
estimatedExcludeCluster <- 1

# 
# True positives are number of test excludes 
# in cluster 2
# 
FNs <-  nrow(esr[(esr$deck == 'test') &
                   (esr$label == 'exclude') & 
                   (esr$cluster == 2),])
TNs <-  nrow(esr[(esr$deck == 'test') &
                   (esr$label == 'exclude') & 
                   (esr$cluster == 1),])

esr$cluster <- NULL

setwd('t:/EDDA/WORKSPACE/KEVIN/clustering/data/galacto/csv')
getwd()

library(ConsensusClusterPlus)

esA <- read.table(file = "A.csv", header = TRUE, sep=",")
esb2a <- read.table(file = "B_by_A.csv", header = TRUE, sep=",")
esaDocNum = nrow(esA)
esb2aDocNum = nrow(esb2a)
esA$deck = rep("train", esaDocNum)
esb2a$deck = rep("test", esb2aDocNum)
es = rbind(esA, esb2a)
esr <- es

metaFtrNum = 6
docNum = nrow(esr)
ftrNum = ncol(esr)
regFtrNum = ftrNum - metaFtrNum
fileNames = as.vector(esr$metadata_file)
ftrNames = colnames(esr)[1:regFtrNum]
esData = as.matrix(esr[1:docNum,1:regFtrNum],
                   nrow = docNum, 
                   ncol = regFtrNum,
                   byrow = TRUE)
rownames(esData) <- fileNames
colnames(esData) <- ftrNames
esData = t(esData)

mads=apply(esData,1,mad)
esData=esData[rev(order(mads))[1:1500],]
esData = sweep(esData, 1, apply(esData,1,median,na.rm=T))

maxK_input <- 10
myTitle="T:\\EDDA\\WORKSPACE\\KEVIN\\clustering\\data\\galacto\\output2"
results = ConsensusClusterPlus(esData,
                               maxK=maxK_input,
                               reps=50,
                               pItem=0.8,
                               pFeature=1,
                               title=myTitle,
                               clusterAlg="hc",
                               distance="pearson",
                               seed=1262118388.71279,
                               plot="pngBMP")

analysis <- analyzeK(2,results,esr)
for(i in 3:maxK_input) {
  analysis <- cbind(analysis,analyzeK(i,results,esr))
}
colnames(analysis) <- as.character(2:(ncol(analysis)+1))
analysis

results = ConsensusClusterPlus(esData,
                               maxK=maxK_input,
                               reps=25,
                               pItem=1,
                               pFeature=1,
                               title=myTitle,
                               clusterAlg="hc",
                               distance="pearson",
                               plot="pngBMP")


myTitle="T:\\EDDA\\WORKSPACE\\KEVIN\\clustering\\data\\galacto\\output2"

esA <- read.table(file = "A.csv", header = TRUE, sep=",")
esb2a <- read.table(file = "B_by_A.csv", header = TRUE, sep=",")
esaDocNum = nrow(esA)
esb2aDocNum = nrow(esb2a)
esA$deck = rep("train", esaDocNum)
esb2a$deck = rep("test", esb2aDocNum)
es = rbind(esA, esb2a)
esr <- es

metaFtrNum = 6
docNum = nrow(esr)
ftrNum = ncol(esr)
regFtrNum = ftrNum - metaFtrNum
fileNames = as.vector(esr$metadata_file)
ftrNames = colnames(esr)[1:regFtrNum]
esData = as.matrix(esr[1:docNum,1:regFtrNum],
                   nrow = docNum, 
                   ncol = regFtrNum,
                   byrow = TRUE)
rownames(esData) <- fileNames
colnames(esData) <- ftrNames
esData = t(esData)
#esData <- filterBestMedianAbsoluteDeviation(esData)

maxK_input <- 6

results = ConsensusClusterPlus(esData,
                               maxK=maxK_input,
                               reps=2,
                               pItem=1,
                               pFeature=1,
                               title=myTitle,
                               clusterAlg="kmdist",
                               distance="pearson",
                               plot="pngBMP")

analysis <- analyzeCC(results,esr)
analysis

include <- function(file, env) {
  # ensure file and env are provided
  if(missing(file) || missing(env))
    stop("'file' and 'env' must be provided")
  # ensure env is character
  if(!is.character(file) || !is.character(env))
    stop("'file' and 'env' must be a character")
  
  # see if env is attached to the search path
  if(env %in% search()) {
    ENV <- get(env)
    files <- get(".files",ENV)
    # if the file hasn't been loaded
    if(!(file %in% files)) {
      sys.source(file, ENV)                        # load the file
      assign(".files", c(file, files), envir=ENV)  # set the flag
    }
  } else {
    ENV <- attach(NULL, name=env)      # create/attach new environment
    sys.source(file, ENV)              # load the file
    assign(".files", file, envir=ENV)  # set the flag
  }
}

warning("overriding source with my own function FYI")
source <- function(path, .force=FALSE, ...) {
  library(tools)
  path <- tryCatch(normalizePath(path), error=function(e) path)
  m<-md5sum(path)
  
  go<-TRUE
  if (!is.vector(.GlobalEnv$sourced)) {
    .GlobalEnv$sourced <- list()
  }
  if(! is.null(.GlobalEnv$sourced[[path]])) {
    if(m == .GlobalEnv$sourced[[path]]) {
      message(sprintf("Not re-sourcing %s. Override with:\n  source('%s', .force=TRUE)", path, path))
      go<-FALSE
    }
    else {
      message(sprintf('re-sourcing %s as it has changed from: %s to: %s', path, .GlobalEnv$sourced[[path]], m))
      go<-TRUE
    }
  } 
  if(.force) {
    go<-TRUE
    message("  ...forcing.")
  }
  if(go) {
    message(sprintf("sourcing %s", path))
    .GlobalEnv$sourced[path] <- m
    base::source(path, ...)
  }
}

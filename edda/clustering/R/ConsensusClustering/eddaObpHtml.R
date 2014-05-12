# outputHtml
#
# Analyze each K = number of clustersc
#
outputHtml <- function(ccResults, webContext, webContextImgOutput) {
  Sys.sleep(60)
  maxK <- length(ccResults)
  navBox <- newTextBlock("<ul id='navBox'>")
  for(i in 2:maxK) {
    navBox <- appendText(navBox,buildAnalysisListItem(i))
    clusterBox <- newTextBlock("<div>")
    clusterBox <- appendText(clusterBox,buildAnalysisHeader(i))
    clusterAssignments <- as.vector(ccResults[[i]]$consensusClass)
    for(j in 1:i) {
      clusterWords <- sort(colnames(esData500)[clusterAssignments == j])
      clusterBox <- appendText(clusterBox, buildClusterHeader(j))
      clusterBox <- appendText(clusterBox,"<p>")
      wordsAdded <- 0
      for (word in clusterWords) {
        clusterBox <- appendText(clusterBox, word)
        clusterBox <- appendText(clusterBox, "&nbsp;")
        wordsAdded <- wordsAdded + 1
        if (wordsAdded == 10) {
          clusterBox <- appendText(clusterBox, "<br/>")
          wordsAdded <- 0
        }
      }
      clusterBox <- appendText(clusterBox,"</p>")
    }
    clusterBox <- appendText(clusterBox, "</div>")
    xHtmlDoc <- newTextBlock(createXhtmlPrefix())
    xHtmlDoc <- appendText(xHtmlDoc, clusterBox)
    xHtmlDoc <- appendText(xHtmlDoc, createXhtmlSuffix())
    writeTextBlockToFile(buildAnalysisFileName(webContext,i),xHtmlDoc)
  }
  navBox <- appendText(navBox,"</ul>")
  xHtmlDoc <- newTextBlock(createXhtmlPrefix())
  xHtmlDoc <- appendText(xHtmlDoc, navBox)
  xHtmlDoc <- appendText(xHtmlDoc, buildImageLinks(webContextImgOutput))
  xHtmlDoc <- appendText(xHtmlDoc, createXhtmlSuffix())
  navigationHtmlFileName <- paste(webContext,"obp2.html",sep="/")
  writeTextBlockToFile(navigationHtmlFileName,xHtmlDoc)
}


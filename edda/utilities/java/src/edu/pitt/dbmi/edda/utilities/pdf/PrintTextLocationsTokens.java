package edu.pitt.dbmi.edda.utilities.pdf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.examples.util.PrintTextLocations;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.text.TextPosition;


public class PrintTextLocationsTokens extends PrintTextLocations {

    private List bufferTokens;

    public PrintTextLocationsTokens() throws IOException {
        bufferTokens = new ArrayList();
        super.setSortByPosition(true);
    }
    
    protected void processTextPosition(TextPosition text) {
        String cachar = text.getCharacter();
        PDFont dFont = text.getFont();
        float h = text.getHeight();
        float w = text.getWidth();
        float sizeFont = text.getFontSize();
        float widthOfSpace = text.getWidthOfSpace();
        float wordSpacing = text.getWordSpacing();
        float x = text.getX();
        float y = text.getY();
        float xScale = text.getXScale();
        float yScale = text.getYScale();
        Token token=new Token(cachar, dFont, h, w, sizeFont, widthOfSpace, wordSpacing, x, y, xScale, yScale);
        bufferTokens.add(token);
    }

    public List getBufferTokens() {
        return bufferTokens;
    }
}

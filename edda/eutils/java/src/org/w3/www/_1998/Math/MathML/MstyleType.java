/**
 * MstyleType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.w3.www._1998.Math.MathML;

public class MstyleType  implements java.io.Serializable {
    private java.math.BigInteger scriptlevel;  // attribute

    private boolean displaystyle;  // attribute

    private java.math.BigDecimal scriptsizemultiplier;  // attribute

    private java.lang.String scriptminsize;  // attribute

    private java.lang.String color;  // attribute

    private java.lang.String background;  // attribute

    private java.lang.String veryverythinmathspace;  // attribute

    private java.lang.String verythinmathspace;  // attribute

    private java.lang.String thinmathspace;  // attribute

    private java.lang.String mediummathspace;  // attribute

    private java.lang.String thickmathspace;  // attribute

    private java.lang.String verythickmathspace;  // attribute

    private java.lang.String veryverythickmathspace;  // attribute

    private org.w3.www._1998.Math.MathML.Linethickness linethickness;  // attribute

    private org.w3.www._1998.Math.MathML.Form form;  // attribute

    private org.w3.www._1998.Math.MathML.Lspace lspace;  // attribute

    private org.w3.www._1998.Math.MathML.Rspace rspace;  // attribute

    private boolean fence;  // attribute

    private boolean separator;  // attribute

    private boolean stretchy;  // attribute

    private boolean symmetric;  // attribute

    private boolean movablelimits;  // attribute

    private boolean accent;  // attribute

    private boolean largeop;  // attribute

    private org.w3.www._1998.Math.MathML.Minsize minsize;  // attribute

    private org.w3.www._1998.Math.MathML.Maxsize maxsize;  // attribute

    private org.w3.www._1998.Math.MathML.Mathvariant mathvariant;  // attribute

    private org.w3.www._1998.Math.MathML.Mathsize mathsize;  // attribute

    private java.lang.String mathcolor;  // attribute

    private java.lang.String mathbackground;  // attribute

    private org.apache.axis.types.NMTokens _class;  // attribute

    private java.lang.String style;  // attribute

    private org.apache.axis.types.IDRef xref;  // attribute

    private org.apache.axis.types.Id id;  // attribute

    private java.lang.Object href;  // attribute

    public MstyleType() {
    }

    public MstyleType(
           java.math.BigInteger scriptlevel,
           boolean displaystyle,
           java.math.BigDecimal scriptsizemultiplier,
           java.lang.String scriptminsize,
           java.lang.String color,
           java.lang.String background,
           java.lang.String veryverythinmathspace,
           java.lang.String verythinmathspace,
           java.lang.String thinmathspace,
           java.lang.String mediummathspace,
           java.lang.String thickmathspace,
           java.lang.String verythickmathspace,
           java.lang.String veryverythickmathspace,
           org.w3.www._1998.Math.MathML.Linethickness linethickness,
           org.w3.www._1998.Math.MathML.Form form,
           org.w3.www._1998.Math.MathML.Lspace lspace,
           org.w3.www._1998.Math.MathML.Rspace rspace,
           boolean fence,
           boolean separator,
           boolean stretchy,
           boolean symmetric,
           boolean movablelimits,
           boolean accent,
           boolean largeop,
           org.w3.www._1998.Math.MathML.Minsize minsize,
           org.w3.www._1998.Math.MathML.Maxsize maxsize,
           org.w3.www._1998.Math.MathML.Mathvariant mathvariant,
           org.w3.www._1998.Math.MathML.Mathsize mathsize,
           java.lang.String mathcolor,
           java.lang.String mathbackground,
           org.apache.axis.types.NMTokens _class,
           java.lang.String style,
           org.apache.axis.types.IDRef xref,
           org.apache.axis.types.Id id,
           java.lang.Object href) {
           this.scriptlevel = scriptlevel;
           this.displaystyle = displaystyle;
           this.scriptsizemultiplier = scriptsizemultiplier;
           this.scriptminsize = scriptminsize;
           this.color = color;
           this.background = background;
           this.veryverythinmathspace = veryverythinmathspace;
           this.verythinmathspace = verythinmathspace;
           this.thinmathspace = thinmathspace;
           this.mediummathspace = mediummathspace;
           this.thickmathspace = thickmathspace;
           this.verythickmathspace = verythickmathspace;
           this.veryverythickmathspace = veryverythickmathspace;
           this.linethickness = linethickness;
           this.form = form;
           this.lspace = lspace;
           this.rspace = rspace;
           this.fence = fence;
           this.separator = separator;
           this.stretchy = stretchy;
           this.symmetric = symmetric;
           this.movablelimits = movablelimits;
           this.accent = accent;
           this.largeop = largeop;
           this.minsize = minsize;
           this.maxsize = maxsize;
           this.mathvariant = mathvariant;
           this.mathsize = mathsize;
           this.mathcolor = mathcolor;
           this.mathbackground = mathbackground;
           this._class = _class;
           this.style = style;
           this.xref = xref;
           this.id = id;
           this.href = href;
    }


    /**
     * Gets the scriptlevel value for this MstyleType.
     * 
     * @return scriptlevel
     */
    public java.math.BigInteger getScriptlevel() {
        return scriptlevel;
    }


    /**
     * Sets the scriptlevel value for this MstyleType.
     * 
     * @param scriptlevel
     */
    public void setScriptlevel(java.math.BigInteger scriptlevel) {
        this.scriptlevel = scriptlevel;
    }


    /**
     * Gets the displaystyle value for this MstyleType.
     * 
     * @return displaystyle
     */
    public boolean isDisplaystyle() {
        return displaystyle;
    }


    /**
     * Sets the displaystyle value for this MstyleType.
     * 
     * @param displaystyle
     */
    public void setDisplaystyle(boolean displaystyle) {
        this.displaystyle = displaystyle;
    }


    /**
     * Gets the scriptsizemultiplier value for this MstyleType.
     * 
     * @return scriptsizemultiplier
     */
    public java.math.BigDecimal getScriptsizemultiplier() {
        return scriptsizemultiplier;
    }


    /**
     * Sets the scriptsizemultiplier value for this MstyleType.
     * 
     * @param scriptsizemultiplier
     */
    public void setScriptsizemultiplier(java.math.BigDecimal scriptsizemultiplier) {
        this.scriptsizemultiplier = scriptsizemultiplier;
    }


    /**
     * Gets the scriptminsize value for this MstyleType.
     * 
     * @return scriptminsize
     */
    public java.lang.String getScriptminsize() {
        return scriptminsize;
    }


    /**
     * Sets the scriptminsize value for this MstyleType.
     * 
     * @param scriptminsize
     */
    public void setScriptminsize(java.lang.String scriptminsize) {
        this.scriptminsize = scriptminsize;
    }


    /**
     * Gets the color value for this MstyleType.
     * 
     * @return color
     */
    public java.lang.String getColor() {
        return color;
    }


    /**
     * Sets the color value for this MstyleType.
     * 
     * @param color
     */
    public void setColor(java.lang.String color) {
        this.color = color;
    }


    /**
     * Gets the background value for this MstyleType.
     * 
     * @return background
     */
    public java.lang.String getBackground() {
        return background;
    }


    /**
     * Sets the background value for this MstyleType.
     * 
     * @param background
     */
    public void setBackground(java.lang.String background) {
        this.background = background;
    }


    /**
     * Gets the veryverythinmathspace value for this MstyleType.
     * 
     * @return veryverythinmathspace
     */
    public java.lang.String getVeryverythinmathspace() {
        return veryverythinmathspace;
    }


    /**
     * Sets the veryverythinmathspace value for this MstyleType.
     * 
     * @param veryverythinmathspace
     */
    public void setVeryverythinmathspace(java.lang.String veryverythinmathspace) {
        this.veryverythinmathspace = veryverythinmathspace;
    }


    /**
     * Gets the verythinmathspace value for this MstyleType.
     * 
     * @return verythinmathspace
     */
    public java.lang.String getVerythinmathspace() {
        return verythinmathspace;
    }


    /**
     * Sets the verythinmathspace value for this MstyleType.
     * 
     * @param verythinmathspace
     */
    public void setVerythinmathspace(java.lang.String verythinmathspace) {
        this.verythinmathspace = verythinmathspace;
    }


    /**
     * Gets the thinmathspace value for this MstyleType.
     * 
     * @return thinmathspace
     */
    public java.lang.String getThinmathspace() {
        return thinmathspace;
    }


    /**
     * Sets the thinmathspace value for this MstyleType.
     * 
     * @param thinmathspace
     */
    public void setThinmathspace(java.lang.String thinmathspace) {
        this.thinmathspace = thinmathspace;
    }


    /**
     * Gets the mediummathspace value for this MstyleType.
     * 
     * @return mediummathspace
     */
    public java.lang.String getMediummathspace() {
        return mediummathspace;
    }


    /**
     * Sets the mediummathspace value for this MstyleType.
     * 
     * @param mediummathspace
     */
    public void setMediummathspace(java.lang.String mediummathspace) {
        this.mediummathspace = mediummathspace;
    }


    /**
     * Gets the thickmathspace value for this MstyleType.
     * 
     * @return thickmathspace
     */
    public java.lang.String getThickmathspace() {
        return thickmathspace;
    }


    /**
     * Sets the thickmathspace value for this MstyleType.
     * 
     * @param thickmathspace
     */
    public void setThickmathspace(java.lang.String thickmathspace) {
        this.thickmathspace = thickmathspace;
    }


    /**
     * Gets the verythickmathspace value for this MstyleType.
     * 
     * @return verythickmathspace
     */
    public java.lang.String getVerythickmathspace() {
        return verythickmathspace;
    }


    /**
     * Sets the verythickmathspace value for this MstyleType.
     * 
     * @param verythickmathspace
     */
    public void setVerythickmathspace(java.lang.String verythickmathspace) {
        this.verythickmathspace = verythickmathspace;
    }


    /**
     * Gets the veryverythickmathspace value for this MstyleType.
     * 
     * @return veryverythickmathspace
     */
    public java.lang.String getVeryverythickmathspace() {
        return veryverythickmathspace;
    }


    /**
     * Sets the veryverythickmathspace value for this MstyleType.
     * 
     * @param veryverythickmathspace
     */
    public void setVeryverythickmathspace(java.lang.String veryverythickmathspace) {
        this.veryverythickmathspace = veryverythickmathspace;
    }


    /**
     * Gets the linethickness value for this MstyleType.
     * 
     * @return linethickness
     */
    public org.w3.www._1998.Math.MathML.Linethickness getLinethickness() {
        return linethickness;
    }


    /**
     * Sets the linethickness value for this MstyleType.
     * 
     * @param linethickness
     */
    public void setLinethickness(org.w3.www._1998.Math.MathML.Linethickness linethickness) {
        this.linethickness = linethickness;
    }


    /**
     * Gets the form value for this MstyleType.
     * 
     * @return form
     */
    public org.w3.www._1998.Math.MathML.Form getForm() {
        return form;
    }


    /**
     * Sets the form value for this MstyleType.
     * 
     * @param form
     */
    public void setForm(org.w3.www._1998.Math.MathML.Form form) {
        this.form = form;
    }


    /**
     * Gets the lspace value for this MstyleType.
     * 
     * @return lspace
     */
    public org.w3.www._1998.Math.MathML.Lspace getLspace() {
        return lspace;
    }


    /**
     * Sets the lspace value for this MstyleType.
     * 
     * @param lspace
     */
    public void setLspace(org.w3.www._1998.Math.MathML.Lspace lspace) {
        this.lspace = lspace;
    }


    /**
     * Gets the rspace value for this MstyleType.
     * 
     * @return rspace
     */
    public org.w3.www._1998.Math.MathML.Rspace getRspace() {
        return rspace;
    }


    /**
     * Sets the rspace value for this MstyleType.
     * 
     * @param rspace
     */
    public void setRspace(org.w3.www._1998.Math.MathML.Rspace rspace) {
        this.rspace = rspace;
    }


    /**
     * Gets the fence value for this MstyleType.
     * 
     * @return fence
     */
    public boolean isFence() {
        return fence;
    }


    /**
     * Sets the fence value for this MstyleType.
     * 
     * @param fence
     */
    public void setFence(boolean fence) {
        this.fence = fence;
    }


    /**
     * Gets the separator value for this MstyleType.
     * 
     * @return separator
     */
    public boolean isSeparator() {
        return separator;
    }


    /**
     * Sets the separator value for this MstyleType.
     * 
     * @param separator
     */
    public void setSeparator(boolean separator) {
        this.separator = separator;
    }


    /**
     * Gets the stretchy value for this MstyleType.
     * 
     * @return stretchy
     */
    public boolean isStretchy() {
        return stretchy;
    }


    /**
     * Sets the stretchy value for this MstyleType.
     * 
     * @param stretchy
     */
    public void setStretchy(boolean stretchy) {
        this.stretchy = stretchy;
    }


    /**
     * Gets the symmetric value for this MstyleType.
     * 
     * @return symmetric
     */
    public boolean isSymmetric() {
        return symmetric;
    }


    /**
     * Sets the symmetric value for this MstyleType.
     * 
     * @param symmetric
     */
    public void setSymmetric(boolean symmetric) {
        this.symmetric = symmetric;
    }


    /**
     * Gets the movablelimits value for this MstyleType.
     * 
     * @return movablelimits
     */
    public boolean isMovablelimits() {
        return movablelimits;
    }


    /**
     * Sets the movablelimits value for this MstyleType.
     * 
     * @param movablelimits
     */
    public void setMovablelimits(boolean movablelimits) {
        this.movablelimits = movablelimits;
    }


    /**
     * Gets the accent value for this MstyleType.
     * 
     * @return accent
     */
    public boolean isAccent() {
        return accent;
    }


    /**
     * Sets the accent value for this MstyleType.
     * 
     * @param accent
     */
    public void setAccent(boolean accent) {
        this.accent = accent;
    }


    /**
     * Gets the largeop value for this MstyleType.
     * 
     * @return largeop
     */
    public boolean isLargeop() {
        return largeop;
    }


    /**
     * Sets the largeop value for this MstyleType.
     * 
     * @param largeop
     */
    public void setLargeop(boolean largeop) {
        this.largeop = largeop;
    }


    /**
     * Gets the minsize value for this MstyleType.
     * 
     * @return minsize
     */
    public org.w3.www._1998.Math.MathML.Minsize getMinsize() {
        return minsize;
    }


    /**
     * Sets the minsize value for this MstyleType.
     * 
     * @param minsize
     */
    public void setMinsize(org.w3.www._1998.Math.MathML.Minsize minsize) {
        this.minsize = minsize;
    }


    /**
     * Gets the maxsize value for this MstyleType.
     * 
     * @return maxsize
     */
    public org.w3.www._1998.Math.MathML.Maxsize getMaxsize() {
        return maxsize;
    }


    /**
     * Sets the maxsize value for this MstyleType.
     * 
     * @param maxsize
     */
    public void setMaxsize(org.w3.www._1998.Math.MathML.Maxsize maxsize) {
        this.maxsize = maxsize;
    }


    /**
     * Gets the mathvariant value for this MstyleType.
     * 
     * @return mathvariant
     */
    public org.w3.www._1998.Math.MathML.Mathvariant getMathvariant() {
        return mathvariant;
    }


    /**
     * Sets the mathvariant value for this MstyleType.
     * 
     * @param mathvariant
     */
    public void setMathvariant(org.w3.www._1998.Math.MathML.Mathvariant mathvariant) {
        this.mathvariant = mathvariant;
    }


    /**
     * Gets the mathsize value for this MstyleType.
     * 
     * @return mathsize
     */
    public org.w3.www._1998.Math.MathML.Mathsize getMathsize() {
        return mathsize;
    }


    /**
     * Sets the mathsize value for this MstyleType.
     * 
     * @param mathsize
     */
    public void setMathsize(org.w3.www._1998.Math.MathML.Mathsize mathsize) {
        this.mathsize = mathsize;
    }


    /**
     * Gets the mathcolor value for this MstyleType.
     * 
     * @return mathcolor
     */
    public java.lang.String getMathcolor() {
        return mathcolor;
    }


    /**
     * Sets the mathcolor value for this MstyleType.
     * 
     * @param mathcolor
     */
    public void setMathcolor(java.lang.String mathcolor) {
        this.mathcolor = mathcolor;
    }


    /**
     * Gets the mathbackground value for this MstyleType.
     * 
     * @return mathbackground
     */
    public java.lang.String getMathbackground() {
        return mathbackground;
    }


    /**
     * Sets the mathbackground value for this MstyleType.
     * 
     * @param mathbackground
     */
    public void setMathbackground(java.lang.String mathbackground) {
        this.mathbackground = mathbackground;
    }


    /**
     * Gets the _class value for this MstyleType.
     * 
     * @return _class
     */
    public org.apache.axis.types.NMTokens get_class() {
        return _class;
    }


    /**
     * Sets the _class value for this MstyleType.
     * 
     * @param _class
     */
    public void set_class(org.apache.axis.types.NMTokens _class) {
        this._class = _class;
    }


    /**
     * Gets the style value for this MstyleType.
     * 
     * @return style
     */
    public java.lang.String getStyle() {
        return style;
    }


    /**
     * Sets the style value for this MstyleType.
     * 
     * @param style
     */
    public void setStyle(java.lang.String style) {
        this.style = style;
    }


    /**
     * Gets the xref value for this MstyleType.
     * 
     * @return xref
     */
    public org.apache.axis.types.IDRef getXref() {
        return xref;
    }


    /**
     * Sets the xref value for this MstyleType.
     * 
     * @param xref
     */
    public void setXref(org.apache.axis.types.IDRef xref) {
        this.xref = xref;
    }


    /**
     * Gets the id value for this MstyleType.
     * 
     * @return id
     */
    public org.apache.axis.types.Id getId() {
        return id;
    }


    /**
     * Sets the id value for this MstyleType.
     * 
     * @param id
     */
    public void setId(org.apache.axis.types.Id id) {
        this.id = id;
    }


    /**
     * Gets the href value for this MstyleType.
     * 
     * @return href
     */
    public java.lang.Object getHref() {
        return href;
    }


    /**
     * Sets the href value for this MstyleType.
     * 
     * @param href
     */
    public void setHref(java.lang.Object href) {
        this.href = href;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MstyleType)) return false;
        MstyleType other = (MstyleType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.scriptlevel==null && other.getScriptlevel()==null) || 
             (this.scriptlevel!=null &&
              this.scriptlevel.equals(other.getScriptlevel()))) &&
            this.displaystyle == other.isDisplaystyle() &&
            ((this.scriptsizemultiplier==null && other.getScriptsizemultiplier()==null) || 
             (this.scriptsizemultiplier!=null &&
              this.scriptsizemultiplier.equals(other.getScriptsizemultiplier()))) &&
            ((this.scriptminsize==null && other.getScriptminsize()==null) || 
             (this.scriptminsize!=null &&
              this.scriptminsize.equals(other.getScriptminsize()))) &&
            ((this.color==null && other.getColor()==null) || 
             (this.color!=null &&
              this.color.equals(other.getColor()))) &&
            ((this.background==null && other.getBackground()==null) || 
             (this.background!=null &&
              this.background.equals(other.getBackground()))) &&
            ((this.veryverythinmathspace==null && other.getVeryverythinmathspace()==null) || 
             (this.veryverythinmathspace!=null &&
              this.veryverythinmathspace.equals(other.getVeryverythinmathspace()))) &&
            ((this.verythinmathspace==null && other.getVerythinmathspace()==null) || 
             (this.verythinmathspace!=null &&
              this.verythinmathspace.equals(other.getVerythinmathspace()))) &&
            ((this.thinmathspace==null && other.getThinmathspace()==null) || 
             (this.thinmathspace!=null &&
              this.thinmathspace.equals(other.getThinmathspace()))) &&
            ((this.mediummathspace==null && other.getMediummathspace()==null) || 
             (this.mediummathspace!=null &&
              this.mediummathspace.equals(other.getMediummathspace()))) &&
            ((this.thickmathspace==null && other.getThickmathspace()==null) || 
             (this.thickmathspace!=null &&
              this.thickmathspace.equals(other.getThickmathspace()))) &&
            ((this.verythickmathspace==null && other.getVerythickmathspace()==null) || 
             (this.verythickmathspace!=null &&
              this.verythickmathspace.equals(other.getVerythickmathspace()))) &&
            ((this.veryverythickmathspace==null && other.getVeryverythickmathspace()==null) || 
             (this.veryverythickmathspace!=null &&
              this.veryverythickmathspace.equals(other.getVeryverythickmathspace()))) &&
            ((this.linethickness==null && other.getLinethickness()==null) || 
             (this.linethickness!=null &&
              this.linethickness.equals(other.getLinethickness()))) &&
            ((this.form==null && other.getForm()==null) || 
             (this.form!=null &&
              this.form.equals(other.getForm()))) &&
            ((this.lspace==null && other.getLspace()==null) || 
             (this.lspace!=null &&
              this.lspace.equals(other.getLspace()))) &&
            ((this.rspace==null && other.getRspace()==null) || 
             (this.rspace!=null &&
              this.rspace.equals(other.getRspace()))) &&
            this.fence == other.isFence() &&
            this.separator == other.isSeparator() &&
            this.stretchy == other.isStretchy() &&
            this.symmetric == other.isSymmetric() &&
            this.movablelimits == other.isMovablelimits() &&
            this.accent == other.isAccent() &&
            this.largeop == other.isLargeop() &&
            ((this.minsize==null && other.getMinsize()==null) || 
             (this.minsize!=null &&
              this.minsize.equals(other.getMinsize()))) &&
            ((this.maxsize==null && other.getMaxsize()==null) || 
             (this.maxsize!=null &&
              this.maxsize.equals(other.getMaxsize()))) &&
            ((this.mathvariant==null && other.getMathvariant()==null) || 
             (this.mathvariant!=null &&
              this.mathvariant.equals(other.getMathvariant()))) &&
            ((this.mathsize==null && other.getMathsize()==null) || 
             (this.mathsize!=null &&
              this.mathsize.equals(other.getMathsize()))) &&
            ((this.mathcolor==null && other.getMathcolor()==null) || 
             (this.mathcolor!=null &&
              this.mathcolor.equals(other.getMathcolor()))) &&
            ((this.mathbackground==null && other.getMathbackground()==null) || 
             (this.mathbackground!=null &&
              this.mathbackground.equals(other.getMathbackground()))) &&
            ((this._class==null && other.get_class()==null) || 
             (this._class!=null &&
              this._class.equals(other.get_class()))) &&
            ((this.style==null && other.getStyle()==null) || 
             (this.style!=null &&
              this.style.equals(other.getStyle()))) &&
            ((this.xref==null && other.getXref()==null) || 
             (this.xref!=null &&
              this.xref.equals(other.getXref()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.href==null && other.getHref()==null) || 
             (this.href!=null &&
              this.href.equals(other.getHref())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getScriptlevel() != null) {
            _hashCode += getScriptlevel().hashCode();
        }
        _hashCode += (isDisplaystyle() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getScriptsizemultiplier() != null) {
            _hashCode += getScriptsizemultiplier().hashCode();
        }
        if (getScriptminsize() != null) {
            _hashCode += getScriptminsize().hashCode();
        }
        if (getColor() != null) {
            _hashCode += getColor().hashCode();
        }
        if (getBackground() != null) {
            _hashCode += getBackground().hashCode();
        }
        if (getVeryverythinmathspace() != null) {
            _hashCode += getVeryverythinmathspace().hashCode();
        }
        if (getVerythinmathspace() != null) {
            _hashCode += getVerythinmathspace().hashCode();
        }
        if (getThinmathspace() != null) {
            _hashCode += getThinmathspace().hashCode();
        }
        if (getMediummathspace() != null) {
            _hashCode += getMediummathspace().hashCode();
        }
        if (getThickmathspace() != null) {
            _hashCode += getThickmathspace().hashCode();
        }
        if (getVerythickmathspace() != null) {
            _hashCode += getVerythickmathspace().hashCode();
        }
        if (getVeryverythickmathspace() != null) {
            _hashCode += getVeryverythickmathspace().hashCode();
        }
        if (getLinethickness() != null) {
            _hashCode += getLinethickness().hashCode();
        }
        if (getForm() != null) {
            _hashCode += getForm().hashCode();
        }
        if (getLspace() != null) {
            _hashCode += getLspace().hashCode();
        }
        if (getRspace() != null) {
            _hashCode += getRspace().hashCode();
        }
        _hashCode += (isFence() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isSeparator() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isStretchy() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isSymmetric() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isMovablelimits() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isAccent() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isLargeop() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getMinsize() != null) {
            _hashCode += getMinsize().hashCode();
        }
        if (getMaxsize() != null) {
            _hashCode += getMaxsize().hashCode();
        }
        if (getMathvariant() != null) {
            _hashCode += getMathvariant().hashCode();
        }
        if (getMathsize() != null) {
            _hashCode += getMathsize().hashCode();
        }
        if (getMathcolor() != null) {
            _hashCode += getMathcolor().hashCode();
        }
        if (getMathbackground() != null) {
            _hashCode += getMathbackground().hashCode();
        }
        if (get_class() != null) {
            _hashCode += get_class().hashCode();
        }
        if (getStyle() != null) {
            _hashCode += getStyle().hashCode();
        }
        if (getXref() != null) {
            _hashCode += getXref().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getHref() != null) {
            _hashCode += getHref().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MstyleType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "mstyle.type"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("scriptlevel");
        attrField.setXmlName(new javax.xml.namespace.QName("", "scriptlevel"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "integer"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("displaystyle");
        attrField.setXmlName(new javax.xml.namespace.QName("", "displaystyle"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("scriptsizemultiplier");
        attrField.setXmlName(new javax.xml.namespace.QName("", "scriptsizemultiplier"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("scriptminsize");
        attrField.setXmlName(new javax.xml.namespace.QName("", "scriptminsize"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "length-with-unit"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("color");
        attrField.setXmlName(new javax.xml.namespace.QName("", "color"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("background");
        attrField.setXmlName(new javax.xml.namespace.QName("", "background"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("veryverythinmathspace");
        attrField.setXmlName(new javax.xml.namespace.QName("", "veryverythinmathspace"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "length-with-unit"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("verythinmathspace");
        attrField.setXmlName(new javax.xml.namespace.QName("", "verythinmathspace"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "length-with-unit"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("thinmathspace");
        attrField.setXmlName(new javax.xml.namespace.QName("", "thinmathspace"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "length-with-unit"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("mediummathspace");
        attrField.setXmlName(new javax.xml.namespace.QName("", "mediummathspace"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "length-with-unit"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("thickmathspace");
        attrField.setXmlName(new javax.xml.namespace.QName("", "thickmathspace"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "length-with-unit"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("verythickmathspace");
        attrField.setXmlName(new javax.xml.namespace.QName("", "verythickmathspace"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "length-with-unit"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("veryverythickmathspace");
        attrField.setXmlName(new javax.xml.namespace.QName("", "veryverythickmathspace"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", "length-with-unit"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("linethickness");
        attrField.setXmlName(new javax.xml.namespace.QName("", "linethickness"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">linethickness"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("form");
        attrField.setXmlName(new javax.xml.namespace.QName("", "form"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">form"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("lspace");
        attrField.setXmlName(new javax.xml.namespace.QName("", "lspace"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">lspace"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("rspace");
        attrField.setXmlName(new javax.xml.namespace.QName("", "rspace"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">rspace"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("fence");
        attrField.setXmlName(new javax.xml.namespace.QName("", "fence"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("separator");
        attrField.setXmlName(new javax.xml.namespace.QName("", "separator"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("stretchy");
        attrField.setXmlName(new javax.xml.namespace.QName("", "stretchy"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("symmetric");
        attrField.setXmlName(new javax.xml.namespace.QName("", "symmetric"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("movablelimits");
        attrField.setXmlName(new javax.xml.namespace.QName("", "movablelimits"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("accent");
        attrField.setXmlName(new javax.xml.namespace.QName("", "accent"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("largeop");
        attrField.setXmlName(new javax.xml.namespace.QName("", "largeop"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("minsize");
        attrField.setXmlName(new javax.xml.namespace.QName("", "minsize"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">minsize"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("maxsize");
        attrField.setXmlName(new javax.xml.namespace.QName("", "maxsize"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">maxsize"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("mathvariant");
        attrField.setXmlName(new javax.xml.namespace.QName("", "mathvariant"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">mathvariant"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("mathsize");
        attrField.setXmlName(new javax.xml.namespace.QName("", "mathsize"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/1998/Math/MathML", ">mathsize"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("mathcolor");
        attrField.setXmlName(new javax.xml.namespace.QName("", "mathcolor"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("mathbackground");
        attrField.setXmlName(new javax.xml.namespace.QName("", "mathbackground"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("_class");
        attrField.setXmlName(new javax.xml.namespace.QName("", "class"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "NMTOKENS"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("style");
        attrField.setXmlName(new javax.xml.namespace.QName("", "style"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("xref");
        attrField.setXmlName(new javax.xml.namespace.QName("", "xref"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "IDREF"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "ID"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("href");
        attrField.setXmlName(new javax.xml.namespace.QName("http://www.w3.org/1999/xlink", "href"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        typeDesc.addFieldDesc(attrField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}

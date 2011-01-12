package edu.bth.spla.calculator.code.java;

import edu.bth.spla.calculator.model.*;

public class TTheme
{
  protected static String nl;
  public static synchronized TTheme create(String lineSeparator)
  {
    nl = lineSeparator;
    TTheme result = new TTheme();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package com.spl.gui;" + NL + "" + NL + "public class Theme {" + NL + "\tpublic final String OM_TEXT_1ROW = \"text1row\";" + NL + "\tpublic final String OM_TEXT_2ROWS = \"text2rows\";" + NL + "\tpublic final String IM_TEXT = \"text\";" + NL + "\tpublic final String IM_BUTTONS = \"buttons\";" + NL + "\t" + NL + "\tprivate String input_method;" + NL + "\tprivate String output_mode;" + NL + "\tprivate String bg_image;" + NL + "\tprivate String bg_color;" + NL + "\tprivate String fg_button;" + NL + "\tprivate String bg_display;" + NL + "\tprivate String fg_display;" + NL + "\t" + NL + "\tpublic Theme(String iM, String oM, String img, String bgColor, " + NL + "\t\t\tString fgBut, String bgDis, String fgDis) {" + NL + "\t\tinput_method = iM;" + NL + "\t\toutput_mode = oM;" + NL + "\t\tbg_image = img;" + NL + "\t\tbg_color= bgColor;" + NL + "\t\tfg_button = fgBut;" + NL + "\t\tbg_display = bgDis;" + NL + "\t\tfg_display = fgDis;" + NL + "\t}" + NL + "\t" + NL + "\tpublic void setIputMethod(String iM) {" + NL + "\t\tinput_method = iM;" + NL + "\t}" + NL + "\t" + NL + "\tpublic String getInputMethod() {" + NL + "\t\treturn input_method;" + NL + "\t}" + NL + "\t" + NL + "\tpublic void setOutputMode(String oM) {" + NL + "\t\toutput_mode = oM;" + NL + "\t}" + NL + "\t" + NL + "\tpublic String getOutputMode() {" + NL + "\t\treturn output_mode;" + NL + "\t}" + NL + "\t" + NL + "\tpublic void setBgImage(String img) {" + NL + "\t\tbg_image = img;" + NL + "\t}" + NL + "\t" + NL + "\tpublic String getBgImage() {" + NL + "\t\treturn bg_image;" + NL + "\t}" + NL + "\t" + NL + "\tpublic void setBgColor(String col) {" + NL + "\t\tbg_color = col;" + NL + "\t}" + NL + "\t" + NL + "\tpublic String getBgColor() {" + NL + "\t\treturn bg_color;" + NL + "\t}" + NL + "\t" + NL + "\tpublic void setFgButton(String fgBut) {" + NL + "\t\tfg_button= fgBut;" + NL + "\t}" + NL + "\t" + NL + "\tpublic String getFgButton() {" + NL + "\t\treturn fg_button;" + NL + "\t}" + NL + "\t" + NL + "\tpublic void setFgDisplay(String fgDisplay) {" + NL + "\t\tfg_display = fgDisplay;" + NL + "\t}" + NL + "\t" + NL + "\tpublic String getFgDisplay() {" + NL + "\t\treturn fg_display;" + NL + "\t}" + NL + "\t" + NL + "\tpublic void setBgDisplay(String bgDisplay) {" + NL + "\t\tbg_display = bgDisplay;" + NL + "\t}" + NL + "\t" + NL + "\tpublic String getBgDisplay() {" + NL + "\t\treturn bg_display;" + NL + "\t}" + NL + "\t" + NL + "}";
  protected final String TEXT_2 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     CalculatorModel model = (CalculatorModel) argument; 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}

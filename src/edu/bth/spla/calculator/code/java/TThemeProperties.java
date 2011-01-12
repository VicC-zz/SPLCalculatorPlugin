package edu.bth.spla.calculator.code.java;

import edu.bth.spla.calculator.model.*;

public class TThemeProperties
{
  protected static String nl;
  public static synchronized TThemeProperties create(String lineSeparator)
  {
    nl = lineSeparator;
    TThemeProperties result = new TThemeProperties();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "#############################" + NL + "# THEME CONFIGURATION FILE" + NL + "#############################" + NL + "# input_method E {buttons, text}, buttons is default" + NL + "# output_mode E {text1row, text2rows}, text1row is default" + NL + "# bg_image is a path to the image" + NL + "input_method=";
  protected final String TEXT_2 = "text";
  protected final String TEXT_3 = "buttons";
  protected final String TEXT_4 = NL + "output_mode=";
  protected final String TEXT_5 = "text1row";
  protected final String TEXT_6 = "text2rows";
  protected final String TEXT_7 = NL + "bg_image=";
  protected final String TEXT_8 = NL + "bg_color=";
  protected final String TEXT_9 = NL + "fg_button=";
  protected final String TEXT_10 = NL + "bg_display=";
  protected final String TEXT_11 = NL + "fg_display=";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     CalculatorModel model = (CalculatorModel) argument; 
    stringBuffer.append(TEXT_1);
     if(model.getInput().equals(Input.KEYBOARD)){
    stringBuffer.append(TEXT_2);
    }
     if(model.getInput().equals(Input.MOUSE)){
    stringBuffer.append(TEXT_3);
    }
    stringBuffer.append(TEXT_4);
    if(model.getOutput().equals(Output.ONE_ROW)){
    stringBuffer.append(TEXT_5);
    }
     if(model.getOutput().equals(Output.TWO_ROW)){
    stringBuffer.append(TEXT_6);
    }
    stringBuffer.append(TEXT_7);
    stringBuffer.append(model.getTheme().getBgImage());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(model.getTheme().getBgColor());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(model.getTheme().getFgButton());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(model.getTheme().getBgDisplay());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(model.getTheme().getFgDisplay());
    return stringBuffer.toString();
  }
}

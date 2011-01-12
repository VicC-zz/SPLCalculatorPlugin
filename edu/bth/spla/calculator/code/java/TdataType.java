package edu.bth.spla.calculator.code.java;

import edu.bth.spla.calculator.model.*;

public class TdataType
{
  protected static String nl;
  public static synchronized TdataType create(String lineSeparator)
  {
    nl = lineSeparator;
    TdataType result = new TdataType();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "#############################" + NL + "# DATA TYPE CONFIGURATION FILE" + NL + "#############################" + NL + "# data_type E {integer, float}, integer is default" + NL + "data_type=";
  protected final String TEXT_2 = "float";
  protected final String TEXT_3 = "integer";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     CalculatorModel model = (CalculatorModel) argument; 
    stringBuffer.append(TEXT_1);
     if(model.getType().equals(Type.ADULT)){
    stringBuffer.append(TEXT_2);
    }
     if(model.getType().equals(Type.CHILD)){
    stringBuffer.append(TEXT_3);
    }
    return stringBuffer.toString();
  }
}

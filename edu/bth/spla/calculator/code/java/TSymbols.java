package edu.bth.spla.calculator.code.java;

import edu.bth.spla.calculator.model.*;

public class TSymbols
{
  protected static String nl;
  public static synchronized TSymbols create(String lineSeparator)
  {
    nl = lineSeparator;
    TSymbols result = new TSymbols();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "#############################" + NL + "# SYMBOLS CONFIGURATION FILE" + NL + "#############################" + NL + "# numbers E {0,1,2,3,4,5,6,7,8,9,.}, 0-9 is default" + NL + "# operators E {+,-,*,/,^,e,~,s,(,)}, arithmetic + - * / are default" + NL + "numbers=0,1,2,3,4,5,6,7,8,9";
  protected final String TEXT_2 = ",.";
  protected final String TEXT_3 = NL + "operators=";
  protected final String TEXT_4 = "+,-,*,/";
  protected final String TEXT_5 = ",~";
  protected final String TEXT_6 = ",e";
  protected final String TEXT_7 = ",^";
  protected final String TEXT_8 = ",s";
  protected final String TEXT_9 = ",(,)";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     CalculatorModel model = (CalculatorModel) argument; 
    stringBuffer.append(TEXT_1);
     if(model.getType().equals(Type.ADULT)){
    stringBuffer.append(TEXT_2);
    }
    stringBuffer.append(TEXT_3);
     if(model.getOperations().contains(Operation.ARITHMETIC)){
    stringBuffer.append(TEXT_4);
    }
    if(model.getOperations().contains(Operation.ABS)){
    stringBuffer.append(TEXT_5);
    }
     if(model.getOperations().contains(Operation.EXP)){
    stringBuffer.append(TEXT_6);
    }
     if(model.getOperations().contains(Operation.POW)){
    stringBuffer.append(TEXT_7);
    }
     if(model.getOperations().contains(Operation.SQRT)){
    stringBuffer.append(TEXT_8);
    }
     if(model.getType().equals(Type.ADULT)){
    stringBuffer.append(TEXT_9);
    }
    return stringBuffer.toString();
  }
}

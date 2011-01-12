package edu.bth.spla.calculator.code.java;

import edu.bth.spla.calculator.model.*;

public class TOperations
{
  protected static String nl;
  public static synchronized TOperations create(String lineSeparator)
  {
    nl = lineSeparator;
    TOperations result = new TOperations();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "#############################" + NL + "# OPERATORS CONFIGURATION FILE" + NL + "#############################" + NL + "# Format: operator mathematical_representation" + NL + "#";
  protected final String TEXT_2 = NL + "+ +" + NL + "- -" + NL + "= =" + NL + "* *" + NL + "/ /";
  protected final String TEXT_3 = NL + "~ Math.abs(y)";
  protected final String TEXT_4 = NL + "^ Math.pow(x,y)";
  protected final String TEXT_5 = NL + "s Math.sqrt(y)";
  protected final String TEXT_6 = NL + "e Math.exp(y)";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     CalculatorModel model = (CalculatorModel) argument; 
    stringBuffer.append(TEXT_1);
     if(model.getOperations().contains(Operation.ARITHMETIC)){
    stringBuffer.append(TEXT_2);
    }
     if(model.getOperations().contains(Operation.ABS)){
    stringBuffer.append(TEXT_3);
    }
     if(model.getOperations().contains(Operation.POW)){
    stringBuffer.append(TEXT_4);
    }
     if(model.getOperations().contains(Operation.SQRT)){
    stringBuffer.append(TEXT_5);
    }
     if(model.getOperations().contains(Operation.EXP)){
    stringBuffer.append(TEXT_6);
    }
    return stringBuffer.toString();
  }
}

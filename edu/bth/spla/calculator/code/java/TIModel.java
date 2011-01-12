package edu.bth.spla.calculator.code.java;

import edu.bth.spla.calculator.model.*;

public class TIModel
{
  protected static String nl;
  public static synchronized TIModel create(String lineSeparator)
  {
    nl = lineSeparator;
    TIModel result = new TIModel();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package com.spl.model;" + NL + "" + NL + "public interface IModel{" + NL + "\tpublic static String RESULT=\"result\";" + NL + "\tpublic static String STATEMENT=\"statment\";" + NL + "\t" + NL + "\tpublic void addSymbolToStatement(String Symbol);" + NL + "\t" + NL + "\tpublic void deleteLastSymbol();" + NL + "\t" + NL + "\tpublic void deleteStatement();" + NL + "\t" + NL + "\tpublic String getStatement();" + NL + "" + NL + "\tpublic void setResult(String result);" + NL + "\t" + NL + "\tpublic void deleteResult();" + NL + "\t" + NL + "\tpublic String getResult();" + NL + "\t" + NL + "\tpublic void subscribe(ModelObserver modelObserver);" + NL + "\t" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     CalculatorModel model = (CalculatorModel) argument; 
    stringBuffer.append(TEXT_1);
    return stringBuffer.toString();
  }
}

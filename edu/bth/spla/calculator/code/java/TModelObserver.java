package edu.bth.spla.calculator.code.java;

import edu.bth.spla.calculator.model.*;

public class TModelObserver
{
  protected static String nl;
  public static synchronized TModelObserver create(String lineSeparator)
  {
    nl = lineSeparator;
    TModelObserver result = new TModelObserver();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package com.spl.model;" + NL + "" + NL + "public interface ModelObserver {" + NL + "\t" + NL + "\tpublic void notifyObserver(String output);" + NL + "}";
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

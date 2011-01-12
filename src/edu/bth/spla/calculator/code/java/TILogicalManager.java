package edu.bth.spla.calculator.code.java;

import edu.bth.spla.calculator.model.*;

public class TILogicalManager
{
  protected static String nl;
  public static synchronized TILogicalManager create(String lineSeparator)
  {
    nl = lineSeparator;
    TILogicalManager result = new TILogicalManager();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package com.spl.math;" + NL + "" + NL + "public interface ILogicalManager {" + NL + "\t" + NL + "\tpublic void performOperation();" + NL + "}";
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

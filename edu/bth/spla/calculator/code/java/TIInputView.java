package edu.bth.spla.calculator.code.java;

import edu.bth.spla.calculator.model.*;

public class TIInputView
{
  protected static String nl;
  public static synchronized TIInputView create(String lineSeparator)
  {
    nl = lineSeparator;
    TIInputView result = new TIInputView();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package com.spl.input;" + NL + "" + NL + "public interface IInputView {" + NL + "" + NL + "}";
  protected final String TEXT_2 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}

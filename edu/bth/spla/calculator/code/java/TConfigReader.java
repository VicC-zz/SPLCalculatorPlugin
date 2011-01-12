package edu.bth.spla.calculator.code.java;

import edu.bth.spla.calculator.model.*;

public class TConfigReader
{
  protected static String nl;
  public static synchronized TConfigReader create(String lineSeparator)
  {
    nl = lineSeparator;
    TConfigReader result = new TConfigReader();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package com.spl.properties;" + NL + "" + NL + "import java.util.ResourceBundle;" + NL + "" + NL + "public class ConfigReader {" + NL + "\tResourceBundle properties;" + NL + "\t" + NL + "\t/**" + NL + "\t * Creates a new config file reader" + NL + "\t * @param fileName The name of the properties file without the extension. For example \"operations\"" + NL + "\t */" + NL + "\tpublic ConfigReader(String fileName){" + NL + "\t\tproperties = ResourceBundle.getBundle(\"com.spl.properties.\"+fileName);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Returns the value of a key" + NL + "\t * @param key The key for the value you are looking for" + NL + "\t * @return The value of the given key" + NL + "\t */" + NL + "\tpublic String getProperty(String key){" + NL + "\t\treturn properties.getString(key);" + NL + "\t}" + NL + "\t" + NL + "\t" + NL + "}";
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

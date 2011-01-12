package edu.bth.spla.calculator.code.java;

import edu.bth.spla.calculator.model.*;

public class TModel
{
  protected static String nl;
  public static synchronized TModel create(String lineSeparator)
  {
    nl = lineSeparator;
    TModel result = new TModel();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package com.spl.model;" + NL + "" + NL + "import java.util.ArrayList;" + NL + "" + NL + "public class Model implements IModel{" + NL + "\tprivate static IModel instance;" + NL + "\tArrayList<ModelObserver> observers=new ArrayList<ModelObserver>();" + NL + "\tString result=new String(\"\");" + NL + "\tString statement=new String(\"\");" + NL + "\t" + NL + "\t" + NL + "\tpublic void addSymbolToStatement(String symbol) {" + NL + "\t\tstatement=statement.concat(symbol);" + NL + "\t\tnotifyAllObservers(STATEMENT);" + NL + "\t}" + NL + "" + NL + "\t" + NL + "\tpublic void deleteLastSymbol() {" + NL + "\t\tif(statement.length() > 0) {" + NL + "\t\t\tstatement=statement.substring(0, statement.length()-1);" + NL + "\t\t\tnotifyAllObservers(STATEMENT);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t" + NL + "\tpublic void deleteStatement() {" + NL + "\t\tstatement=\"\";" + NL + "\t\tnotifyAllObservers(STATEMENT);" + NL + "\t}" + NL + "" + NL + "\t" + NL + "\tpublic String getStatement() {" + NL + "\t\treturn statement;" + NL + "\t}" + NL + "\t" + NL + "\tpublic String getResult() {" + NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\t" + NL + "\tpublic void setResult(String result) {" + NL + "\t\tthis.result=result;" + NL + "\t\tnotifyAllObservers(RESULT);" + NL + "\t}" + NL + "\t" + NL + "\tpublic void deleteResult() {" + NL + "\t\tresult=\"\";" + NL + "\t\tnotifyAllObservers(RESULT);" + NL + "\t}" + NL + "" + NL + "\t" + NL + "\tpublic void subscribe(ModelObserver modelObserver) {" + NL + "\t\tobservers.add(modelObserver);" + NL + "\t}" + NL + "" + NL + "\t" + NL + "\tpublic static IModel getInstance() {" + NL + "\t\tif(instance==null){" + NL + "\t\t\tinstance = new Model();" + NL + "\t\t}" + NL + "\t\treturn instance;" + NL + "\t}" + NL + "\t" + NL + "\tprivate void notifyAllObservers(String output){" + NL + "\t\tfor (ModelObserver modelObserver : observers) {" + NL + "\t\t\tmodelObserver.notifyObserver(output);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     CalculatorModel model = (CalculatorModel) argument; 
    stringBuffer.append(TEXT_1);
    return stringBuffer.toString();
  }
}

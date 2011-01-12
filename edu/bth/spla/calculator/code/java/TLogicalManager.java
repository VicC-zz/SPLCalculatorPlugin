package edu.bth.spla.calculator.code.java;

import edu.bth.spla.calculator.model.*;

public class TLogicalManager
{
  protected static String nl;
  public static synchronized TLogicalManager create(String lineSeparator)
  {
    nl = lineSeparator;
    TLogicalManager result = new TLogicalManager();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package com.spl.math;" + NL + "" + NL + "import java.util.StringTokenizer;" + NL + "" + NL + "import com.spl.model.IModel;" + NL + "import com.spl.model.Model;" + NL + "import com.spl.properties.ConfigReader;" + NL + "" + NL + "import bsh.EvalError;" + NL + "import bsh.Interpreter;" + NL + "" + NL + "public class LogicalManager implements ILogicalManager{" + NL + "\tIModel model;" + NL + "\tString data_type;" + NL + "\tpublic void performOperation() {" + NL + "\t\tthis.model=Model.getInstance();" + NL + "\t\t//if the user presses = and there is nothing in the statement - ignore the process" + NL + "\t\tif(model.getStatement().equals(\"\")) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tInterpreter i = new Interpreter();  // Construct an interpreter" + NL + "\t\tload_data_type();" + NL + "\t\t//Parser parser=new Parser(model.getStatement());" + NL + "\t\t";
  protected final String TEXT_2 = NL + "\t\tParser parser=new Parser();" + NL + "\t\tparser.load_valid_operators();" + NL + "\t\tString converted = parser.converter(model.getStatement());" + NL + "\t\t";
  protected final String TEXT_3 = NL + "\t\t";
  protected final String TEXT_4 = NL + "\t\t\tString converted = model.getStatement();" + NL + "\t\t";
  protected final String TEXT_5 = NL + "\t\t// Eval a statement and get the result" + NL + "\t\ttry {" + NL + "\t\t\ti.eval(\"result = \" + converted);" + NL + "\t\t\tString final_result = i.get(\"result\").toString();" + NL + "\t\t\t//check the data_type" + NL + "\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\tmodel.setResult(truncate_number(final_result));" + NL + "\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t";
  protected final String TEXT_8 = NL + "\t\t\t\tmodel.setResult(final_result);" + NL + "\t\t\t";
  protected final String TEXT_9 = "\t\t\t" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\t// TODO Auto-generated catch block" + NL + "\t\t\tmodel.setResult(e.getMessage());" + NL + "\t\t\tSystem.out.println(e.getMessage());" + NL + "\t\t\t//e.printStackTrace();" + NL + "\t\t}             " + NL + "//System.out.println(converted);" + NL + "\t}" + NL + "\t" + NL + "\tpublic void load_data_type() {" + NL + "\t\tConfigReader confReader = new ConfigReader(\"data_type\");" + NL + "\t\tdata_type = confReader.getProperty(\"data_type\");" + NL + "\t}" + NL + "\t" + NL + "\tpublic String truncate_number(String number) {" + NL + "\t\tStringTokenizer st = new StringTokenizer(number, \".\");" + NL + "\t\treturn st.nextToken();" + NL + "\t}" + NL + "\t" + NL + "}" + NL;
  protected final String TEXT_10 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     CalculatorModel model = (CalculatorModel) argument; 
    stringBuffer.append(TEXT_1);
     if(model.getType().equals(Type.ADULT)){
    stringBuffer.append(TEXT_2);
    }
    stringBuffer.append(TEXT_3);
     if(model.getType().equals(Type.CHILD)){
    stringBuffer.append(TEXT_4);
    }
    stringBuffer.append(TEXT_5);
     if(model.getType().equals(Type.CHILD)){
    stringBuffer.append(TEXT_6);
    }
    stringBuffer.append(TEXT_7);
     if(model.getType().equals(Type.ADULT)){
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
    return stringBuffer.toString();
  }
}

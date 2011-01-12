package edu.bth.spla.calculator.code.java;

import edu.bth.spla.calculator.model.*;

public class TInputManager
{
  protected static String nl;
  public static synchronized TInputManager create(String lineSeparator)
  {
    nl = lineSeparator;
    TInputManager result = new TInputManager();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package com.spl.input;" + NL + "" + NL + "import java.util.StringTokenizer;" + NL + "" + NL + "import com.spl.math.LogicalManager;" + NL + "import com.spl.model.Model;" + NL + "import com.spl.properties.ConfigReader;" + NL + "" + NL + "public class InputManager {" + NL + "\t" + NL + "\tpublic char symbols[];" + NL + "\tpublic char nums[];" + NL + "\tpublic String ops;" + NL + "\t" + NL + "\t//read the config file and load the parameters into an array" + NL + "\tpublic void load_valid_operators() {" + NL + "\t\t//read the operators from the file" + NL + "\t\tConfigReader confReader = new ConfigReader(\"symbols\");" + NL + "\t\tchar [] numbers = confReader.getProperty(\"numbers\").toCharArray();" + NL + "\t\tchar [] operators = confReader.getProperty(\"operators\").toCharArray();" + NL + "\t\t//delete ',' from the operators" + NL + "\t\tint without_commas = ((numbers.length + operators.length)/ 2) + 1;" + NL + "\t\tsymbols = new char [without_commas];" + NL + "\t\tnums = new char[(numbers.length/2)+1];" + NL + "\t\t" + NL + "\t\tint i;" + NL + "\t\tint j = 0;" + NL + "\t\tint n = 0;" + NL + "\t\tint o = 0;" + NL + "\t\tfor(i = 0; i < numbers.length; i++) {" + NL + "\t\t\tif(numbers[i] != ','){" + NL + "\t\t\t\tsymbols[j++] = numbers[i];" + NL + "\t\t\t\tnums[n++] = numbers[i];" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tfor(i = 0; i < operators.length; i++) {" + NL + "\t\t\tif(operators[i] != ',') {" + NL + "\t\t\t\tsymbols[j++] = operators[i];" + NL + "\t\t\t\tops += operators[i];" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "/*\t" + NL + "\tpublic String filter(String input) {" + NL + "\t\tchar [] in_chars = input.toCharArray();" + NL + "\t\tString statement = \"\";" + NL + "\t\tfor (int i = 0; i < in_chars.length && in_chars[i] != '='; i++) {" + NL + "\t\t\t//always skip the space" + NL + "\t\t\tif(in_chars[i] != ' ' && search_symbols(in_chars[i])){" + NL + "\t\t\t\taddSymbol(in_chars[i]);" + NL + "\t\t\t\tstatement += in_chars[i];" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t//call performOperations" + NL + "\t\tLogicalManager logicalManager = new LogicalManager();" + NL + "\t\tlogicalManager.performOperation();" + NL + "\t\t" + NL + "\t\treturn statement; " + NL + "\t}" + NL + "*/" + NL + "\tpublic void addSymbol(char in_char) {" + NL + "//System.out.print(in_char);" + NL + "\t\tif(in_char == '=') {" + NL + "\t\t\t//call performOperations" + NL + "\t\t\tLogicalManager logicalManager = new LogicalManager();" + NL + "\t\t\tlogicalManager.performOperation();" + NL + "\t\t} else if(search_symbols(in_char)) {" + NL + "\t\t\tModel.getInstance().addSymbolToStatement(Character.toString(in_char));\t\t\t" + NL + "\t\t}else {}" + NL + "\t}" + NL + "\t" + NL + "\tpublic void clearall() {" + NL + "\t\tModel.getInstance().deleteStatement();" + NL + "\t\tModel.getInstance().deleteResult();" + NL + "\t}" + NL + "\t" + NL + "\tpublic void clear() {" + NL + "\t\tModel.getInstance().deleteLastSymbol();" + NL + "\t}" + NL + "\t" + NL + "\tpublic boolean search_symbols(char symbol) {" + NL + "\t\tboolean exists = false;" + NL + "\t\tfor(int i = 0; i < symbols.length; i++){" + NL + "\t\t\tif(symbol == symbols[i]){" + NL + "\t\t\t\texists = true;" + NL + "\t\t\t\tbreak;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn exists;" + NL + "\t}" + NL + "}";
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

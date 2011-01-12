package edu.bth.spla.calculator.code.java;

import edu.bth.spla.calculator.model.*;

public class TParser
{
  protected static String nl;
  public static synchronized TParser create(String lineSeparator)
  {
    nl = lineSeparator;
    TParser result = new TParser();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package com.spl.math;" + NL + "" + NL + "import java.util.*;" + NL + "import com.spl.properties.ConfigReader;" + NL + "" + NL + "public class Parser {" + NL + "" + NL + "\tpublic String ops = \"\";" + NL + "" + NL + "\tpublic void load_valid_operators() {" + NL + "\t\t//read the operators from the file" + NL + "\t\tConfigReader confReader = new ConfigReader(\"symbols\");" + NL + "\t\tchar [] operators = confReader.getProperty(\"operators\").toCharArray();" + NL + "\t\t//delete ',' from the operators" + NL + "\t\t" + NL + "\t\tint i;" + NL + "\t\tfor(i = 0; i < operators.length; i++)" + NL + "\t\t\tif(operators[i] != ',') " + NL + "\t\t\t\tops += operators[i];" + NL + "\t}" + NL + "\t" + NL + "\tpublic String converter(String expression){" + NL + "\t\tStringTokenizer st = new StringTokenizer(expression, ops, true);" + NL + "\t\tString tokens [] = new String[50];" + NL + "\t\tboolean marker [] = new boolean[50]; //it will mark the numbers and operators that were moved to the final expression" + NL + "\t\tboolean parenthesis_left = false;" + NL + "\t\tboolean parenthesis_right = false;" + NL + "\t\tint number_tokens = 0;" + NL + "\t\tString final_expression = \"\";" + NL + "\t\t\t\t" + NL + "\t\tint i;" + NL + "\t\tfor(i = 0; i < marker.length; i++)" + NL + "\t\t\tmarker[i] = false;" + NL + "\t\t" + NL + "\t\t//put all tokens in array " + NL + "\t\twhile (st.hasMoreTokens()) {" + NL + "\t\t\tString token = st.nextToken();" + NL + "\t\t\ttokens[number_tokens++] = token;" + NL + "\t\t}" + NL + "\t\t//here we read the array and we check the operators, we can retrieve based on the position" + NL + "\t\tfor(i = 0; i < number_tokens; i++) {" + NL + "\t\t\tif(isNumber(tokens[i])) {" + NL + "\t\t\t} else {" + NL + "\t\t\t\t//if parentheses ... keep reading until you reach the other parenthesis" + NL + "\t\t\t\tif(tokens[i].equals(\"(\") || tokens[i].equals(\")\") ) {" + NL + "\t\t\t\t\tif(tokens[i].equals(\"(\"))" + NL + "\t\t\t\t\t\tparenthesis_left = true;" + NL + "\t\t\t\t\tif(tokens[i].equals(\")\"))" + NL + "\t\t\t\t\t\tparenthesis_right = true;" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tfinal_expression += tokens[i];" + NL + "\t\t\t\t\tmarker[i] = true;" + NL + "\t\t\t\t} else if(isArithmetic(tokens[i])) {" + NL + "\t\t\t\t\t//now check if the next operator is from the same category" + NL + "\t\t\t\t\tif(isArithmetic(tokens[i+2]) && marker[i+2] == false) {" + NL + "\t\t\t\t\t\t//in this case read both numbers and operator and skip to the next operator\t\t\t\t\t\t" + NL + "\t\t\t\t\t\tif(i > 0 && marker[i-1] == false) {" + NL + "\t\t\t\t\t\t\tfinal_expression += tokens[i-1];" + NL + "\t\t\t\t\t\t\tmarker[i-1] = true;\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tfinal_expression += tokens[i] + tokens[i+1];" + NL + "\t\t\t\t\t\tmarker[i] = true;" + NL + "\t\t\t\t\t\tmarker[i+1] = true;" + NL + "\t\t\t\t\t\t++i;" + NL + "\t\t\t\t\t} else { //if not - add the number and the first operator only" + NL + "\t\t\t\t\t\tif(i > 0 && marker[i-1] == false) {" + NL + "\t\t\t\t\t\t\tfinal_expression += tokens[i-1];" + NL + "\t\t\t\t\t\t\tmarker[i-1] = true;\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tfinal_expression +=  tokens[i];" + NL + "\t\t\t\t\t\tmarker[i] = true;" + NL + "\t\t\t\t\t\t//check if the parentheses are closed or opened " + NL + "\t\t\t\t\t\tif(parenthesis_left == true && parenthesis_right == false){" + NL + "\t\t\t\t\t\t\tfinal_expression +=  tokens[i+1];" + NL + "\t\t\t\t\t\t\tmarker[i+1] = true;" + NL + "\t\t\t\t\t\t\tparenthesis_left = false; " + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} else {\t\t\t\t" + NL + "\t\t\t\t\tif(false){" + NL + "\t\t\t\t\t\t//do nothing" + NL + "\t\t\t\t\t}";
  protected final String TEXT_2 = NL + "\t\t\t\t\telse if(tokens[i].equals(\"^\")) {" + NL + "\t\t\t\t\t\tfinal_expression += \"Math.pow(\" + tokens[i-1] + \",\" + tokens[i+1] + \")\";" + NL + "\t\t\t\t\t\tmarker[i-1] = true;" + NL + "\t\t\t\t\t\tmarker[i] = true;" + NL + "\t\t\t\t\t\tmarker[i+1] = true;" + NL + "\t\t\t\t\t}";
  protected final String TEXT_3 = NL + "\t\t\t\t\telse if(tokens[i].equals(\"e\")) {" + NL + "\t\t\t\t\t\tfinal_expression += \"Math.exp(\" + tokens[i+1] + \")\";" + NL + "\t\t\t\t\t\tmarker[i] = true;" + NL + "\t\t\t\t\t\tmarker[i+1] = true;" + NL + "\t\t\t\t\t}";
  protected final String TEXT_4 = NL + "\t\t\t\t\telse if(tokens[i].equals(\"s\")) {" + NL + "\t\t\t\t\t\tfinal_expression += \"Math.sqrt(\" + tokens[i+1] + \")\";" + NL + "\t\t\t\t\t\tmarker[i] = true;" + NL + "\t\t\t\t\t\tmarker[i+1] = true;" + NL + "\t\t\t\t\t}";
  protected final String TEXT_5 = NL + "\t\t\t\t\telse if(tokens[i].equals(\"~\")) {" + NL + "\t\t\t\t\t\tfinal_expression += \"Math.abs(\";" + NL + "\t\t\t\t\t\tif(tokens[i+1].equals(\"-\") ||tokens[i+1].equals(\"+\")) {" + NL + "\t\t\t\t\t\t\tfinal_expression += tokens[i+1] + tokens[i + 2] + \")\";" + NL + "\t\t\t\t\t\t\tmarker[i] = true;" + NL + "\t\t\t\t\t\t\tmarker[i+1] = true;\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\tmarker[i+2] = true;" + NL + "\t\t\t\t\t\t\ti++;" + NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\tfinal_expression += tokens[i+1] + \")\";" + NL + "\t\t\t\t\t\t\tmarker[i+1] = true;\t" + NL + "\t\t\t\t\t\t\tmarker[i] = true;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}";
  protected final String TEXT_6 = NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t// if the last element is not added" + NL + "\t\tif(marker[i - 1] == false)" + NL + "\t\t\tfinal_expression += tokens[i - 1];" + NL + "\t\treturn final_expression;" + NL + "\t}" + NL + "\t" + NL + "\tpublic boolean isArithmetic(String ops) {" + NL + "\t\tString operators []= {\"+\", \"-\", \"*\", \"/\"};" + NL + "\t\tboolean exists = false;" + NL + "\t\tfor(int i = 0; i < operators.length; i++) {" + NL + "\t\t\tif(operators[i].equals(ops)) {" + NL + "\t\t\t\texists = true;" + NL + "\t\t\t\tbreak;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn exists;" + NL + "\t}" + NL + "\t" + NL + "\tpublic boolean isNumber(String exp) {" + NL + "\t\t if (exp.matches(\"([0-9]+(\\\\.[0-9]+)?)+\")) " + NL + "             return true;" + NL + "\t\t else" + NL + "\t\t\t return false;" + NL + "\t}" + NL + "" + NL + "}";
  protected final String TEXT_7 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     CalculatorModel model = (CalculatorModel) argument; 
    stringBuffer.append(TEXT_1);
    if(model.getOperations().contains(Operation.POW)){
    stringBuffer.append(TEXT_2);
    }
    if(model.getOperations().contains(Operation.EXP)){
    stringBuffer.append(TEXT_3);
    }
    if(model.getOperations().contains(Operation.SQRT)){
    stringBuffer.append(TEXT_4);
    }
    if(model.getOperations().contains(Operation.ABS)){
    stringBuffer.append(TEXT_5);
    }
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}

package edu.bth.spla.calculator.code.java;

import edu.bth.spla.calculator.model.*;

public class TBuild
{
  protected static String nl;
  public static synchronized TBuild create(String lineSeparator)
  {
    nl = lineSeparator;
    TBuild result = new TBuild();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<project name=\"spl.calculator\" basedir=\"./\" default=\"createJar\">" + NL + "\t<property name=\"srcDir\" value=\"src\" />" + NL + "\t<property name=\"compileDir\" value=\"classes\" />" + NL + "\t<property name=\"deployDir\" value=\"deploy\" />" + NL + "\t<property name=\"libFile\" value=\"calculator.jar\" />" + NL + "\t<property name=\"libs.project\" value=\"bsh-2.0b4.jar\" />" + NL + "" + NL + "\t<target name=\"clean\">" + NL + "\t\t<delete dir=\"classes\" />" + NL + "\t</target>" + NL + "" + NL + "\t<target name=\"compile\" depends=\"clean\">" + NL + "\t\t<mkdir dir=\"${compileDir}\" />" + NL + "\t\t<javac destdir=\"${compileDir}\" srcdir=\"${srcDir}\" classpath=\"${libs.project}\" fork=\"true\" debug=\"true\" includes=\"\">\t" + NL + "\t\t</javac>" + NL + "\t\t<copy verbose=\"true\" todir=\"${compileDir}\" >" + NL + "\t\t\t<fileset dir=\"${srcDir}\">" + NL + "\t\t\t<include name=\"**/*.properties\" />" + NL + "\t\t\t</fileset>" + NL + "\t\t</copy>" + NL + "\t</target>" + NL + "" + NL + "\t<target name=\"createJar\" depends=\"compile\">" + NL + "\t\t<jar destfile=\"${libFile}\" basedir=\"classes\">" + NL + "\t\t\t<manifest>" + NL + "\t\t\t\t<attribute name=\"Main-Class\" value=\"com.spl.gui.Calculator\" />" + NL + "\t\t\t\t<!-- finally, use the magically generated libs path -->" + NL + "\t\t\t\t<attribute name=\"Class-Path\" value=\"${libs.project}\" />" + NL + "\t\t\t</manifest>" + NL + "\t\t</jar>" + NL + "\t\t<delete dir=\"${compileDir}\"/>" + NL + "\t\t<!--" + NL + "\t\t<exec executable=\"java\" >" + NL + "\t\t\t<arg value=\"-jar\"/>" + NL + "\t\t\t<arg value=\"${deployDir}/${libFile}\"/>" + NL + "\t\t</exec>" + NL + "\t\t-->" + NL + "\t</target>" + NL + "</project>";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     CalculatorModel model = (CalculatorModel) argument; 
    stringBuffer.append(TEXT_1);
    return stringBuffer.toString();
  }
}

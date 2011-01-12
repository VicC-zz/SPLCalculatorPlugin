package edu.bth.spla.calculator.code.java;

import edu.bth.spla.calculator.model.*;

public class TImagePanel
{
  protected static String nl;
  public static synchronized TImagePanel create(String lineSeparator)
  {
    nl = lineSeparator;
    TImagePanel result = new TImagePanel();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package com.spl.gui;" + NL + "" + NL + "import java.awt.Graphics;" + NL + "import java.awt.image.BufferedImage;" + NL + "import java.io.File;" + NL + "import java.io.IOException;" + NL + "" + NL + "import javax.imageio.ImageIO;" + NL + "import javax.swing.JPanel;" + NL + "" + NL + "public class ImagePanel extends JPanel{" + NL + "" + NL + "    private BufferedImage image;" + NL + "" + NL + "    public ImagePanel(String img) {" + NL + "    \tif (img != null) {" + NL + "\t       try {                " + NL + "\t          image = ImageIO.read(new File(img));" + NL + "\t       } catch (IOException ex) {" + NL + "\t            // handle exception..." + NL + "\t       }" + NL + "    \t}" + NL + "    }" + NL + "" + NL + "    @Override" + NL + "    public void paintComponent(Graphics g) {" + NL + "        g.drawImage(image, 0, 0, null); // see javadoc for more info on the parameters" + NL + "    }" + NL + "" + NL + "}";
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

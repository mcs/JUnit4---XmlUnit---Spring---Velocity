package learning;

import static org.custommonkey.xmlunit.XMLAssert.*;

import org.custommonkey.xmlunit.XMLUnit;
import org.junit.Test;

/**
 * Some learning examples how XMLUnit works.
 * 
 * @author Marcus Krassmann
 */
public class XmlUnitTest {
  
  @Test
  public void compareIdenticalXmlStrings() throws Exception {
    String xml1 = "<root><node>Test</node></root>";
    String xml2 = "<root><node>Test</node></root>";
    XMLUnit.setIgnoreWhitespace(false);

    assertXMLEqual(xml1, xml2);
  }

  @Test
  public void compareSimilarXmlStringsWithoutTolerance() throws Exception {
    String xml1 = "<root><node>Test</node></root>";
    String xml2 = "<root>\n  <node>Test</node>\n</root>";
    XMLUnit.setIgnoreWhitespace(false);

    assertXMLNotEqual(xml1, xml2);
  }

  @Test
  public void compareSimilarXmlStringsIgnoringWhitespace() throws Exception {
    String xml1 = "<root><node>Test</node></root>";
    String xml2 = "<root>\n  <node> Test </node>\n</root>";
    XMLUnit.setIgnoreWhitespace(true);

    assertXMLEqual(xml1, xml2);
  }

  @Test
  public void compareDifferentXmlStringsIgnoringWhitespace() throws Exception {
    String xml1 = "<root><node>Test</node></root>";
    String xml2 = "<root><node>Te st</node></root>";
    XMLUnit.setIgnoreWhitespace(true);

    assertXMLNotEqual(xml1, xml2);
  }
}

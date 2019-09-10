package formatters;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FindFormatterTest
{
  @Test
  public void testFindToFind()
  {
    String inputFile="files/input/find_test_file_in.txt";

    String outputFile="files/output/find_out.txt";

    String comparisonFile="files/comparison/find_test_file_out.txt";

    String output=Util.format(inputFile);

    Util.writeOutput(output, outputFile);

    boolean test=Util.fileComparator(outputFile, comparisonFile);

    assertTrue(test);

  }

  @Test
  public void testFindToPyton()
  {
    String inputFile="files/input/find_test_file_in.txt";

    String outputFile="files/output/pyton_out.txt";

    String comparisonFile="files/comparison/pyton_test_file_out.txt";

    String output=Util.format(inputFile, "pyton");

    Util.writeOutput(output, outputFile);

    boolean test=Util.fileComparator(outputFile, comparisonFile);

    assertTrue(test);

  }

  @Test
  public void testFindToXml()
  {
    String inputFile="files/input/find_test_file_in.txt";

    String outputFile="files/output/xml_out.txt";

    String comparisonFile="files/comparison/xml_test_file_out.txt";

    String output=Util.format(inputFile, "xml");

    Util.writeOutput(output, outputFile);

    boolean test=Util.fileComparator(outputFile, comparisonFile);

    assertTrue(test);

  }

  @Test
  public void testFindToAcm1()
  {
    String inputFile="files/input/find_test_file_in.txt";

    String outputFile="files/output/acm1_out.txt";

    String comparisonFile="files/comparison/acm1_test_file_out.txt";

    String output=Util.format(inputFile, "acm1");

    Util.writeOutput(output, outputFile);

    boolean test=Util.fileComparator(outputFile, comparisonFile);

    assertTrue(test);

  }

  @Test
  public void testFindToAcm2()
  {
    String inputFile="files/input/find_test_file_in.txt";

    String outputFile="files/output/acm2_out.txt";

    String comparisonFile="files/comparison/acm2_test_file_out.txt";

    String output=Util.format(inputFile, "acm2");

    Util.writeOutput(output, outputFile);

    boolean test=Util.fileComparator(outputFile, comparisonFile);

    assertTrue(test);

  }

  @Test
  public void testFindToAcm3()
  {
    String inputFile="files/input/find_test_file_in.txt";

    String outputFile="files/output/acm3_out.txt";

    String comparisonFile="files/comparison/acm3_test_file_out.txt";

    String output=Util.format(inputFile, "acm3");

    Util.writeOutput(output, outputFile);

    boolean test=Util.fileComparator(outputFile, comparisonFile);

    assertTrue(test);

  }
}

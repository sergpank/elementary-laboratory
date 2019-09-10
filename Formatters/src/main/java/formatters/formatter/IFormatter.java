package formatters.formatter;

import formatters.graph.FileGraph;

import java.util.Scanner;

public interface IFormatter
{
  public abstract FileGraph  parse(Scanner sc);
  public abstract String format(FileGraph g);
}

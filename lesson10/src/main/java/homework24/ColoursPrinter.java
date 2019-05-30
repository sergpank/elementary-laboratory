package homework24;

import homework24.htmlHelper.*;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
* Извиняйте за много букв - увлекся.
* html файлы шаблона и готового представления в папке html
* до тестов руки не дошли
* */

public class ColoursPrinter
{
  private static final String BODY_MARKER = "@body";

  private static final int MAX_COLOR_VALUE = 255;

  private static final int MIN_COLOR_VALUE = 0;

  private static final int COLOR_INKREMENT = 1;

  public enum Rgb
  {
    RED,
    GREEN,
    BLUE;
  }

  public static void main(String[] args)
  {
    String template = readTemplate("html/template.html");

    HtmlItem container = buildColorTable();

    String view = prepareView(template, container.toString());

    writeView("html/view.html", view);

  }


  /**
   * Метод читает шаблон html страницы из файла
   * @param path путь к шаблону
   * @return строка, содержащая шаблон
   */
  public static String readTemplate(String path)
  {
    File file = new File(path);
    StringBuilder sb = new StringBuilder();

    if (file.exists())
    {
      try (BufferedReader reader = new BufferedReader(new FileReader(file)))
      {
        char[] buffer = new char[100];
        int count = 0;
        while ((count = reader.read(buffer)) != -1)
        {
          sb.append(buffer, 0, count);
        }
      }
      catch (IOException ex)
      {
        ex.printStackTrace();
      }
    }

    return new String(sb);
  }

  /**
   * Метод записывает в файл готовую html страницу
   * @param destinationPath путь к фалу
   * @param view строка, содержащая готовую html страницу
   */
  public static void writeView(String destinationPath, String view)
  {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(destinationPath)))
    {
      writer.write(view);
    }
    catch (IOException ex)
    {
      ex.printStackTrace();
    }
  }

  /**
   * Метод создаёт готовую html страницу из шаблона и фрагмента, содержащего таблицу цветовых оттенков
   * @param template строка, содержащая шаблон
   * @param html строка, содержащая сгенерированную разметку
   * @return строка, содержащая готовую html страницу
   */
  public static String prepareView(String template, String html)
  {
    Pattern ptn = Pattern.compile(BODY_MARKER);
    Matcher matcher = ptn.matcher(template);
    return matcher.replaceFirst(html);
  }

  /**
   * Метод создаёт колонку оттенков одного из цветов
   * @param color соответствующий объект перечисления Rgb
   * @return объект класса, инкапсулирующий сответствующий html-элемент
   */
  public static HtmlItem buildColumn(Rgb color)
  {
    HtmlItem column = new HtmlItem(HtmlTag.DIV);

    column.addClasses("col");

    for (int colorValue = MIN_COLOR_VALUE; colorValue <= MAX_COLOR_VALUE; colorValue += COLOR_INKREMENT)
    {
      Colour value = null;

      switch (color)
      {
        case RED:
          value = new Colour(colorValue, 0, 0);
          break;

        case GREEN:
          value = new Colour(0, colorValue, 0);
          break;

        case BLUE:
          value = new Colour(0, 0, colorValue);
          break;
      }

      HtmlItem item = buildColorfulItem(value);

      column.addChildren(item);
    }

    return column;
  }

  /**
   * Метод создаёт элемент, содержащий определенный цвет
   * @param value цвет элемента, инкапсулированный в классе Colour
   * @return объект класса, инкапсулирующий сответствующий html-элемент
   */
  public static HtmlItem buildColorfulItem(Colour value)
  {
    HtmlItem item = new HtmlItem(HtmlTag.DIV);

    item.addClasses("item");

    item.setStyle("background-color", value);

    return item;
  }

  /**
   * Метод создаёт таблицу оттенков красного, зеленого и синего цветов
   * @return объект класса, инкапсулирующий корневой html-элемент таблицы
   */
  public static HtmlItem buildColorTable()
  {
    HtmlItem container = new HtmlItem(HtmlTag.DIV);

    container.addClasses("container");

    for (Rgb color : Rgb.values())
    {
      HtmlItem column = buildColumn(color);

      container.addChildren(column);
    }

    return container;
  }


}


package homework_36;

import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import homework_36.entity.*;

public class App
{
    public static void main( String[] args ) throws IOException
    {
        String filePath="files/100000 Records.csv";

        double medianSalary=getMedianSalary(filePath, e->true);

        double medianSalaryForMen=getMedianSalary(filePath, e->e.getGender().equals("M"));

        double medianSalaryForWomen=getMedianSalary(filePath, e->e.getGender().equals("F"));

        double truncatedAverage_5=getTruncatedMeanSalary(filePath,0.05,e->true);

        double truncatedAverage_10=getTruncatedMeanSalary(filePath,0.1,e->true);

        double truncatedAverage_15=getTruncatedMeanSalary(filePath,0.15,e->true);

        double truncatedAverage_20=getTruncatedMeanSalary(filePath,0.2,e->true);

        double truncatedAverage_25=getTruncatedMeanSalary(filePath,0.25,e->true);

        IntSummaryStatistics ageSummary=getAgeSummaryStatistics(filePath);

        System.out.printf("Общая медианная зарплата: %.2f;\n", medianSalary);

        System.out.printf("Медианная зарплата среди мужчин: %.2f;\n",medianSalaryForMen);

        System.out.printf("Медианная зарплата среди женщин: %.2f;\n", medianSalaryForWomen);

        System.out.printf("Средняя усеченная зарплата (усечение - 5%%): %.2f;\n", truncatedAverage_5);

        System.out.printf("Средняя усеченная зарплата (усечение - 10%%): %.2f;\n", truncatedAverage_10);

        System.out.printf("Средняя усеченная зарплата (усечение - 15%%): %.2f;\n", truncatedAverage_15);

        System.out.printf("Средняя усеченная зарплата (усечение - 20%%): %.2f;\n", truncatedAverage_20);

        System.out.printf("Средняя усеченная зарплата (усечение - 25%%): %.2f;\n", truncatedAverage_25);

        System.out.printf("Минимальный возраст %d, максимальный возраст %d;\n",ageSummary.getMin(), ageSummary.getMax());

        for(int current=ageSummary.getMin(); current<ageSummary.getMax(); current+=5)
        {
            final int from=current;
            final int to=current+5<ageSummary.getMax()? current+5 : ageSummary.getMax();
            double medSalary=getMedianSalary(filePath, e->e.getAge()>=from && e.getAge()<to);
            System.out.printf("Медианная зарплата в диапазоне возрастов от %d до %d составляет: %.2f;\n",
                from, to, medSalary);
        }
    }

    public static double getMedianSalary(String filePath, Predicate<Employee> condition)
    {
        long count = getRecordCount(filePath, condition);

        int takeCount = 0;
        long skipCount = 0;

        if (count % 2 != 0)
        {
            skipCount = count / 2;
            takeCount = 1;
        }
        else
        {
            skipCount = count / 2 - 1;
            takeCount = 2;
        }

        Double[] values=getSortedSalaryArray(filePath, condition, skipCount, takeCount);

        return Arrays.stream(values).reduce(0d,(a, b) -> a + b) / values.length;
    }

    public static long getRecordCount(String filePath, Predicate<Employee> condition)
    {
        long result=0;
        try(EmployeeReader reader=new EmployeeReader(filePath))
        {
           result=reader.getEmployeesAsStream()
                .filter(condition).count();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }

    public static Double[] getSortedSalaryArray(String filePath, Predicate<Employee> condition, long skip, long take)
    {
        Double[] arr=null;

        try(EmployeeReader reader=new EmployeeReader(filePath))
        {
            arr=reader.getEmployeesAsStream()
                .filter(condition)
                .map(e->e.getSalary())
                .sorted()
                .skip(skip)
                .limit(take)
                .toArray(Double[]::new);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return arr;
    }


    public static double getTruncatedMeanSalary(String filePath, double discarded, Predicate<Employee> condition)
    {
        double result=0;
        long count = getRecordCount(filePath, condition);
        long skip=(long)(count*discarded);
        long take=count-(skip*2);

        Double[] arr0=getSortedSalaryArray(filePath, condition, 0, count);
        Double[] arr=getSortedSalaryArray(filePath, condition, skip, take);

        result=Arrays.stream(arr).reduce((a,b)->a+b).get()/arr.length;

        return result;
    }

    public static IntSummaryStatistics getAgeSummaryStatistics(String filePath)
    {
        IntSummaryStatistics result=null;
        try(EmployeeReader reader=new EmployeeReader(filePath))
        {
            result=reader.getEmployeesAsStream()
               .collect(Collectors.summarizingInt(e->e.getAge()));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return  result;
    }

}

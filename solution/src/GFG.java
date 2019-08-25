import java.util.*;
import java.lang.*;

class GFG
{
  public static void main(String[] args)
  {
    Scanner scanner = new Scanner(System.in);
    int T = scanner.nextInt();
    List<Edge> graf ;
    List<Map<Integer,List<Integer>>> mapList = new ArrayList<>();
    int countVertic;
    int countEdge;
        for (int i = 0; i < T; i++)
    {
      mapList.add(new HashMap());
      graf = new ArrayList<>();
      countVertic = scanner.nextInt();
      countEdge = scanner.nextInt();
      for (int j = 0; j < countEdge; j++)
      {
        graf.add(new Edge(scanner.nextInt(), scanner.nextInt()));
      }

      for (int j = 0; j < countVertic; j++)
      {
        mapList.get(i).put(j, new ArrayList<>());
        for (int k = 0; k < graf.size(); k++)
        {
          if (graf.get(k).contain(j))
          {
            mapList.get(i).get(j).add(graf.get(k).getVertic(j));
          }
        }
      }
    }
    for (int i = 0; i < mapList.size(); i++)
    {
      show(mapList.get(i),mapList.get(i).size());
    }
  }
  public static void show(Map<Integer,List<Integer>> map, int k){
    for (int i = 0; i < k; i++)
    {
      System.out.print(i);
      Iterator iterator = map.get(i).iterator();
      while (iterator.hasNext()){
        int b = (Integer) iterator.next();
        System.out.print( "-> " + b );
      }
      System.out.println();
    }
  }
  public static class Edge
  {
    private int v1;
    private int v2;

    public Edge(int v1, int v2)
    {
      this.v1 = v1;
      this.v2 = v2;
    }

    public boolean contain(int v){
      if (v1 == v || v2 == v) return true;
      else return false;
    }
    public int getVertic(int v){
      if (v == v1)return v2;
      else return v1;
    }
  }
}



package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
  @Test
  public void randomizedTest(){
      AListNoResizing<Integer> L = new AListNoResizing<>();
      BuggyAList<Integer> buggyAList = new BuggyAList();

      int N = 5000;
      for (int i = 0; i < N; i += 1) {
          int operationNumber = StdRandom.uniform(0, 4);
          if (operationNumber == 0) {
              // addLast
              int randVal = StdRandom.uniform(0, 100);
              L.addLast(randVal);
              buggyAList.addLast(randVal);
              // System.out.println("addLast(" + randVal + ")");
          } else if (operationNumber == 1) {
              // size
              int size = L.size();
              int bSize = buggyAList.size();
//              System.out.println("size: " + size);
//              System.out.println("bSize: " + bSize);
              assertEquals(size, bSize);
          } else if (operationNumber == 2) {
              // getLast
              int size = L.size();
              int bSize = buggyAList.size();
              if (size == 0 || bSize == 0) {
                  continue;
              }
//              System.out.println("getLast: " + L.getLast());
//              System.out.println("getLast: " + buggyAList.getLast());
              assertEquals(L.getLast(), buggyAList.getLast());
          } else if (operationNumber == 3) {
              // removeLast
              int size = L.size();
              int bSize = buggyAList.size();
              if (size == 0 || bSize == 0) {
                  continue;
              }
              int l1 = L.removeLast();
              int l2 = buggyAList.removeLast();
//              System.out.println("removeLast: " + l1);
//              System.out.println("removeLast: " + l2);
              assertEquals(l1, l2);
          }
      }
  }
}

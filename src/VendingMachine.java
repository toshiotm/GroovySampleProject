import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


/**
 * Created with IntelliJ IDEA.
 * User: kyon
 * Date: 12/06/02
 * Time: 12:51
 * To change this template use File | Settings | File Templates.
 */
public class VendingMachine {

    private ArrayList<Integer> maneyList;

    private Integer total = new Integer(0);

    private Map<String, Queue<Juice>> stockMap = new HashMap<String, Queue<Juice>>();

    public VendingMachine() {

        // ‹–‰Â‚·‚é‚¨‹à‚Ìí—Ş
        maneyList = new ArrayList<Integer>();
        maneyList.add(10);
        maneyList.add(50);
        maneyList.add(100);
        maneyList.add(1000);


        // ‰Šú‚ÌİŒÉ
        Queue<Juice> queue = new LinkedList<Juice>();
        Coke coke = new Coke();
        queue.add(coke);

        stockMap.put(coke.getName(), queue);
    }

    public Integer getTotal() {
        return total;
    }

    public int in(int maney) {

        if (maneyList.contains(maney)) {
             total += maney;
             return 0;
        } else {
            return maney;
        }
    }

    public Integer getChange() {

        int change = total;
        total = 0;

        return change;
    }


    public List<String> getNames() {
        return new ArrayList<String>(stockMap.keySet());
    }


    public Collection<Queue<Juice>> getPrices() {
        return stockMap.values();
    }
}

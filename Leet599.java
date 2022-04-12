import java.util.*;

public class Leet599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int n1 = list1.length;
        int n2 = list2.length;

        List<String> str = new ArrayList<String>();
        for (int i = 0; i < n1; i++) {
            map.put(list1[i], i);
        }

        int min = 2000;
        for (int i = 0; i < n2; i++) {
            if (!map.containsKey(list2[i])) {
                continue;
            }
            if (map.get(list2[i]) + i < min) {
                str.clear();
                str.add(list2[i]);
            } else if (map.get(list2[i]) + i == min) {
                str.add(list2[i]);
            }
        }
        return str.toArray(new String[str.size()]);
    }
}

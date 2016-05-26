package surveyor.client.collection;

import java.util.HashMap;

public class HashMap2D {

    private HashMap<String, HashMap> outerMap;

    public HashMap2D() {
        outerMap = new HashMap<>();
    }

    public void addElement(String key1, String key2, Object value) {
        HashMap innerMap = outerMap.get(key1);
        if (innerMap == null) {
            innerMap = new HashMap<>();
            outerMap.put(key1, innerMap);
        }
        innerMap.put(key2, value);
    }

    public Object getElement(String key1, String key2) {
        HashMap innerMap = outerMap.get(key1);
        if (innerMap == null) {
            return null;
        }
        return innerMap.get(key2);
    }

    public void clear() {
        outerMap.clear();
    }
}

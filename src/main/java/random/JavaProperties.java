package random;

import java.util.*;

public class JavaProperties {
    public static void main(String[] args) {
        Properties properties = System.getProperties();
        TreeMap<String, String> propMap = new TreeMap<>();
        for (final String propName : properties.stringPropertyNames()) {
            propMap.put(propName, properties.getProperty(propName));
        }
        for (Map.Entry<String, String> entry : propMap.entrySet()) {
            System.out.println(entry.getKey() +  ": " + entry.getValue());
        }
    }
}

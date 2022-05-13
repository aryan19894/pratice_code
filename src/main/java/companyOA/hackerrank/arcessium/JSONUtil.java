package companyOA.hackerrank.arcessium;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import companyOA.hackerrank.arcessium.model.Person;
import companyOA.hackerrank.arcessium.wrapper.HybridMap;
import pratice.tutorial.durgasir.class2.P;

import java.beans.PropertyDescriptor;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class JSONUtil {
    private static final String restURL = "https://raw.githubusercontent.com/arcjsonapi/ApiSampleData/master/api/users";

    public static List<Integer> apiResponseParser(List<String> inputList, int size) throws Exception {
        String jsonResponse = fetchAPI(restURL);
        Person[] persons = toModel(jsonResponse);
        HybridMap map = toModelMap(persons);

        String attr = inputList.get(0);
        String[] keyword = inputList.get(2).split(",");
        List<Integer> result = new ArrayList();
        for (String k : keyword)
            result.add(map.get(attr).getOrDefault(k, -1));

        return result;
    }

    private static String fetchAPI(String restURL) throws Exception {
        StringBuilder content = new StringBuilder();
        URL url = new URL(restURL);
        URLConnection conn = url.openConnection();
        InputStream response = conn.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(response));

        String line;
        while ((line = br.readLine()) != null) {
            content.append(line);
        }

        br.close();
        return content.toString();
    }

    public static Person[] toModel(String jsonResponse) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        return (Person[]) gson.fromJson(jsonResponse, Person[].class);
    }

    public static HybridMap toModelMap(Person[] persons) throws Exception {
        HybridMap map = new HybridMap();
        for(Person p: persons){
            Class personClass = p.getClass();
            populateAttr(map, personClass, "", p, p.getId());
        }
        return map;
    }

    private static void populateAttr(HybridMap map, Class cls, String parentAttr, Object obj, int personId) throws Exception {
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            String fName = field.getName();
            if (!fName.equals("id")) {
                if (isClass(field.getType())) {
                    populateAttr(map, field.getType(), fName, getVal(obj, fName), personId);
                } else {
                    map.put(parentAttr + (parentAttr == "" ? "" : ".") + fName, getVal(obj, fName), personId);
                }
            }
        }
    }

    private static boolean isClass(Class<?> type) {
        String t = type.toString();
        return !t.endsWith("String") && t.startsWith("class");
    }

    public static Object getVal(Object obj, String variableName) throws Exception {
        if (obj == null) {
            return null;
        } else {
            PropertyDescriptor pd = new PropertyDescriptor(variableName, obj.getClass());
            Method getter = pd.getReadMethod();
            return getter.invoke(obj);
        }
    }
}

package companyOA.hackerrank.arcessium;

import pratice.common.Out;

import java.util.ArrayList;
import java.util.List;

public class FilterJSONApp {
    public static void main(String[] args) throws Exception {
        List<String> input = new ArrayList();
        input.add("address.city");
        input.add("EQUALS");
        input.add("Tom");
        Out.print(JSONUtil.apiResponseParser(input, input.size()));
    }
}

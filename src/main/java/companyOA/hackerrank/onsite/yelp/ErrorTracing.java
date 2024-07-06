package companyOA.hackerrank.onsite.yelp;

import lombok.Getter;
import lombok.Setter;
import org.json.JSONArray;
import org.json.JSONObject;
import pratice.common.Out;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter
class Trace {
    private String traceId;
    private String parentTraceId;
    private Long statusCode;

    Trace(JSONObject jsonTrace) {
        this.traceId = (String) jsonTrace.get("trace_id");
        Object obj = jsonTrace.get("parent_trace_id");
        this.parentTraceId = !obj.toString().equals("null") ? (String) obj : null;
        this.statusCode = ((Number) jsonTrace.get("status_code")).longValue();
    }

    public boolean isTraceable() {
        return this.getStatusCode() >= 500;
    }
}

@Getter
@Setter
class TraceNode {
    private Trace trace;
    private TraceNode child;

    public TraceNode(Trace trace, TraceNode child) {
        this.trace = trace;
        this.child = child;
    }
}

public class ErrorTracing {

    private static List<String> getListOfFinalTraceIds(List<Trace> traces) {
        HashMap<String, TraceNode> traceMap = new HashMap<>();

        for (Trace t : traces) {
            if (t.isTraceable()) {
                TraceNode child = traceMap.getOrDefault(t.getTraceId(), new TraceNode(t, null));
                TraceNode parent = traceMap.getOrDefault(t.getParentTraceId(), new TraceNode(null, null));

                parent.setChild(child);
                child.setTrace(t);

                traceMap.put(t.getTraceId(), child);
                traceMap.put(t.getParentTraceId(), parent);
            }
        }

        List<TraceNode> traceNodesList = new ArrayList<>();
        for (TraceNode tn : traceMap.values()) {
            if (tn.getTrace() != null && tn.getTrace().getParentTraceId() == null)
                traceNodesList.add(tn);
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < traceNodesList.size(); i++) {
            TraceNode t = traceNodesList.get(i);
            while (t.getChild() != null) t = t.getChild();
            result.add(t.getTrace().getTraceId());
        }

        return result;
    }

    public static void main(String[] args) {
//        String jsonString = new BufferedReader(new InputStreamReader(System.in))
//                .lines().collect(Collectors.joining("\n"));

        JSONArray jsonTraces = new JSONArray(data);
        List<Trace> traces = new ArrayList<>();
        for (int i = 0; i < jsonTraces.length(); i++)
            traces.add(new Trace(jsonTraces.getJSONObject(i)));

        List<String> finalTraces = getListOfFinalTraceIds(traces);
        Out.print(finalTraces);
    }

    private static final String data = "[\n" +
            "  {\n" +
            "    \"trace_id\": \"count.dark.allows\",\n" +
            "    \"parent_trace_id\": null,\n" +
            "    \"status_code\": 500\n" +
            "  },\n" +
            "  {\n" +
            "    \"trace_id\": \"native.vest.funded\",\n" +
            "    \"parent_trace_id\": \"count.dark.allows\",\n" +
            "    \"status_code\": 500\n" +
            "  },\n" +
            "  {\n" +
            "    \"trace_id\": \"makes.boss.hint\",\n" +
            "    \"parent_trace_id\": null,\n" +
            "    \"status_code\": 200\n" +
            "  },\n" +
            "  {\n" +
            "    \"trace_id\": \"plans.itself.pine\",\n" +
            "    \"parent_trace_id\": \"makes.boss.hint\",\n" +
            "    \"status_code\": 200\n" +
            "  },\n" +
            "  {\n" +
            "    \"trace_id\": \"plus.orange.hammer\",\n" +
            "    \"parent_trace_id\": null,\n" +
            "    \"status_code\": 500\n" +
            "  }\n" +
            "]";
}

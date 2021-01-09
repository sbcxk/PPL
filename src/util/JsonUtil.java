package util;

import domain.Category;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import java.util.List;

public class JsonUtil {

    public static String list2json(List<Category> list) {
        JSONArray jsonArray=JSONArray.fromObject(list);
        return jsonArray.toString();
    }


    public static String array2json(Object[] objects) {
        JSONArray jsonArray=JSONArray.fromObject(objects);
        return jsonArray.toString();
    }


    public static JsonConfig configJson(String[] excludes) {
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(excludes);
        jsonConfig.setIgnoreDefaultExcludes(true);
        jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
        return jsonConfig;
    }
}

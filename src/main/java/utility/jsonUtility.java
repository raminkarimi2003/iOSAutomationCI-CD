package utility;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONException;
import org.json.JSONObject;

public class jsonUtility {
	public static JSONObject getJson(String path) throws JSONException, IOException {
	  return new JSONObject(new String(Files.readAllBytes(Paths.get(path))));
	}

}

package $17_MockingSolutionStubs;

import org.apache.commons.lang3.StringUtils;

import com.jayway.jsonpath.JsonPath;

import spark.Spark;

public class $02_CreateApiMockUsingSpark {
    public static void main(String[] args) {
		Spark.port(8889);
		Spark.post("/credit-card", (req,res)->{
			String response = "";
			String card = JsonPath.read(req.body().toString(), "$.creditcard");
//			if(card.equals("1234567891234")) //for the  single value;
			if(StringUtils.equalsAny(card, "1234567891234","1234567891235")) {
				response = "{ \"status\" : \"Payment Success\"}";
				res.status(200);
			}else {
				response = "{ \"status\" : \"Payment Success\"}";
				res.status(404);
			}
			res.type("application/json");
			return response;
		});
		
		System.out.println("++++++++++++++Running++++++++++++++");
	}
}

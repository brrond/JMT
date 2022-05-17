package ua.kharkov.kpi.jmt.xmath;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.io.StringReader;

public final class XMathApiClient {
    private static final String BASE_API_URL = "https://x-math.herokuapp.com/api/";

    private static final String ADD = BASE_API_URL + "add/";
    private static final String SUB = BASE_API_URL + "sub/";
    private static final String MUL = BASE_API_URL + "mul/";
    private static final String DIV = BASE_API_URL + "div/";
    private static final String RANDOM = BASE_API_URL + "random/";

    public static Expression getRandomExpression() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(RANDOM);

        Invocation invocation = target.request().buildGet();
        Response response = invocation.invoke();
        String body = response.readEntity(String.class);

        JsonReader jsonReader = Json.createReader(new StringReader(body));
        return ExpressionFactory.getExpression(jsonReader.readObject());
    }

    public static JsonObject constructQuery(Character operation,
                                            Integer minFirst, Integer maxFirst,
                                            Integer minSecond, Integer maxSecond) {
        Client client = ClientBuilder.newClient();
        WebTarget target;
        switch (operation) {
            case '+': target = client.target(ADD); break;
            case '*': target = client.target(MUL); break;
            case '-': target = client.target(SUB); break;
            case '/': target = client.target(DIV); break;
            default: target = client.target(RANDOM);
        }

        Invocation invocation = target.queryParam("minFirst", minFirst)
                .queryParam("maxFirst", maxFirst)
                .queryParam("minSecond", minSecond)
                .queryParam("maxSecond", maxSecond).request().buildGet();
        Response response = invocation.invoke();
        String body = response.readEntity(String.class);

        JsonReader jsonReader = Json.createReader(new StringReader(body));

        return jsonReader.readObject();
    }

}

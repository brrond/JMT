package ua.kharkov.kpi.jmt.xmath;

import javax.json.JsonObject;

public final class ExpressionFactory {

    public static Expression getSimpleExpression() {
        return getExpression(XMathApiClient.constructQuery('r', -20, 20, -20, 20));
    }

    public static Expression getComplexExpression() {
        return getExpression(XMathApiClient.constructQuery('r', -100, 100, -100, 100));
    }

    public static Expression getExpression(JsonObject jsonObject) {
        Expression expression = new Expression();
        expression.setFirst(jsonObject.getInt("first"));
        expression.setSecond(jsonObject.getInt("second"));
        expression.setOperation(jsonObject.getString("operation"));
        expression.setAnswer(jsonObject.getInt("answer"));
        expression.setExpression(jsonObject.getString("expression"));
        return expression;
    }
}

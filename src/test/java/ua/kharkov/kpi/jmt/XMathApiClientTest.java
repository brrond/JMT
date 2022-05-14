package ua.kharkov.kpi.jmt;

import org.junit.jupiter.api.Test;
import ua.kharkov.kpi.jmt.model.Expression;

import static org.junit.jupiter.api.Assertions.*;

class XMathApiClientTest {

    /**
     * This test demonstrates how API and APIClient work
     */
    @Test
    void getRandomExpression() {
        for (int i = 0; i < 10; i++) {
            Expression expression = XMathApiClient.getRandomExpression();
            Integer f = expression.getFirst();
            Integer s = expression.getSecond();
            Integer res = null;
            switch (expression.getOperation()) {
                case "+": res = f + s; break;
                case "-": res = f - s; break;
                case "*": res = f * s; break;
                case "/": res = f / s; break;
            }

            assertEquals(expression.getAnswer(), res);
        }
    }
}
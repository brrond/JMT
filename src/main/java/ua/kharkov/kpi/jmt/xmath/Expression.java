package ua.kharkov.kpi.jmt.xmath;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Expression {
    private Integer first;
    private Integer second;
    private String operation;
    private String expression;
    private Integer answer;
}

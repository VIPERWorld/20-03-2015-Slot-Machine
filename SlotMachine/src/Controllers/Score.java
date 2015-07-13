/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.math.BigDecimal;

/**
 *
 * @author Loek
 */
public class Score {

    private BigDecimal money;

    public Score() {
        money = new BigDecimal("5.00");
    }

    @Override
    public String toString() {
        return money.toPlainString();
    }

    public void changeMoney(String string) {
        BigDecimal change = new BigDecimal(string);
        money = money.add(change);
    }

    public boolean hasMoney() {
        return money.floatValue() > 0.00;
    }

}

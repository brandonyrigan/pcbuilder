package com.pcbuilder.checkout;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    private Order order;
    private Map<String, String> testPrices;

    @BeforeEach
    void setUp() {
        order = new Order();
        testPrices = new HashMap<>();
        testPrices.put("1", "name1,129023,50.99");
        testPrices.put("2", "name2,902348,239.95");
        testPrices.put("3", "name3,233849,390.23");
    }

    @Test
    void testCalcTotalFromSubTotals_Returns_Total_Price_From_All_Map_Values() {
        Double expected = 0.0;
        expected = 50.99 + 239.95 + 390.23;

        Double actual = order.calcTotalFromSubTotals(testPrices);

        assertEquals(expected, actual, .01);
    }

    @Test
    void testCreateShoppingCartSubTotal_Returns_Map_With_String_And_Double_From_String_Map() {
        Map<String, Double> expected = new HashMap<>();
        expected.put("name1", 50.99);
        expected.put("name2", 239.95);
        expected.put("name3", 390.23);

        Map<String, Double> actual = order.createShoppingCartSubTotal(testPrices);

        assertEquals(expected, actual);
    }
}
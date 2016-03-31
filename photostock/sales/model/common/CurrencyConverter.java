package pl.com.bottega.photostock.sales.model.common;

/**
 * Sergej Povzaniuk
 * 2016-03-30.
 */
public class CurrencyConverter {

    private static double changeRateUSDtoCredit = 8.0;

    public static double convertUSDToCradit(double priceInUSD){
        return priceInUSD * changeRateUSDtoCredit;
    }

    public static void setChangeRateUSDtoCredit(double changeRateUSDtoCredit) {
        CurrencyConverter.changeRateUSDtoCredit = changeRateUSDtoCredit;
    }

}

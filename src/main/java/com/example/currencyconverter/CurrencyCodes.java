package com.example.currencyconverter;

import java.util.Arrays;
import java.util.List;

public class CurrencyCodes {
    private static final List<String> SUPPORTED_CODES = Arrays.asList(
            "USD", "EUR", "GBP", "JPY", "AUD", "CAD", "CHF", "CNY", "HKD", "NZD", "SEK", "KRW", "SGD", "NOK", "MXN", "INR", "RUB", "ZAR", "TRY", "BRL", "TWD", "DKK", "PLN", "THB", "IDR", "HUF", "CZK", "ILS", "CLP", "PHP", "AED", "COP", "SAR", "MYR", "RON", "BGN", "HRK", "ISK", "KWD", "KZT", "QAR", "OMR", "JOD", "BHD", "PEN", "CRC", "LBP", "TND", "TZS", "UGX", "VND", "GHS", "NGN", "PKR", "EGP", "UZS", "LYD", "KES", "GTQ", "SYP", "LAK", "MAD", "BAM", "MMK", "MDL", "KHR", "LKR", "BDT", "MVR", "AWG", "GIP", "SHP", "FKP", "NAD", "LSL", "BZD", "SRD", "NGN", "AMD", "XDR", "BTN", "IRR", "IQD", "WON", "CUP", "CDF", "KMF", "DZD", "SDG", "RWF", "MGA", "KYD", "SOS", "CNY"
    );

    public static List<String> getSupportedCodes() {
        return SUPPORTED_CODES;
    }
}
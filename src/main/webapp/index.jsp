<%@ page import="com.example.currencyconverter.CurrencyCodes" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Currency Converter</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-blue-500">
<div>
    <div class="max-w-2x1 mx-auto my-96 w-1/2 rounded-3xl bg-white py-5 text-center shadow-xl">
        <h2 class="mx-6 border-b pb-2 text-center text-4xl font-semibold">Exchange Rate Calculator</h2>
        <h3 class="bg-red-300 text-red-900 font-semibold text-xl w-80 rounded-lg my-2 mx-auto" id="error"></h3>
        <div id="exchangeForm" class="mx-8 my-5 grid gap-4">
            <div class="mx-8 my-5 pb-5">
                <label for="amount" class="flex items-center text-xl"> Enter Amount: </label>
                <input class="w-full appearance-none rounded-lg border-2 border-blue-700 p-2 placeholder-blue-800 focus:outline-none focus:ring" type="number" min="0" id="amount" name="amount" required />
            </div>
            <label for="baseCurrency" class="flex items-center text-xl">Currency 1: </label>
            <select class="w-full appearance-none rounded-lg border-2 border-blue-700 p-1 placeholder-blue-800 focus:outline-none focus:ring" id="baseCurrency" name="baseCurrency" required>
                <% List<String> currencyCodes = CurrencyCodes.getSupportedCodes();
                    for (String code : currencyCodes) { %>
                <option value="<%= code %>"><%= code %></option>
                <% } %>
            </select><br />
            <label class="flex items-center text-xl" for="targetCurrency">Currency 2: </label>
            <select class="w-full appearance-none rounded-lg border-2 border-blue-700 p-1 placeholder-blue-800 focus:outline-none focus:ring" id="targetCurrency" name="targetCurrency" required>
                <% for (String code : currencyCodes) { %>
                <option value="<%= code %>"><%= code %></option>
                <% } %>
            </select>
        </div>
        <button class="rounded-lg m-8 bg-blue-300 px-4 py-1 text-xl font-semibold hover:bg-blue-800 hover:text-white" id="calculateBtn">Calculate</button>
        <p class="font-mono text-3xl text-green-600" id="result">Result: </p>
    </div>
</div>
<script>
    $(document).ready(function () {
        $('#calculateBtn').click(function (event) {
            event.preventDefault();
            var amount = $('#amount').val();
            var baseCurrency = $('#baseCurrency').val();
            var targetCurrency = $('#targetCurrency').val();
            $.ajax({
                type: 'POST',
                url: '/converter',
                data: {
                    amount: amount,
                    baseCurrency: baseCurrency,
                    targetCurrency: targetCurrency
                },
                success: function(response){
                    $('#result').text('Result: ' + response);
                },
                error: function () {
                    $('#error').text('An error occurred.');
                }
            });
        });
    });
</script>
</body>
</html>
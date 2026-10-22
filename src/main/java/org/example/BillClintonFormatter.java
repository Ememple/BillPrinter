package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class BillClintonFormatter
{
    private static final int WIDTH = 43;
    private static final int DPH_PERCENT = 21;

    private static final String ROW_FORMAT   = "| %-20s %3d x %8.2f CZK |%n";
    private static final String TOTAL_FORMAT = "| %-26s %8.2f CZK |%n";
    private static final String DPH_FORMAT   = "| %-26s %8.2f CZK |%n";
    private static final String DATE_FORMAT  = "| %-22s %16s |%n";

    private static final DateTimeFormatter DATE_TIME = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    public String format(List<BillItem> items)
    {
        var builder = new StringBuilder();
        var separator = "-".repeat(WIDTH) + System.lineSeparator();

        builder.append(title("The Bill")).append(System.lineSeparator());

        double total = 0;

        for (var item : items)
        {
            var product = item.getProduct();
            var price = item.getQuantity() * product.getPrice();
            total += price;

            builder.append(String.format(Locale.ROOT, ROW_FORMAT,
                    truncate(product.getName(), 20),
                    item.getQuantity(),
                    price));
        }

        var dph = total * DPH_PERCENT / (100 + DPH_PERCENT);

        builder.append(separator);
        builder.append(String.format(Locale.ROOT, TOTAL_FORMAT, "Total (bez DPH)", total));
        builder.append(String.format(Locale.ROOT, DPH_FORMAT, "z toho DPH " + DPH_PERCENT + " %", dph));
        builder.append(String.format(Locale.ROOT, TOTAL_FORMAT, "Total (vcetne DPH)", total + dph));
        builder.append(separator);
        builder.append(String.format(Locale.ROOT, DATE_FORMAT, "Datum", LocalDateTime.now().format(DATE_TIME)));
        builder.append("-".repeat(WIDTH));

        return builder.toString();
    }

    private static String title(String text)
    {
        var padded = " " + text + " ";
        var left = (WIDTH - padded.length()) / 2;
        return "-".repeat(left) + padded + "-".repeat(WIDTH - left - padded.length());
    }

    private static String truncate(String text, int max)
    {
        return text.length() <= max ? text : text.substring(0, max - 1) + "…";
    }
}
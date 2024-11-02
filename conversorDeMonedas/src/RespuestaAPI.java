import java.util.Map;

class RespuestaAPI {
    String result;
    String base_code;
    Map<String, Double> conversion_rates;

    @Override
    public String toString() {
        return
                "Moneda Base='" + base_code + '\n' +
                "Tasas de convercion=" + conversion_rates + "\n";
    }
}

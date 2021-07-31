package Service;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import Model.Stocks;

public class StocksService implements StockServiceInterface {
    @Override
    public JSONArray addStock(JSONArray jsonArray, Stocks stocks) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("StockName", stocks.getStockName());
        jsonObject.put("StockPrice", stocks.getStockPrice());
        jsonObject.put("StockQuantity", stocks.getStockQuantity());
        jsonArray.add(jsonObject);
        return jsonArray;
    }

    @Override
    public JSONArray updateStock(JSONArray jsonArray, String name, double price, double quantity) {
        JSONObject obj;
        for (int i = 0; i < jsonArray.size(); i++) {
            obj = (JSONObject) jsonArray.get(i);
            if (((String) obj.get("StockName")).equals(name)) {
                obj.replace("StockPrice", price);
                obj.replace("StockQuantity", quantity);
                break;
            }
        }
        return jsonArray;
    }

    @Override
    public JSONArray deleteStock(JSONArray jsonArray, String name) {
        JSONObject obj;
        for (int i = 0; i < jsonArray.size(); i++) {
            obj = (JSONObject) jsonArray.get(i);
            if (((String) obj.get("StockName")).equals(name)) {
                jsonArray.remove(i);
                break;
            }
        }
        return jsonArray;
    }
}

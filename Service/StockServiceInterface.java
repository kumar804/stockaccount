package Service;

import Model.Stocks;
import org.json.simple.JSONArray;

public interface StockServiceInterface {
    public abstract  JSONArray  addStock(JSONArray jsonArray, Stocks stocks);
    public abstract JSONArray updateStock(JSONArray jsonArray,String name, double price , double quantity);
    public abstract JSONArray deleteStock(JSONArray jsonArray,String name);
}

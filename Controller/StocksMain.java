package Controller;

import Model.Stocks;
import Service.StockServiceInterface;
import Service.StocksService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Scanner;

public class StocksMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StocksService stockService = new StocksService();
        JSONArray jsonArray = new JSONArray();
        StockAccount stockAccount = new StockAccount();
        int choice = 0;
        while (choice != 10) {

            System.out.println("1)Add Stock");
            System.out.println("2)View Stock");
            System.out.println("3)Update Stock");
            System.out.println("4)Delete Stock");
            System.out.println("5Total Value");
            System.out.println("5)Count Stock");
            System.out.println("6)Create an account");
            System.out.println("7)buy Stock");
            System.out.println("8)Sell Stock");
            System.out.println("9)display account info");
            System.out.println("10) Exit");
            choice = sc.nextInt();


            switch (choice) {
                case 1:
                    Stocks stocks = new Stocks();
                    System.out.println("Add stocks");
                    System.out.println("Enter the name");
                    String name = sc.next();
                    stocks.setStockName(name);
                    System.out.println("Enter the price ");
                    double price = sc.nextInt();
                    stocks.setStockPrice(price);
                    System.out.println("Enter the Quantity");
                    double quantity = sc.nextDouble();
                    stocks.setStockQuantity(quantity);

                    jsonArray = stockService.addStock(jsonArray,stocks);
                    System.out.println(jsonArray);
                    break;
                case 2:
                    System.out.println("View stocks");
                    System.out.println(jsonArray);

                    break;
                case 3:
                    System.out.println("Edit stocks");
                    System.out.println("Enter the name you want to edit");
                    String nameChange = sc.next();
                    System.out.println("Enter the new price ");
                    double priceNew = sc.nextInt();
                    System.out.println("Enter the new quantity");
                    double quantityNew = sc.nextDouble();
                    jsonArray = stockService.updateStock(jsonArray,nameChange , priceNew ,quantityNew);
                    break;

                case 4:
                    System.out.println("Delete stocks");
                    System.out.println("Enter the name you want to delete");
                    String nameDelete = sc.next();

                    jsonArray= stockService.deleteStock(jsonArray, nameDelete);
                    break;

                case 5:
                    System.out.println("Total Value");
                    JSONObject obj;
                    double total=0;
                    for(int i=0;i<jsonArray.size();i++){
                        obj = (JSONObject) jsonArray.get(i);
                        total+= (double)obj.get("StockPrice") * (double) obj.get("StockQuantity");
                    }
                    System.out.println(total);

                    break;
                case 6:
                    stockAccount.stockAccount();
                    break;
                case 7:
                    stockAccount.buyShare(jsonArray);
                    break;
                case 8 :
                    jsonArray= stockAccount.sellShare(jsonArray);
                    break;
                case 9 :
                    stockAccount.printAccount();
                    break;
                case 10 :
                    break;
            }
        }
    }
}

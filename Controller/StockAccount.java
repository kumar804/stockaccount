package Controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class StockAccount {

    Scanner sc = new Scanner(System.in);
    HashMap<String, HashMap<String,Integer>> accountInfo = new HashMap<String , HashMap<String ,Integer>>();
    // HashMap<String,AccountHolder> accountInfo1 = new HashMap<>();

    /**
     * This function creates an account for the user
     */
    public void stockAccount(){
        System.out.println("Enter the name of account holder");
        String name = sc.next();
        HashMap<String,Integer> accountStocks = new HashMap<String,Integer>();
        accountInfo.put(name,accountStocks);
    }

    /**
     * Lets the user buy stocks from the market and keep them in his account
     * @param jsonArray
     * @return
     */
    public JSONArray  buyShare(JSONArray jsonArray){
        System.out.println("Enter the name of account you want to enter share into");
        String name =  sc.next();
        System.out.println("Enter the name of share");
        String share = sc.next();
        System.out.println("Enter the number of stocks you wany to buy");
        int numStock = sc.nextInt();
        JSONObject obj;
        for( int i = 0 ;i<jsonArray.size();i++){
            obj=(JSONObject) jsonArray.get(i);
            if(((String) obj.get("StockName")).equals(share)){
                double  availStocks = (double) obj.get("StockQuantity");
                System.out.println(availStocks);
                if(availStocks>= numStock){
                    HashMap<String,Integer> temp = accountInfo.get(name);
                    temp.put(share,numStock);
                    availStocks-=numStock;
                    obj.replace("StockQuantity",availStocks);
                    for(Map.Entry<String, HashMap<String, Integer>> Ok : accountInfo.entrySet()){
                        System.out.println(Ok);

                    }
                    System.out.println(accountInfo);
                    return jsonArray;

                }
                else{
                    System.out.println("That many stocks arent available.The number of available stocks are"+availStocks);

                }
            }

        }
        return jsonArray ;
    }

    /**
     * Lets the user sell shares into the stock market
     * @param jsonArray
     * @return
     */

    public JSONArray sellShare(JSONArray jsonArray){
        System.out.println("Enter the name of account you want to sell  shares from");
        String name =  sc.next();
        System.out.println("Enter the name of share");
        String share = sc.next();
        System.out.println("Enter the number of stocks you wany to sell");
        double numStock = sc.nextDouble();
        JSONObject obj;
        for( int i = 0 ;i<jsonArray.size();i++){
            obj=(JSONObject) jsonArray.get(i);
            if(((String) obj.get("StockName")).equals(share)){
                HashMap<String,Integer> temp = accountInfo.get(name);
                double exists =  temp.get(share);
                if(exists >= numStock) {
                    temp.replace(share,(int) (exists - numStock));
                    double availStocks = (double)obj.get("StockQuantity");
                    obj.replace("StockQuantity",(availStocks+numStock));

                }

            }

        }
        return jsonArray;
    }

    /**
     * Prints the infrmation about the users account
     */
    public void printAccount(){
        for(Map.Entry<String, HashMap<String, Integer>> Ok : accountInfo.entrySet()){
            System.out.println(Ok);

        }

    }


}

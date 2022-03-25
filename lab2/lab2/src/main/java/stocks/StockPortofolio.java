package stocks;

import java.util.ArrayList;

public class StockPortofolio {
    
    private ArrayList<Stock> myStock = new ArrayList<>();
    private IStockmarketService service;




    public StockPortofolio(IStockmarketService service){
        this.service = service;
    }

    public void addStock(Stock stock){
        this.myStock.add(stock);
    }
    public IStockmarketService getMarketService(){
        return this.service;
    }
    public void setMarketService(IStockmarketService service){
        this.service = service;
    }


    public double getTotalValue(){
        double t = 0;
        try{

            for (Stock stock : this.myStock)
            t = t + (stock.getQuantity() * this.service.getPrice(stock.getLabel()));
            
            return t;
        }catch(Exception e){
            return 0;
        }
    }
    
}

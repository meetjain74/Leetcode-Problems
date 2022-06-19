class StockSpanner {
    class Stock {
        int day;
        int price;
        
        public Stock(int day,int price) {
            this.day=day;
            this.price=price;
        }
    }
    
    Stack<Stock> ngl; // nearest greater left
    int day;

    public StockSpanner() {
        ngl = new Stack<>();
        day=0;
    }
    
    public int next(int price) {
        while (!ngl.isEmpty() && ngl.peek().price<=price) {
            ngl.pop();
        }
        int span = day - (ngl.isEmpty() ? -1 : ngl.peek().day);
        ngl.push(new Stock(day++,price));
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
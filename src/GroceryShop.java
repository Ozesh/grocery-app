import java.util.ArrayList;

public class GroceryShop {

    ArrayList<String> itemNameList;
    ArrayList<Integer> itemIdList;
    ArrayList<Integer> itemQuantityList;
    ArrayList<Double> factoryPriceList;
    ArrayList<Double> shopPriceList;
    ArrayList<String> itemSerialNoList;

    public GroceryShop(int itemSize){
        this.itemNameList = new ArrayList<>(itemSize);
        this.itemIdList = new ArrayList<>(itemSize);
        this.itemQuantityList = new ArrayList<>(itemSize);
        this.factoryPriceList = new ArrayList<>(itemSize);
        this.shopPriceList = new ArrayList<>(itemSize);
        this.itemSerialNoList = new ArrayList<>(itemSize);
    }

    public ArrayList<String> getItemSerialNoList() {
        return itemSerialNoList;
    }

    public void setItemSerialNoList(ArrayList<String> itemSerialNoList) {
        this.itemSerialNoList = itemSerialNoList;
    }

    public void addItemName(String name){
        int index = this.itemNameList.size();
        this.itemNameList.add(index, name);
    }

    public ArrayList<String> getItemNameList() {
        return itemNameList;
    }

    public void setItemNameList(ArrayList<String> itemNameList) {
        this.itemNameList = itemNameList;
    }

    public void addItemId(Integer id){
        int index = this.itemIdList.size();
        this.itemIdList.add(index, id);
    }

    public ArrayList<Integer> getItemIdList() {
        return itemIdList;
    }

    public void setItemIdList(ArrayList<Integer> itemIdList) {
        this.itemIdList = itemIdList;
    }


    public void addItemQuantity(Integer quantity){
        int index = this.itemQuantityList.size();
        this.itemQuantityList.add(index, quantity);
    }

    public ArrayList<Integer> getItemQuantityList() {
        return itemQuantityList;
    }

    public void setItemQuantityList(ArrayList<Integer> itemQuantityList) {
        this.itemQuantityList = itemQuantityList;
    }

    public void addFactoryPrice(Double price){
        int index = this.factoryPriceList.size();
        this.factoryPriceList.add(index, price);
    }

    public ArrayList<Double> getFactoryPriceList() {
        return factoryPriceList;
    }

    public void setFactoryPriceList(ArrayList<Double> factoryPriceList) {
        this.factoryPriceList = factoryPriceList;
    }

    public void addShopPrice(Double price){
        int index = this.shopPriceList.size();
        this.shopPriceList.add(index, price);
    }

    public ArrayList<Double> getShopPriceList() {
        return shopPriceList;
    }

    public void setShopPriceList(ArrayList<Double> shopPriceList) {
        this.shopPriceList = shopPriceList;
    }

    public boolean isItemIdValid(Integer id) {
        return (id >= 1 && id <= 333);
    }

    public boolean itemIdExists(Integer id) {
        return this.itemIdList.contains(id);
    }

    public boolean isFactoryPriceValid(Double price) {
        return (price >= 1 && price <= 1000);
    }

    public boolean isStockZero(Integer index){
       return this.itemQuantityList.get(index) == 0;
    }

    public void decreaseStock(Integer index,Integer decreaseBy){
        this.itemQuantityList.set(index, this.itemQuantityList.get(index) - decreaseBy);
    }

}

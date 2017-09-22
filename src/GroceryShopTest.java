import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class GroceryShopTest {

    public static void main(String[] args) {
        final int N = 5;
        GroceryShop groceryShop = new GroceryShop(N);
        executeProgram(groceryShop, N);
    }

    public static void executeProgram(GroceryShop groceryShop, Integer itemSizeLimit) {
        int choice;
        System.out.println("\n");;
        System.out.println("GroceryShop application started....");
        populateItemSerialNoList(groceryShop, itemSizeLimit);
        while (true) {
            displayMenu();
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    if (groceryShop.getItemIdList().size() == itemSizeLimit) {
                        System.out.println("Items size limit reached !!! You cannot add new item");
                    } else {
                        readValidateAndStoreItems(groceryShop, scanner, itemSizeLimit);
                    }
                    break;

                case 2:
                    calculateAndStoreShopPrice(groceryShop, scanner);
                    break;

                case 3:
                    displayItems(groceryShop.itemSerialNoList,
                            groceryShop.itemIdList,
                            groceryShop.itemQuantityList,
                            groceryShop.itemNameList,
                            groceryShop.factoryPriceList,
                            groceryShop.shopPriceList,
                            itemSizeLimit);
                    break;

                case 4:
                    sellAnItem(groceryShop, scanner);
                    break;

                case 5:
                    displayItemsWithLowestFactoryPrice(groceryShop, itemSizeLimit);
                    break;

                case 6:
                    sortAndDisplay(groceryShop, itemSizeLimit);
                    break;

                case 7:
                    System.out.println("GroceryShop Application is shutting down!!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }

    public static void populateItemSerialNoList(GroceryShop groceryShop, Integer size) {
        for (int i = 0; i < size; i++) {
            int itemNo = i + 1;
            groceryShop.getItemSerialNoList().add(i, "ITEM " + itemNo);
        }
    }

    public static void displayMenu() {
        System.out.println("\n");
        System.out.println("CHOOSE MENU OPTIONS");
        System.out.println("1- Read, validate and store all items");
        System.out.println("2- Calculate and store shop price for all items");
        System.out.println("3- Display all items");
        System.out.println("4- Sell an item");
        System.out.println("5- Display all items with the lowest factory price");
        System.out.println("6- Sort and display sorted items");
        System.out.println("7- Exit from the application");
        System.out.print("Enter your choice - \n");
    }

    /**
     * This method is to to find the indices of one or more minimum number in a list
     * @param list list under operation
     * @return list of indices
     */
    public static ArrayList<Integer> minIndices(ArrayList<Double> list) {
        Double minNumber;
        minNumber = list.get(list.indexOf(Collections.min(list)));
        return indexOfAll(minNumber, list);
    }

    /**
     * This method is used to find the indices of all the matching elements in a list
     * @param obj any type of object used to match
     * @param list list under operation
     * @return matching indices list
     */
    public static ArrayList<Integer> indexOfAll(Object obj, ArrayList list) {
        ArrayList<Integer> indexList = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++)
            if (obj.equals(list.get(i)))
                indexList.add(i);
        return indexList;
    }

    public static void displayItemsWithLowestFactoryPrice(GroceryShop groceryShop, Integer itemSize) {

        ArrayList<Integer> indexList = minIndices(groceryShop.factoryPriceList);

        ArrayList<String> itemNameList = new ArrayList<>(itemSize);
        ArrayList<Integer> itemIdList = new ArrayList<>(itemSize);
        ArrayList<Integer> itemQuantityList = new ArrayList<>(itemSize);
        ArrayList<Double> factoryPriceList = new ArrayList<>(itemSize);
        ArrayList<Double> shopPriceList = new ArrayList<>(itemSize);
        ArrayList<String> columnNameList = new ArrayList<>(itemSize);

        for (int i = 0; i < indexList.size(); i++) {
            int indexPos = indexList.get(i);
            itemIdList.add(i, groceryShop.getItemIdList().get(indexPos));
            itemNameList.add(i, groceryShop.getItemNameList().get(indexPos));
            itemQuantityList.add(i, groceryShop.getItemQuantityList().get(indexPos));
            factoryPriceList.add(i, groceryShop.getFactoryPriceList().get(indexPos));
            shopPriceList.add(i, groceryShop.getFactoryPriceList().get(indexPos));
            columnNameList.add(i, "Item" + indexPos);
        }

        displayItems(columnNameList, itemIdList, itemQuantityList, itemNameList, factoryPriceList, shopPriceList,indexList.size()+1);
    }

    public static void sortAndDisplay(GroceryShop gp, Integer itemSize) {

        ArrayList<String> sortedNameList = gp.getItemNameList();
        ArrayList<Integer> modifiedItemIdList = gp.getItemIdList();
        ArrayList<Integer> modifiedItemQuantityList = gp.getItemQuantityList();
        ArrayList<Double> modifiedFactoryPriceList = gp.getFactoryPriceList();
        ArrayList<Double> modifiedShopPriceList = gp.getShopPriceList();
        ArrayList<String> modifiedItemSerialNoList = gp.getItemSerialNoList();
        Integer tempItemId;
        Integer tempQuantity;
        String tempName;
        String tempColumnName;
        Double tempFactoryPrice;
        Double tempShopPrice;

        for (int x = 0; x < gp.getItemNameList().size(); x++)
        {
            for (int i = 0; i < (gp.getItemNameList().size() - x - 1); i++) {

                if (gp.getItemNameList().get(i).compareTo(gp.getItemNameList().get(i + 1)) < 0) {
                    tempName = gp.getItemNameList().get(i);
                    sortedNameList.set(i, gp.getItemNameList().get(i + 1));
                    sortedNameList.set(i + 1, tempName);

                    tempItemId = gp.getItemIdList().get(i);
                    modifiedItemIdList.set(i, gp.getItemIdList().get(i + 1));
                    modifiedItemIdList.set(i + 1, tempItemId);

                    tempQuantity = gp.getItemQuantityList().get(i);
                    modifiedItemQuantityList.set(i, gp.getItemQuantityList().get(i + 1));
                    modifiedItemQuantityList.set(i + 1, tempQuantity);

                    tempFactoryPrice = gp.getFactoryPriceList().get(i);
                    modifiedFactoryPriceList.set(i, gp.getFactoryPriceList().get(i + 1));
                    modifiedFactoryPriceList.set(i + 1, tempFactoryPrice);

                    if (!gp.getShopPriceList().isEmpty()) {
                        tempShopPrice = gp.getShopPriceList().get(i);
                        modifiedShopPriceList.set(i, gp.getShopPriceList().get(i + 1));
                        modifiedShopPriceList.set(i + 1, tempShopPrice);
                    }
                    tempColumnName = gp.getItemSerialNoList().get(i);
                    modifiedItemSerialNoList.set(i, gp.getItemSerialNoList().get(i + 1));
                    modifiedItemSerialNoList.set(i + 1, tempColumnName);
                }
            }
        }

        System.out.println("\n");
        System.out.println("\n");
        displayItems(modifiedItemSerialNoList,
                modifiedItemIdList,
                modifiedItemQuantityList,
                sortedNameList,
                modifiedFactoryPriceList,
                modifiedShopPriceList,
                itemSize);

    }

    public static void sellAnItem(GroceryShop groceryShop, Scanner scanner) {
        int itemId, indexPosition;
        System.out.println("Enter id of the item to sell");
        itemId = scanner.nextInt();
        if (groceryShop.itemIdExists(itemId)) {
            indexPosition = groceryShop.getItemIdList().indexOf(itemId);
            if (groceryShop.isStockZero(indexPosition)) {
                System.out.printf("Item not in stock");
            } else {
                System.out.println("Item is sold");
                groceryShop.decreaseStock(indexPosition, 1);
            }
        } else {
            System.out.println("Item not in stock");
        }
    }

    public static void calculateAndStoreShopPrice(GroceryShop groceryShop, Scanner scanner) {
        Double factoryPrice, shopPrice;
        Double discountPercent, discountFactor;
        System.out.println("Enter discount in percentage");
        Scanner scanner5 = new Scanner(System.in);
        discountPercent = scanner.nextDouble();
        discountFactor = (discountPercent / 100);
        for (int i = 0; i < groceryShop.getFactoryPriceList().size(); i++) {
            factoryPrice = groceryShop.getFactoryPriceList().get(i);
            shopPrice = (1 - discountFactor) * factoryPrice;
            groceryShop.addShopPrice(shopPrice);
        }
        System.out.println("Shop prices have been calculated and added");
        System.out.println("\n");
    }


    public static void displayItems(ArrayList<String> itemSerialNoList,
                                    ArrayList<Integer> itemIdList,
                                    ArrayList<Integer> itemQuantityList,
                                    ArrayList<String> itemNameList,
                                    ArrayList<Double> factoryPriceList,
                                    ArrayList<Double> shopPriceList,
                                    Integer itemSizeLimit) {

        ArrayList<ArrayList<String>> resultHolderArray = new ArrayList<>();
        ArrayList<ArrayList<String>> transposedResultHolderArray = new ArrayList<>();

        ArrayList<String> itemNameRow = new ArrayList<>();
        ArrayList<String> itemIdRow = new ArrayList<>();
        ArrayList<String> itemQuantityRow = new ArrayList<>();
        ArrayList<String> factoryPriceRow = new ArrayList<>();
        ArrayList<String> shopPriceRow = new ArrayList<>();
        ArrayList<String> itemSerialNoRow = new ArrayList<>();

        itemSerialNoRow.add(" ");
        for (int i = 0; i < itemSerialNoList.size(); i++) {
            itemSerialNoRow.add(itemSerialNoList.get(i));
        }
        resultHolderArray.add(itemSerialNoRow);


        itemIdRow.add("ITEM ID");
        for (int i = 0; i < itemIdList.size(); i++) {
            itemIdRow.add(itemIdList.get(i).toString());
        }
        resultHolderArray.add(itemIdRow);

        itemNameRow.add("ITEM NAME");
        for (int i = 0; i < itemNameList.size(); i++) {
            itemNameRow.add(itemNameList.get(i));
        }
        resultHolderArray.add(itemNameRow);

        itemQuantityRow.add("QUANTITY");
        for (int i = 0; i < itemQuantityList.size(); i++) {
            itemQuantityRow.add(itemQuantityList.get(i).toString());
        }
        resultHolderArray.add(itemQuantityRow);

        factoryPriceRow.add("FACTORY PRICE");

        for (int i = 0; i < factoryPriceList.size(); i++) {
            factoryPriceRow.add(factoryPriceList.get(i).toString());
        }
        resultHolderArray.add(factoryPriceRow);

        shopPriceRow.add("SHOP PRICE");
        for (int i = 0; i < shopPriceList.size(); i++) {
            shopPriceRow.add(shopPriceList.get(i).toString());
        }
        resultHolderArray.add(shopPriceRow);

        transposedResultHolderArray = transpose(resultHolderArray);

        for (int i=0; i < itemSizeLimit; i++){ // row
            for (int j=0; j< transposedResultHolderArray.get(0).size(); j++){ //column
                System.out.format("%20s", transposedResultHolderArray.get(i).get(j));
            }
            System.out.println("\n");
        }
    }

    /**
     * performs transpose of two dimensional array
     * @param list list under operation
     * @return returns transposed list
     */
    public static ArrayList<ArrayList<String>> transpose (ArrayList<ArrayList<String>> list){
        ArrayList<ArrayList<String>> matrixOut = new ArrayList<>();
        int rowCount = list.size();
        int colCount = 0;

        //find max width
        for(int i = 0; i < rowCount; i++){
            ArrayList<String> row = list.get(i);
            int rowSize = row.size();
            if(rowSize > colCount){
                colCount = rowSize;
            }
        }
        for (int r = 0; r < rowCount; r++){
            ArrayList<String> innerIn = list.get(r);
            for (int c = 0; c < colCount; c++){
                ArrayList<String> matrixOutRow = new ArrayList<>();
                if (r != 0) {
                    try{
                        matrixOutRow = matrixOut.get(c);
                    }catch(java.lang.IndexOutOfBoundsException e){
                        System.out.println("Transposition error!\n"
                                + "could not get matrixOut at index "
                                + c + " - out of bounds" +e);
                        matrixOutRow.add("");
                    }
                }
                try{
                    matrixOutRow.add(innerIn.get(c));
                }catch (java.lang.IndexOutOfBoundsException e){
                    matrixOutRow.add("");
                }
                try {
                    matrixOut.set(c,matrixOutRow);
                }catch(java.lang.IndexOutOfBoundsException e){
                    matrixOut.add(matrixOutRow);
                }
            }
        }
        return matrixOut;
    }

    public static void readValidateAndStoreItems(GroceryShop groceryShop, Scanner scanner, Integer size) {
        int quantity;
        String itemName;

        validateAndReadItem(groceryShop, scanner);

        System.out.println("Provide itemName");
        itemName = scanner.next();
        groceryShop.addItemName(itemName);

        System.out.println("Insert item quantity");
        quantity = scanner.nextInt();
        groceryShop.addItemQuantity(quantity);

        validateAndReadFactoryPrice(groceryShop, scanner);
    }

    public static void validateAndReadItem(GroceryShop groceryShop, Scanner scanner) {
        int itemId;

        System.out.println("Provide item id");
        itemId = scanner.nextInt();
        if (!groceryShop.isItemIdValid(itemId)) {
            System.out.println("Provided id is not within the required range [1,333] !!");
            validateAndReadItem(groceryShop, scanner);
        } else if (groceryShop.itemIdExists(itemId)) {
            System.out.println("Provided id already exists. You must provide unique item Id !!");
            validateAndReadItem(groceryShop, scanner);
        } else {
            groceryShop.addItemId(itemId);
        }
    }

    public static void validateAndReadFactoryPrice(GroceryShop groceryShop, Scanner scanner) {
        Double factoryPrice;
        System.out.println("Insert factory price");
        factoryPrice = scanner.nextDouble();
        if (groceryShop.isFactoryPriceValid(factoryPrice)) {
            groceryShop.addFactoryPrice(factoryPrice);
        } else {
            System.out.println("Provided factory price must be within [$1, $1000] !!");
            validateAndReadFactoryPrice(groceryShop, scanner);
        }
    }
}

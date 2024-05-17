public class TestProduct {
    public static void main(String[] args) {
        ProductList list = new ProductList();
        while (list.getProducts().size() > 0) {
            list.inputProduct();
            System.out.println("剩下的商品：");
            if (list.getProducts().size() == 0) {
                System.out.println("商品售罄");
                break;
            }
            list.outputProduct();
        }

    }
}

package com.demo.myretail.bo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.mongodb.morphia.Datastore;

import com.demo.myretail.dao.ProductDAOImpl;
import com.demo.myretail.util.MongoConnector;
import com.demo.myretail.vo.Product;

/**
 * @author vkiran
 *
 */
public class ProductPriceProcessor {
  public static final String COMMA = ",";

  public static final String FILE_PATH = "D:\\productsInput.csv";

  public static void main(String args[]) {

    Datastore datastore = null;
    try {
      List<List<Long>> productIds = new ProductPriceProcessor().processInputFile(FILE_PATH);
      datastore = MongoConnector.getMongoDataStore();
      for (List<Long> prodIds : productIds) {
        List<Product> products = new ProductDAOImpl(datastore).findByProductIds(prodIds);
        printDiscountedPriceForProducts(products);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private List<List<Long>> processInputFile(String inputFilePath) throws IOException {

    File inputF = new File(inputFilePath);
    InputStream inputFS = new FileInputStream(inputF);
    BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
    // skip the header of the csv
    List<List<Long>> inputList = br.lines().skip(1).map(this.mapToItem).collect(Collectors.toList());
    br.close();
    return inputList;
  }

  private Function<String, List<Long>> mapToItem = (line) -> {
    String[] arrProdId = line.split(COMMA);// a CSV has comma separated lines
    List<String> strProdIds = Arrays.asList(arrProdId);
    List<Long> prodIds = new ArrayList<>(4);
    long length = arrProdId.length;
    int i = 0;
    for (String prodId : strProdIds) {
      prodIds.add(Long.parseLong(strProdIds.get(i)));
      i++;
    }
    return prodIds;
  };

  private static void printDiscountedPriceForProducts(

      List<Product> products) {

    long brandDiscountPc = 0;
    long categoryDiscountPc = 0;
    long ancesCatDiscountPc = 0;
    long maxDiscount = 0;
    double discountedPrice = 0;
    double price = 0;
    double discount = 0;
    double productPricSum = 0;

    for (Product product : products) {
      price = product.getPrice();
      brandDiscountPc = product.getBrandDiscountPc();
      categoryDiscountPc = product.getCategoryDiscountPc();
      ancesCatDiscountPc = product.getAncesCatDiscountPc();
      maxDiscount = Math.max(Math.max(brandDiscountPc, categoryDiscountPc), ancesCatDiscountPc);
      discount = price * ((double) maxDiscount / 100);
      discountedPrice = price - discount;
      productPricSum = productPricSum + discountedPrice;
    }
    System.out
        .println("Sum of the Products Price (separated by comma) after discount , calcualted for each line in csv  is "
            + productPricSum);
  }
}
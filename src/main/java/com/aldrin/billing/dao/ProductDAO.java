/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.billing.dao;

import com.aldrin.billing.model.Product;
import java.util.List;

/**
 *
 * @author Java Programming with Aldrin
 */
public interface ProductDAO {

    //    add Product
    public void addProduct(Product product);

//    update Product
    public void updateProduct(Product product);

//    delete Product
    public void deleteProduct(Product product);

//    list of the Product
    public List<Product> selectProduct();

    public void comboBoxProduct();

    public Product findProductById(Product product);

}

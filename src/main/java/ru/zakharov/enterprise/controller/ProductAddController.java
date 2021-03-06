package ru.zakharov.enterprise.controller;

import ru.zakharov.enterprise.dao.CategoryDAO;
import ru.zakharov.enterprise.dao.ProductDAO;
import ru.zakharov.enterprise.entity.Category;
import ru.zakharov.enterprise.entity.Product;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

@ViewScoped
@ManagedBean
public class ProductAddController {

    @Inject
    private ProductDAO productDAO;

    @Inject
    private CategoryDAO categoryDAO;

    private String name = "";

    private int price = 0;

    private String categoryId = null;

    private String shortDesc = "";

    private String picFileName = "";

    private String fullDesc = "";

    public void saveProduct() {
        if (categoryId == null) {
            return;
        }

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setShortDescription(shortDesc);
        product.setFullDescription(fullDesc);
        product.setPictureFileName(picFileName);
        Category category = categoryDAO.getCategoryById(categoryId);
        product.setCategory(category);
        category.addToCategory(product);
        productDAO.merge(product);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getFullDesc() {
        return fullDesc;
    }

    public void setFullDesc(String fullDesc) {
        this.fullDesc = fullDesc;
    }

    public String getPicFileName() {
        return picFileName;
    }

    public void setPicFileName(String picFileName) {
        this.picFileName = picFileName;
    }
}

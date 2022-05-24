package swp391.fptqna.dto;

import java.io.Serializable;

public class ProductDTO implements Serializable {
    private String name;
    private int price;
    private String imgUrl;
    private String description;
    private int status;
    private int categoryID;
    private int ID;
    private int quantity = 0;

    public ProductDTO(String name, int price, String imgUrl, String description, int status, int categoryID, int ID) {
        this.name = name;
        this.price = price;
        this.imgUrl = imgUrl;
        this.description = description;
        this.status = status;
        this.categoryID = categoryID;
        this.ID = ID;
    }

    public ProductDTO(String name, int price, String imgUrl, String description, int status, int categoryID, int ID, int quantity) {
        this.name = name;
        this.price = price;
        this.imgUrl = imgUrl;
        this.description = description;
        this.status = status;
        this.categoryID = categoryID;
        this.ID = ID;
        this.quantity = quantity;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getFormatedPrice() {
        String tempPrice = Integer.toString(price);
        String formatedPrice = "";
        int priceLength = tempPrice.length();
        for (int i = 0; i < priceLength; i++) {
            if (i % 3 == 0 && i != 0) {
                formatedPrice = "." + formatedPrice;
            }
            formatedPrice = tempPrice.charAt(priceLength - i - 1) + formatedPrice;
        }
        return formatedPrice;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        ProductDTO product = (ProductDTO) obj;
        if (product.ID != this.ID) return false;
        return true;
    }
}

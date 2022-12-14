package com.example.duan1.Model;

public class Category {
    private int id;
    private String category,categoryThumb,categoryDescription;

    public Category() {
    }

    public Category(int id, String category, String categoryThumb, String categoryDescription) {
        this.id = id;
        this.category = category;
        this.categoryThumb = categoryThumb;
        this.categoryDescription = categoryDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategoryThumb() {
        return categoryThumb;
    }

    public void setCategoryThumb(String categoryThumb) {
        this.categoryThumb = categoryThumb;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }
}

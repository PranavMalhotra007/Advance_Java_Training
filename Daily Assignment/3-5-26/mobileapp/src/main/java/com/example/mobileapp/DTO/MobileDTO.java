package com.example.mobileapp.DTO;

import java.io.Serializable;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class MobileDTO  implements Serializable{
	 private static final long serialVersionUID = 1L;
	 private int id;
	 @NotBlank(message = "brand name cannot be empty")
	 @Pattern(regexp = "^[a-zA-Z0-9 ]+$",message = "enter valid brand name")
	 private String brandName;
	 @NotBlank(message = "model name cannot be empty")
	 @Pattern(regexp = "^[a-zA-Z0-9 ]+$",message = "enter valid model name")
	 private String modelName;
	 @Min(value = 1000 , message = "Minimum value must be 1000")
	 private double price;
	 @NotBlank(message = "ram cannot be empty")
	 @Pattern(regexp = "^(4|6|8|16)(GB|gb)$",message = "enter valid ram possible [4,6,8,16]")
	 private String ram;
	 @NotBlank(message = "storage cannot be empty")
	 @Pattern(regexp = "^(64|128|256)(GB|gb)$",message = "enter valid storage possible [64,128,256]")
	 private String storage;
	 @NotBlank(message = "color cannot be empty")
	 @Pattern(regexp = "^(BLACK|WHITE|PURPLE|GREY|RED|BLUE)$",message = "enter valid color BLACK|WHITE|PURPLE|GREY|RED|BLUE ")
	 private String color;
	 public int getId() {
		 return id;
	 }
	 public void setId(int id) {
		 this.id = id;
	 }
	 public String getBrandName() {
		 return brandName;
	 }
	 public void setBrandName(String brandName) {
		 this.brandName = brandName;
	 }
	 public String getModelName() {
		 return modelName;
	 }
	 public void setModelName(String modelName) {
		 this.modelName = modelName;
	 }
	 public double getPrice() {
		 return price;
	 }
	 public void setPrice(double price) {
		 this.price = price;
	 }
	 public String getRam() {
		 return ram;
	 }
	 public void setRam(String ram) {
		 this.ram = ram;
	 }
	 public String getStorage() {
		 return storage;
	 }
	 public void setStorage(String storage) {
		 this.storage = storage;
	 }
	 public String getColor() {
		 return color;
	 }
	 public void setColor(String color) {
		 this.color = color;
	 }
	 public MobileDTO() {
		super();
	 }
	 
}

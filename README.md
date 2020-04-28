# GT Food Truck Database Management System

![title_logo](https://github.com/XinzeWang/GT-Food-Truck/raw/master/readme-resource/logo.png)

## Online Demo
This project has been deployed on AWS using Elastic Beanstalk and Amazon Aurora. 
Demo Link: 👉👉 http://gtfoodtruck-env.eba-fvaym9bd.us-east-1.elasticbeanstalk.com/ 👈👈

## Description
This project aims to design and implement a food truck database management system using relational database concepts. The goal is to improve food truck management and food order process for users, admins, managers and staffs. 

The design and structure of the database system originated from ***CS4400 "Database System", instructed by Mark Moss, from Georgia Institute of Technology.*** 

## Project Highlights
 ![image1](https://github.com/XinzeWang/GT-Food-Truck/raw/master/readme-resource/screen1.png)
 
 ![image2](https://github.com/XinzeWang/GT-Food-Truck/raw/master/readme-resource/screen2.png)
 
 ![image3](https://github.com/XinzeWang/GT-Food-Truck/raw/master/readme-resource/screen3.png)

## Technique Stacks
* Database: MySQL
* Backend: Spring Boot + Hibernate
* Frontend: Thymeleaf, Semantic-UI

## Run The Application On Your Local System
1.	Open the project file in IntelliJ or Eclipse
2.	Make sure you have a MySQL server running containing correct table schema and data 
3.	Enter your MySQL schema name and credentials in foodtruck/src/main/resources/application.properties
4.	To start the server, press “run application” or navigate to the root of the project via command line and execute the command “mvn spring-boot:run”
5.  The base path is localhost:8080

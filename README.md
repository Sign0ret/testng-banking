## TestNG Banking App

In this repository, we tested the BankAccount class to ensure its methods work as expected. As an extra feature, we implemented the invest feature, which moves the money invested from balance to invest.

## Team 46

- Carlos Iván Armenta Naranjo - A01643070
- Jorge Javier Blásquez Gonzalez - A01637706 
- Adolfo Hernández Signoret - A01637184
- Arturo Ramos Martínez - A01643269
- Moisés Adrián Cortés Ramos - A01642492
- Bryan Ithan Landín Lara - A01636271

## How to execute
1. Clone this repo:
```
git clone https://github.com/Sign0ret/testng-banking.git
```
2. Install dependencies and packages from the pom.xml using mvn:
```
mvn clean install
```
In case of a failing installation, check which maven-surefire-plugin version works for you.
3. Run the negative tests which are executed by default via the testng.xml
```
mvn clean test
```
4. Check the positive tests by uncommenting the testng.xml of positive tests.

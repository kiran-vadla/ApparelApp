This Application is used to calculate the sum of the discounted price for each product in the line item in the input csv file productsInput.csv . 

Line item of csv file contains of productIds separated by comma. 

This program assumes that this input file is stored at the location D:\\productsInput.csv.
	
*****************
Sample Input
*****************	
	2
	1,2,3,4
	1,5
	
*****************
Expected output:
	3860
	2140
*****************
Technlogy Stack
*****************
	Java8
	Morphia
	MongoDB 3.6.0 Community
	Maven
	MongoCompass
*****************	

For details on the MongoDB schema , please refer the image file 'apparelApp-mongodb-schema.PNG' that is 
available parallel to this README.md file in the GIT Repository

Instructions to launch this program
************************************

Assuming that the input file is at location D:\\productsInput.csv, launch the Java Main Program 
	"com.demo.myretail.bo.ProductPriceProcessor" and assuming the Sample Input in this csv file is 
	2
	1,2,3,4
	1,5
	
Output that will be print in the console will be as follows 

*************************
Sum of the Products Price (separated by comma) after discount , calcualted for each line in csv  is 3860.0
Sum of the Products Price (separated by comma) after discount , calcualted for each line in csv  is 2140.0
*************************
	

	
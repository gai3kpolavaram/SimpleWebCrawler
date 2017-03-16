Simple Crawler to visit the web within the given domain

Assumptions:
-----------
Input will be a fully formed URL, including the protocol
For example: https://www.google.com

Build Instructions:
------------------

go to the download directory run the following command to run unit tests and build
 ./gradlew build

Run instructions:
-----------------
java -jar build/libs/crawler-1.0-SNAPSHOT.jar THE_URL_TO_CRAWL MAX_NUMBER_OF_SITES_TO_CRAWL
for eg: java -jar build/libs/crawler-1.0-SNAPSHOT.jar https://www.wiprotechnologies.com 30

OUTPUT:
______
The output is printed on the console and is the list of all websites in the domain, only the ones which are in the same domain will be visited


Future Work:
0. More test cases
1. Output formatter/writer




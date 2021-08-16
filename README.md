# design_patterns

How to run Selenium Grid:
1. Download selenium-server-standalone-3.141.59.jar and put it with same folder with hub_3.141.59.bat and se-node_xxx-3.141.59.bat
2. Download Chromedriver, Edgedriver
3. Change in se-node-xxx.bat files path to your Chromedriver, Edgedriver
4. Run Selenuim Grid Hub - hub_3.141.59.bat
5. Run Selenuim Grid Nodes - se-node_xxx-3.141.59.bat
Done!

How to run Framework:
Run from command line: mvn -Dbrowser=chrome -Dsurefire.suiteXmlFiles=src\test\resources\testNG.xml -Dusage=1year clean test
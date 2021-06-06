:: Beginning of hub batch file
set SERVER_VERSION=3.141.59
set TASK_NAME=SeleniumServerNode3
set NODE_PORT=5557
set HUB_PORT=4444
set REGISTER_IP=localhost
set CHROME_DRIVER=D:\_Install\Selenium\chromedriver.exe
java -Dwebdriver.chrome.driver=%CHROME_DRIVER% -jar selenium-server-standalone-3.141.59.jar -role node -browser "browserName=chrome,version=91,maxinstance=4,platform=WINDOWS" -hub http://192.168.31.142:4444/grid/register -port 5557
:: End of hub batch file
pause
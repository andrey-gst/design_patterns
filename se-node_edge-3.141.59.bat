:: Beginning of hub batch file
set SERVER_VERSION=3.141.59
set TASK_NAME=SeleniumServerNode3
set NODE_PORT=5556
set HUB_PORT=4444
set REGISTER_IP=localhost
set EDGE_DRIVER=D:\_Install\Selenium\msedgedriver.exe
java -Dwebdriver.edge.driver=%EDGE_DRIVER% -jar selenium-server-standalone-3.141.59.jar -role node -browser "browserName=MicrosoftEdge,version=91,maxinstance=4,platform=WINDOWS" -hub http://localhost:4444/grid/register -port 5556
:: End of hub batch file
pause
### TestNG project for parallel execution using Selenium GRID composed in Docker containers
mvn clean test

compose-grid.yaml - for ChromeDriver.

compose-grid_debug.yaml - for ChromeDriver which enables VNC look ports mapped to 5600. Password: secret. As well for Sikuli usage.


to start docker compose open cmd in *docker* project folder and run command where after -f specify which file you want to use

```docker-compose -f compose-grid_debug.yaml up -d```


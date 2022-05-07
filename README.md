# Predictive Analysis - Web UI

Steps for project set up
1. git clone https://github.com/hsam-2021/bankds.git
2. Set up Docker for Linux following the instruction in link https://docs.docker.com/engine/install/ubuntu/
3. Please copy the db script file "init.sql" to "/home/hs4703" location or if you are copying this to other location then update the command below with correct path of init.sql.
4. Set up postgres DB ---> Run Docker command "docker pull postgres" --> Create/Start docker container "docker run -it --privileged --restart=always --name postgres_bankds -p 5434:5432 -v /home/hs4703/init.sql:/docker-entrypoint-initdb.d/init.sql -e POSTGRES_PASSWORD=bankds -d postgres"
5. Go to the folder location in your local where you clone the data_prediction repository
6. Run command to build docker image "docker build -t  bankds:1.0 bankds"   (Note - please make sure you one directory above the project folder before executing the command)
7. Run command to create and run docker container "docker run -it --privileged --restart=always -d --name sameproj -p 8080:8080 bankds:1.0"
8. Launch the web page http://<host_id:8080> 

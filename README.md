# Predictive Analysis - Web UI

Steps for project set up
1. git clone https://github.com/hsam-2021/bankds.git
2. Set up Docker for Linux following the instruction in link https://docs.docker.com/engine/install/ubuntu/
3. Go to the folder location in your local where you clone the data_prediction repository
4. Run command to build docker image "docker build -t  bankds:1.0 bankds"   (Note - please make sure you one directory above the project folder before executing the command)
5. Run command to create and run docker container "docker run -it --privileged --restart=always -d --name sameproj -p 8080:8080 bankds:1.0"
6. Launch the web page http://<host_id:8080> 

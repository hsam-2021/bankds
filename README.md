# Predictive Analysis - Web UI

## Abstract
Recent advances in data analytics and machine learning are providing banks with powerful new tools for gaining insights into their customers’ needs and behavior. Through the use of advanced predictive and prescriptive analytics, banks are applying technology in ways that can have a direct and tangible impact on their ability to access and apply useful business intelligence capabilities. The potential benefits of these sweeping new advances can be seen in a variety of areas, including enhanced anticipation and prediction of possible customer churn, improved effectiveness of cross-selling and marketing activities etc. Today business decisions are based on data. The data should be of high quality to help make best decisions. My data science project is about analysis and prediction based on bank dataset which is utilized to understand the customer behavior whether the customer will subscribe for term deposit or not. Also based on the customer data it can be predicted whether a particular customer should be given a loan or not. The accuracy for my model is high and as more and more data are being collected and fed to the model it will improve with time and give better predictions.

##  Steps for project set up
1. git clone https://github.com/hsam-2021/bankds.git
2. Set up Docker for Linux following the instruction in link https://docs.docker.com/engine/install/ubuntu/
3. Please copy the db script file "init.sql" to "/home/hs4703" location or if you are copying this to other location then update the command below with correct path of init.sql.
4. Set up postgres DB ---> Run Docker command "docker pull postgres" --> Create/Start docker container "docker run -it --privileged --restart=always --name postgres_bankds -p 5434:5432 -v /home/hs4703/init.sql:/docker-entrypoint-initdb.d/init.sql -e POSTGRES_PASSWORD=bankds -d postgres"
5. Go to the folder location in your local where you clone the data_prediction repository
6. Run command to build docker image "docker build -t  bankds:1.0 bankds"   (Note - please make sure you one directory above the project folder before executing the command)
7. Run command to create and run docker container "docker run -it --privileged --restart=always -d --name sameproj -p 8080:8080 bankds:1.0"
8. Launch the web page http://<host_id:8080> 

## Tool and Technologies used
Machine learning part
Platform:
  -	Operating system: Windows 10
  
Integrated Development Environment (IDE):

  -	Jupyter Notebook
  -PyCharm
Programming languages:

  - Python 3.10
Programming Frameworks:

  -	TensorFlow
  -Flask
Libraries:
  •	NumPy
  •	Pandas
  •	Matplotlib
  •	Seaborn
  •	Sklearn
  •	Json
   •	pickle
API testing tool:
  •	Postman
Data visualization tool:
  •	Tableau
Web development part/ Back end
Database:
  •	Postgres
User Interface:
  •	HTML5
  •	JavaScript (Ajax, jQuery)
  •	Bootstrap 4 for styling and scripting
  •	Datatable library for interactive tables
Programming language:
  •	Java 8
IDE:
  •	Spring Tool Suite (STS)
Template engine:
  •	Thymeleaf for server-side template engine
Frameworks:
  •	Java Persistence API (Hibernate) as Object Relational Mapping (ORM) tool
  •	Springboot
API:
  •	Rest API for CRUD operations
Application and Web server:
  •	Tomcat
Container:
  1.	Docker
Cloud platform:
  2.	Google cloud platform


## Project Milestones
• Requirement collection
• Data Processing
• Data Cleaning
• Exploratory data analysis, Feature engineering and selection
• Data visualization for business analysis
  ### Data visualization on term deposit prediction dataset
  #### Interactive dashboard of data distribution w.r.t. job, education and marital status
  ![image](https://user-images.githubusercontent.com/94940146/228030562-7db5fb0a-3bf5-4d1a-bf11-5712e159249f.png)
  #### Distribution of client age w.r.t term deposit output (yes or no)
  ![image](https://user-images.githubusercontent.com/94940146/228030652-866e6a8d-8776-42a0-85ad-7461d7319a92.png)
  #### Box plot for duration w.r.t. term deposit output
  ![image](https://user-images.githubusercontent.com/94940146/228030759-290d4122-7461-4c0c-819b-90dd185fdd11.png)
  #### Dashboard of term deposit output w.r.t credit, housing and personal loan fields
  ![image](https://user-images.githubusercontent.com/94940146/228030900-1d18a021-e1df-4cd2-ab9a-857c79ce9c39.png)
  ### Data visualization for loan dataset
  ![image](https://user-images.githubusercontent.com/94940146/228031018-8f4b3819-16f6-4e78-a0e1-221e0cebb426.png)
  #### Dashboard for the dataset distribution w.r.t marital status, gender and number of dependents
  ![image](https://user-images.githubusercontent.com/94940146/228031095-79d54ce0-764d-4680-8a35-55740fb55e35.png)


• Model Building
• Model Evaluation
• Model Deployment

## Some snapshots of the application

After login the user will last on the dashboard

![image](https://user-images.githubusercontent.com/94940146/228032129-13fd36aa-40cf-4cf1-a0bf-7c7062f3b35e.png)

Here based on the customer inputs the predicted customer behavior will be that the customer will not subscribe for term deposit.
![image](https://user-images.githubusercontent.com/94940146/228032276-fee5c737-5e97-4581-8d06-d9dd2891edd4.png)

If based on the customer input features the customer behavior will be that he/she will subscribe for the term deposit then the following page will be displayed. 
![image](https://user-images.githubusercontent.com/94940146/228032338-c2331b3f-2022-4215-b450-4b714fbd878e.png)

### For loan approval

Another predictive model is used to predict whether the customer loan will be approved or not based on the data entered regarding the customer.
![image](https://user-images.githubusercontent.com/94940146/228032520-1e7573dd-9ea1-4477-8c87-a386713fa39e.png)


## Future scope

In this project I have tried to mimic a real time application scenario of buiding a predictive model based on the bank data and utilizing it for for making impactful business decision. However, this project can be expanded and more functionalities can be added which would add more feature. Some examples are targeting potential customer section using KNN algorithm. This is a really interesting field and more and more we explore this we can develop more and more interesting and useful applications.





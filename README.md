# Ellipse Internship Management Platform

## Overview
Ellipse Internship Management Platform is a web application designed to streamline the management of internships and intern applications within the business environment, this platform automates various HR tasks, offering a robust solution to managing intern data, internship postings, and application processes.

## Features
- **Admin Dashboard:** Manage intern profiles, internship offers, and staff assignments.
- **Intern Applications:** Allows candidates to apply for internships, manage their profiles, and track application status.
- **Statistics and Reports:** Generate and view reports on internship data, including progress and completion rates.
- **Document Management:** Automatically generate internship certificates and manage authentication of login credentials.

## Technologies
- **Frontend:** HTML, CSS, JavaScript
- **Backend:** Java Enterprise Edition (JEE)
- **Database:** MySQL
- **Server:** Apache Tomcat

## Installation

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- MySQL Server 5.7 or higher
- Apache Tomcat 9.0 or higher

### Steps
1. **Clone the Repository**
   ```bash
   git clone https://github.com/yourusername/your-repository.git
2. **Database Setup**
   -Create a database named 'ellipse'.
   -Import the provided SQL script to set up tables:
   ```bash
   mysql -u username -p ellipse < setup.sql
3.**Configure Application**
   -update
   ```bash
   Update src/main/resources/application.properties with your database credentials and server settings.
4.**Build And Deploy
-Compile the project using:
```bash
javac -cp "path/to/tomcat/lib/servlet-api.jar:path/to/project/src" -d path/to/project/build path/to/project/src/**/*.java

-Deploy the generated '.war' file to Tomcat's 'webapps' directory.

### Usage
 1.***Start the tomcat Server
-Run startup.sh (Linux/Mac) or startup.bat (Windows) from the Tomcat bin directory.
2.***Access the Platform***
-Open a web browser and navigate to http://localhost:8080/ellipse.
### Contributing
Contributions to the Ellipse Internship Management Platform are welcome! Please fork the repository and submit a pull request with your enhancements.

### Aknowledgments
-Special thanks to Prof. Noreddine Gherabi for guidance and supervision.
-Gratitude to all contributors and testers who have helped shape this project.



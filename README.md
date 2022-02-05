<!--
Copyright 2018-2021 Crown Copyright

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
-->
 
# Synthetic Data Generator

This synthetic data generator fakes classic human resources data about employees and teachers.
The data structure contains the types of complex data structures that can make 
computation expensive or difficult to truly test your platform.

This repository provides the code to generate as many Employee records as you want, split over as many Avro files as you desire. You can also optionally define the number of parallel threads used to generate your data.

An `Employee` and a `Teacher` objects were created.

The `Employee`contains the following fields:
```
class Employee {
    UserId uid;
    String name;
    String dateOfBirth;
    PhoneNumber[] contactNumbers;
    EmergencyContact[] emergencyContacts;
    Address address;
    BankDetails bankDetails;
    String taxCode;
    Nationality nationality;
    Manager[] manager;
    String hireDate;
    Grade grade;
    Department department;
    int salaryAmount;
    int salaryBonus;
    WorkLocation workLocation;
    Sex sex;
}
```

The `Teacher` object contains the following fields:
```
class Teacher {
    UserId uid;
    String name;
    String dateOfBirth;
    PhoneNumber[] contactNumbers;
    EmergencyContact[] emergencyContacts;
    Address address;
    Nationality nationality;
    Subject subject;
    Department department;
    Manager[] manager;
    String hireDate;
    int salaryAmount;
    int salaryBonus;
    WorkLocation workLocation;
    Sex sex;
}
```
The manager field is an array of manager, which could potentially be nested several layers deep, in the generated example manager is nested 3-5 layers deep.


## Generated data format

It is possible to print the generated data in two different format:
- CSV format
- AVRO format

This option will be available to the end user when executing the command of generating the data.

## Data selection

This synthetic data generator allows the user to select whether the generated records are going to be in an **Employee** or a **Teacher** format.

This option will be available to the end user when executing the command of generating the data.


## Get Started
To use the generator you will need to have installed (git, maven and JDK 11).  
To get started first clone this repo locally.

```bash
git clone https://github.com/alu0101221960/ProyectoLHD
```

Then cd into the synthetic-data-generator directory and build the codebase

```bash
mvn clean install
```

then to start the generator:

```bash
.createHRData.sh [PATH] [PEOPLE] [FILES] [THREADS] [OUTPUT] [TYPE]
```

where:
- PATH is the relative path to generate the files
- PEOPLE is the number of people records to create
- FILES is the number of files to spread them over
- THREADS (optional) specifies the number of threads to use
- OUTPUT is the type of output we want to generate. If the value is set to 1 we will obtain a **csv** output file and if the value is set to 0 we will obtain an **avro** output file
- TYPE is the type of records we want to generate. If we select the value "e" we will obtain **employee** records and if the value is set to "t" we will obtain teacher records

**Note**:

It does not affect the correct execution of the command if the selected TYPE is written in capital letters or not. The system will automatically recognize what type of data to generate.

### Employee records

The following command has to be executed to generate 1,000,000 employee records, spread over 15 files, running the program with 4 threads, generating a *csv* output file and writing the output to /data/employee :

```bash
.createHRData.sh data/employee 1000000 15 4 1 e 
```

If the previous ejecution line is not working please execute the following: 

```bash
FILE=target/synthetic-data-generator-*-jar-with-dependencies.jar
java -cp $FILE uk.gov.gchq.syntheticdatagenerator.CreateData $@ data/teacher 1000000 15 4 1 e 
```

### Teacher records 

The following command has to be executed to generate 1,000,000 teacher records, spread over 15 files, running the program with 4 threads, generating an *avro* output file and writing the output to /data/teacher:

```bash
.createHRData.sh data/teacher 1000000 15 4 0 t 
```

As mentioned before, if the previous execution line is not working please excute the following:

```bash
FILE=target/synthetic-data-generator-*-jar-with-dependencies.jar
java -cp $FILE uk.gov.gchq.syntheticdatagenerator.CreateData $@ data/teacher 1000000 15 4 0 t 
```
